package com.example.coffeetemplate;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button btnScreenSignIn = findViewById(R.id.btnScreenSignIn);
        btnScreenSignIn.setOnClickListener(view -> {
            finish();
        });
    }
}