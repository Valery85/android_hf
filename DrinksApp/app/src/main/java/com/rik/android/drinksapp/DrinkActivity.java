package com.rik.android.drinksapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String DRINK_NO = "indexInDrinkArray";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        Intent intent = getIntent();

        // here I get index in the Array correspondent drink
        int drinkNo = (int) intent.getExtras().get(DRINK_NO);

        // get id for image to show for chosen drink
        int resourceImageId =   (int) Drinks.drinks[drinkNo].getImageResouceId();
               // connect ImageView in layout and java code
        ImageView drinkImage = (ImageView) findViewById(R.id.image_drink);
                // set resource id of image for chosen drink
        drinkImage.setImageResource(resourceImageId);


        TextView drinkName = (TextView) findViewById(R.id.drink_name);
        drinkName.setText(Drinks.drinks[drinkNo].getName());

        TextView drinkDescription = (TextView) findViewById(R.id.drink_description);
        drinkDescription.setText(Drinks.drinks[drinkNo].getDescription());
    }
}
