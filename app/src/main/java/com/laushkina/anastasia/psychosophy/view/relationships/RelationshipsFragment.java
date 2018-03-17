package com.laushkina.anastasia.psychosophy.view.relationships;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentRelationshipsBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionGetter;

public class RelationshipsFragment extends BaseFragment{

    private RelationshipsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentRelationshipsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_relationships,
                container, false);
        binding.setFragment(this);
        presenter = new RelationshipsPresenter();

        View view = binding.getRoot();
        initialize(view);
        return view;
    }

    private void initialize(View view){
        setTitle();

        Spinner firstTypeSpinner = getFirstTypeSpinner(view);
        Spinner secondTypeSpinner = getSecondTypeSpinner(view);

        firstTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onFirstItemClick(adapterView, view, i, l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        secondTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onSecondItemClick(adapterView, view, i, l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, PsychotypeDescriptionGetter.getAllDescriptions(getActivity()));
        firstTypeSpinner.setAdapter(adapter);
        secondTypeSpinner.setAdapter(adapter);
    }

    public void calculate(){
        presenter.calcRelationships();
    }

    private void onFirstItemClick(AdapterView<?> parent, View view, int pos, long id) {
        presenter.setFistType(Psychotype.values()[pos]);
    }

    private void onSecondItemClick(AdapterView<?> parent, View view, int pos, long id) {
        presenter.setSecondTYpe(Psychotype.values()[pos]);
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.relationships);
    }

    private Spinner getFirstTypeSpinner(View view){
        return view.findViewById(R.id.first_type_spinner);
    }

    private Spinner getSecondTypeSpinner(View view){
        return view.findViewById(R.id.second_type_spinner);
    }
}
