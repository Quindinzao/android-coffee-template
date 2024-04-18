package com.example.coffeetemplate.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeetemplate.R;
import com.example.coffeetemplate.models.ListItem;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {

    private final List<ListItem> itemList;
    private OnItemClickListener listener;

    public ListItemAdapter(List<ListItem> itemList) {
        this.itemList = itemList;
    }

    // Interface para o ouvinte de clique
    public interface OnItemClickListener {
        void onItemClick(ListItem item);
    }

    // Método para definir o ouvinte de clique
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem = itemList.get(position);
        holder.textViewName.setText(listItem.getTitle());
        holder.imageView.setImageResource(listItem.getImageResource());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(listItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textItem);
            imageView = itemView.findViewById(R.id.imageItem);
        }
    }
}
