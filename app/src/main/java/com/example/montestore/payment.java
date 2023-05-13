package com.example.montestore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class payment extends AppCompatActivity {
    private EditText cardname, holdername, CVV, digits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        cardname = findViewById(R.id.editTextTextPersonName);
        holdername = findViewById(R.id.editTextTextPersonName2);
        CVV = findViewById(R.id.editTextDate);
        digits = findViewById(R.id.editTextNumber);

        findViewById(R.id.button).setOnClickListener(view -> {
            String cardNumber = cardname.getText().toString();
            String cardHolder = holdername.getText().toString();
            String expiration = digits.getText().toString(); // Fix here
            String cvv = CVV.getText().toString();
            if (cardNumber.isEmpty() || cardHolder.isEmpty() || expiration.isEmpty() || cvv.isEmpty() || digits.getText().toString().isEmpty()) { // Fix here
                Toast.makeText(payment.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else if (!cvv.matches("[0-9]+") || !digits.getText().toString().matches("[0-9]+")) { // Fix here
                Toast.makeText(payment.this, "CVV and digits fields must contain only numbers", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), Admin.class);
                startActivity(intent);
            }
        });
    }
}