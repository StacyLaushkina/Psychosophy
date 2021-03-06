package com.laushkina.anastasia.psychosophy.view.basesAndFunctions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class BasesAndFunctionsAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    companion object {
        const val BASES = 0
        const val FUNCTIONS = 1
        private const val PAGE_AMOUNT = 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            BASES -> {
                BasesFragment()
            }
            FUNCTIONS -> {
                FunctionsDecriptionFragment()
            }
            else -> throw RuntimeException("Cannot detect bases and fragments page")
        }
    }

    override fun getCount(): Int {
       return PAGE_AMOUNT
    }
}