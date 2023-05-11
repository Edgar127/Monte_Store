package com.example.montestore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class browse extends AppCompatActivity {
    Button btnlogout, btnCart;
    ProductEntity product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        btnlogout= findViewById(R.id.btnlogout);
        btnCart=findViewById(R.id.btncart);

        product = getIntent().getParcelableExtra("product");
        //cart
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(browse.this,Admin.class);
                startActivity(intent);
            }
        });

        //create on click listener for logout
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user clicks logout
                Intent intent = new Intent(browse.this, Login.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
