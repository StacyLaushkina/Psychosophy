package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentPsychotypeDescriptionBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.PsychotypeImageGetter;

public class PsychotypeDescriptionFragment extends BaseFragment {

    public static final String psychotypeExtra = "psychotypeEtra";
    private Psychotype psychotype;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentPsychotypeDescriptionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_psychotype_description,
                container, false);
        binding.setFragment(this);

        setTitle();
        return binding.getRoot();
    }

    @Override
    protected String getTitle(){
        if (getArguments() == null) return getResources().getString(R.string.psychotype_description);

        psychotype = (Psychotype)getArguments().getSerializable(psychotypeExtra);
        return psychotype == null ? getResources().getString(R.string.psychotype_description) : psychotype.getDescription();
    }

    public Drawable getImageForType(){
        return PsychotypeImageGetter.get(psychotype, getActivity());
    }

    public String getShortDescription(){
        return PsychotypeDescriptionGetter.getShort(psychotype, getActivity());
    }

    public String getDescription(){
        return PsychotypeDescriptionGetter.getFull(psychotype, getActivity());
    }

    public String getFirstFunction(){
        return "1" + psychotype.asFunctionsArray()[0].name();
    }

    public String getSecondFunction(){
        return "2" + psychotype.asFunctionsArray()[1].name();
    }

    public String getThirdFunction(){
        return "3" + psychotype.asFunctionsArray()[2].name();
    }

    public String getForthFunction(){
        return "4" + psychotype.asFunctionsArray()[3].name();
    }

    public void relatedFirstFunction(){
    }

    public void relatedSecondFunction(){
    }

    public void relatedThirdFunction(){
    }

    public void relatedForthFunction(){
    }
}
