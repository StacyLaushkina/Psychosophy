package com.laushkina.anastasia.psychosophy.view.psychotypes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;

public class PsychotypesFragment extends BaseFragment {

    public static final String psychotypeExtra = "psychotypeExtra";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_psychotypes, container, false);
        initialize(view);

        return view;
    }

    private void initialize(View view){
        setTitle();

        RecyclerView recyclerView = getTypesRecyclerView(view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), getColumnAmount()));

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.basic_margin);
        recyclerView.addItemDecoration(new SpacesPsychotypeItemDecoration(spacingInPixels));
        recyclerView.setAdapter(new PsychotypesAdapter(Psychotype.values(), getActivity(), getFragmentManager(), getNavigationView()));
    }

    public int getColumnAmount() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return (int) (displayMetrics.widthPixels / getResources().getDimension(R.dimen.psychotype_card_size));
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.psychotypes);
    }

    private RecyclerView getTypesRecyclerView(View view){
        return view.findViewById(R.id.psychotypes_recycler);
    }
}
