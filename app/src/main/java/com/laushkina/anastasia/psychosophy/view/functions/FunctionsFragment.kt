package com.laushkina.anastasia.psychosophy.view.functions

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction
import com.laushkina.anastasia.psychosophy.view.BaseFragment

class FunctionsFragment: BaseFragment() {
    companion object {
        const val REQUESTED_TAB = "tabExtra"
        private const val NO_TAB_REQUESTED = -1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_functions, container, false)
        initialize(view)

        return view
    }

    private fun initialize(view: View) {
        initialize()

        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.first_function_title)))
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.second_function_title)))
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.third_function_title)))
        tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.forth_function_title)))

        val adapter = FunctionsAdapter(childFragmentManager, view.context, getRequestedFunction())
        val pager = view.findViewById<ViewPager>(R.id.functions_pager)
        pager.adapter = adapter

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        val requestedTab = getRequestedTab()
        if (requestedTab != NO_TAB_REQUESTED) {
            pager.currentItem = requestedTab
        }
    }

    override fun getTitle(): CharSequence {
        return resources.getString(R.string.functions)
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_functions
    }

    private fun getRequestedTab(): Int {
        val bundle = arguments
        return bundle?.getInt(REQUESTED_TAB, NO_TAB_REQUESTED) ?: NO_TAB_REQUESTED
    }

    private fun getRequestedFunction(): PsychoFunction? {
        val bundle = arguments ?: return null

        val functionExtra = bundle.getSerializable(FunctionsDescriptionFragment.requestedFunctionExtra)
        return if (functionExtra == null) null else functionExtra as PsychoFunction
    }

}