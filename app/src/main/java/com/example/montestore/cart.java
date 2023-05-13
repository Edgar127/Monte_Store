package com.example.montestore;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class cart extends AppCompatActivity {
    ListView cartItems;
    ArrayAdapter<String> adapter;
    ArrayList<String> cartItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItems = findViewById(R.id.cartList);

        int headphonesQuantity = getIntent().getIntExtra("headphones_quantity", 0);
        int watchQuantity = getIntent().getIntExtra("watch_quantity", 0);
        int macProQuantity = getIntent().getIntExtra("mac_pro_quantity", 0);
//        ArrayList<String> cartItemList = new ArrayList<>();
        cartItemList = new ArrayList<>();
        if (headphonesQuantity > 0) {
            cartItemList.add("Headphones: " + headphonesQuantity);
        }
        if (watchQuantity > 0) {
            cartItemList.add("Watch: " + watchQuantity);
        }
        if (macProQuantity > 0) {
            cartItemList.add("Mac Pro: " + macProQuantity);
        }

        if (cartItemList.isEmpty()) {
            cartItemList.add("No items added to cart");
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItemList);
        cartItems.setAdapter(adapter);
        cartItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Remove the item from the cart and update the list
                cartItemList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }
}
