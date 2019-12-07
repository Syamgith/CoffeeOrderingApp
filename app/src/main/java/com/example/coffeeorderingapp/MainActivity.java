package com.example.coffeeorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnadd, btnremove, btnorder;
    TextView tvitems, tvorder;
    int items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnadd = findViewById(R.id.btnadd);
        btnremove = findViewById(R.id.btnremove);
        btnorder = findViewById(R.id.btnorder);
        tvitems = findViewById(R.id.tvitems);
        tvorder= findViewById(R.id.tvorder);
        items = Integer.parseInt(tvitems.getText().toString());

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items++;
                tvitems.setText(""+items);
            }
        });

        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items--;
                tvitems.setText(""+items);
            }
        });


    }
}
