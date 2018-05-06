package com.laushkina.anastasia.psychosophy.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.view.about.AboutFragment;
import com.laushkina.anastasia.psychosophy.view.aspectsAndFunctions.AspectsAndFunctionsFragment;
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment;
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsDescriptionFragment;
import com.laushkina.anastasia.psychosophy.view.introduction.IntroductionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;
import com.laushkina.anastasia.psychosophy.view.relationships.RelationshipsFragment;
import com.laushkina.anastasia.psychosophy.view.test.TestFragment;
import com.laushkina.anastasia.psychosophy.view.test.TestResultsFragment;

public final class NavigationHelper {

    public static void showTest(FragmentManager manager) {
        changeContent(new TestFragment(), manager);
    }

    public static void showTypes(FragmentManager manager){
        changeContent(new PsychotypesFragment(), manager);
    }

    public static void showFunctions(FragmentManager manager){
        changeContent(new FunctionsFragment(), manager);
    }

    public static void showFunctions(FragmentManager manager, int requestedTab, Function requestedFunction){
        Bundle bundle = new Bundle(2);
        bundle.putInt(FunctionsFragment.REQUESTED_TAB, requestedTab);
        bundle.putSerializable(FunctionsDescriptionFragment.requestedFunctionExtra, requestedFunction);

        FunctionsFragment fragment = new FunctionsFragment();
        fragment.setArguments(bundle);

        changeContent(fragment, manager);
    }

    public static void showAbout(FragmentManager manager){
        changeContent(new AboutFragment(), manager);
    }

    public static void showIntroduction(FragmentManager manager){
        changeContent(new IntroductionFragment(), manager);
    }

    public static void showTestResults(Psychotype[] results, FragmentManager manager){
        Bundle bundle = new Bundle(1);
        bundle.putParcelableArray(TestResultsFragment.testResultsExtra, results);

        TestResultsFragment fragment = new TestResultsFragment();
        fragment.setArguments(bundle);

        changeContent(fragment, manager);
    }

    public static void showTypeDescription(Psychotype type, FragmentManager manager) {
        Bundle bundle = new Bundle(1);
        bundle.putSerializable(PsychotypesFragment.psychotypeExtra, type);

        PsychotypeDescriptionFragment fragment = new PsychotypeDescriptionFragment();
        fragment.setArguments(bundle);
        changeContent(fragment, manager);
    }

    public static void showRelationships(FragmentManager manager){
        changeContent(new RelationshipsFragment(), manager);
    }

    public static void showAspectsAndFunctions(FragmentManager manager){
        changeContent(new AspectsAndFunctionsFragment(), manager);
    }

    private static void changeContent(Fragment fragment, FragmentManager manager){
        // Insert the fragment by replacing any existing fragment
        manager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}
