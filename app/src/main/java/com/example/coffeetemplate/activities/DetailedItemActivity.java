package com.example.coffeetemplate.activities;

import android.os.Bundle;
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

        txtItemTitle.setText(itemTitle);
        txtItemDescription.setText(itemDescription);
        txtItemPrice.setText(getText(R.string.dollar) + itemPrice);
//        imgItemImage.setImageResource(Integer.getInteger(itemImageResource));
    }
}