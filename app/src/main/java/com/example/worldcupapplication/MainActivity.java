package com.example.worldcupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    private static CustomAdapter adapter;
    ArrayList<CountryModelClass> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. AdapterView: a listView
        listView = findViewById(R.id.listview);
        //2. Data source
        dataModels = new ArrayList<>();
        dataModels.add(new CountryModelClass("Germany", "4", R.drawable.germany));
        dataModels.add(new CountryModelClass("France", "2", R.drawable.img));
        dataModels.add(new CountryModelClass("Germany", "5", R.drawable.germany));
        dataModels.add(new CountryModelClass("Germany", "3", R.drawable.germany));
        dataModels.add(new CountryModelClass("Germany", "4", R.drawable.germany));
        dataModels.add(new CountryModelClass("Germany", "4", R.drawable.germany));
        dataModels.add(new CountryModelClass("Germany", "4", R.drawable.germany));
        dataModels.add(new CountryModelClass("Germany", "4", R.drawable.germany));
        dataModels.add(new CountryModelClass("Germany", "4", R.drawable.germany));
        dataModels.add(new CountryModelClass("Germany", "4", R.drawable.germany));
        dataModels.add(new CountryModelClass("Germany", "4", R.drawable.germany));

        //3. Adapter
        adapter = new CustomAdapter(dataModels, getApplicationContext());
        listView.setAdapter(adapter);

        //Handling the click events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Country "+adapter.getItem(i).getCountry_name()+"\n"+
                                "World Cups Wins: "+ adapter.getItem(i).getCup_win_count(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
