package com.capston.googolhkl.schduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {

    GridView grid;
    String[] data ={
            "","월","화","수","목","금",
            "1교시", "멀티미디어시스템", "영어", "", "과학","사화",
            "2교시", "도덕"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridView)findViewById(R.id.gridview1);
        // TODO: 글씨가 많아지면 칸이 계속 늘어나는 현상을 없애야함. 고정크기
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data
        );

        grid.setAdapter(adapter);
    }
}
