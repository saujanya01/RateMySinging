package com.example.saujanya.ratemysinging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    EditText getAge,getName;
    Button upload,go_to_databse;
    static int count;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAge=findViewById(R.id.age);
        getName=findViewById(R.id.name);
        databaseReference=FirebaseDatabase.getInstance().getReference().child("user");
        upload=findViewById(R.id.upload);
        go_to_databse=findViewById(R.id.go);
        count=0;
        upload.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String str_name,str_age;
                str_name=getName.getText().toString().trim();
                str_age=getAge.getText().toString().trim();
                HashMap<String ,String> desc=new HashMap<String, String>();
                desc.put("name",str_name);
                desc.put("age",str_age);
                databaseReference.child(Integer.toString(count)).setValue(desc);
                count ++;
                if (count >=10)
                {
                    count=9;//Every child after 10th value is added at end
                }
                getAge.setText("");
                getName.setText("");
            }
        });
        go_to_databse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent j=new Intent(MainActivity.this,database.class);
                startActivity(j);
            }
        });
    }
}