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

public class PsychotypeOverviewDescriptionFragment extends BaseFragment implements IFunctionsNavigator {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentPsychotypeOverviewDescriptionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_psychotype_overview_description,
                container, false);
        binding.setViewModel(getViewModel());
        binding.setNavigator(this);

        setTitle();
        return binding.getRoot();
    }

    @Override
    protected CharSequence getTitle(){
        return PsychotypeDescriptionGetter.getTitle(getPsychotype(), getActivity());
    }

    @Override
    public void navigateToFirstFunction(){
        // Switch between drawer's tabs, so level of activity's fragment manager is needed
        NavigationHelper.showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.FIRST_FUNCTION,
                                       getPsychotype().getFunctions()[0], getNavigationView());
    }

    @Override
    public void navigateToSecondFunction(){
        NavigationHelper.showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.SECOND_FUNCTION,
                                       getPsychotype().getFunctions()[1], getNavigationView());
    }

    @Override
    public void navigateToThirdFunction(){
        NavigationHelper.showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.THIRD_FUNCTION,
                                       getPsychotype().getFunctions()[2], getNavigationView());
    }

    @Override
    public void navigateToForthFunction(){
        NavigationHelper.showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.FORTH_FUNCTION,
                                       getPsychotype().getFunctions()[3], getNavigationView());
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
