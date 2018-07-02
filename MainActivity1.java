package com.example.testjsonparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Receiver{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonResultClient(this).execute();
    }




    @Override
    public void OnReceiveData(ArrayList<Tour> a) {
        if(a != null) {
            RecyclerView rv = (RecyclerView) findViewById(R.id.RecyclerView);
            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setAdapter(new TourAdapter(a));

        }
    }

    @Override
    public void OnReceiveError(String s) {
        ((TextView)findViewById(R.id.ErrorTextView)).setText(s);
    }




}