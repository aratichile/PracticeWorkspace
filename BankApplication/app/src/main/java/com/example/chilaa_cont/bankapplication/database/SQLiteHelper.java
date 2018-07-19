package com.example.chilaa_cont.bankapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.chilaa_cont.bankapplication.utils.Bank;


import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Bank.CREATE_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Bank.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(sql);
    }

    public long insertData(byte[] image, String ifsc, String accountnum, String accountholdername, String phonenum) {

        SQLiteDatabase database = getWritableDatabase();
        // String sql="INSERT INTO BANK VALUES(?,?,?,?,?,?)";

        ContentValues contentValues = new ContentValues();
        contentValues.put(Bank.COLUMN_IFSC, ifsc);
        contentValues.put(Bank.COLUMN_IMAGE, image);
        contentValues.put(Bank.COLUMN_ACCOUNTNUM, accountnum);
        contentValues.put(Bank.COLUMN_ACCOUNTHOLDERNAME, accountholdername);
        contentValues.put(Bank.COLUMN_PHONENUM, phonenum);

        long data = database.insert(Bank.TABLE_NAME, null, contentValues);

        // close db connection
        database.close();
        return data;
    }

    public Bank getBank(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Bank.TABLE_NAME,
                new String[]{Bank.COLUMN_ID, Bank.COLUMN_IFSC,
                            Bank.COLUMN_IMAGE, Bank.COLUMN_ACCOUNTNUM,
                            Bank.COLUMN_ACCOUNTHOLDERNAME, Bank.COLUMN_PHONENUM},
                            Bank.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        assert cursor != null;
        Bank bank = new Bank(
                cursor.getInt(cursor.getColumnIndex(Bank.COLUMN_ID)),
                cursor.getBlob(cursor.getColumnIndex(Bank.COLUMN_IMAGE)),
                cursor.getString(cursor.getColumnIndex(Bank.COLUMN_IFSC)),
                cursor.getString(cursor.getColumnIndex(Bank.COLUMN_ACCOUNTNUM)),
                cursor.getString(cursor.getColumnIndex(Bank.COLUMN_ACCOUNTHOLDERNAME)),
                cursor.getString(cursor.getColumnIndex(Bank.COLUMN_PHONENUM)));
        cursor.close();
        return bank;
    }

    public ArrayList<Bank> getAllBankAccount() {
        ArrayList<Bank> banks = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Bank.TABLE_NAME ;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Bank bank = new Bank();
                bank.setId(cursor.getInt(cursor.getColumnIndex(Bank.COLUMN_ID)));
                bank.setImage(cursor.getBlob(cursor.getColumnIndex(Bank.COLUMN_IMAGE)));
                bank.setIfsc(cursor.getString(cursor.getColumnIndex(Bank.COLUMN_IFSC)));
                bank.setAccountnum(cursor.getString(cursor.getColumnIndex(Bank.COLUMN_ACCOUNTNUM)));
                bank.setAccountholdername(cursor.getString(cursor.getColumnIndex(Bank.COLUMN_ACCOUNTHOLDERNAME)));
                bank.setPhonenum(cursor.getString(cursor.getColumnIndex(Bank.COLUMN_PHONENUM)));

                banks.add(bank);
                cursor.moveToNext();
            }
        }
        database.close();
        return banks;
    }

}