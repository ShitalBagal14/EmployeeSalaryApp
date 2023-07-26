package com.sveri.employeesalaryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.sveri.employeesalaryapp.MyHelper;


public class MyHelper extends SQLiteOpenHelper {

    //private SQLiteDatabase db;

    public MyHelper(Context context){super (context,"Userdata.db",null,1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create Table employee(name Text primary key,sal Text,tax Text,nsal Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists employee");

    }
    public Boolean insertuserdata(String name,String sal,String tax,String nsal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("salary", sal);
        contentValues.put("tax", tax);
        contentValues.put("nsal", nsal);
        long result = db.insert ("employee", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }




   public Cursor getdata(){
          SQLiteDatabase db=this.getWritableDatabase();
            Cursor cursor=db.rawQuery("Select * from Employee",null);
            return cursor;
   }
}
