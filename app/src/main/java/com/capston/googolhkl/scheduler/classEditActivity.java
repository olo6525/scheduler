package com.capston.googolhkl.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.capston.googolhkl.schduler.R;

/**
 * Created by googolhkl on 2016. 11. 10..
 */

//시간 꾹누르고 편집눌렀을 때
public class classEditActivity extends Activity {
    private SendBirdOpenChannelListActivity.SendBirdChannelListFragment mSendBirdChannelListFragment;
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

        // 과목정보 업데이트
        TextView textView = (TextView) findViewById(R.id.info_subject_show2);
        textView.setText(ci.getClassName());
        textView = (TextView) findViewById(R.id.info_professor_show2);
        textView.setText(ci.getProfessor());
        textView = (TextView) findViewById(R.id.info_classroom_show2);
        textView.setText(ci.getClassRoom());
        textView = (TextView) findViewById(R.id.info_memo_show2);
        textView.setText(ci.getMemo());

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
