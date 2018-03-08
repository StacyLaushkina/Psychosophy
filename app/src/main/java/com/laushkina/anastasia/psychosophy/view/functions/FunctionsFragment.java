package com.laushkina.anastasia.psychosophy.view.functions;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentFunctionsBinding;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.utils.SlidingTabLayout;

public class FunctionsFragment extends BaseFragment {

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

        FunctionsAdapter adapter = new FunctionsAdapter(getActivity().getFragmentManager());
        ViewPager pager = view.findViewById(R.id.functions_pager);
        pager.setAdapter(adapter);

        SlidingTabLayout tabLayout = view.findViewById(R.id.sliding_tabs);
        tabLayout.setViewPager(pager);
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.functions);
    }
}
