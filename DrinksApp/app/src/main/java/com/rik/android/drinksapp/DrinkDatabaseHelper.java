package com.rik.android.drinksapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DrinkDatabaseHelper extends SQLiteOpenHelper {

    // set up name and version of database
    private static final String DB_NAME = "drinkDatabase";
    private static final int DB_VERSION = 2;

    DrinkDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    // this method used to create database and data insert
    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    // this method used to update database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }
    // method to insert drinks in table
    private static void insertDrink(SQLiteDatabase db, String name,
                                    String description, int resourceID){

    //Class ContentValues is used to store a set of values
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", resourceID);
        db.insert("DRINK",null, drinkValues);

    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion < 1){
            // create table DRINK with columns NAME, DESCRIPTION, IMAGE_RESOURCE_ID
            db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME TEXT," +
                    "DESCRIPTION TEXT," +
                    "IMAGE_RESOURCE_ID INTEGER); ");
            insertDrink(db, "Latte", "Espresso with milk", R.drawable.latte );
            insertDrink(db,"Cappuccino", "Espresso milk and foam", R.drawable.cappucino);
            insertDrink(db, "Filter", "Some coffee", R.drawable.filter );
        }
        if (oldVersion < 2){
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }
}
