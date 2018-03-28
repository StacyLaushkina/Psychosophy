package com.laushkina.anastasia.psychosophy.view.functions;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

public class FunctionsAdapter extends FragmentPagerAdapter {

    public static final int FIRST_FUNCTION = 0;
    public static final int SECOND_FUNCTION = 1;
    public static final int THIRD_FUNCTION = 2;
    public static final int FORTH_FUNCTION = 3;
    private static final int PAGE_AMOUNT = 4;

    private Function requestedFunction;
    private Context context;

    FunctionsAdapter(FragmentManager fm, Context context, Function requestedFunction) {
        super(fm);
        this.context = context;
        this.requestedFunction = requestedFunction;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle(2);
        bundle.putSerializable(FunctionsDescriptionFragment.requestedFunctionExtra, requestedFunction);

        FunctionsDescriptionFragment fragment;

        switch (position){
            case FIRST_FUNCTION:
                fragment = new FirstFunctionFragment();
                break;
            case SECOND_FUNCTION:
                fragment = new SecondFunctionFragment();
                break;
            case THIRD_FUNCTION:
                fragment = new ThirdFunctionFragment();
                break;
            case FORTH_FUNCTION:
                fragment = new ForthFunctionFragment();
                break;
            default:
                throw new AssertionError();
        }
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_AMOUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return context.getResources().getString(R.string.first_function_title);
            case 1: return context.getResources().getString(R.string.second_function_title);
            case 2: return context.getResources().getString(R.string.third_function_title);
            case 3: return context.getResources().getString(R.string.forth_function_title);
            default: return null;
        }
    }
}
