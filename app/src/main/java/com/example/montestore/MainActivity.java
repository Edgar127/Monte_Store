package com.example.montestore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText userId, password, name;
    Button register, login,admin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        register = findViewById(R.id.register);
        login = findViewById(R.id.Login);
        admin = findViewById(R.id.admin1);
        //For admin
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Admin.class);
                startActivity(intent);
            }
        });
        //For returning users
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        //Register button
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ///creating user entity
//                UEntity entity = new UEntity();
//                entity.setUserId(userId.getText().toString());
//                entity.setPassword(password.getText().toString());
//                entity.setName(name.getText().toString());
//                if(validateInput(entity)){
//                    //Insert operation
//                    DataBase dataBase = DataBase.getDataBase(getApplicationContext());
//                    final DAO dao = dataBase.userDao();
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            dao.registerUser(entity);
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(getApplicationContext(), "User Registerd",Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(getApplicationContext(),browse.class);
//                                    startActivity(intent);
//                                }
//                            });
//                        }
//                    }).start();
//                }else{
//                    Toast.makeText(getApplicationContext(), "Fill all the fields",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating user entity
                UEntity entity = new UEntity();
                entity.setUserId(userId.getText().toString());
                entity.setPassword(password.getText().toString());
                entity.setName(name.getText().toString());

                // Check if user already exists
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DataBase dataBase = DataBase.getDataBase(getApplicationContext());
                        DAO dao = dataBase.userDao();
                        UEntity userEntity = dao.getUserByIdOrName(entity.getUserId(), entity.getName());

                        if (userEntity != null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User already exists", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            // Register new user
                            if (validateInput(entity)) {
                                //Insert operation
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        final DAO dao = dataBase.userDao();
                                        dao.registerUser(entity);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(getApplicationContext(), "User registered", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), browse.class);
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                }).start();
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Fill all the fields", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    }
                }).start();
            }
        });
    }
        private Boolean validateInput(UEntity entity){
        return !entity.getUserId().isEmpty() && !entity.getPassword().isEmpty() && !entity.getName().isEmpty();
    }

}