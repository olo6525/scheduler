package com.capston.googolhkl.scheduler;

import android.app.Activity;
import android.os.Bundle;

import com.capston.googolhkl.schduler.R;

/**
 * Created by googolhkl on 2016. 11. 10..
 */

public class dbtestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);

        final SQLiteHelper dbHelper = new SQLiteHelper(getApplicationContext(), "classInfo.db", null,1);
        dbHelper.insert("tue5 tue6 tue7", "강릉원주대학교", "C프로그래밍", "212-213", "홍길동", "N12-512", "11월 24일까지 과제", "col1");
        //dbHelper.update("mon1 mon2 sat4", "강릉원주대학교", "Java프로그래밍", "212-212", "홍길동", "N12-512", "11월 24일까지 과제", "col1");
        //dbHelper.delete("212-212");
        dbHelper.getResult();
    }
}
