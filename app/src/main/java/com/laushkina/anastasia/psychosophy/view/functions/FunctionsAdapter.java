package com.laushkina.anastasia.psychosophy.view.functions;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class FunctionsAdapter extends FragmentPagerAdapter {

    private static final int FIRST_FUNCTION = 0;
    private static final int SECOND_FUNCTION = 1;
    private static final int THIRD_FUNCTION = 2;
    private static final int FORTH_FUNCTION = 3;

    public FunctionsAdapter(FragmentManager fm) {
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
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Function " + (position + 1);
    }
}
