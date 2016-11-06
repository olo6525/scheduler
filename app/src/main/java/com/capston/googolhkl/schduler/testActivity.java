package com.capston.googolhkl.schduler;

/**
 * Created by googolhkl on 2016. 11. 6..
 */

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.IntegerRes;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.MenuItemHoverListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

public class testActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        ArrayList<ClassInformation> ci = (ArrayList<ClassInformation>)intent.getSerializableExtra("data");

        String txt = ci.get(0).getTime() + " " + ci.get(0).getSchoolName() + " " + ci.get(0).getClassName()
                + " " + ci.get(0).getClassNumber() + " " + ci.get(0).getProfessor() + " " + ci.get(0).getClassRoom()
                + " " + ci.get(0).getMemo() + " " + ci.get(0).getClassColor();
        Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_LONG).show();


        findViewById(R.id.testBox).setOnClickListener( new Button.OnClickListener() {
            public void onClick(View v) {
                //String txt = "눌림";
                //Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_LONG).show();

                View view = testActivity.this.getLayoutInflater().inflate(R.layout.scheduler_nickname, null);
                final EditText chName = (EditText) view.findViewById(R.id.nickname); // 학교이름과 과목번호로 생성하도록 수정해야함

                AlertDialog.Builder builder = new AlertDialog.Builder(testActivity.this);
                builder.setTitle("오픈채팅 입장")
                        .setMessage("채팅방에서 사용할 닉네임을 입력해주세요")
                        .setCancelable(false)
                        .setView(view)
                        .setPositiveButton("입장", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String txt = chName.getText().toString();
                                Toast.makeText(getApplicationContext(),"닉네임 : " + txt,Toast.LENGTH_LONG).show();
                                finish();
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
        }
        );
    }
}
