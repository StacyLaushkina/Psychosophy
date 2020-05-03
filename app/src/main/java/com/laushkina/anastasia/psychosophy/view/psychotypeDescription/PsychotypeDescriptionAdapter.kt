package com.laushkina.anastasia.psychosophy.view.psychotypeDescription

import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import android.support.v13.app.FragmentPagerAdapter
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment

class PsychotypeDescriptionAdapter(fm: FragmentManager,
                                   private var psychotype: Psychotype?): FragmentPagerAdapter(fm) {

    fun setPsychotype(psychotype: Psychotype) {
        this.psychotype = psychotype
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        val fragment: Fragment = when (position) {
            PREVIEW_DESCRIPTION -> {
                PsychotypeOverviewDescriptionFragment()
            }
            FULL_TEXT_DESCRIPTION -> {
                PsychotypeFullTextDescriptionFragment()
            }
            else -> throw RuntimeException("Cannot detect psychotype description page")
        }

        val typeExtra = Bundle(1)
        typeExtra.putSerializable(PsychotypesFragment.psychotypeExtra, psychotype)
        fragment.arguments = typeExtra

        return fragment
    }

    override fun getCount(): Int {
        return PAGE_AMOUNT
    }

    companion object {
        const val PREVIEW_DESCRIPTION = 0
        const val FULL_TEXT_DESCRIPTION = 1
        private const val PAGE_AMOUNT = 2
    }

}