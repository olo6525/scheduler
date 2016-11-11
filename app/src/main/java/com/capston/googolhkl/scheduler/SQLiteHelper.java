package com.capston.googolhkl.scheduler;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by googolhkl on 2016. 11. 10..
 */



public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE CLASSINFO (classTime TEXT,schoolName TEXT, className TEXT, classNumber TEXT, professor TEXT, classRoom TEXT, memo TEXT, classColor TEXT);";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public void insert(String classTime, String schoolName, String className, String classNumber, String professor, String classRoom, String memo, String classColor)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT INTO CLASSINFO VALUES('" + classTime + "', '" + schoolName + "', '" + className + "', '" + classNumber + "', '" +  professor + "', '" + classRoom + "', '" + memo + "', '" + classColor +"');";
        db.execSQL(query);
        db.close();
    }

    public void update(String classTime, String schoolName, String className, String classNumber, String professor, String classRoom, String memo, String classColor) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "UPDATE CLASSINFO SET classTime=" + "'"+classTime+"', " + "schoolName=" + "'"+schoolName+"', "+ "className=" + "'"+className+"', " + "professor=" + "'"+professor+"', " + "classRoom=" + "'"+classRoom+"', " + "memo=" + "'"+memo+"', " + "classColor=" + "'"+classColor+"' " + " WHERE classNumber='" + classNumber + "';";
        db.execSQL(query);
        db.close();
    }

    public void delete(String classNumber) {
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM CLASSINFO WHERE classNumber='" + classNumber + "';";
        db.execSQL(query);
        db.close();
    }

    public ArrayList<String> getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> result = new ArrayList<String>();

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM CLASSINFO", null);
        while (cursor.moveToNext()) {
            result.add(cursor.getString(0) + ":"
                    + cursor.getString(1) + ":"
                    + cursor.getString(2) + ":"
                    + cursor.getString(3) + ":"
                    + cursor.getString(4) + ":"
                    + cursor.getString(5) + ":"
                    + cursor.getString(6) + ":"
                    + cursor.getString(7));
        }
        return result;
    }
}
