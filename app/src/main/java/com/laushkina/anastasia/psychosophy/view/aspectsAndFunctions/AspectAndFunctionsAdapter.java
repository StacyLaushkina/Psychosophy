package com.laushkina.anastasia.psychosophy.view.aspectsAndFunctions;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class AspectAndFunctionsAdapter extends FragmentPagerAdapter {

    public static final int ASPECTS = 0;
    public static final int FUNCTIONS = 1;
    private static final int PAGE_AMOUNT = 2;

    AspectAndFunctionsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case ASPECTS: {
                fragment = new AspectsFragment();
                break;
            }
            case FUNCTIONS: {
                fragment = new FunctionsFragment();
                break;
            }
            default:
                throw new RuntimeException("Cannot detect aspects and fragments page");
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_AMOUNT;
    }
}
