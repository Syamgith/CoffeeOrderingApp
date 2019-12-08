package com.example.coffeeorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnadd, btnremove, btnorder;
    TextView tvitems, tvorder;
    EditText etname;
    CheckBox cbwhippedCream, cbchocolate;
    int items;
    String name;
    boolean cream, chocolate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnadd = findViewById(R.id.btnadd);
        btnremove = findViewById(R.id.btnremove);
        btnorder = findViewById(R.id.btnorder);
        etname = findViewById(R.id.etname);
        name = etname.getText().toString();
        tvitems = findViewById(R.id.tvitems);
        tvorder= findViewById(R.id.tvorder);
        items = Integer.parseInt(tvitems.getText().toString());

        //checkbox initailization
        cbwhippedCream = findViewById(R.id.checkBox1);
        cbchocolate = findViewById(R.id.checkBox2);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items++;
                disply();
            }
        });

        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items--;
                disply();
            }
        });



    }

    //disply method
    void disply() {
        tvitems.setText(""+items);
        tvorder.setText("Name : "+name+"\n"+"Quantity : "+items+"\n"+"Whipped cream - "+cbwhippedCream.isChecked()+"\n"+"Chocolate - "+cbchocolate.isChecked()+"\n"+"Total : "+items*10+" Rs");

    }
}
