package com.example.montestore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class browse extends AppCompatActivity {
    Button btnlogout, btnCart;
    ProductEntity product;
    Button addHeadphones, addIpad,addM2;
    TextView card_view1,card_view2,card_view3,
    price1, price2,price3;
    TextView usernames;
    int HeadphonesQuantity = 0;
    int WatchQuantity =0;
    int MacProQuantity=0;
    
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // display the username at the top of the activity
        usernames = findViewById(R.id.textView3);
        usernames.setText("Welcome, " + username);
        btnlogout= findViewById(R.id.btnlogout);
        btnCart=findViewById(R.id.btncart);
        //TextView
       card_view1 = findViewById(R.id.headphones_quantity);
       card_view2= findViewById(R.id.m2_quantity);
       card_view3 = findViewById(R.id.watch_quantity);
       price1=findViewById(R.id.headphones_price);
       price2=findViewById(R.id.m2_price);
       price3 =findViewById(R.id.watch_price);

        //Add Heaphones
        Button addHeadphones = findViewById(R.id.headphones_to_cart);
        addHeadphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HeadphonesQuantity++;
                card_view1.setText("Quantity: "+ HeadphonesQuantity);
                Toast.makeText(browse.this, "Headphones added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        Button addWatch = findViewById(R.id.watch_to_cart);
        addWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WatchQuantity++;
                card_view1.setText("Quantity: "+ WatchQuantity);
                Toast.makeText(browse.this, "Watch added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        Button addMac = findViewById(R.id.m2_to_cart);
        addMac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MacProQuantity++;
                card_view1.setText("Quantity: "+MacProQuantity);
                Toast.makeText(browse.this, "MacBook Pro added to cart", Toast.LENGTH_SHORT).show();
            }
        });
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(browse.this,cart.class);
                intent.putExtra("headphones_quantity", HeadphonesQuantity);
                intent.putExtra("ipad_quantity", WatchQuantity);
                intent.putExtra("mac_pro_quantity", MacProQuantity);
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
