package com.laushkina.anastasia.psychosophy.view.introduction;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentIntroductionBinding;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.NavigationHelper;
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsAdapter;

public class IntroductionFragment extends BaseFragment implements IIntroductionNavigator {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentIntroductionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_introduction,
                container, false);
        binding.setViewModel(getViewModel());
        binding.setNavigator(this);

        initialize();
        return binding.getRoot();
    }

    private IntroductionViewModel getViewModel(){
        IntroductionViewModel viewModel = new IntroductionViewModel();
        viewModel.setPsychosophyDefinition(getPsychosophyDefinition());
        viewModel.setPersonalitiesDescription(getPersonalitiesDescription());
        viewModel.setRelationshipsDescription(getRelationshipsDescription());

        return viewModel;
    }

    private CharSequence getPsychosophyDefinition(){
        return Html.fromHtml(getResources().getString(R.string.introduction_psychosophy_definition));
    }

    private CharSequence getPersonalitiesDescription(){
        return Html.fromHtml(getResources().getString(R.string.introduction_psychosophy_personalities));
    }

    private CharSequence getRelationshipsDescription(){
        return Html.fromHtml(getResources().getString(R.string.introduction_psychosophy_relationships));
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.introduction);
    }

    @Override
    protected int getNavigationItemId(){
        return R.id.nav_introduction;
    }

    @Override
    public void navigateToFirstFunction() {
        NavigationHelper.getInstance().showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.FIRST_FUNCTION,null);
    }

    @Override
    public void navigateToSecondFunction() {
        NavigationHelper.getInstance().showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.SECOND_FUNCTION,null);
    }

    @Override
    public void navigateToThirdFunction() {
        NavigationHelper.getInstance().showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.THIRD_FUNCTION,null);
    }

    @Override
    public void navigateToForthFunction() {
        NavigationHelper.getInstance().showFunctions(getActivity().getFragmentManager(), FunctionsAdapter.FORTH_FUNCTION,null);
    }

    @Override
    public void navigateToPsychotypes() {
        NavigationHelper.getInstance().showTypes(getActivity().getFragmentManager());
    }

    @Override
    public void navigateToTest() {
        NavigationHelper.getInstance().showTest(getActivity().getFragmentManager());
    }

    @Override
    public void navigateToAspectsAnfFunctions() {
        NavigationHelper.getInstance().showAspectsAndFunctions(getActivity().getFragmentManager());
    }

    @Override
    public void navigateToRelationships() {
        NavigationHelper.getInstance().showRelationships(getActivity().getFragmentManager());
    }
}
