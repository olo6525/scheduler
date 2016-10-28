package com.capston.googolhkl.schduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Button mon1 =(Button)findViewById(R.id.mon1);
        //mon1.setBackgroundResource(R.drawable.button2);


        /* 오늘 날짜에 해당하는 요일의 테두리색을 변경 */
        TextView mon = (TextView)findViewById(R.id.mon);
        mon.setBackgroundResource(R.drawable.day2);

        /* 현재 시간에 해당하는 시간 테두리색을 변경 */
        TextView clock = (TextView)findViewById(R.id.clock14);
        clock.setBackgroundResource(R.drawable.time2);

    }
}

