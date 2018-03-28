package com.laushkina.anastasia.psychosophy.view.functions;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentFunctionsBinding;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.utils.SlidingTabLayout;

public class FunctionsFragment extends BaseFragment {

    public static final String REQUESTED_TAB = "tabExtra";
    private static final int NO_TAB_REQUESTED = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentFunctionsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_functions,
                container, false);
        binding.setFragment(this);

        View view = binding.getRoot();
        initialize(view);

        return view;
    }

    private void initialize(View view){
        setTitle();

        FunctionsAdapter adapter = new FunctionsAdapter(getChildFragmentManager(), getActivity(), getRequestedFunction());
        ViewPager pager = view.findViewById(R.id.functions_pager);
        pager.setAdapter(adapter);

        SlidingTabLayout tabLayout = view.findViewById(R.id.sliding_tabs);
        tabLayout.setViewPager(pager);

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
