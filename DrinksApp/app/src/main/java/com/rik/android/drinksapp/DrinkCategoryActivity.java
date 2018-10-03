package com.rik.android.drinksapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends ListActivity {

    @Override
    protected void onListItemClick(ListView l, View v, int position, long indexInArrayDrink) {
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
        intent.putExtra(DrinkActivity.DRINK_NO, (int) indexInArrayDrink);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // as I use special activity extended ListActivity I can get listView without layout creation
        ListView listView = getListView();

        //to fill listView I need ArrayAdapter which know how to fill it automatically
        // it will fill it with toString() method, so it's important that it has to be defined
        // in Drink.java to show the name of each drink for each object
        ArrayAdapter<Drinks> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Drinks.drinks);
        listView.setAdapter(adapter);

    }
}
