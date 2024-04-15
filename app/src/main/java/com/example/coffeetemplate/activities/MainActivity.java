package com.example.coffeetemplate.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.coffeetemplate.R;
import com.example.coffeetemplate.databinding.ActivityMainBinding;
import com.example.coffeetemplate.fragments.DrinkFragment;
import com.example.coffeetemplate.fragments.FoodFragment;
import com.example.coffeetemplate.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        TextView headerText = findViewById(R.id.headerText);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.food) {
                replaceFragment(new FoodFragment());
                headerText.setText(R.string.food);
            } else if (item.getItemId() == R.id.drink) {
                replaceFragment(new DrinkFragment());
                headerText.setText(R.string.drink);
            }

            return true;
        });

        binding.homeButton.setOnClickListener(item -> {
            replaceFragment(new HomeFragment());
            headerText.setText(R.string.home);
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}