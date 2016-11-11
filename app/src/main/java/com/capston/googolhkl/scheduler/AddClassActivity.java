package com.capston.googolhkl.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.capston.googolhkl.schduler.R;
import java.util.ArrayList;

/**
 * Created by googolhkl on 2016. 11. 11..
 */

// 과목추가에서 시간선택후 추가눌렀을 때
public class AddClassActivity extends Activity {

    Intent intent;
    String time;
    private SQLiteHelper dbHelper;
    private ArrayList<ClassInformation> ci = new ArrayList<ClassInformation>();
    String classColor = "color_button1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_add);
        dbHelper = new SQLiteHelper(getApplicationContext(), "classInfo.db", null,1);
        intent = getIntent();
        time = (String)intent.getSerializableExtra("time");

        ArrayList<String> result = dbHelper.getResult();
        for(int i=0; i< result.size(); i++){
            ci.add(new ClassInformation(result.get(i)));
        }

        if(!ci.isEmpty()) {
            String schoolName = ci.get(0).getSchoolName();
            EditText schoolNameText = (EditText) findViewById(R.id.class_add_schoolname_show);
            schoolNameText.setText(schoolName);
        }

        findViewById(R.id.color_button1).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button1";
            }
        });

        findViewById(R.id.color_button2).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button2";
            }
        });

        findViewById(R.id.color_button3).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button3";
            }
        });

        findViewById(R.id.color_button4).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button4";
            }
        });

        findViewById(R.id.color_button5).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button5";
            }
        });

        findViewById(R.id.color_button6).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button6";
            }
        });

        findViewById(R.id.color_button7).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button7";
            }
        });

        findViewById(R.id.color_button8).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button8";
            }
        });

        findViewById(R.id.color_button9).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button9";
            }
        });

        findViewById(R.id.color_button10).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                classColor = "color_button10";
            }
        });

        // 닫기 눌렀을 때
        findViewById(R.id.class_add_cancle).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        // 추가 눌렀을 때
        findViewById(R.id.class_add_ok).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {

                String schoolName;
                String className;
                String classNumber;
                String professor;
                String classRoom;
                String memo = "";

                EditText editText1 = (EditText)findViewById(R.id.class_add_schoolname_show);
                schoolName = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_classname_show);
                className = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_classnumber_show);
                classNumber = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_professor_show) ;
                professor = editText1.getText().toString();

                editText1 = (EditText)findViewById(R.id.class_add_classroom_show) ;
                classRoom = editText1.getText().toString();

                String query = time + ":"+ schoolName + ":" + className + ":" + classNumber + ":" + professor + ":" + classRoom + ":" + classColor + ":" + memo;
                Log.d("STATE", query);
                dbHelper.insert(time,schoolName,className,classNumber,professor,classRoom,memo,classColor);
                finish();
            }
        });
    }
}