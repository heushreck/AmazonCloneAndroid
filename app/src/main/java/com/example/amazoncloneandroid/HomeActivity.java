package com.example.amazoncloneandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.TypedValue;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.amazoncloneandroid.Fragments.HomeFragment;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private ActionBarDrawerToggle at1;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        setUpToolBar(true);

        DrawerLayout drawer = findViewById(R.id.drawer_layout_home);
        NavigationView navigationView = findViewById(R.id.nav_view_home);

        //der Pfeil oben links, der die Navigation View rauszieht
        at1 = new ActionBarDrawerToggle(this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(at1);
        at1.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Fragment home = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", "Von Start");
        home.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.my_layout_home, home);
        fragmentTransaction.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.nav_home){
                    final Fragment homeFragment = new HomeFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("key", "Von Drawer");
                    homeFragment.setArguments(bundle);
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.my_layout_home, homeFragment);
                    fragmentTransaction.commit();
                } else if (menuItem.getItemId()==R.id.nav_your_order){
                    changeToNotHome("Your order");
                } else if (menuItem.getItemId()==R.id.nav_buy_again){
                    changeToNotHome("buy again");
                } else if (menuItem.getItemId()==R.id.nav_wishlist){
                    changeToNotHome("wishlist");
                } else if (menuItem.getItemId()==R.id.nav_account){
                    changeToNotHome("accouunt");
                } else if (menuItem.getItemId()==R.id.nav_department){
                    changeToNotHome("navigation");
                } else if (menuItem.getItemId()==R.id.nav_today){
                    changeToNotHome("today");
                } else if (menuItem.getItemId()==R.id.nav_gift_card){
                    changeToNotHome("gift card");
                } else if (menuItem.getItemId()==R.id.nav_prime){
                    changeToNotHome("prime");
                } else if (menuItem.getItemId()==R.id.nav_fresh){
                    menu.findItem(R.id.action_shopping).setIcon(ContextCompat.getDrawable(HomeActivity.this, R.drawable.baseline_shopping_cart_24));
                    onPrepareOptionsMenu(menu);
                    changeToNotHome("fresh");
                } else if (menuItem.getItemId()==R.id.nav_all_programmes){
                    changeToNotHome("programmes");
                } else if (menuItem.getItemId()==R.id.nav_notification){
                    changeToNotHome("notification");
                } else if (menuItem.getItemId()==R.id.nav_settings){
                    changeToNotHome("settings");
                } else if (menuItem.getItemId()==R.id.nav_service){
                    changeToNotHome("service");
                } else if (menuItem.getItemId()==R.id.nav_legal){
                    changeToNotHome("legal");
                }
                //falls etwas ausgewählt wird, soll dich der Drawer schließen
                DrawerLayout drawer = findViewById(R.id.drawer_layout_home);
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_shopping){
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), "test", Snackbar.LENGTH_LONG);
            snackbar.show();
        }else if (at1.onOptionsItemSelected(item)){
            View view = getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeToNotHome(String value){
        Intent i = new Intent(HomeActivity.this, NotHomeActivity.class);
        i.putExtra("key", value);
        i.putExtra("content", ContentType.TEST_TYPE);
        startActivity(i);
    }

    @SuppressLint("ResourceType")
    private void setUpToolBar(boolean deliver){
        TextView textView = findViewById(R.id.app_bar_2_deliver_text);
        textView.setText("Deliver to Nicolas - München 80636");

        int actionBarHeight = 52;
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }

        LinearLayout linearLayout1 = findViewById(R.id.app_bar_2_buttons);
        CollapsingToolbarLayout.LayoutParams params = (CollapsingToolbarLayout.LayoutParams) linearLayout1.getLayoutParams();
        int dp48 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, this.getResources().getDisplayMetrics());
        params.topMargin = dp48 + actionBarHeight;
        linearLayout1.setLayoutParams(params);

        LinearLayout linearLayout2 = findViewById(R.id.app_bar_2_deliver);
        params = (CollapsingToolbarLayout.LayoutParams) linearLayout2.getLayoutParams();
        params.topMargin = dp48 + dp48 + actionBarHeight;
        linearLayout2.setLayoutParams(params);

        if (!deliver){
            CollapsingToolbarLayout ctl = findViewById(R.id.my_collapsingToolbarLayout);
            ctl.removeView(findViewById(R.id.app_bar_2_deliver));
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
