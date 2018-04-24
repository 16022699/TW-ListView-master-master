package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvYear;
    ArrayAdapter aa;
    ArrayList<Module> modules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvModules);
        tvYear = (TextView) findViewById(R.id.tvYear);

        // Create a few food objects in Food array
        modules = new ArrayList<Module>();
        modules.add(new Module("C208", true));
        modules.add(new Module("C200", false));
        modules.add(new Module("C346", true));

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new ModuleAdapter(this, R.layout.row, modules);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module selectedFood = modules.get(position);

                Toast.makeText(SecondActivity.this, selectedFood.getName()
                                + " Star: " + selectedFood.isProgramming(),
                        Toast.LENGTH_LONG).show();

                Intent i = getIntent();
                String year = i.getStringExtra("year");
                tvYear.setText(year);
            }
        });
    }





    }

    