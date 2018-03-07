package com.laushkina.anastasia.psychosophy.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.view.about.AboutFragment;
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;
import com.laushkina.anastasia.psychosophy.view.relationships.RelationshipsFragment;
import com.laushkina.anastasia.psychosophy.view.test.TestFragment;

import java.io.Serializable;

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

    public static void showAbout(FragmentManager manager){
        changeContent(new AboutFragment(), manager);
    }

    public static void showTypeDescription(Serializable type, FragmentManager manager) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(PsychotypesFragment.psychotypeExtra, type);

        PsychotypeDescriptionFragment fragment = new PsychotypeDescriptionFragment();
        fragment.setArguments(bundle);
        changeContent(fragment, manager);
    }

    public static void showRelationships(FragmentManager manager){
        changeContent(new RelationshipsFragment(), manager);
    }

    private static void changeContent(Fragment fragment, FragmentManager manager){
        // Insert the fragment by replacing any existing fragment
        manager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
    }
}
