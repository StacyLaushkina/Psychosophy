package com.laushkina.anastasia.psychosophy.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.view.introduction.IntroductionFragment
import com.laushkina.anastasia.psychosophy.view.test.TestFragment

class MainActivity: Activity(), NavigationView.OnNavigationItemSelectedListener {
    companion object {
        const val SCREEN_NAME_EXTRA = "main_activity_screen_name"
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
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
        if (intent.extras == null) return

        when (intent.extras!!.getSerializable(SCREEN_NAME_EXTRA) as Screen) {
            Screen.TEST -> fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, TestFragment())
                    .commit()
            Screen.INTRODUCTION -> fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, IntroductionFragment())
                    .commit()
        }
    }

    private fun showSelectedScreen(selectedItem: Int) {
        when (selectedItem) {
            R.id.nav_introduction -> NavigationHelper.instance.showIntroduction(fragmentManager)
            R.id.nav_test -> NavigationHelper.instance.showTest(fragmentManager)
            R.id.nav_psychotypes -> NavigationHelper.instance.showTypes(fragmentManager)
            R.id.nav_relationships -> NavigationHelper.instance.showRelationships(fragmentManager)
            R.id.nav_functions -> NavigationHelper.instance.showFunctions(fragmentManager)
            R.id.nav_about -> NavigationHelper.instance.showAbout(fragmentManager)
            R.id.nav_bases_and_functions -> NavigationHelper.instance.showBasesAndFunctions(fragmentManager)
        }
    }

    private fun initializeLeftMenu() {
        val toolbar = getToolbar()
        // If activity doesn't have toolbar - no action is needed

        val drawer = getDrawerLayout()
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
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