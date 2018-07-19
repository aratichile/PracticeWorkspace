package com.example.chilaa_cont.bankapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.chilaa_cont.bankapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView banking_card, ideas_card, link_card, add_card, list_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banking_card = (CardView ) findViewById(R.id.banking_card);
        ideas_card = (CardView) findViewById(R.id.ideas_card);
        link_card = (CardView) findViewById(R.id.link_card);
        add_card = (CardView) findViewById(R.id.add_card);
        list_card = (CardView) findViewById(R.id.list_card);

        banking_card.setOnClickListener(this);
        ideas_card.setOnClickListener(this);
        link_card.setOnClickListener(this);
        add_card.setOnClickListener(this);
        list_card.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        int ifsc;

        String txtTitle;
        switch (v.getId()) {
            case R.id.banking_card:
                txtTitle = "Banking Card";
                i = new Intent(this, BankingDetailActivity.class);
                i.putExtra("Title", txtTitle);
                startActivity(i);
                break;
            case R.id.ideas_card:
                txtTitle = "Get Ideas";
                i = new Intent(this, BankingIdeasActivity.class);
                i.putExtra("Title", txtTitle);
                startActivity(i);
                break;
            case R.id.link_card:
                txtTitle = "Get Link";
                i = new Intent(this, BankingLinkActivity.class);
                i.putExtra("Title", txtTitle);
                startActivity(i);
                break;
            case R.id.add_card:
                ifsc = 2345;
                i = new Intent(this, AddBankAccountActivity.class);
                i.putExtra("ifsc", ifsc);
                startActivity(i);
                break;
            case R.id.list_card:
                ifsc = 2345;
                i = new Intent(this, BankAccountListActivity.class);
                i.putExtra("ifsc", ifsc);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
