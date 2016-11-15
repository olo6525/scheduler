package com.capston.googolhkl.scheduler;

/**
 * Created by googolhkl on 2016. 11. 6..
 */

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

import com.capston.googolhkl.schduler.R;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.OpenChannelListQuery;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

import com.google.firebase.iid.FirebaseInstanceId;


// 시간표 꾹 누를 때
public class testActivity extends Activity{

    private static final String appId = "9FBD1E10-6A0A-4D2D-B8ED-79164DA35F4D";
    public static String sUserId="default";
    private String mNickname;
    private String key;
    private String value;
    private String title;
    private int i=0;
    static private int count =0;
    private int channelMaxSize=0;
    private SQLiteHelper dbHelper;
    private ClassInformation ci;
    private ArrayList<ClassInformation> tempCi = new ArrayList<ClassInformation>();;


    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
       mainStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
        setContentView(R.layout.activity_test);
        mainStart();
    }

    public void mainStart() {
        dbHelper = new SQLiteHelper(getApplicationContext(), "classInfo.db", null,1);
        //과목 정보 얻기
        intent = getIntent();
        ci = (ClassInformation)intent.getSerializableExtra("data");

        // 업데이트
        ArrayList<String> result = dbHelper.getResult();
        for(int i=0; i< result.size(); i++){
            tempCi.add(new ClassInformation(result.get(i)));
        }
        for(int i=0; i< tempCi.size(); i++) {
            String test = tempCi.get(i).getClassNumber();
            if(test.equals(ci.getClassNumber()))
                ci = tempCi.get(i);
        }

        // MAC 주소 얻기
        WifiManager mng = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo info = mng.getConnectionInfo();
        String mac = info.getMacAddress();

        // 핸드폰 번호 얻기
        //TelephonyManager phone = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        //String phoneNum = phone.getLine1Number();
        sUserId = mac;

        // 채팅을 위한 초기화
        SendBird.init(appId, this);

        // 채팅방의 key와 value (key = 학교이름:수강번호, value = 과목이름)
        key = ci.getSchoolName() +":"+ ci.getClassNumber();
        value = ci.getClassName();

        // 과목정보 업데이트
        TextView textView = (TextView) findViewById(R.id.info_subject_show);
        textView.setText(ci.getClassName());
        textView = (TextView) findViewById(R.id.info_professor_show);
        textView.setText(ci.getProfessor());
        textView = (TextView) findViewById(R.id.info_classroom_show);
        textView.setText(ci.getClassRoom());
        textView = (TextView) findViewById(R.id.info_memo_show);
        textView.setText(ci.getMemo());

        // 채팅방의 이름 (학교이름 과목이름)
        title = ci.getSchoolName() +" " + ci.getClassName();

        // 닫기 눌렀을 때
        findViewById(R.id.info_close).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        // 삭제 눌렀을 때
        findViewById(R.id.info_delete).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                View view = testActivity.this.getLayoutInflater().inflate(R.layout.scheduler_nickname, null);


                AlertDialog.Builder builder = new AlertDialog.Builder(testActivity.this);
                builder.setTitle("과목 삭제")
                        .setMessage("정말로 삭제할까요?")
                        .setCancelable(false)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, final int which) {
                                dbHelper = new SQLiteHelper(getApplicationContext(), "classInfo.db", null,1);
                                dbHelper.delete(ci.getClassName());
                                finish();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog dialog = builder.create();    // 알림창 객체 생성
                dialog.show();
            }
        });

        // 편집 눌렀을 때
        findViewById(R.id.info_edit).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intentSubActivity =new Intent(testActivity.this, classEditActivity.class);
                intentSubActivity.putExtra("data",ci);
                startActivity(intentSubActivity);
            }
        });

        findViewById(R.id.open_chat_btn).setOnClickListener( new Button.OnClickListener() {
             public void onClick(View v) {
                 View view = testActivity.this.getLayoutInflater().inflate(R.layout.scheduler_nickname, null);
                 final EditText chName = (EditText) view.findViewById(R.id.nickname);

                 AlertDialog.Builder builder = new AlertDialog.Builder(testActivity.this);
                 builder.setTitle("오픈채팅 입장")
                         .setMessage("채팅방에서 사용할 닉네임을 입력해주세요")
                         .setCancelable(false)
                         .setView(view)
                         .setPositiveButton("입장", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(final DialogInterface dialog, final int which) {
                                 count =0;

                                 mNickname = chName.getText().toString();

                                 connect();
                                 Helper.hideKeyboard(testActivity.this);

                                 OpenChannelListQuery mChannelListQuery = OpenChannel.createOpenChannelListQuery();
                                 mChannelListQuery.next(new OpenChannelListQuery.OpenChannelListQueryResultHandler() {
                                     @Override
                                     public void onResult(final List<OpenChannel> channels, SendBirdException e) {
                                         if (e != null) {
                                             Toast.makeText(testActivity.this, "다시 시도해주세요.", Toast.LENGTH_SHORT).show();
                                             return;
                                         }

                                         final List<String> keys = new ArrayList<String>();
                                         keys.add(key);
                                         channelMaxSize = channels.size();
                                         for( i=0; i<channels.size(); i++) {

                                             final OpenChannel channel = channels.get(i);
                                             final int j = i;
                                             //channel = channels.get(i);
                                             channels.get(i).getMetaData(keys, new BaseChannel.MetaDataHandler() {
                                                 @Override
                                                 public void onResult(Map<String, String> map, SendBirdException e) {
                                                     if (e != null) {
                                                         return;
                                                     }

                                                     String str =  map.get(key);
                                                     // 방이 있을 때 바로 입장
                                                     if(value.equals(str)) {
                                                         Intent intent = new Intent(testActivity.this, SendBirdOpenChatActivity.class);
                                                         intent.putExtra("channel_url", channel.getUrl());
                                                         startActivity(intent);
                                                     }
                                                     // 방이 없을 때 생성하고 입장
                                                     else{
                                                         count++;

                                                         if(count==channelMaxSize){
                                                             List<User> operators = new ArrayList<>();
                                                             operators.add(SendBird.getCurrentUser());

                                                             OpenChannel.createChannel(title, null, null, operators, new OpenChannel.OpenChannelCreateHandler() {
                                                                 @Override
                                                                 public void onResult(OpenChannel openChannel, SendBirdException e) {
                                                                     if (e != null) {
                                                                         return;
                                                                     }
                                                                     HashMap<String, String> data = new HashMap<String, String>();
                                                                     data.put(key,value);
                                                                     openChannel.createMetaData(data, new BaseChannel.MetaDataHandler() {
                                                                         @Override
                                                                         public void onResult(Map<String, String> map, SendBirdException e) {
                                                                             if(e != null){
                                                                                 return;
                                                                             }

                                                                         }
                                                                     });

                                                                     Intent intent = new Intent(testActivity.this, SendBirdOpenChatActivity.class);
                                                                     intent.putExtra("channel_url", openChannel.getUrl());
                                                                     startActivity(intent);
                                                                 }
                                                             });
                                                         }
                                                     }
                                                 }
                                             });
                                         }
                                     }

                                 });

                             }

                         })
                         .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {

                             }
                         });
                 AlertDialog dialog = builder.create();    // 알림창 객체 생성
                 dialog.show();    // 알림창 띄우기
             }
         });
    }

        private void connect() {
        SendBird.connect(sUserId, new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {

                if (e != null) {
                    return;
                }

                String nickname = mNickname;

                SendBird.updateCurrentUserInfo(nickname, null, new SendBird.UserInfoUpdateHandler() {
                    @Override
                    public void onUpdated(SendBirdException e) {
                        if (e != null) {
                            return;
                        }

                        SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
                        editor.putString("user_id", sUserId);
                        editor.putString("nickname", mNickname);
                        editor.commit();
                    }
                });

                if (FirebaseInstanceId.getInstance().getToken() == null) return;

                SendBird.registerPushTokenForCurrentUser(FirebaseInstanceId.getInstance().getToken(), new SendBird.RegisterPushTokenWithStatusHandler() {
                    @Override
                    public void onRegistered(SendBird.PushTokenRegistrationStatus pushTokenRegistrationStatus, SendBirdException e) {
                        if (e != null) {
                            return;
                        }
                    }
                });
            }
        });
    }
}
