package com.example.fooddonationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelperTwo extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="FOOD_RECORD.db";
    private static final String TABLE_NAME="FOOD_DATA";
    private static final String COL_1="NAME";
    private static final String COL_2="FOOD";
    private static final String COL_3="ADDRESS";
    private static final String COL_4="PHONE";
    private static final String COL_5="PIN";
    private static final String COL_6="QUANTITY";
    private static final String COL_7="EMAIL";


    public DBHelperTwo(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDBuser) {
        myDBuser.execSQL("CREATE TABLE IF NOT EXISTS FOOD_DATA (NAME TEXT,FOOD TEXT,ADDRESS TEXT,PHONE TEXT,PIN TEXT,QUANTITY TEXT,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDBuser, int oldVersion, int newVersion) {
        myDBuser.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public Boolean insertfood(String name, String food,String address,String phone,String pin,String quantity,String email){
        SQLiteDatabase myBDuser = this.getWritableDatabase();
        ContentValues Values = new ContentValues();
        Values.put(COL_1,name);
        Values.put(COL_2,food);
        Values.put(COL_3,address);
        Values.put(COL_4,phone);
        Values.put(COL_5,pin);
        Values.put(COL_6,quantity);
        Values.put(COL_7,email);



        long result = myBDuser.insert(TABLE_NAME,null,Values);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor readdata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="SELECT *FROM "+ TABLE_NAME ;
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;
    }

}

/*
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperTwo extends SQLiteOpenHelper {
    public DBHelperTwo(Context context) {

        super(context, "Share.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDBtwo) {
        MyDBtwo.execSQL("create Table food (Id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT , number INT(10), address VARCHAR(255), pin INT(6), foodtype VARCHAR(255), quantity INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDBtwo, int i, int i1) {
        MyDBtwo.execSQL("drop Table if exists food");
        onCreate(MyDBtwo);

    }

    public Boolean addrecord(String name, String email , String number, String address, String pin, String foodtype, String quantity ) {
        SQLiteDatabase MyDBtwo = this.getWritableDatabase();

        ContentValues CV = new ContentValues();
        CV.put("name", name);
        CV.put("email", email);
        CV.put("number", number);
        CV.put("address", address);
        CV.put("pin", pin);
        CV.put("foodtype", foodtype);
        CV.put("quantity", quantity);

        long result = MyDBtwo.insert("Share", null, CV);
        if (result == -1)
            return false;
        else
            return true;
    }

    public  Cursor readalldata(){
        SQLiteDatabase myDBtwo = this.getWritableDatabase();
        Cursor cursor = myDBtwo.rawQuery("Select * from food order by Id desc",null);
        return cursor;
    }

}

*/
