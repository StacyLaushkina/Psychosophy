package com.laushkina.anastasia.psychosophy.view.relationships;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentRelationshipsBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

import javax.inject.Inject;

import dagger.Module;

@Module
public class RelationshipsFragment extends BaseFragment implements AdapterView.OnItemSelectedListener, IRelationshipsResultObserver{

    @Inject RelationshipsPresenter presenter;
    private RelationshipsViewModel viewModel = new RelationshipsViewModel();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentRelationshipsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_relationships,
                container, false);
        binding.setRelationships(viewModel);

        presenter = DaggerRelationshipsComponent.create().getPresenter();

        View view = binding.getRoot();
        initialize(view);
        return view;
    }

    private void initialize(View view){
        initialize();

        initSpinner(getFirstTypeSpinner(view), getResources().getString(R.string.relationships_first_type_prompt));
        initSpinner(getSecondTypeSpinner(view), getResources().getString(R.string.relationships_second_type_prompt));
    }

    private void initSpinner(Spinner spinner, String prompt){
        PsychotypesAdapter secondAdapter = new PsychotypesAdapter(getActivity(), android.R.layout.simple_list_item_1,
                presenter.getPsychotypes(), prompt);
        spinner.setAdapter(secondAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if(position == 0) return;

        Psychotype firstSelected = getFirstType();
        if (firstSelected == null) return;

        Psychotype secondSelected = getSecondType();
        if (secondSelected == null) return;

        animateTypesSelection();
        calculate(firstSelected, secondSelected);
        // Scroll to the top
        getRelationshipsContainer().scrollTo(0, 0);
    }

    private void animateTypesSelection(){
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

        TranslateAnimation anim = new TranslateAnimation(0,0, 0, - getSpinnersContainer().getTop());
        anim.setDuration(100);

        anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                getRelationshipsContainer().setVisibility(View.VISIBLE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)getSpinnersContainer().getLayoutParams();
                layoutParams.removeRule(RelativeLayout.CENTER_IN_PARENT);
                getSpinnersContainer().setLayoutParams(layoutParams);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        getSpinnersContainer().startAnimation(anim);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //DO nothing
    }

    public Psychotype getFirstType(){
        Spinner firstTypeSpinner = getFirstTypeSpinner();
        return (Psychotype) firstTypeSpinner.getSelectedItem();
    }

    public Psychotype getSecondType(){
        Spinner firstTypeSpinner = getSecondTypeSpinner();
        return (Psychotype) firstTypeSpinner.getSelectedItem();
    }

    public void calculate(Psychotype fistType, Psychotype secondType){
        RelationshipsViewModel relationships = presenter.calcRelationships(fistType, secondType, this);
        viewModel.refreshWith(relationships);
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.relationships);
    }

    @Override
    protected int getNavigationItemId(){
        return R.id.nav_relationships;
    }

    private Spinner getFirstTypeSpinner(View view){
        return view.findViewById(R.id.first_type_spinner);
    }

    private Spinner getFirstTypeSpinner(){
        return getActivity().findViewById(R.id.first_type_spinner);
    }

    private Spinner getSecondTypeSpinner(View view){
        return view.findViewById(R.id.second_type_spinner);
    }

    private Spinner getSecondTypeSpinner(){
        return getActivity().findViewById(R.id.second_type_spinner);
    }

    private View getSpinnersContainer(){
        return getActivity().findViewById(R.id.spinner_container);
    }

    private View getRelationshipsContainer(){
        return getActivity().findViewById(R.id.relationships_scroller);
    }

    @Override
    public void hideHint() {
        getActivity().findViewById(R.id.select_types_hint).setVisibility(View.GONE);
    }

    @Override
    public void showHint() {
        getActivity().findViewById(R.id.select_types_hint).setVisibility(View.VISIBLE);
    }

    @Override
    public Context getContext(){
        return getActivity();
    }
}
