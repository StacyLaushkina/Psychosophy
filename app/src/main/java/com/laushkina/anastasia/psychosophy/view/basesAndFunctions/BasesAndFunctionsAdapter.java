package com.laushkina.anastasia.psychosophy.view.basesAndFunctions;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class BasesAndFunctionsAdapter extends FragmentPagerAdapter {

    public static final int BASES = 0;
    public static final int FUNCTIONS = 1;
    private static final int PAGE_AMOUNT = 2;

    BasesAndFunctionsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case BASES: {
                fragment = new BasesFragment();
                break;
            }
            case FUNCTIONS: {
                fragment = new BasesAndFunctions_FunctionsFragment();
                break;
            }
            default:
                throw new RuntimeException("Cannot detect bases and fragments page");
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_AMOUNT;
    }
}
