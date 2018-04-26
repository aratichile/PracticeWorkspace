package com.example.chilaa_cont.bankingapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Add extends AppCompatActivity {

    public TextView ifscCodeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        TextView addTextView= (TextView) findViewById(R.id.addTextView);
        //  TextView ideaTextView= (TextView) findViewById(R.id.ideaTextView);
        // ideaTextView.setVisibility(View.GONE);
        //ifscCodeEditText=(TextView) findViewById(R.id.ifscCodeEditText);

        Bundle bundle=getIntent().getExtras();
        String add = bundle.getString("Title");

        addTextView.setText(add);
//        String ideas = bundle.getString("ideas");
//        ideaTextView.setText(ideas);


    }

}
