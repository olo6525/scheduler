package com.capston.googolhkl.schduler;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 시간 얻기 */
        Calendar calendar = Calendar.getInstance();
        long Now = calendar.getTimeInMillis();
        String strNow = calendar.getTime().toString(); //

        // 요일 찾기
        String strDay = getDayString(strNow); // 월요일 : Mon
        //strNow = Integer.toString(getDayID(strNow));

        // 시간 찾기
        String strTime = getHourString(strNow); // 오후 2시 : 14
        /*
        Object obj = R.id.clock14;
        strNow = obj.getClass().getName();
        TextView testView =(TextView) findViewById(R.id.testID);
        testView.setText(strNow);

        Integer currentHour = Integer.parseInt(strTime);
        TextView testView =(TextView) findViewById(R.id.testID);
        testView.setText(Integer.toString(currentHour));
        */
        Integer currentHour = Integer.parseInt(strTime);
        TextView testView =(TextView) findViewById(R.id.testID);
        testView.setText(Integer.toString(currentHour));


        /* 오늘 날짜에 해당하는 요일의 테두리색을 변경 */
        TextView mon = (TextView)findViewById(getDayID(strDay)); //Integer형
        mon.setBackgroundResource(R.drawable.day2); //

        if( currentHour >= 8 || currentHour <=22)
        {

            /* 현재 시간에 해당하는 시간 테두리색을 변경 */
            TextView clock = (TextView) findViewById(getTimeID(strTime)); // Integer형
            clock.setBackgroundResource(R.drawable.time2);
        }
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

    //TODO 요일 전부 추가하기
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

