package com.laushkina.anastasia.psychosophy.view.functions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class FunctionsFragment extends BaseFragment {

    public static final String REQUESTED_TAB = "tabExtra";
    private static final int NO_TAB_REQUESTED = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_functions, container, false);
        initialize(view);

        return view;
    }

    private void initialize(View view){
        setTitle();

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.first_function_title)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.second_function_title)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.third_function_title)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.forth_function_title)));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        FunctionsAdapter adapter = new FunctionsAdapter(getChildFragmentManager(), getActivity(), getRequestedFunction());
        ViewPager pager = view.findViewById(R.id.functions_pager);
        pager.setAdapter(adapter);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        Integer requestedTab = getRequestedTab();
        if (requestedTab != NO_TAB_REQUESTED) {
            pager.setCurrentItem(requestedTab);
        }
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.functions);
    }

    private Integer getRequestedTab(){
        return getArguments() == null ? NO_TAB_REQUESTED : getArguments().getInt(REQUESTED_TAB, NO_TAB_REQUESTED);
    }

    private Function getRequestedFunction(){
        return getArguments() == null ? null : (Function)getArguments().getSerializable(FunctionsDescriptionFragment.requestedFunctionExtra);
    }
}
