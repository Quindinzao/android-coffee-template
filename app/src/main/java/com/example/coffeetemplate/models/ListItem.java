package com.example.coffeetemplate.models;

public class ListItem {

    private final String id;
    private final String title;
    private final String description;
    private final double price;
    private final int imageResource;

    public ListItem(String id, String title, String description, double price, int imageResource) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }
}
