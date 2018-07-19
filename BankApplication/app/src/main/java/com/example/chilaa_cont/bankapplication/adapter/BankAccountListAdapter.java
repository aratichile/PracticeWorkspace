package com.example.chilaa_cont.bankapplication.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chilaa_cont.bankapplication.R;
import com.example.chilaa_cont.bankapplication.utils.Bank;

import java.util.List;

public class BankAccountListAdapter extends RecyclerView.Adapter<BankAccountListAdapter.BankViewHolder> {

    private List<Bank> accounts;
    private OnAccountSelectedListener listener;

    public BankAccountListAdapter(List<Bank> accounts) {
        this.accounts = accounts;
    }

    public void setListener(OnAccountSelectedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_account_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final BankViewHolder holder, int position) {
        Bank bank = accounts.get(position);
        byte[] profileImage;
        profileImage = bank.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(profileImage, 0, profileImage.length);
        holder.profile_image.setImageBitmap(bitmap);

        holder.ifsc.setText(bank.getIfsc());
        holder.accountnum.setText(bank.getAccountnum());
        holder.accountholder.setText(bank.getAccountholdername());
        holder.mobilenum.setText(bank.getPhonenum());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onAccountSelected(accounts.get(holder.getAdapterPosition()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public interface OnAccountSelectedListener {
        void onAccountSelected(Bank bank);
    }

    class BankViewHolder extends RecyclerView.ViewHolder {

        public final ImageView profile_image;
        public final TextView ifsc;
        public final TextView accountnum;
        public final TextView accountholder;
        public final TextView mobilenum;

        BankViewHolder(View itemView) {
            super(itemView);

            profile_image = itemView.findViewById(R.id.profile_image);
            ifsc = itemView.findViewById(R.id.ifsc);
            accountnum = itemView.findViewById(R.id.accountnum);
            accountholder = itemView.findViewById(R.id.accountholder);
            mobilenum = itemView.findViewById(R.id.mobilenum);
        }
    }
}
