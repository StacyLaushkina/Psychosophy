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
import com.laushkina.anastasia.psychosophy.view.aspectsAndFunctions.AspectsAndFunctions_FunctionsFragment;
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsDescriptionFragment;
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment;
import com.laushkina.anastasia.psychosophy.view.introduction.IntroductionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;
import com.laushkina.anastasia.psychosophy.view.relationships.RelationshipsFragment;
import com.laushkina.anastasia.psychosophy.view.test.TestFragment;
import com.laushkina.anastasia.psychosophy.view.test.TestResultsFragment;

public final class NavigationHelper {

    private int selectedPage;
    private static NavigationHelper instance;

    private NavigationHelper(){
        selectedPage = -1;
    }

    public static synchronized NavigationHelper getInstance(){
        if (instance == null) {
            instance = new NavigationHelper();
        }
        return instance;
    }

    public int getSelectedPage(){
        return selectedPage;
    }

    public void showTest(FragmentManager manager, NavigationView navigationView) {
        changeContent(new TestFragment(), manager, navigationView, R.id.nav_test, false);
    }

    public void showTypes(FragmentManager manager, NavigationView navigationView){
        changeContent(new PsychotypesFragment(), manager, navigationView, R.id.nav_psychotypes, false);
    }

    public void showFunctions(FragmentManager manager, NavigationView navigationView){
        changeContent(new FunctionsFragment(), manager, navigationView, R.id.nav_functions, false);
    }

    public void showFunctions(FragmentManager manager, int requestedTab, Function requestedFunction, NavigationView navigationView){
        Bundle bundle = new Bundle(2);
        bundle.putInt(com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment.REQUESTED_TAB, requestedTab);
        bundle.putSerializable(FunctionsDescriptionFragment.requestedFunctionExtra, requestedFunction);

        com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment fragment = new com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment();
        fragment.setArguments(bundle);

        changeContent(fragment, manager, navigationView, R.id.nav_functions, false);
    }

    public void showAbout(FragmentManager manager, NavigationView navigationView){
        changeContent(new AboutFragment(), manager, navigationView, R.id.nav_about, false);
    }

    public void showIntroduction(FragmentManager manager, NavigationView navigationView){
        changeContent(new IntroductionFragment(), manager, navigationView, R.id.nav_introduction, false);
    }

    public void showTestResults(Psychotype[] results, FragmentManager manager, NavigationView navigationView){
        Bundle bundle = new Bundle(1);
        bundle.putParcelableArray(TestResultsFragment.testResultsExtra, results);

        TestResultsFragment fragment = new TestResultsFragment();
        fragment.setArguments(bundle);

        changeContent(fragment, manager, navigationView, R.id.nav_test, true);
    }

    public void showTypeDescription(Psychotype type, FragmentManager manager, NavigationView navigationView) {
        Bundle bundle = new Bundle(1);
        bundle.putSerializable(PsychotypesFragment.psychotypeExtra, type);

        PsychotypeDescriptionFragment fragment = new PsychotypeDescriptionFragment();
        fragment.setArguments(bundle);
        changeContent(fragment, manager, navigationView, R.id.nav_psychotypes, true);
    }

    public void showRelationships(FragmentManager manager, NavigationView navigationView){
        changeContent(new RelationshipsFragment(), manager, navigationView, R.id.nav_relationships, false);
    }

    public void showAspectsAndFunctions(FragmentManager manager, NavigationView navigationView){
        changeContent(new AspectAndFunctionsFragment(), manager, navigationView, R.id.nav_aspects_and_functions, false);
    }

    private void changeContent(Fragment fragment, FragmentManager manager,
                               NavigationView navigationView, int checkedItemId, boolean doForceChange){
        if (selectedPage == checkedItemId && !doForceChange) return;

        // Insert the fragment by replacing any existing fragment
        manager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();

        selectedPage = checkedItemId;
        navigationView.setCheckedItem(checkedItemId);
    }
}
