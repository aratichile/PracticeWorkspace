package com.example.admin.goodsreceipt.historylist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.goodsreceipt.R;
import com.example.admin.goodsreceipt.model.Contact;

import java.util.List;

/**
 * Created by admin on 4/11/2018.
 */

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ContactViewHolder> {

    private final List<Contact> contacts;
    private OnContactDetailsListener listener;

    public HistoryListAdapter(List<Contact> contacts) {
        this.contacts = contacts;

    }

    public void setListener(OnContactDetailsListener listener)
    {
        this.listener=listener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_list, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.serialNoTextView.setText(contact.ordernumber);
        holder.dateTextView.setText(contact.date);
        holder.nameTextView.setText(contact.name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contactDetails = contacts.get(holder.getAdapterPosition());

                if (listener != null) {
                    listener.onContactDetails(contactDetails);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public interface OnContactDetailsListener {
        void onContactDetails(Contact contact);
    }


    class ContactViewHolder extends RecyclerView.ViewHolder{

        private TextView serialNoTextView;
        private TextView dateTextView;
        private TextView nameTextView;

        public ContactViewHolder(View view) {
            super(view);

            serialNoTextView=view.findViewById(R.id.serialNoEditText);
            dateTextView=view.findViewById(R.id.dateTextView);
            nameTextView=view.findViewById(R.id.nameTextView);

        }
    }


}
