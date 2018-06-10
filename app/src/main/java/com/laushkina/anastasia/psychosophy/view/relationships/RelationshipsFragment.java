package com.laushkina.anastasia.psychosophy.view.relationships;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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

    private static final int ANIMATION_TIME = 100;

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
                presenter.getPsychotypes(), prompt, getResources().getColor(R.color.boulder));
        spinner.setAdapter(secondAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Psychotype firstSelected = getFirstType();
        Psychotype secondSelected = getSecondType();

        if (firstSelected == null || secondSelected == null) {
            onPromtItemSelected(firstSelected, secondSelected);
            return;
        }

        animateTypesSelection();
        calculate(firstSelected, secondSelected);
        // Scroll to the top
        getRelationshipsContainer().scrollTo(0, 0);
    }

    private void onPromtItemSelected(Psychotype firstSelected, Psychotype secondSelected){
        boolean wasPromptAlreadySelected =  getRelationshipsContainer().getVisibility() != View.VISIBLE;
        if (wasPromptAlreadySelected) return;

        setHintAndImageVisibility(View.VISIBLE);

        // Animate slide to the middle of the screen
        Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int rotation = display.getRotation();
        TranslateAnimation animation = getPromtSelectedAnimation(rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180);
        getSpinnersContainer().startAnimation(animation);
    }

    private void animateTypesSelection(){
        Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int rotation = display.getRotation();
        TranslateAnimation animation = getTypesSelectedAnimation(rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180);
        getSpinnersContainer().startAnimation(animation);
    }

    private TranslateAnimation getTypesSelectedAnimation(boolean isPortrait){
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

        TranslateAnimation anim;
        if (isPortrait) {
            anim = new TranslateAnimation(0,0, 0, - getSpinnersContainer().getTop());
        } else {
            anim = new TranslateAnimation(0, -metrics.heightPixels / 2, 0, 0);
        }

        anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                getRelationshipsContainer().setVisibility(View.VISIBLE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)getSpinnersContainer().getLayoutParams();
                layoutParams.removeRule(RelativeLayout.CENTER_IN_PARENT);
                if (!isPortrait) {
                    layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
                }
                getSpinnersContainer().setLayoutParams(layoutParams);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        anim.setDuration(ANIMATION_TIME);
        return anim;
    }

    private TranslateAnimation getPromtSelectedAnimation(boolean isPortrait){
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

        TranslateAnimation anim;
        if (isPortrait) {
            anim = new TranslateAnimation(0,0, 0, metrics.heightPixels / 2);
        } else {
            anim = new TranslateAnimation(0, 0, 0, 0);
        }

        anim.setAnimationListener(new TranslateAnimation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                getRelationshipsContainer().setVisibility(View.GONE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)getSpinnersContainer().getLayoutParams();
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                if (!isPortrait) {
                    layoutParams.removeRule(RelativeLayout.CENTER_VERTICAL);
                }
                getSpinnersContainer().setLayoutParams(layoutParams);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        anim.setDuration(ANIMATION_TIME);
        return anim;
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
    public void setHintAndImageVisibility(int visibility) {
        viewModel.setImageAndHintVisibility(visibility);
    }

    @Override
    public Context getContext(){
        return getActivity();
    }
}
