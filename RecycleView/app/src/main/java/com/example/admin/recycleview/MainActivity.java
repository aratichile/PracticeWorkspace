package com.example.admin.recycleview;


import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.admin.recycleview.grid.GridFragment;
import com.example.admin.recycleview.list.ListFragment;
import com.example.admin.recycleview.model.Animal;

public class MainActivity extends AppCompatActivity implements ListFragment.ListFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i=item.getItemId();
        switch (i){
            case R.id.menu_item_list:
                showFragment(new ListFragment());
                return true;
            case R.id.menu_item_grid:
                showFragment(new GridFragment());
                return true;
            default:
                return false;
        }
    }
    private void showFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();

    }

    @Override
    public void onAnimalSelected(Animal animal) {
        Toast.makeText(this,"This is " + animal.name + "from Activity!!!",Toast.LENGTH_LONG).show();
    }
}
