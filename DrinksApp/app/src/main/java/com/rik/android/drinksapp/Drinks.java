package com.rik.android.drinksapp;

import java.lang.reflect.Array;

public class Drinks {

    private String name;
    private String description;
    private int imageResouceId;

    public Drinks (String name, String description, int imageResouceId){
        this.name = name;
        this.description = description;
        this.imageResouceId = imageResouceId;
    }

   public final static  Drinks[] drinks = {
        new Drinks("Latte", "Espresso with milk", R.drawable.latte),
        new Drinks("Cappuccino", "Espresso milk and foam", R.drawable.cappucino),
        new Drinks("Filter", "Some coffe", R.drawable.filter)
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResouceId() {
        return imageResouceId;
    }
// Define toString for ArrayAdapter used in DrinkCategoryActivity, to fill list automaticly
// with name of drinks
    @Override
    public String toString() {
        return this.name;
    }
}
