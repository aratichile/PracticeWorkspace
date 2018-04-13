package com.example.admin.recycleview.list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.recycleview.R;
import com.example.admin.recycleview.model.Animal;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Animal> animals=new ArrayList<>();

        animals.add(new Animal("Cat",R.drawable.ic_cat));
        animals.add(new Animal("Dog",R.drawable.ic_dog));
        animals.add(new Animal("Dear",R.drawable.ic_dear));
        animals.add(new Animal("Tiger",R.drawable.ic_tiger));
        animals.add(new Animal("Lion",R.drawable.ic_lion));

        AnimalListAdapter adapter=new AnimalListAdapter(animals);
        adapter.setListener(this);

    }

    public interface ListFragmentListener{
        void onAnimalSelected(Animal animal);
    }

}
