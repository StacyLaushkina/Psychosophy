package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;

public class PsychotypeDescriptionAdapter extends FragmentPagerAdapter {

    public static final int PREVIEW_DESCRIPTION = 0;
    public static final int FULL_TEXT_DESCRIPTION = 1;
    private static final int PAGE_AMOUNT = 2;

    private Psychotype psychotype;

    PsychotypeDescriptionAdapter(FragmentManager fragmentManager, Psychotype psychotype){
        super(fragmentManager);
        this.psychotype = psychotype;
    }

    public void setPsychotype(Psychotype psychotype){
        this.psychotype = psychotype;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case PREVIEW_DESCRIPTION: {
                fragment = new PsychotypePreviewDescriptionFragment();
                break;
            }
            case FULL_TEXT_DESCRIPTION: {
                fragment = new PsychotypeFullTextDescriptionFragment();
                break;
            }
            default:
                throw new RuntimeException("Cannot detect psychotype description page");
        }

        Bundle typeExtra = new Bundle(1);
        typeExtra.putSerializable(PsychotypesFragment.psychotypeExtra, psychotype);
        fragment.setArguments(typeExtra);

        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_AMOUNT;
    }
}
