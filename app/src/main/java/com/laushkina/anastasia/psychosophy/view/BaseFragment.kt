package com.laushkina.anastasia.psychosophy.view

import android.app.Fragment
import com.google.android.material.navigation.NavigationView
import android.widget.TextView
import com.laushkina.anastasia.psychosophy.R

abstract class BaseFragment: Fragment() {
    fun initialize() {
        setToolbar()
        setNavigationItemId()
    }

    protected abstract fun getTitle(): CharSequence

    protected abstract fun getNavigationItemId(): Int

    private fun setToolbar() {
        val toolbar = getToolbar()
        toolbar.text = getTitle()
    }

    private fun setNavigationItemId() {
        val navigationView = getNavigationView()
        navigationView.setCheckedItem(getNavigationItemId())
        NavigationHelper.instance.setSelectedPage(getNavigationItemId())
    }

    private fun getToolbar(): TextView {
        return activity.findViewById(R.id.toolbar_title)
    }

    private fun getNavigationView(): NavigationView {
        return activity.findViewById(R.id.nav_view)
    }
}