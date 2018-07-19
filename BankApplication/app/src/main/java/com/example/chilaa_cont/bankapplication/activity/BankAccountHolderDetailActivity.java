package com.example.chilaa_cont.bankapplication.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.chilaa_cont.bankapplication.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class BankAccountHolderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_account_holder_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CircleImageView profile_image = findViewById(R.id.profile_image);
        TextView ifsc = findViewById(R.id.idscTextView);
        TextView accountnum = findViewById(R.id.accountnumTextView);
        TextView accountholder = findViewById(R.id.accountholderNameTextView);
        TextView mobilenum = findViewById(R.id.phoneNumTextView);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            String sIfscNo = b.getString("ifsc", "");
            String sAccountNo = b.getString("accountnum", "");
            String sAccountholdername = b.getString("accountholder", "");
            String sMobileNo = b.getString("mobilenum", "");
            byte[] profileImage = Base64.decode(b.getString("profile_image"), Base64.NO_WRAP);
            Bitmap bmp = BitmapFactory.decodeByteArray(profileImage, 0, profileImage.length);
            profile_image.setImageBitmap(bmp);

            ifsc.setText(sIfscNo);
            accountnum.setText(sAccountNo);
            accountholder.setText(sAccountholdername);
            mobilenum.setText(sMobileNo);
        }

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
