package com.example.coffeetemplate.activities;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffeetemplate.R;

public class DetailedItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_item);

        String itemId = getIntent().getStringExtra("itemId");
        String itemTitle = getIntent().getStringExtra("itemTitle");
        String itemDescription = getIntent().getStringExtra("itemDescription");
        String itemPrice = getIntent().getStringExtra("itemPrice");
        String itemImageResource = getIntent().getStringExtra("itemImageResource");

        TextView txtItemTitle = findViewById(R.id.txtItemTitle);
        TextView txtItemDescription = findViewById(R.id.txtItemDescription);
        TextView txtItemPrice = findViewById(R.id.txtItemPrice);
        ImageView imgItemImage = findViewById(R.id.imgItemImage);
        ImageButton arrowBack = findViewById(R.id.imgArrowBack);

        txtItemTitle.setText(itemTitle);
        txtItemDescription.setText(itemDescription);
        txtItemPrice.setText(getText(R.string.dollar) + itemPrice);

        // Converte a string de recurso de imagem de volta para int e define a imagem no ImageView
        int resourceId = Integer.parseInt(itemImageResource);
        imgItemImage.setImageResource(resourceId);

        arrowBack.setOnClickListener(view -> {
            finish();
        });
    }
}