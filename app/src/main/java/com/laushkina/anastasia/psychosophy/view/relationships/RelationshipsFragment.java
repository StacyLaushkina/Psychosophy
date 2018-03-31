package com.laushkina.anastasia.psychosophy.view.relationships;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentRelationshipsBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionGetter;

import javax.inject.Inject;

import dagger.Module;

@Module
public class RelationshipsFragment extends BaseFragment{

    @Inject RelationshipsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentRelationshipsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_relationships,
                container, false);
        binding.setFragment(this);

        presenter = DaggerRelationshipsComponent.create().getPresenter();

        View view = binding.getRoot();
        initialize(view);
        return view;
    }

    private void initialize(View view){
        setTitle();

        Spinner firstTypeSpinner = getFirstTypeSpinner(view);
        Spinner secondTypeSpinner = getSecondTypeSpinner(view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, PsychotypeDescriptionGetter.getAllDescriptions(getActivity()));
        firstTypeSpinner.setAdapter(adapter);
        secondTypeSpinner.setAdapter(adapter);
    }

    public Psychotype provideFirstType(){
        Spinner firstTypeSpinner = getFirstTypeSpinner();
        int pos = firstTypeSpinner.getSelectedItemPosition();
        return Psychotype.values()[pos];
    }

    public Psychotype provideSecondType(){
        Spinner firstTypeSpinner = getSecondTypeSpinner();
        int pos = firstTypeSpinner.getSelectedItemPosition();
        return Psychotype.values()[pos];
    }

    public void calculate(){
        presenter.calcRelationships(provideFirstType(),provideSecondType() );
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
}
