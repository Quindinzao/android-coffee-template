package com.example.coffeetemplate.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffeetemplate.R;

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