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

import java.util.ArrayList;
import java.util.List;

public class TestFragment extends BaseFragment implements TestView {

    private TestPresenter presenter;
    private TestQuestionsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);

        presenter = new TestPresenter(this);

        FragmentTestBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test,
                container, false);
        binding.setFragment(this);

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

    public void runTest(){
        presenter.onTestResultRequested(adapter.getQuestions());
    }

    private RecyclerView getQuestionsRecyclerView(View view){
        return view.findViewById(R.id.test_questions_recycler);
    }

    @Override
    public void showMissingAnswersMessage() {
        Toast.makeText(getActivity(), R.string.not_all_questions_answered, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showTypeDescription(Psychotype[] psychotypes) {
        NavigationHelper.showTestResults(psychotypes, getFragmentManager());
    }

    @Override
    public void showExceptionResultDescription(){
        NavigationHelper.showTestResults(null, getFragmentManager());
    }
}
