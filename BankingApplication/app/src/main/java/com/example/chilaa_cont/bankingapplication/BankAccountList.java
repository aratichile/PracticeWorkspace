package com.example.chilaa_cont.bankingapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class BankAccountList extends AppCompatActivity{

    ListView listView;
    ArrayList<Bank> list;
    BankAccountListAdapter adapter=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);



        listView=(ListView)findViewById(R.id.listView);
        list=new ArrayList<>();

        //get all data from sqlite

        Cursor cursor=AddAccount.sqLiteHelper.getData("SELECT * FROM BANK");

        while (cursor.moveToNext()){
            String id=cursor.getString(0);

            byte[] image=cursor.getBlob(1);
            String ifsc=cursor.getString(2);
            String accountnum=cursor.getString(3);
            String accountholdername=cursor.getString(4);
            String phonenum=cursor.getString(5);

            list.add(new Bank(id,image,ifsc,accountnum,accountholdername,phonenum));
        }

        adapter=new BankAccountListAdapter(this,R.layout.activity_list,list);
        listView.setAdapter(adapter);

        list.clear();
        adapter.notifyDataSetChanged();
    }
}
