package com.example.chilaa_cont.bankapplication.utils;

public class Bank {
    public static final String TABLE_NAME = "BANK";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_IFSC = "ifsc";
    public static final String COLUMN_ACCOUNTNUM = "accountnum";
    public static final String COLUMN_ACCOUNTHOLDERNAME = "accountholdername";
    public static final String COLUMN_PHONENUM = "phonenum";

    private int id;
    private byte[] image;
    private String ifsc;
    private String accountnum;
    private String accountholdername;
    private String phonenum;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_IMAGE + " BLOG,"
                    + COLUMN_IFSC + " TEXT,"
                    + COLUMN_ACCOUNTNUM + " TEXT,"
                    + COLUMN_ACCOUNTHOLDERNAME + " TEXT,"
                    + COLUMN_PHONENUM + " TEXT"
                    + ")";


    public Bank(int id, byte[] image, String ifsc, String accountnum, String accountholdername, String phonenum) {
        this.id = id;
        this.image = image;
        this.ifsc = ifsc;
        this.accountnum = accountnum;
        this.accountholdername = accountholdername;
        this.phonenum = phonenum;
    }

    public Bank() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getAccountnum() {
        return accountnum;
    }

    public void setAccountnum(String accountnum) {
        this.accountnum = accountnum;
    }

    public String getAccountholdername() {
        return accountholdername;
    }

    public void setAccountholdername(String accountholdername) {
        this.accountholdername = accountholdername;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}
