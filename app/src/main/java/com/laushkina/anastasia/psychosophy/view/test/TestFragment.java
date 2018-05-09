package com.laushkina.anastasia.psychosophy.view.test;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.laushkina.anastasia.psychosophy.domain.test.QuestionAnswer;
import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentTestBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.NavigationHelper;

import java.util.List;

import javax.inject.Inject;

public class TestFragment extends BaseFragment implements ITestResultsObserver, ITypeCalculator {

    @Inject TestPresenter presenter;
    private TestViewModel viewModel;
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
        binding.setViewModel(viewModel);

        return view;
    }

    private void initialize(View view){
        setTitle();
        viewModel = new TestViewModel(presenter.getNextQuestionText(this));

        // Initialize questions
        RecyclerView questionsRecycler = view.findViewById(R.id.test_questions_recycler);
        questionsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TestQuestionsAdapter(presenter.getFirstGroupOfQuestions(this), this::onAnswersSelected);
        questionsRecycler.setAdapter(adapter);

        ProgressBar progressBar = view.findViewById(R.id.test_progress);
        progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.test_progress_drawable));
    }

    void onAnswersSelected() {
        presenter.onAnswerSelected(this);
    }

    public void next() {
        presenter.onNextRequested(adapter.getAnswers(),this);
    }

    @Override
    public void showNexGroupOfQuestions(List<CharSequence> questionSet) {
        adapter.setQuestions(questionSet);
        viewModel.setProgress(presenter.getProgress());
        viewModel.setNextButtonText(presenter.getNextQuestionText(this));
        viewModel.setNextEnabled(false);
    }

    @Override
    public void showNextButton() {
        viewModel.setNextEnabled(true);
    }

    @Override
    public void showExceptionResultDescription(){
        NavigationHelper.showTestResults(null, getFragmentManager(), getNavigationView());
    }

    @Override
    public void showTypeDescription(Psychotype[] psychotypes) {
        NavigationHelper.showTestResults(psychotypes, getFragmentManager(), getNavigationView());
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.test);
    }
}
