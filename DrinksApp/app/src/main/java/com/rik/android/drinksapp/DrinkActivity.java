package com.rik.android.drinksapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DrinkActivity extends AppCompatActivity {

    public static final String DRINK_NO = "indexInDrinkArray";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        Intent intent = getIntent();

        // here I get index in the Array correspondent drink
        int drinkNo = (int) intent.getExtras().get(DRINK_NO);

    }
}
