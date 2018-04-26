package com.example.chilaa_cont.bankingapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddAccount extends AppCompatActivity{

    CircleImageView profileimage;
    public Toolbar toolbar;
    public EditText ifscCodeEditText;
    public EditText accountNumberEditText;
    public EditText accountHolderNameEditText;
    public EditText mobileNumberEditText;
    private Button addBankAccount;

    public static SQLiteHelper sqLiteHelper;
    final int REQUEST_CODE_GALLERY=1000;
    final int REQUEST_CODE_CAMERA=1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       init();

       sqLiteHelper=new SQLiteHelper(this,"BankDb.sqlite",null,1);

       sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS BANK (Id TEXT, IMAGE BLOG, IFCF VARCHAR, ACCOUNTNUM VARCHAR, ACCOUNTHOLDERNAME VARCHAR, PHONENUM VARCHAR);");

        profileImage();
        addAccountBtn();


    }

    private void addAccountBtn(){
        addBankAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(),"PLEASE ADD DATA",Toast.LENGTH_SHORT).show();
                try {
                    sqLiteHelper.insertData(
                            profileimageToByte(profileimage),
                            ifscCodeEditText.getText().toString().trim(),
                            accountNumberEditText.getText().toString().trim(),
                            accountHolderNameEditText.getText().toString().trim(),
                            mobileNumberEditText.getText().toString().trim()
                    );
                    Toast.makeText(getApplicationContext(),"added Successfully",Toast.LENGTH_SHORT).show();

                    profileimage.setImageResource(R.drawable.ic_user_profile);
                    ifscCodeEditText.setText("");
                    accountNumberEditText.setText("");
                    accountHolderNameEditText.setText("");
                    mobileNumberEditText.setText("");
                    Intent intent=new Intent(AddAccount.this,BankAccountList.class);

                    startActivity(intent);
                }
                catch (Exception e){
                    e.printStackTrace();
                    // Toast.makeText(getApplicationContext(),"added FAIL",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    private void profileImage(){
        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(AddAccount.this, profileimage);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(AddAccount.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        switch (item.getItemId()) {
                            case R.id.cameraButton:
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(intent, REQUEST_CODE_CAMERA);
                                break;

                            case R.id.galleryButton:
                                Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                intent1.setType("image/*");
                                startActivityForResult(intent1.createChooser(intent1, "Select File"), REQUEST_CODE_GALLERY);
                                break;
                            default:
                                closeOptionsMenu();
                                break;
                        }
                        return true;
                    }
                });

                popupMenu.show();


            }
        });
    }
    private void init(){
        profileimage = findViewById(R.id.profile_image);
        // profileimage.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ifscCodeEditText = (EditText) findViewById(R.id.ifscCodeEditText);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String add = bundle.getString("Title");

        ifscCodeEditText.setText(add);
        accountNumberEditText = (EditText) findViewById(R.id.accountNumberEditText);
        accountHolderNameEditText = (EditText) findViewById(R.id.accountHolderNameEditText);
        mobileNumberEditText = (EditText) findViewById(R.id.mobileNumberEditText);

        addBankAccount = findViewById(R.id.addBankAccount);
        // addBankAccount.setOnClickListener(this);
    }


    private byte[] profileimageToByte(CircleImageView image) {
        Bitmap bitmap=((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray=stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==REQUEST_CODE_GALLERY){
            if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            }else {
                Toast.makeText(getApplicationContext(),"You Dont have permisson to access",Toast.LENGTH_LONG).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK && data!=null) {
            if (requestCode == REQUEST_CODE_GALLERY) {
                Uri uri = data.getData();

                try {
                    InputStream inputStream = getContentResolver().openInputStream(uri);

                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    profileimage.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (requestCode == REQUEST_CODE_CAMERA) {
                Bundle bundle = data.getExtras();
                Bitmap bmp = (Bitmap) bundle.get("data");
                profileimage.setImageBitmap(bmp);

            }
        }

        super.onActivityResult(requestCode, resultCode, data);
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
