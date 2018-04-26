package com.example.chilaa_cont.bankingapplication;

public class Bank {
    private String id;
    private byte[] image;
    private String ifsc;
    private String accountnum;
    private String accountholdername;
    private String phonenum;

    public Bank(String id,byte[] image,String ifsc,String accountnum,String accountholdername,String phonenum){
        this.id=id;
        this.image=image;
        this.ifsc=ifsc;
        this.accountnum=accountnum;
        this.accountholdername=accountholdername;
        this.phonenum=phonenum;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
