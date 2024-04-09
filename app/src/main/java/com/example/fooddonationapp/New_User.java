package com.example.fooddonationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class New_User extends AppCompatActivity {

    private EditText ETname, ETpassword, ETrepassword;
    private Button SignUp;
    private DBHelper userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        ETname = (EditText) findViewById(R.id.NewUserName);
        ETpassword = (EditText) findViewById(R.id.NewUserPassword);
        ETrepassword = (EditText) findViewById(R.id.NewUserRePassword);

        SignUp = (Button) findViewById(R.id.SignUpBtn);
        userDB = new DBHelper(this);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = ETname.getText().toString();
                String password = ETpassword.getText().toString();
                String repassword = ETrepassword.getText().toString();

                if (name.equals("") || password.equals("") || repassword.equals("")) {
                    Toast.makeText(New_User.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {

                    if (password.equals(repassword)) {
                        Boolean checkUserNameResult = userDB.checkusername(name);

                        if (checkUserNameResult) {
                            Toast.makeText(New_User.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        } else {


                            Boolean insertDataResult = userDB.insertData(name, password);

                            if (insertDataResult) {
                                Toast.makeText(New_User.this, "Registration completed successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(New_User.this, User_Login.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(New_User.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }

                    } else {
                        Toast.makeText(New_User.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
}