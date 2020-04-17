package com.laushkina.anastasia.psychosophy.view

import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction
import com.laushkina.anastasia.psychosophy.view.about.AboutFragment
import com.laushkina.anastasia.psychosophy.view.basesAndFunctions.BasesAndFunctionsFragment
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsDescriptionFragment
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment
import com.laushkina.anastasia.psychosophy.view.introduction.IntroductionFragment
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionFragment
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment
import com.laushkina.anastasia.psychosophy.view.relationships.RelationshipsFragment
import com.laushkina.anastasia.psychosophy.view.test.TestFragment
import com.laushkina.anastasia.psychosophy.view.test.TestResultsFragment

class NavigationHelper {
    private var selectedPage: Int = -1

    private object HOLDER {
        val INSTANCE = NavigationHelper()
    }

    companion object {
        val instance: NavigationHelper by lazy { HOLDER.INSTANCE }
    }

    //Navigation can me made through helper and back button
    fun setSelectedPage(page: Int) {
        this.selectedPage = page
    }

    fun showTest(manager: FragmentManager) {
        changeContent(TestFragment(), manager, R.id.nav_test, false)
    }

    fun showTypes(manager: FragmentManager) {
        changeContent(PsychotypesFragment(), manager, R.id.nav_psychotypes, false)
    }

    fun showFunctions(manager: FragmentManager) {
        changeContent(FunctionsFragment(), manager, R.id.nav_functions, false)
    }

    fun showFunctions(manager: FragmentManager, requestedTab: Int, requestedFunction: PsychoFunction?) {
        val bundle = Bundle(2)
        bundle.putInt(FunctionsFragment.REQUESTED_TAB, requestedTab)
        bundle.putSerializable(FunctionsDescriptionFragment.requestedFunctionExtra, requestedFunction)

        val fragment = FunctionsFragment()
        fragment.arguments = bundle

        changeContent(fragment, manager, R.id.nav_functions, false)
    }

    fun showAbout(manager: FragmentManager) {
        changeContent(AboutFragment(), manager, R.id.nav_about, false)
    }

    fun showIntroduction(manager: FragmentManager) {
        changeContent(IntroductionFragment(), manager, R.id.nav_introduction, false)
    }

    fun showTestResults(results: Array<Psychotype>?, manager: FragmentManager) {
        val bundle = Bundle(1)
        bundle.putParcelableArray(TestResultsFragment.testResultsExtra, results)

        val fragment = TestResultsFragment()
        fragment.arguments = bundle

        // Showing test results doesn't change selected page - so force update is needed
        changeContent(fragment, manager, R.id.nav_test, true)
    }

    fun showTypeDescription(type: Psychotype, manager: FragmentManager) {
        val bundle = Bundle(1)
        bundle.putSerializable(PsychotypesFragment.psychotypeExtra, type)

        // Showing concrete psychotype doesn't change selected page - so force update is needed
        val fragment = PsychotypeDescriptionFragment()
        fragment.arguments = bundle
        changeContent(fragment, manager, R.id.nav_psychotypes, true)
    }

    fun showRelationships(manager: FragmentManager) {
        changeContent(RelationshipsFragment(), manager, R.id.nav_relationships, false)
    }

    fun showBasesAndFunctions(manager: FragmentManager) {
        changeContent(BasesAndFunctionsFragment(), manager, R.id.nav_bases_and_functions, false)
    }

    private fun changeContent(fragment: Fragment, manager: FragmentManager, checkedItemId: Int, doForceChange: Boolean) {
        // Do not recreate fragment -- keep all changes in it
        if (selectedPage == checkedItemId && !doForceChange) return

        // Insert the fragment by replacing any existing fragment
        manager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit()
    }
}