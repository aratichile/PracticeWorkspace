package com.example.admin.goodsreceipt.historylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.goodsreceipt.R;
import com.example.admin.goodsreceipt.model.Contact;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment implements HistoryListAdapter.OnContactDetailsListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_history,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Contact> contacts=new ArrayList<>();

        contacts.add(new Contact(465456776,"02/02/2018","Rajesh"));
        contacts.add(new Contact(469856776,"02/02/2018","Majesh"));
        contacts.add(new Contact(462356776,"02/02/2018","Ganesh"));
        contacts.add(new Contact(462456776,"02/02/2018","Sandesh"));
        contacts.add(new Contact(468756776,"02/02/2018","Ramesh"));

        HistoryListAdapter adapter=new HistoryListAdapter(contacts);
        adapter.setListener(this);
        RecyclerView countriesListRecyclerView = view.findViewById(R.id.historyListRecycleView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        countriesListRecyclerView.setLayoutManager(manager);
        countriesListRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onContactDetails(Contact contact) {
        Toast.makeText(getActivity(),"Created By "+ contact.name,Toast.LENGTH_LONG).show();
        if (getActivity()instanceof HistoryFragmentListener){
            HistoryFragmentListener listener=(HistoryFragmentListener) getActivity();
            listener.onContactDetails(contact);
        }
    }

    public interface HistoryFragmentListener{
        void onContactDetails(Contact contact);
    }
}
