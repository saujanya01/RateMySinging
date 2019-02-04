package com.example.saujanya.ratemysinging;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class listitem extends RecyclerView.Adapter<listitem.descViewHolder>
{
    String name[];
    String age[];
    public listitem(String name[],String age[])
    {
        this.name=name;
        this.age=age;
    }
    @NonNull
    @Override
    public descViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.list_view,viewGroup,false);
        return new descViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull descViewHolder descViewHolder, int position)
    {
        String n=name[position];
        String a=age[position];
        descViewHolder.ag.setText(a);
        descViewHolder.nam.setText(n);
    }

    @Override
    public int getItemCount()
    {
        return Integer.parseInt(database.dkey)+1;
    }

    public class descViewHolder extends RecyclerView.ViewHolder
    {
        TextView nam,ag;

        public descViewHolder(@NonNull View itemView)
        {
            super(itemView);
            nam=itemView.findViewById(R.id.name);
            ag=itemView.findViewById(R.id.age);
        }
    }
}