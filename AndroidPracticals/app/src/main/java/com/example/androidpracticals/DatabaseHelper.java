package com.example.androidpracticals;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "employee.db",null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table emp(id integer primary key autoincrement, name text, company text, designation text, location text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public boolean insertDate(String name, String company, String designation, String location)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("company",company);
        contentValues.put("designation",designation);
        contentValues.put("location",location);
        long res = db.insert("emp",null,contentValues);
        if(res == -1)
            return false;
        else
            return true;
    }
}