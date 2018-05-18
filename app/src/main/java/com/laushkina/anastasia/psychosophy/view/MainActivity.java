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

    public static final String SCREEN_NAME_EXTRA = "main_activity_screen_name";
    private static final String SAVED_PAGE_EXTRA = "main_activity_saved_page";
    private static final int PAGE_WAS_NOT_SAVED = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLeftMenu();

        int savedPage = savedInstanceState == null ? PAGE_WAS_NOT_SAVED : savedInstanceState.getInt(SAVED_PAGE_EXTRA, PAGE_WAS_NOT_SAVED);
        if (savedPage != PAGE_WAS_NOT_SAVED){
            showSelectedScreen(savedPage);
        } else {
            openRequestedContent(getIntent());
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        openRequestedContent(intent);
    }

    // Only test and psychotypes fragments can be requested (from welcome activity)
    private void openRequestedContent(Intent intent){
        if (intent.getExtras() == null) return;

        Screen screen = (Screen)intent.getExtras().getSerializable(SCREEN_NAME_EXTRA);
        if (screen == null) return;

        switch (screen) {
            case test:
                NavigationHelper.getInstance().showTest(getFragmentManager(), getNavigationView());
                break;
            case introduction:
                NavigationHelper.getInstance().showIntroduction(getFragmentManager(), getNavigationView());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt(SAVED_PAGE_EXTRA, NavigationHelper.getInstance().getSelectedPage());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        showSelectedScreen(item.getItemId());

        DrawerLayout drawer = getDrawerLayout();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showSelectedScreen(int selectedItem){
        switch (selectedItem) {
            case R.id.nav_introduction:
                NavigationHelper.getInstance().showIntroduction(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_test:
                NavigationHelper.getInstance().showTest(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_psychotypes:
                NavigationHelper.getInstance().showTypes(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_relationships:
                NavigationHelper.getInstance().showRelationships(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_functions:
                NavigationHelper.getInstance().showFunctions(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_about:
                NavigationHelper.getInstance().showAbout(getFragmentManager(), getNavigationView());
                break;
            case R.id.nav_aspects_and_functions:
                NavigationHelper.getInstance().showAspectsAndFunctions(getFragmentManager(), getNavigationView());

        }
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
