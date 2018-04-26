package com.example.chilaa_cont.bankingapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BankAccountListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Bank> bankAccountList;

    public BankAccountListAdapter(Context context, int layout, ArrayList<Bank> bankAccountList) {
        this.context = context;
        this.layout = layout;
        this.bankAccountList = bankAccountList;
    }


    @Override
    public int getCount() {
        return bankAccountList.size();
    }

    @Override
    public Object getItem(int position) {
        return bankAccountList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        CircleImageView profile_image;
        TextView ifsc,accountnum,accountholder,mobilenum;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;
        ViewHolder holder=new ViewHolder();

        if(row==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(layout,null);

            holder.profile_image=(CircleImageView) row.findViewById(R.id.profile_image);
            holder.ifsc=(TextView)row.findViewById(R.id.ifsc);
            holder.accountnum=(TextView)row.findViewById(R.id.accountnum);
            holder.accountholder=(TextView)row.findViewById(R.id.accountholder);
            holder.mobilenum=(TextView)row.findViewById(R.id.mobilenum);
            row.setTag(holder);
        }else {
            holder=(ViewHolder)row.getTag();

        }


        Bank bank=bankAccountList.get(position);

        byte[] accountholderprofile=bank.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(accountholderprofile,0,accountholderprofile.length);
        holder.profile_image.setImageBitmap(bitmap);

        holder.ifsc.setText(bank.getIfsc());
        holder.accountnum.setText(bank.getAccountnum());
        holder.accountholder.setText(bank.getAccountholdername());
        holder.mobilenum.setText(bank.getPhonenum());


        return row;
    }


}
