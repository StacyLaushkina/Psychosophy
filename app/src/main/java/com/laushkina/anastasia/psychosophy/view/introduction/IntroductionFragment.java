package com.laushkina.anastasia.psychosophy.view.introduction;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentIntroductionBinding;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class IntroductionFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentIntroductionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_introduction,
                container, false);

        setTitle();
        return binding.getRoot();
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.introduction);
    }
}
