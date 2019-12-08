package com.example.coffeeorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


        tvitems = findViewById(R.id.tvitems);
        tvorder= findViewById(R.id.tvorder);
        items = Integer.parseInt(tvitems.getText().toString());

        //checkbox initailization
        cbwhippedCream = findViewById(R.id.checkBox1);
        cbchocolate = findViewById(R.id.checkBox2);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (items <= 100){
                    items++;
                    disply();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Maximum 100 coffees per order",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (items > 0){
                    items--;
                    disply();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please select 1 or more coffee",Toast.LENGTH_SHORT).show();
                }

            }
        });

        cbchocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disply();
            }
        });

        cbwhippedCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disply();
            }
        });


        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                composeEmail();
            }
        });

    }

    //disply method
    void disply() {
        tvitems.setText(""+items);

        etname = findViewById(R.id.etname);
        Editable nameEditable = etname.getText();
        name = nameEditable.toString();

        tvorder.setText("Name : "+ name +"\n"+"No. of coffees : "+items+"\n"+"Whipped cream - "+cbwhippedCream.isChecked()+"\n"+"Chocolate - "+cbchocolate.isChecked()+"\n"+"Total : "+items*10+" Rs");

    }

    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee orders");
        intent.putExtra(Intent.EXTRA_TEXT,tvorder.getText());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
