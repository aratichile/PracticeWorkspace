package com.example.admin.goodsreceipt.model;

/**
 * Created by admin on 4/11/2018.
 */

public class Contact {
    public final int ordernumber;
    public final String date;
    public final String name;

   public Contact(int orderno,String date,String name){
       this.ordernumber=orderno;
       this.date=date;
       this.name=name;
   }
}
