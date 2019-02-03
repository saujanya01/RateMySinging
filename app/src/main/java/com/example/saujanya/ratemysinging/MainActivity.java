package com.example.saujanya.ratemysinging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.desc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String na[]={"Saujanya","Leah Gotti","Tori black","Lana Rhodes","Emma Watson","Camilia Cabello"};
        int ag[]={19,21,22,30,27,25};
        recyclerView.setAdapter(new listitem(na,ag));
    }
}