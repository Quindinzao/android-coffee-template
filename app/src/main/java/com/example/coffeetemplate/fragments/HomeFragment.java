package com.example.coffeetemplate.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeetemplate.R;
import com.example.coffeetemplate.adapters.ListItemAdapter;
import com.example.coffeetemplate.models.ListItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<ListItem> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Crie uma lista de itens
        itemList = new ArrayList<>();
        itemList.add(new ListItem("Item 1", R.drawable.food));
        itemList.add(new ListItem("Item 2", R.drawable.logo));

        // Configurar o RecyclerView
        setupRecyclerView(view);

        return view;
    }

    // Método para inicializar e configurar o RecyclerView
    private void setupRecyclerView(View view) {
        // Inicializa o RecyclerView e define o LayoutManager e o Adapter
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crie um novo adaptador e configure-o no RecyclerView
        ListItemAdapter adapter = new ListItemAdapter(itemList);

        // Define o ouvinte de clique no adapter
        adapter.setOnItemClickListener(item -> {
            // Exibe um Toast com o nome do item clicado
            Toast.makeText(getContext(), "Item clicado: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        });

        // Define o adapter no RecyclerView
        recyclerView.setAdapter(adapter);
    }
}