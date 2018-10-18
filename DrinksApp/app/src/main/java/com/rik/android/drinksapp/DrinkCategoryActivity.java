package com.rik.android.drinksapp;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DrinkCategoryActivity extends ListActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

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

/*      take data from Drink.java
        -----------------------------------------
        //to fill listView I need ArrayAdapter which know how to fill it automatically
        // it will fill it with toString() method, so it's important that it has to be defined
        // in Drink.java to show the name of each drink for each object
        ArrayAdapter<Drinks> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Drinks.drinks);
        listView.setAdapter(adapter);
        -----------------------------------------
*/
        //get data from database
        try {
            SQLiteOpenHelper drinkDatabaseHelper = new DrinkDatabaseHelper(DrinkCategoryActivity.this);
            db = drinkDatabaseHelper.getReadableDatabase();

            // cursor hold data which get from the database
            cursor = db.query("DRINK",
                                    new String[]{"_id", "NAME"},
                                    null, null, null, null, null);

            CursorAdapter listAdapter = new SimpleCursorAdapter(
                    DrinkCategoryActivity.this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    // what column chose
                    new String[]{"NAME"},
                    // where insert data from chosen column
                    new int[] {android.R.id.text1},
                    0);
            listView.setAdapter(listAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(DrinkCategoryActivity.this,
                    "Database unavailable", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
