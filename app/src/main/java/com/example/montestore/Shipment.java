package com.example.montestore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Shipment extends AppCompatActivity {
    EditText address,carrier,fast;
    Button finish;
    private static final String CHANNEL_ID = "order_number_notification_channel";
    private static final int NOTIFICATION_ID = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipment);

        carrier=findViewById(R.id.editTextTextPersonName3);
        fast=findViewById(R.id.editTextTextPersonName4);
        address=findViewById(R.id.editTextTextPersonName5);
        finish=findViewById(R.id.button3);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Your order number is 6j7h2f46nh7jv" +", Thank You.";
                Toast.makeText(Shipment.this, message, Toast.LENGTH_SHORT).show();

            }
        });

    }

}

