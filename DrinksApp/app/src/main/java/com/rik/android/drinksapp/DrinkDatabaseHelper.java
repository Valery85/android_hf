package com.rik.android.drinksapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DrinkDatabaseHelper extends SQLiteOpenHelper {

    // set up name and version of database
    private static final String DB_NAME = "drinkDatabase";
    private static final int DB_VERSION = 1;

    DrinkDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    // this method used to create database and data insert
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    // this method used to update database
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
