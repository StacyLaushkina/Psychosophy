package com.laushkina.anastasia.psychosophy.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.laushkina.anastasia.psychosophy.R;

public class MainActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String screenNameExtra = "screenNameExtra";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLeftMenu();
        openRequestedContent(getIntent());
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        openRequestedContent(intent);
    }

    // Only test and psychotypes fragments can be requested (from welcome activity)
    private void openRequestedContent(Intent intent){
        if (intent.getExtras() == null) return;

        Screen screen = (Screen)intent.getExtras().getSerializable(screenNameExtra);
        if (screen == null) return;

        switch (screen) {
            case test:
                NavigationHelper.showTest(getFragmentManager(), getNavigationView());
                break;
            case introduction:
                NavigationHelper.showIntroduction(getFragmentManager(), getNavigationView());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_introduction:
                NavigationHelper.showIntroduction(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_test:
                NavigationHelper.showTest(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_psychotypes:
                NavigationHelper.showTypes(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_relationships:
                NavigationHelper.showRelationships(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_functions:
                NavigationHelper.showFunctions(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_about:
                NavigationHelper.showAbout(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_aspects_and_functions:
                NavigationHelper.showAspectsAndFunctions(getFragmentManager(), getNavigationView());

        }

        DrawerLayout drawer = getDrawerLayout();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initializeLeftMenu(){
        Toolbar toolbar = getToolbar();
        // If activity doesn't have toolbar - no action is needed
        if (toolbar == null) return;

        DrawerLayout drawer = getDrawerLayout();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = getNavigationView();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private Toolbar getToolbar(){
        return (Toolbar)findViewById(R.id.toolbar);
    }

    private NavigationView getNavigationView(){
        return (NavigationView) findViewById(R.id.nav_view);
    }

    private DrawerLayout getDrawerLayout(){
        return (DrawerLayout) findViewById(R.id.drawer_layout);
    }

}
