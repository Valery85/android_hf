package com.rik.android.pizza;

//import android.app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.ShareActionProvider;
import android.support.v7.widget.ShareActionProvider;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // fill menu, elements (items) will be added on the action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // get item of menu
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("This is my example text");
        return super.onCreateOptionsMenu(menu);
    }

    // onOptionsItemSelected used to add logic when the element of  action bar clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                // code for create_order button
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:
                // code for action_settings element
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }


}
