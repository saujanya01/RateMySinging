package com.example.saujanya.ratemysinging;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class database extends AppCompatActivity
{
    RecyclerView desc;
    DatabaseReference user_child;
    String  arr_name[]=new String[10];
    String arr_age[]=new String [10];
    String s_name,s_age;
    static String dkey;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        desc=findViewById(R.id.recycler);
        desc.setLayoutManager(new LinearLayoutManager(this));
        user_child=FirebaseDatabase.getInstance().getReference().child("user");
        user_child.addChildEventListener(new ChildEventListener()
        {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s)
            {
                dkey=dataSnapshot.getKey();
                s_name=dataSnapshot.child("name").getValue(String.class);
                s_age=dataSnapshot.child("age").getValue().toString();
                arr_name[Integer.parseInt(dkey)]=s_name;
                arr_age[Integer.parseInt(dkey)]=s_age;
                desc.setAdapter(new listitem(arr_name,arr_age));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s)
            {
                int k;
                String name,age;
                k=Integer.parseInt(dataSnapshot.getKey());
                name=dataSnapshot.child("name").getValue(String.class);
                age=dataSnapshot.child("age").getValue(String.class);
                arr_age[k]=age;
                arr_name[k]=name;
                desc.setAdapter(new listitem(arr_name,arr_age));
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot)
            {
                int k;
                k=Integer.parseInt(dataSnapshot.getKey());
                arr_age[k]="";
                arr_name[k]="";
                desc.setAdapter(new listitem(arr_name,arr_age));
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s)
            {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }
}
