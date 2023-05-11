package com.example.montestore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText username, password2;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password2 = findViewById(R.id.password1);
        btnlogin = findViewById(R.id.btnsinin1);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String password = password2.getText().toString().trim();

                // Validate user input
                if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter both user ID and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if user exists in database
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UEntity user = DataBase.getDataBase(Login.this).userDao().getUserByCredentials(name, password);
                            Log.d("Login", "getUserByCredentials returned " + user);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (user != null) {
                                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),browse.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(Login.this, "Invalid user ID or password", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }).start();
                }
            }
        });

    }
    }
