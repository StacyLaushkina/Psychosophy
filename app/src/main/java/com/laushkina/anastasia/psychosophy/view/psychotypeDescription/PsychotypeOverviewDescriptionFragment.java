package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentPsychotypeOverviewDescriptionBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.NavigationHelper;
import com.laushkina.anastasia.psychosophy.view.PsychotypeImageGetter;
import com.laushkina.anastasia.psychosophy.view.functions.FunctionTitleGetter;
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsAdapter;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment;

public class PsychotypeOverviewDescriptionFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentPsychotypeOverviewDescriptionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_psychotype_overview_description,
                container, false);
        binding.setViewModel(getViewModel());
        binding.setFragment(this);

        setTitle();
        return binding.getRoot();
    }

    @Override
    protected String getTitle(){
        return PsychotypeDescriptionGetter.getTitle(getPsychotype(), getActivity());
    }

    //TODO navigatiors interface
    public void navigateToFirstFunction(){
        // Switch between drawer's tabs, so level of activity's fragment manager is needed
        NavigationHelper.showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.FIRST_FUNCTION);
    }

    public void navigateToSecondFunction(){
        NavigationHelper.showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.SECOND_FUNCTION);
    }

    public void navigateToThirdFunction(){
        NavigationHelper.showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.THIRD_FUNCTION);
    }

    public void navigateToForthFunction(){
        NavigationHelper.showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.FORTH_FUNCTION);
    }

    private DescriptionViewModel getViewModel(){
        Psychotype psychotype = getPsychotype();

        return new DescriptionViewModel.Builder()
                .firstFunctionDescription(FunctionTitleGetter.getFirstFunctionTitle(psychotype.getFunctions(), getActivity()))
                .secondFunctionDescription(FunctionTitleGetter.getSecondFunctionTitle(psychotype.getFunctions(), getActivity()))
                .thirdFunctionDescription(FunctionTitleGetter.getThirdFunctionTitle(psychotype.getFunctions(), getActivity()))
                .forthFunctionDescription(FunctionTitleGetter.getForthFunctionTitle(psychotype.getFunctions(), getActivity()))
                .shortDescription(PsychotypeDescriptionGetter.getShort(psychotype, getActivity()))
                .image(PsychotypeImageGetter.get(psychotype, getActivity()))
                .build();
    }

    private Psychotype getPsychotype(){
        return (Psychotype)getArguments().getSerializable(PsychotypesFragment.psychotypeExtra);
    }
}