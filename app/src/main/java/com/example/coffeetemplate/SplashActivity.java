package com.example.coffeetemplate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedPreferences = getSharedPreferences("Files", Context.MODE_PRIVATE);

        boolean userIsLogged;
        String myLogin = sharedPreferences.getString("coffee_user_email", "0");

        userIsLogged = myLogin.equals("0");

        // Usando um Handler para atrasar a transição para a próxima Activity
        new Handler().postDelayed(() -> {
            Intent intent;
            if (!userIsLogged) {
                intent = new Intent(SplashActivity.this, LoginActivity.class);
            } else {
                intent = new Intent(SplashActivity.this, MainActivity.class);
            }
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);
    }
}