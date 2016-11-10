package com.capston.googolhkl.scheduler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.capston.googolhkl.schduler.R;
import com.sendbird.android.SendBird;

/**
 * Created by googolhkl on 2016. 11. 10..
 */

public class classEditActivity extends Activity {
    private static final String appId = "9FBD1E10-6A0A-4D2D-B8ED-79164DA35F4D";
    public static String sUserId="default";
    private String mNickname;
    private String key;
    private String value;
    private String title;
    private int i=0;
    static private int count =0;
    private int channelMaxSize=0;
    private SendBirdOpenChannelListActivity.SendBirdChannelListFragment mSendBirdChannelListFragment;
    private enum State {DISCONNECTED, CONNECTING, CONNECTED}
    private SQLiteHelper dbHelper;
    private Intent intent;
    private ClassInformation ci;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_class_edit);
            mainStart();

        }

        @Override
        protected void onResume(){
            super.onResume();
            setContentView(R.layout.activity_class_edit);
            mainStart();
        }

    public void mainStart(){
        dbHelper = new SQLiteHelper(getApplicationContext(), "classInfo.db", null,1);


        //과목 정보 얻기
        intent = getIntent();
        ci = (ClassInformation)intent.getSerializableExtra("data");

        // 채팅방의 key와 value (key = 학교이름:수강번호, value = 과목이름)
        key = ci.getSchoolName() +":"+ ci.getClassNumber();
        value = ci.getClassName();

        // 과목정보 업데이트
        TextView textView = (TextView) findViewById(R.id.info_subject_show2);
        textView.setText(ci.getClassName());
        textView = (TextView) findViewById(R.id.info_professor_show2);
        textView.setText(ci.getProfessor());
        textView = (TextView) findViewById(R.id.info_classroom_show2);
        textView.setText(ci.getClassRoom());
        textView = (TextView) findViewById(R.id.info_memo_show2);
        textView.setText(ci.getMemo());

        // 채팅방의 이름 (학교이름 과목이름)
        title = ci.getSchoolName() +" " + ci.getClassName();

        // 취소눌렀을 때
        findViewById(R.id.cancle).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        // 확인
        findViewById(R.id.ok).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                String time;
                String schoolName;
                String className;
                String classNumber;
                String professor;
                String classRoom;
                String memo;
                String classColor;

                EditText editText1 = (EditText)findViewById(R.id.info_subject_show2) ;
                className = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.info_professor_show2) ;
                professor = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.info_classroom_show2) ;
                classRoom = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.info_memo_show2) ;
                memo = editText1.getText().toString();

                time = ci.getTime();
                classNumber = ci.getClassNumber();
                schoolName = ci.getSchoolName();
                classColor = ci.getClassColor();
                ci.setClassName(className);
                ci.setProfessor(professor);
                ci.setClassRoom(classRoom);
                ci.setMemo(memo);
                dbHelper.update(time,schoolName,className,classNumber,professor,classRoom,memo,classColor);
                finish();
            }
        });
    }
}
