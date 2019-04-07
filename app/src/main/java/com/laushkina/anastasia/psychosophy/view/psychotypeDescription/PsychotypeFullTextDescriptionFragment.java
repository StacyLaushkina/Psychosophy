package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentPsychotypeFullTextDescriptionBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;

public class PsychotypeFullTextDescriptionFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentPsychotypeFullTextDescriptionBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_psychotype_full_text_description,
                container,
                false);
        binding.setFullDescription(PsychotypeDescriptionGetter.getFull(getPsychotype(), getActivity()));
        return binding.getRoot();
    }

    @Override
    protected CharSequence getTitle(){
        return getResources().getString(R.string.psychotype_description);
    }

    @Override
    protected int getNavigationItemId(){
        return R.id.nav_psychotypes;
    }

    private Psychotype getPsychotype(){
        return (Psychotype) getArguments().getSerializable(PsychotypesFragment.psychotypeExtra);
    }

}
