package com.laushkina.anastasia.psychosophy.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.view.introduction.IntroductionFragment
import com.laushkina.anastasia.psychosophy.view.test.TestFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    companion object {
        const val SCREEN_NAME_EXTRA = "main_activity_screen_name"
        const val TAG = "[MainActivity]"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeLeftMenu()

        if (savedInstanceState == null) {
            openRequestedContent(intent)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        showSelectedScreen(item.itemId)

        val drawer = getDrawerLayout()
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    public override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        openRequestedContent(intent)
    }

    // Only test and psychotypes fragments can be requested (from welcome activity)
    private fun openRequestedContent(intent: Intent) {
        val extras = intent.extras
        val screen = if (extras != null) extras.getSerializable(SCREEN_NAME_EXTRA) as Screen else null

        if (screen != null) {
            when (screen) {
                Screen.TEST -> supportFragmentManager.beginTransaction()
                        .replace(R.id.content_frame, TestFragment())
                        .commit()
                Screen.INTRODUCTION -> supportFragmentManager.beginTransaction()
                        .replace(R.id.content_frame, IntroductionFragment())
                        .commit()
                else -> Log.d(TAG, "Main activity was requested to open unknown content:$screen")
            }
        }
    }

    private fun showSelectedScreen(selectedItem: Int) {
        when (selectedItem) {
            R.id.nav_introduction -> NavigationHelper.instance.showIntroduction(supportFragmentManager)
            R.id.nav_test -> NavigationHelper.instance.showTest(supportFragmentManager)
            R.id.nav_psychotypes -> NavigationHelper.instance.showTypes(supportFragmentManager)
            R.id.nav_relationships -> NavigationHelper.instance.showRelationships(supportFragmentManager)
            R.id.nav_functions -> NavigationHelper.instance.showFunctions(supportFragmentManager)
            R.id.nav_about -> NavigationHelper.instance.showAbout(supportFragmentManager)
            R.id.nav_bases_and_functions -> NavigationHelper.instance.showBasesAndFunctions(supportFragmentManager)
        }
    }

    private fun initializeLeftMenu() {
        val toolbar = getToolbar()

        setSupportActionBar(toolbar)
        // If activity doesn't have toolbar - no action is needed
        val drawer = getDrawerLayout()
        val toggle = ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        getNavigationView().setNavigationItemSelectedListener(this)
    }

    private fun getToolbar(): Toolbar {
        return findViewById(R.id.toolbar)
    }

    private fun getNavigationView(): NavigationView {
        return findViewById(R.id.nav_view)
    }

    private fun getDrawerLayout(): DrawerLayout {
        return findViewById(R.id.drawer_layout)
    }
}