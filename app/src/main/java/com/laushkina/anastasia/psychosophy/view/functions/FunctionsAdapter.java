package com.laushkina.anastasia.psychosophy.view.functions;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class FunctionsAdapter extends FragmentPagerAdapter {

    public static final int FIRST_FUNCTION = 0;
    public static final int SECOND_FUNCTION = 1;
    public static final int THIRD_FUNCTION = 2;
    public static final int FORTH_FUNCTION = 3;
    private static final int PAGE_AMOUNT = 4;

    FunctionsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case FIRST_FUNCTION:
                return new FirstFunctionFragment();
            case SECOND_FUNCTION:
                return new SecondFunctionFragment();
            case THIRD_FUNCTION:
                return new ThirdFunctionFragment();
            case FORTH_FUNCTION:
                return new ForthFunctionFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_AMOUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Function " + (position + 1);
    }
}
