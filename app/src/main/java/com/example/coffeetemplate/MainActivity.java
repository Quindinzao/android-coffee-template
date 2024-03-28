package com.example.coffeetemplate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassword = findViewById(R.id.txtEmail);

        Button btnSignIn = findViewById(R.id.btnSignIn);
        Button btnScreenCreateAccount = findViewById(R.id.btnScreenCreateAccount);

        btnSignIn.setOnClickListener(view -> {
            String email = txtEmail.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please, fill the fields!", Toast.LENGTH_SHORT).show();
            } else {
                // Aqui você pode prosseguir com o processo de login
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            }
        });

        btnScreenCreateAccount.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
        });

    }
}