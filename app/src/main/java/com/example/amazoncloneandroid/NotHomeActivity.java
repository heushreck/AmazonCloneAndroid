package com.example.amazoncloneandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.amazoncloneandroid.Fragments.TestFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class NotHomeActivity extends AppCompatActivity {

    private ActionBarDrawerToggle at1;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_home);
        Toolbar toolbar = findViewById(R.id.toolbar_not_home);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout_not_home);
        NavigationView navigationView = findViewById(R.id.nav_view_not_home);

        //der Pfeil oben links, der die Navigation View rauszieht
        at1 = new ActionBarDrawerToggle(this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(at1);
        at1.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();

        ContentType contentType = (ContentType) i.getExtras().getSerializable("content");
        switch (contentType){
            case TEST_TYPE:
                String s = i.getExtras().getString("key", "nichts");
                final Fragment test = new TestFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key", s);
                test.setArguments(bundle);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.my_layout_not_home, test);
                fragmentTransaction.commit();
                break;
            case SINGE_ITEM:
                Item item = (Item) i.getExtras().getSerializable("item");
                final Fragment test1 = new TestFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString("key", item.getItem_title());
                test1.setArguments(bundle1);
                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fm1.beginTransaction();
                fragmentTransaction1.replace(R.id.my_layout_not_home, test1);
                fragmentTransaction1.commit();
                break;
            case ITEM_LIST:
                Item[] items = (Item[]) i.getExtras().getSerializable("items");
                final Fragment test2 = new TestFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putString("key", "Wie viele: " + items.length);
                test2.setArguments(bundle2);
                FragmentManager fm2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fm2.beginTransaction();
                fragmentTransaction2.replace(R.id.my_layout_not_home, test2);
                fragmentTransaction2.commit();
                break;
        }


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.nav_home){
                    Intent i = new Intent(NotHomeActivity.this, HomeActivity.class);
                    startActivity(i);
                } else if (menuItem.getItemId()==R.id.nav_your_order){
                    changeToTestFragment("Your order");
                } else if (menuItem.getItemId()==R.id.nav_buy_again){
                    changeToTestFragment("buy again");
                } else if (menuItem.getItemId()==R.id.nav_wishlist){
                    menu.findItem(R.id.action_shopping_cart2).setIcon(ContextCompat.getDrawable(NotHomeActivity.this, R.drawable.outline2_shopping_cart_24));
                    onPrepareOptionsMenu(menu);
                    changeToTestFragment("wishlist");
                } else if (menuItem.getItemId()==R.id.nav_account){
                    changeToTestFragment("accouunt");
                } else if (menuItem.getItemId()==R.id.nav_department){
                    changeToTestFragment("department");
                } else if (menuItem.getItemId()==R.id.nav_today){
                    changeToTestFragment("today");
                } else if (menuItem.getItemId()==R.id.nav_gift_card){
                    changeToTestFragment("gift card");
                } else if (menuItem.getItemId()==R.id.nav_prime){
                    menu.findItem(R.id.action_shopping_cart2).setIcon(ContextCompat.getDrawable(NotHomeActivity.this, R.drawable.baseline_shopping_cart_24));
                    onPrepareOptionsMenu(menu);
                    changeToTestFragment("prime");
                } else if (menuItem.getItemId()==R.id.nav_fresh){
                    changeToTestFragment("fresh");
                } else if (menuItem.getItemId()==R.id.nav_all_programmes){
                    changeToTestFragment("programmes");
                } else if (menuItem.getItemId()==R.id.nav_notification){
                    changeToTestFragment("notification");
                } else if (menuItem.getItemId()==R.id.nav_settings){
                    changeToTestFragment("settings");
                } else if (menuItem.getItemId()==R.id.nav_service){
                    changeToTestFragment("service");
                } else if (menuItem.getItemId()==R.id.nav_legal){
                    changeToTestFragment("legal");
                }
                //falls etwas ausgewählt wird, soll dich der Drawer schließen
                DrawerLayout drawer = findViewById(R.id.drawer_layout_not_home);
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.not_home, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_shopping_cart2){
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), "cart", Snackbar.LENGTH_LONG);
            snackbar.show();
        } else if (item.getItemId() == R.id.action_search){
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), "search", Snackbar.LENGTH_LONG);
            snackbar.show();
        } else if (at1.onOptionsItemSelected(item)){
            View view = getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeToTestFragment(String value){
        final Fragment testFragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", value);
        testFragment.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.my_layout_not_home, testFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
