package com.example.fooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Food extends AppCompatActivity {

    private TextView ETname, ETemail, ETnumber, ETaddress, ETpin, ETfoodtype, ETquantity;
    private Button addfoodbtn;
    private DBHelperTwo foodDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        ETname = (EditText) findViewById(R.id.AddFoodName);
        ETemail = (EditText) findViewById(R.id.AddFoodEmail);
        ETnumber = (EditText) findViewById(R.id.AddFoodPhone);
        ETaddress = (EditText) findViewById(R.id.AddFoodAdderss);
        ETpin = (EditText) findViewById(R.id.AddFoodPin);
        ETfoodtype = (EditText) findViewById(R.id.AddFoodType);
        ETquantity = (EditText) findViewById(R.id.AddFoodQuantity);

        addfoodbtn = (Button) findViewById(R.id.AddFoodBtn);
        foodDB = new DBHelperTwo(this);
        insertfood();

    }

    private void insertfood() {
        addfoodbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname, femail, fphone, ffood, fquant, faddress, fpin;

                fname = ETname.getText().toString();
                femail = ETemail.getText().toString();
                fphone = ETnumber.getText().toString();
                faddress = ETaddress.getText().toString();
                fpin = ETpin.getText().toString();
                ffood = ETfoodtype.getText().toString();
                fquant = ETquantity.getText().toString();

                if (fname.equals("") || femail.equals("") || fphone.equals("") || ffood.equals("") || fquant.equals("") || faddress.equals("") || fpin.equals("")) {
                    Toast.makeText(Add_Food.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean insertDataResult = foodDB.insertfood(fname, ffood, faddress, fphone, fpin, fquant, femail);
                    if (insertDataResult) {

                        Toast.makeText(Add_Food.this, "Record added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Add_Food.this, Home.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Add_Food.this, "Field to add record", Toast.LENGTH_SHORT).show();
                    }

                }


            }


        });
    }

}