package com.capston.googolhkl.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.capston.googolhkl.schduler.R;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by googolhkl on 2016. 11. 11..
 */

public class AddClassActivity extends Activity {

    Intent intent;
    String time;
    private SQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_add);
        dbHelper = new SQLiteHelper(getApplicationContext(), "classInfo.db", null,1);
        intent = getIntent();
        time = (String)intent.getSerializableExtra("time");

        // 닫기 눌렀을 때
        findViewById(R.id.class_add_ok).setOnClickListener(new Button.OnClickListener() {
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
                String classColor = "color_default";
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