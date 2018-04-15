package com.laushkina.anastasia.psychosophy.view.relationships;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentRelationshipsBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.relationships.PsychotypeRelationships;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionGetter;

import java.util.Arrays;

import javax.inject.Inject;

import dagger.Module;

@Module
public class RelationshipsFragment extends BaseFragment implements AdapterView.OnItemSelectedListener, IRelationshipsResultObserver{

    @Inject RelationshipsPresenter presenter;
    private PsychotypeRelationshipsViewModel viewModel = new PsychotypeRelationshipsViewModel();

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
        setTitle();

        Spinner firstTypeSpinner = getFirstTypeSpinner(view);
        Spinner secondTypeSpinner = getSecondTypeSpinner(view);

        PsychotypesAdapter adapter = new PsychotypesAdapter(getActivity(), android.R.layout.simple_list_item_1, copyWithFirstNull(Psychotype.values()));
        firstTypeSpinner.setAdapter(adapter);
        firstTypeSpinner.setOnItemSelectedListener(this);
        secondTypeSpinner.setAdapter(adapter);
        secondTypeSpinner.setOnItemSelectedListener(this);
    }

    //TODO move to utils?
    private Psychotype[] copyWithFirstNull(Psychotype[] array){
        Psychotype[] newArray = new Psychotype[array.length + 1];
        int newArrayInd = 1;
        for (Psychotype psychotype : array) {
            newArray[newArrayInd] = psychotype;
            newArrayInd++;
        }
        return newArray;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        calculate();
        // Scroll to the top
        getActivity().findViewById(R.id.relationships_scroller).scrollTo(0, 0);
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

    public void calculate(){
        PsychotypeRelationships relationships = presenter.calcRelationships(getFirstType(),getSecondType(), this);
        viewModel.setFirstFunctionRelationshipsTitle(relationships.getFirstFunctionRelationshipsTitle());
        viewModel.setFirstFunctionRelationships(relationships.getFirstFunctionRelationships());
        viewModel.setSecondFunctionRelationshipsTitle(relationships.getSecondFunctionRelationshipsTitle());
        viewModel.setSecondFunctionRelationships(relationships.getSecondFunctionRelationships());
        viewModel.setThirdFunctionRelationshipsTitle(relationships.getThirdFunctionRelationshipsTitle());
        viewModel.setThirdFunctionRelationships(relationships.getThirdFunctionRelationships());
        viewModel.setForthFunctionRelationshipsTitle(relationships.getForthFunctionRelationshipsTitle());
        viewModel.setForthFunctionRelationships(relationships.getForthFunctionRelationships());
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.relationships);
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
