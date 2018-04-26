package com.example.chilaa_cont.bankingapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import org.w3c.dom.Text;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public void queryData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertData(String id,byte[] image, String ifsc, String accountnum, String accountholdername, String phonenum){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO BANK VALUES(?,?,?,?,?,?)";

        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,id);
        statement.bindBlob(2,image);
        statement.bindString(3,ifsc);
        statement.bindString(4,accountnum);
        statement.bindString(5,accountholdername);
        statement.bindString(6,phonenum);

        statement.executeInsert();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertData(byte[] bytes, String trim, String trim1, String trim2, String trim3) {
    }
}
