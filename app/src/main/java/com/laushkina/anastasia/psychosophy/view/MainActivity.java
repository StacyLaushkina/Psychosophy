package com.laushkina.anastasia.psychosophy.view;

import android.app.Activity;
import android.app.Fragment;
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
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.introduction.IntroductionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeFullTextDescriptionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;
import com.laushkina.anastasia.psychosophy.view.test.TestFragment;

public class MainActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String SCREEN_NAME_EXTRA = "main_activity_screen_name";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLeftMenu();

        if (savedInstanceState == null){
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

        Screen screen = (Screen) intent.getExtras().getSerializable(SCREEN_NAME_EXTRA);
        if (screen == null) return;

        switch (screen) {
            case test:
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, new TestFragment())
                        .commit();
                break;
            case introduction:
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, new IntroductionFragment())
                        .commit();
            case psychotypes:
                Psychotype type = intent.getExtras().getParcelable(PsychotypesFragment.psychotypeExtra);
                Bundle bundle = new Bundle(1);
                bundle.putSerializable(PsychotypesFragment.psychotypeExtra, type);
                Fragment fullDescription = new PsychotypeDescriptionFragment();
                fullDescription.setArguments(bundle);

                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, fullDescription)
                        .commit();
        }
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
                NavigationHelper.getInstance().showIntroduction(getFragmentManager());
                break;
            case R.id.nav_test:
                NavigationHelper.getInstance().showTest(getFragmentManager());
                break;
            case R.id.nav_psychotypes:
                NavigationHelper.getInstance().showTypes(getFragmentManager());
                break;
            case R.id.nav_relationships:
                NavigationHelper.getInstance().showRelationships(getFragmentManager());
                break;
            case R.id.nav_functions:
                NavigationHelper.getInstance().showFunctions(getFragmentManager());
                break;
            case R.id.nav_about:
                NavigationHelper.getInstance().showAbout(getFragmentManager());
                break;
            case R.id.nav_bases_and_functions:
                NavigationHelper.getInstance().showBasesAndFunctions(getFragmentManager());

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

        getNavigationView().setNavigationItemSelectedListener(this);
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
