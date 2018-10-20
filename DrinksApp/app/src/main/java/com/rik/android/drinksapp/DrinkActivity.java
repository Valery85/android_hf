package com.rik.android.drinksapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {

    public static final String DRINK_NO = "indexInDrinkArray";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        Intent intent = getIntent();

        // here I get index in the Array correspondent drink
        int drinkNo = (Integer) intent.getExtras().get(DRINK_NO);

/*     get data from Drink.java
-----------------------------------------------
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
         ------------------------------------------
         */

        //get info from database instead of Drink.java
        try{
            SQLiteOpenHelper drinkDbHelper = new DrinkDatabaseHelper(DrinkActivity.this);

            //get db which was configured in DrinkDatabaseHelper.java
            // get writable database to be sure that data can be inserted
            SQLiteDatabase db = drinkDbHelper.getWritableDatabase();

            // get cursor to work with data from database
            Cursor cursor = db.query("DRINK",
                    new String[] {"NAME","DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id = ?",
                    //working right if correct  drinkNo to drinkNo + 1
                    // when DrinkCategoryActivity begin use db is't ok
                    new String[] {Integer.toString(drinkNo )},
                    null, null, null);

            // go to first element of data formed by query
            if (cursor.moveToFirst()){

                // get name from NAME field in db
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int imageId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);

                TextView name = (TextView) findViewById(R.id.drink_name);
                name.setText(nameText);

                TextView description = (TextView) findViewById(R.id.drink_description);
                description.setText(descriptionText);

                ImageView imageView = (ImageView) findViewById(R.id.image_drink);
                imageView.setImageResource(imageId);

                //set favorite by value from database
                CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
                favorite.setChecked(isFavorite);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(DrinkActivity.this, "Database unavailable", Toast.LENGTH_LONG);
            toast.show();
        }
    }
    //update column of database when checkbox taps
    public  void  onFavoriteClicked (View view){
        //get number of drink in list from intent
        int drinkNo = (Integer) getIntent().getExtras().get(DRINK_NO);
        CheckBox favorite  = (CheckBox) findViewById(R.id.favorite);
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("FAVORITE", favorite.isChecked());
        SQLiteOpenHelper drinkDatabaseHelper =
                new DrinkDatabaseHelper(DrinkActivity.this);
        try {
            SQLiteDatabase db = drinkDatabaseHelper.getWritableDatabase();
            db.update("DRINK", drinkValues, "_id = ?",
                    new String[] {Integer.toString(drinkNo)});
            db.close();
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
