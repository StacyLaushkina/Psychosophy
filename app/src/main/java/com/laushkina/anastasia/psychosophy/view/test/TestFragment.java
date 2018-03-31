package com.laushkina.anastasia.psychosophy.view.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentTestBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.NavigationHelper;


import javax.inject.Inject;

public class TestFragment extends BaseFragment implements ITestResultsObserver, ITypeCalculator{

    @Inject TestPresenter presenter;
    private TestQuestionsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentTestBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test,
                container, false);
        binding.setTestCalculator(this);

        presenter = DaggerTestComponent.create().getPresenter();

        View view = binding.getRoot();
        initialize(view);

        return view;
    }

    private void initialize(View view){
        setTitle();

        RecyclerView questionsRecycler = getQuestionsRecyclerView(view);
        questionsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TestQuestionsAdapter(presenter.getQuestions(getActivity()));
        questionsRecycler.setAdapter(adapter);

        //TODO enable caching
        questionsRecycler.setItemViewCacheSize(adapter.getItemCount());
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.test);
    }

    public void calculate(){
        presenter.onTestResultRequested(adapter.getQuestions(), this);
    }

    private RecyclerView getQuestionsRecyclerView(View view){
        return view.findViewById(R.id.test_questions_recycler);
    }

    public void showMissingAnswersMessage() {
        Toast.makeText(getActivity(), R.string.not_all_questions_answered, Toast.LENGTH_LONG).show();
    }

    public void showTypeDescription(Psychotype[] psychotypes) {
        NavigationHelper.showTestResults(psychotypes, getFragmentManager());
    }

    public void showExceptionResultDescription(){
        NavigationHelper.showTestResults(null, getFragmentManager());
    }
}
