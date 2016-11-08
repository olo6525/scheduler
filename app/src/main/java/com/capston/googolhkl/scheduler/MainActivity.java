package com.capston.googolhkl.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

import com.capston.googolhkl.schduler.R;


public class MainActivity extends AppCompatActivity {
    private ArrayList<ClassInformation> ci = new ArrayList<ClassInformation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* ClassInformation 정보 받아오기 (현재는 임시로 채움) */
        ci.add(new ClassInformation("mon1 mon2 sat4", "강릉원주대학교", "Java프로그래밍", "212-212",
                "홍길동", "N12-512", "11월 24일까지 과제", "col1"));



        /* 액션 오버플로우에 액션바들이 무조건 들어가게 한다. (하드웨어로 메뉴키가 있어도 강제 */
        try {
            ViewConfiguration config = ViewConfiguration. get( this);
            Field menuKeyField = ViewConfiguration.class .getDeclaredField( "sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible( true );
                menuKeyField.setBoolean(config, false );
            }
        } catch (Exception ex) {

        }

        /* 시간 얻기 */
        Calendar calendar = Calendar.getInstance();
        long Now = calendar.getTimeInMillis();
        String strNow = calendar.getTime().toString(); //

        // 요일 찾기
        String strDay = getDayString(strNow); // 월요일 : Mon
        //strNow = Integer.toString(getDayID(strNow));

        // 시간 찾기
        String strTime = getHourString(strNow); // 오후 2시 : 14
        Integer currentHour = Integer.parseInt(strTime);

        /* 오늘 날짜에 해당하는 요일의 테두리색을 변경 */
        TextView mon = (TextView)findViewById(getDayID(strDay)); //Integer형
        mon.setBackgroundResource(R.drawable.day2); //

        if( currentHour >= 8 || currentHour <=22)
        {
            /* 현재 시간에 해당하는 시간 테두리색을 변경 */
            TextView clock = (TextView) findViewById(getTimeID(strTime)); // Integer형
            clock.setBackgroundResource(R.drawable.time2);
        }


        /* 버튼 누르고 있을 때 */
        findViewById(R.id.mon1).setOnLongClickListener( new Button.OnLongClickListener() {
            public boolean onLongClick(View v) {
                //String txt = "과목 상세보기";
                //Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_LONG).show();

                Intent intentSubActivity =new Intent(MainActivity.this, testActivity.class);
                intentSubActivity.putExtra("data",ci);
                startActivity(intentSubActivity);

                return true;
            }
        }
        );
    }

    @Override
    public boolean  onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //ActionBar 메뉴 클릭에 대한 이벤트 처리
        String txt = null;
        int id = item.getItemId();

        switch (id){

            case R.id.main_menu:
                txt = "수강가능 과목은 현재 수강하고 있는 시간 이외 과목들을 표시합니다.";
                break;

            case R.id.addSubject:
                txt = "과목추가하기";
                break;

            case R.id.searchSubject:
                txt = "수강가능 과목찾기";
                break;

            case R.id.maker:
                txt = "만든사람";
                break;
        }
        Toast.makeText(this,txt,Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    String getDayString(String str)
    {
        String[] splitedStr = str.split(" ");
        return splitedStr[0];
    }

    Integer getDayID(String str)
    {
        if(str.equals("Mon"))
        {
            return R.id.mon;
        }
        else if(str.equals("Tue"))
        {
            return R.id.tue;
        }
        else if(str.equals("Wed"))
        {
            return R.id.wed;
        }
        else if(str.equals("Thu"))
        {
            return R.id.thu;
        }
        else if(str.equals("Fri"))
        {
            return R.id.fri;
        }
        else if(str.equals("Sat"))
        {
            return R.id.sat;
        }
        else if(str.equals("Sun"))
        {
            return R.id.sun;
        }

        return -1;
    }

    String getHourString(String str)
    {
        String[] splitedStr = str.split(" ");
        String hour = splitedStr[3].substring(0,2);
        return hour;
    }

    //TODO 시간 전부 추가하기
    Integer getTimeID(String str)
    {
        if(str.equals("8"))
        {
            return R.id.clock8;
        }
        else if(str.equals("9"))
        {
            return R.id.clock9;
        }
        else if(str.equals("10"))
        {
            return R.id.clock10;
        }
        else if(str.equals("11"))
        {
            return R.id.clock11;
        }
        else if(str.equals("12"))
        {
            return R.id.clock12;
        }
        else if(str.equals("13"))
        {
            return R.id.clock13;
        }
        else if(str.equals("14"))
        {
            return R.id.clock14;
        }
        else if(str.equals("15"))
        {
            return R.id.clock15;
        }
        else if(str.equals("16"))
        {
            return R.id.clock16;
        }
        else if(str.equals("17"))
        {
            return R.id.clock17;
        }
        else if(str.equals("18"))
        {
            return R.id.clock18;
        }
        else if(str.equals("19"))
        {
            return R.id.clock19;
        }
        else if(str.equals("20"))
        {
            return R.id.clock20;
        }
        else if(str.equals("21"))
        {
            return R.id.clock21;
        }
        else if(str.equals("22"))
        {
            return R.id.clock22;
        }

        return R.id.clock8;
    }
}

