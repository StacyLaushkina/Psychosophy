package com.laushkina.anastasia.psychosophy.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.view.about.AboutFragment;
import com.laushkina.anastasia.psychosophy.view.aspectsAndFunctions.AspectAndFunctionsFragment;
import com.laushkina.anastasia.psychosophy.view.aspectsAndFunctions.FunctionsFragment;
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsDescriptionFragment;
import com.laushkina.anastasia.psychosophy.view.introduction.IntroductionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;
import com.laushkina.anastasia.psychosophy.view.relationships.RelationshipsFragment;
import com.laushkina.anastasia.psychosophy.view.test.TestFragment;
import com.laushkina.anastasia.psychosophy.view.test.TestResultsFragment;

public final class NavigationHelper {

    public static void showTest(FragmentManager manager, NavigationView navigationView) {
        changeContent(new TestFragment(), manager);
        navigationView.setCheckedItem(R.id.nav_test);
    }

    public static void showTypes(FragmentManager manager, NavigationView navigationView){
        changeContent(new PsychotypesFragment(), manager);
        navigationView.setCheckedItem(R.id.nav_psychotypes);
    }

    public static void showFunctions(FragmentManager manager, NavigationView navigationView){
        changeContent(new com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment(), manager);
        navigationView.setCheckedItem(R.id.nav_functions);
    }

    public static void showFunctions(FragmentManager manager, int requestedTab, Function requestedFunction, NavigationView navigationView){
        Bundle bundle = new Bundle(2);
        bundle.putInt(com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment.REQUESTED_TAB, requestedTab);
        bundle.putSerializable(FunctionsDescriptionFragment.requestedFunctionExtra, requestedFunction);

        com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment fragment = new com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment();
        fragment.setArguments(bundle);

        changeContent(fragment, manager);
        navigationView.setCheckedItem(R.id.nav_functions);
    }

    public static void showAbout(FragmentManager manager, NavigationView navigationView){
        changeContent(new AboutFragment(), manager);
        navigationView.setCheckedItem(R.id.nav_about);
    }

    public static void showIntroduction(FragmentManager manager, NavigationView navigationView){
        changeContent(new IntroductionFragment(), manager);
        navigationView.setCheckedItem(R.id.nav_introduction);
    }

    public static void showTestResults(Psychotype[] results, FragmentManager manager, NavigationView navigationView){
        Bundle bundle = new Bundle(1);
        bundle.putParcelableArray(TestResultsFragment.testResultsExtra, results);

        TestResultsFragment fragment = new TestResultsFragment();
        fragment.setArguments(bundle);

        changeContent(fragment, manager);
        navigationView.setCheckedItem(R.id.nav_test);
    }

    public static void showTypeDescription(Psychotype type, FragmentManager manager, NavigationView navigationView) {
        Bundle bundle = new Bundle(1);
        bundle.putSerializable(PsychotypesFragment.psychotypeExtra, type);

        PsychotypeDescriptionFragment fragment = new PsychotypeDescriptionFragment();
        fragment.setArguments(bundle);
        changeContent(fragment, manager);
        navigationView.setCheckedItem(R.id.nav_psychotypes);
    }

    public static void showRelationships(FragmentManager manager, NavigationView navigationView){
        changeContent(new RelationshipsFragment(), manager);
        navigationView.setCheckedItem(R.id.nav_relationships);
    }

    public static void showAspectsAndFunctions(FragmentManager manager, NavigationView navigationView){
        changeContent(new AspectAndFunctionsFragment(), manager);
        navigationView.setCheckedItem(R.id.nav_aspects_and_functions);
    }

    private static void changeContent(Fragment fragment, FragmentManager manager){
        // Insert the fragment by replacing any existing fragment
        manager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}
