package com.example.coffeetemplate;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
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

        textChanged(txtEmail);
        textChanged(txtPassword);

        btnSignIn.setOnClickListener(view -> {
            if (!validateSignIn(txtEmail, txtPassword)) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            }
        });

        btnScreenCreateAccount.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
            startActivity(intent);
        });

    }

    public void textChanged(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    changeEditTextColor(editText, R.color.defaultEditText, "");
                } else {
                    changeEditTextColor(editText, R.color.error, "This field is required!");
                }
            }
        });
    }

    public void changeEditTextColor(EditText editText, int colorError, String text) {
        ColorStateList colorStateList = ColorStateList.valueOf(getResources().getColor(colorError));
        editText.setHintTextColor(colorStateList);
        editText.setBackgroundTintList(colorStateList);
        if (!Objects.equals(text, "")) {
            editText.setHint(text);
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

    public boolean validateSignIn(EditText txtEmail, EditText txtPassword) {
        boolean result = false;
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        if (!validateEmail(email)) {
            txtEmail.setText("");
            changeEditTextColor(txtEmail, R.color.error, "Please, insert a valid e-mail!");
        } else if (!validatePassword(password)) {
            txtPassword.setText("");
            changeEditTextColor(txtPassword, R.color.error, "Please. insert a valid password!");
        } if ("user@gmail".equals(email) && "Pass#123".equals(password)) {
            result = true;
        }
        return result;
    }

}