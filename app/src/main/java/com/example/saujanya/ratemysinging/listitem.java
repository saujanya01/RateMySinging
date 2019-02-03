package com.example.saujanya.ratemysinging;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class listitem extends RecyclerView.Adapter<listitem.descViewHolder>
{
    String[] name;
    int[] age;
    public listitem(String[] name, int[] age)
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
        int a=age[position];
        descViewHolder.age.setText(Integer.toString(a));
        descViewHolder.name.setText(n);
    }

    @Override
    public int getItemCount()
    {
        return name.length;
    }

    public class descViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,age;

        public descViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);
        }
    }
}