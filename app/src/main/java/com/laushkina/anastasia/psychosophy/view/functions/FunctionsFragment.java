package com.laushkina.anastasia.psychosophy.view.functions;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentFunctionsBinding;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class FunctionsFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentFunctionsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_functions,
                container, false);
        binding.setFragment(this);

        setTitle();
        return binding.getRoot();
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.functions);
    }
}
