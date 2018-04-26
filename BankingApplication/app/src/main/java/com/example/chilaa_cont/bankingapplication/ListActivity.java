package com.example.chilaa_cont.bankingapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle=getIntent().getExtras();
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String add = bundle.getString("Title");

//        CircleImageView profile_image=(CircleImageView)findViewById(R.id.profile_image);
        TextView ifsc=(TextView)findViewById(R.id.ifsc);
        TextView accountnum=(TextView)findViewById(R.id.accountnum);
        TextView accountholder=(TextView)findViewById(R.id.accountholder);
        TextView mobilenum=(TextView)findViewById(R.id.mobilenum);

      /*  Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.id.profile_image);
        profile_image.setImageBitmap(bmp);
        ifsc.setText(bundle.getCharSequence("ifsc"));
        accountnum.setText(bundle.getCharSequence("accountnum"));
        accountholder.setText(bundle.getCharSequence("accountholder"));
        mobilenum.setText(bundle.getCharSequence("mobilenum"));*/
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
