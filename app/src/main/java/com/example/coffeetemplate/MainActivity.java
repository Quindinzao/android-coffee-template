package com.example.coffeetemplate;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassword = findViewById(R.id.txtPassword);

        Button btnSignIn = findViewById(R.id.btnSignIn);
        Button btnScreenCreateAccount = findViewById(R.id.btnScreenCreateAccount);

        btnSignIn.setOnClickListener(view -> {
            String email = txtEmail.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();

            if (email.isEmpty()) {
                isError(txtEmail, R.color.error, "This field is required!");
            } else if (!validateEmail(email)) {
                txtEmail.setText("");
                isError(txtEmail, R.color.error, "Please, insert a valid e-mail!");
            } else if (password.isEmpty()) {
                isError(txtPassword, R.color.error, "This field is required!");
            } else if (!validatePassword(password)) {
                txtPassword.setText("");
                isError(txtPassword, R.color.error, "Please. insert a valid password!");
            } else {
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            }
        });

        btnScreenCreateAccount.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
        });

    }

    public void isError(EditText field, int colorError, String text) {
        ColorStateList colorStateList = ColorStateList.valueOf(getResources().getColor(colorError));
        field.setHint(text);
        field.setHintTextColor(colorStateList);
        field.setBackgroundTintList(colorStateList);
    }

    public static boolean validateSignIn(String email, String password) {
        if ("usuario".equals(email) && "senha123".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean validatePassword(String pass) {
        // Verificar se a senha atende aos critérios desejados
        return pass != null && pass.length() >= 8 && // Pelo menos 8 caracteres de comprimento
                pass.matches(".*[A-Z].*") && // Pelo menos uma letra maiúscula
                pass.matches(".*[a-z].*") && // Pelo menos uma letra minúscula
                pass.matches(".*\\d.*") && // Pelo menos um número
                pass.matches(".*[!@#$%^&*()\\-+=].*"); // Pelo menos um caractere especial
    }
}