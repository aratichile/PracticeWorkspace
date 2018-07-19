package com.example.chilaa_cont.bankapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chilaa_cont.bankapplication.R;
import com.example.chilaa_cont.bankapplication.adapter.BankAccountListAdapter;
import com.example.chilaa_cont.bankapplication.database.SQLiteHelper;
import com.example.chilaa_cont.bankapplication.utils.Bank;

import java.util.ArrayList;

public class BankAccountListActivity extends AppCompatActivity {

    RecyclerView accountsListView;
    ArrayList<Bank> list = new ArrayList<>();
    SQLiteHelper db;
    BankAccountListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_account_list);
        /*Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        init();
        db = new SQLiteHelper(this);
        list = db.getAllBankAccount();
        accountsListView = findViewById(R.id.accountsListView);
        accountsListView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BankAccountListAdapter(list);
        adapter.setListener(new BankAccountListAdapter.OnAccountSelectedListener() {
            @Override
            public void onAccountSelected(Bank bank) {
                Intent intent = new Intent(BankAccountListActivity.this, BankAccountHolderDetailActivity.class);
                Bundle b = new Bundle();

                b.putString("profile_image", Base64.encodeToString(bank.getImage(), Base64.NO_WRAP));
                b.putString("ifsc", bank.getIfsc());
                b.putString("accountnum", bank.getAccountnum());
                b.putString("accountholder", bank.getAccountholdername());
                b.putString("mobilenum", bank.getPhonenum());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        accountsListView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

}
