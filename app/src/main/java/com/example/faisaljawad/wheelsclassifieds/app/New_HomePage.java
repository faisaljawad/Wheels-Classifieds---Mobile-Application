package com.example.faisaljawad.wheelsclassifieds.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.faisaljawad.wheelsclassifieds.Ad_Category;
import com.example.faisaljawad.wheelsclassifieds.ContactUs_Activity;
import com.example.faisaljawad.wheelsclassifieds.R;
import com.example.faisaljawad.wheelsclassifieds.accessories_fragment;
import com.example.faisaljawad.wheelsclassifieds.adapter.AdsAdapter;
import com.example.faisaljawad.wheelsclassifieds.fragment_bikes;
import com.example.faisaljawad.wheelsclassifieds.fragment_car;
import com.example.faisaljawad.wheelsclassifieds.login_signup;
import com.example.faisaljawad.wheelsclassifieds.model.ListDetails;
import com.example.faisaljawad.wheelsclassifieds.model.Model;
import com.example.faisaljawad.wheelsclassifieds.profile_activity;

import java.util.ArrayList;
import java.util.List;

public class New_HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private ArrayList<Model> models;
    private AdsAdapter adsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__home_page);
        listView = (ListView)findViewById(R.id.list_view);
        models = ListDetails.getList();
        adsAdapter = new AdsAdapter(New_HomePage.this,models);
        listView.setAdapter(adsAdapter);
        ListView search_vehicles;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        BottomNavigationView bottomnav=findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_cars:
                            selectedFragment = new fragment_car();
                            break;
                        case R.id.nav_bikes:
                            selectedFragment = new fragment_bikes();
                            break;
                        case R.id.nav_acc:
                            selectedFragment = new accessories_fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
           drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Log.d("abcd", item.toString());


        if(id == R.id.nav_loginsignup)
        {
            Intent i = new Intent(this, login_signup.class);
            startActivity(i);
        }
        else if (id == R.id.nav_contact)
        {
            Log.d("abcd", "abc");
            Intent i = new Intent(this, ContactUs_Activity.class);
            startActivity(i);
        }
        else if(id == R.id.nav_newad)
        {
            Intent i = new Intent(this, Ad_Category.class);
            startActivity(i);
        }
        else if(id == R.id.nav_header_title)
        {
            Intent i = new Intent(this, login_signup.class);
            startActivity(i);
        }
        else if(id == R.id.imageView)
        {
            Intent i = new Intent(this, login_signup.class);
            startActivity(i);
        }
        else if (id == R.id.nav_profile)
        {
            Intent i = new Intent(this, profile_activity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}