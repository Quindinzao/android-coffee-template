package com.example.coffeetemplate.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeetemplate.R;
import com.example.coffeetemplate.activities.DetailedItemActivity;
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
        itemList.add(new ListItem("0001", "Item 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam non elit nec arcu ornare ultricies. Aenean vehicula vitae enim non placerat. Mauris hendrerit velit sed urna aliquam hendrerit. Mauris turpis ipsum, tincidunt eget tellus in, finibus imperdiet dolor. Quisque malesuada risus quis augue eleifend, dignissim placerat mi rutrum. Vestibulum sit amet lobortis elit, ut pellentesque nibh. In vestibulum auctor risus, at scelerisque sem ornare nec. Fusce consectetur iaculis malesuada. Sed eu sem risus. Etiam lacus quam, gravida id erat eu, lobortis ultrices quam. Sed a arcu tincidunt, ornare purus at, ornare sem. Quisque eu rutrum purus. Phasellus non massa vehicula, rutrum ex a, pulvinar nisl. Vivamus malesuada nulla semper ex rutrum, et sodales neque porta. Donec molestie tempor nisl eget consectetur. Pellentesque massa quam, condimentum vel faucibus quis, finibus eget urna.\n" +
                "\n" +
                "Donec vehicula nisl at ligula varius iaculis. Phasellus vel vestibulum nunc. Nunc sollicitudin mattis ornare. Sed ac laoreet urna, non condimentum lectus. Donec ac tempus eros. Aliquam commodo ligula lacus, ut ornare justo vestibulum non. Pellentesque volutpat sit amet nulla ut ultricies. In hac habitasse platea dictumst. Nulla elit neque, efficitur eu viverra ut, feugiat sit amet orci. Donec condimentum nec augue eu faucibus. Nullam molestie libero enim, gravida convallis mi sollicitudin sit amet. Nulla faucibus ultricies lacus. Pellentesque at quam erat. Vestibulum consectetur imperdiet dapibus.\n" +
                "\n" +
                "Duis a porttitor purus. Nunc venenatis eros ipsum, quis sagittis neque commodo vel. Fusce finibus erat ut odio faucibus, id posuere ipsum efficitur. Praesent venenatis suscipit semper. Praesent ac consectetur sem, sed lacinia purus. Pellentesque pulvinar sollicitudin odio sit amet tincidunt. Aenean tristique rhoncus nunc, vel egestas odio interdum ullamcorper.", 10.99, R.drawable.food));
        itemList.add(new ListItem("0002", "Item 2", "Description item 2", 11.99, R.drawable.logo));

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

            Intent intent = new Intent(getContext(), DetailedItemActivity.class);
            intent.putExtra("itemId", item.getId());
            intent.putExtra("itemTitle", item.getTitle());
            intent.putExtra("itemDescription", item.getDescription());
            intent.putExtra("itemPrice", String.valueOf(item.getPrice()));
            intent.putExtra("itemImageResource", String.valueOf(item.getImageResource()));
            startActivity(intent);
        });

        // Define o adapter no RecyclerView
        recyclerView.setAdapter(adapter);
    }
}