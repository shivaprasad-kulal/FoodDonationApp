package com.example.fooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User_Login extends AppCompatActivity {

    EditText ETusername, ETpassword;
    Button UserLogIn, UserJoin, GuestEntry;
    DBHelper userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        ETusername = findViewById(R.id.LogInName);
        ETpassword = findViewById(R.id.LogInPassword);
        UserLogIn = findViewById(R.id.LogInBtn);
        UserJoin = findViewById(R.id.SignUpBtn);
//        GuestEntry = findViewById(R.id.GuestBtn);

        userDB = new DBHelper(this);


        UserLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName, UserPassword;

                UserName=ETusername.getText().toString();
                UserPassword=ETpassword.getText().toString();

                if(UserName.equals("")||UserPassword.equals("")){
                    Toast.makeText(User_Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkUserResult = userDB.checkusernamepassword(UserName,UserPassword);
                    if(checkUserResult){
                        Intent intent = new Intent(User_Login.this,Home.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(User_Login.this, "User doesn't exist, Create one", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        UserJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Login.this, New_User.class);
                startActivity(intent);
            }
        });

//        GuestEntry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(User_Login.this, Home.class);
//                startActivity(intent);
//            }
//        });
    }
}