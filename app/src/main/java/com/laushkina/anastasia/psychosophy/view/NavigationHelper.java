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

    // Selected page is saved for keeping it when onSaveInstanceState() happens
    public int getSelectedPage(){
        return selectedPage;
    }

    //Navigation can me made through helper and back button
    public void setSelectedPage(int page){
        this.selectedPage = page;
    }

    public void showTest(FragmentManager manager) {
        changeContent(new TestFragment(), manager, R.id.nav_test, false);
    }

    public void showTypes(FragmentManager manager){
        changeContent(new PsychotypesFragment(), manager, R.id.nav_psychotypes, false);
    }

    public void showFunctions(FragmentManager manager){
        changeContent(new FunctionsFragment(), manager, R.id.nav_functions, false);
    }

    public void showFunctions(FragmentManager manager, int requestedTab, Function requestedFunction){
        Bundle bundle = new Bundle(2);
        bundle.putInt(com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment.REQUESTED_TAB, requestedTab);
        bundle.putSerializable(FunctionsDescriptionFragment.requestedFunctionExtra, requestedFunction);

        com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment fragment = new com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment();
        fragment.setArguments(bundle);

        changeContent(fragment, manager, R.id.nav_functions, false);
    }

    public void showAbout(FragmentManager manager){
        changeContent(new AboutFragment(), manager, R.id.nav_about, false);
    }

    public void showIntroduction(FragmentManager manager){
        changeContent(new IntroductionFragment(), manager, R.id.nav_introduction, false);
    }

    public void showTestResults(Psychotype[] results, FragmentManager manager){
        Bundle bundle = new Bundle(1);
        bundle.putParcelableArray(TestResultsFragment.testResultsExtra, results);

        TestResultsFragment fragment = new TestResultsFragment();
        fragment.setArguments(bundle);

        // Showing test results doesn't change selected page - so force update is needed
        changeContent(fragment, manager, R.id.nav_test, true);
    }

    public void showTypeDescription(Psychotype type, FragmentManager manager) {
        Bundle bundle = new Bundle(1);
        bundle.putSerializable(PsychotypesFragment.psychotypeExtra, type);

        // Showing concrete psychotype doesn't change selected page - so force update is needed
        PsychotypeDescriptionFragment fragment = new PsychotypeDescriptionFragment();
        fragment.setArguments(bundle);
        changeContent(fragment, manager, R.id.nav_psychotypes, true);
    }

    public void showRelationships(FragmentManager manager){
        changeContent(new RelationshipsFragment(), manager, R.id.nav_relationships, false);
    }

    public void showAspectsAndFunctions(FragmentManager manager){
        changeContent(new AspectAndFunctionsFragment(), manager, R.id.nav_aspects_and_functions, false);
    }

    private void changeContent(Fragment fragment, FragmentManager manager, int checkedItemId, boolean doForceChange){
        // Do not recreate fragment -- keep all changes in it
        if (selectedPage == checkedItemId && !doForceChange) return;

        // Insert the fragment by replacing any existing fragment
        manager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}
