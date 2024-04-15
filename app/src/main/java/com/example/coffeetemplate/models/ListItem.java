package com.example.coffeetemplate.models;

public class ListItem {

    private String title;
    private int imageResource;

    public ListItem(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }
}
