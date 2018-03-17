package com.laushkina.anastasia.psychosophy.view.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesAdapter;

public class TestResultsFragment extends BaseFragment {

    public static final String testResultsExtra = "testResultsExtra";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_test_results, container, false);
        initialize(view);

        return view;
    }

    private void initialize(View view){
        setTitle();

        Psychotype[] testResult = getTestResults();
        getResultsDescriotionTextView(view).setText(getTestResultsDescription(testResult));

        if (testResult == null) return;

        RecyclerView recyclerView = getResultsRecyclerView(view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new PsychotypesAdapter(testResult, getActivity(), getFragmentManager()));
    }

    private String getTestResultsDescription(Psychotype[] results){
        if (results == null) return getResources().getString(R.string.test_results_exception_too_many_results);
        if (results.length == 1) return getResources().getString(R.string.test_results_exception_one_result);
        return getResources().getString(R.string.test_results_exception_several_results);
    }

    private Psychotype[] getTestResults(){
        return (Psychotype[]) getArguments().getParcelableArray(testResultsExtra);
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.test_results);
    }

    private RecyclerView getResultsRecyclerView(View view){
        return view.findViewById(R.id.test_results_recycler);
    }

    private TextView getResultsDescriotionTextView(View view) {
        return view.findViewById(R.id.results_description);
    }
}
