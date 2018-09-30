package com.rik.android.drinksapp;

public class Drinks {

    private String name;
    private String description;
    private int imageResouceId;

    public Drinks (String name, String description, int imageResouceId){
        this.name = name;
        this.description = description;
        this.imageResouceId = imageResouceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResouceId() {
        return imageResouceId;
    }
}
