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

import com.laushkina.anastasia.psychosophy.view.BaseFragment;
import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.databinding.FragmentTestBinding;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.view.NavigationHelper;

import java.util.List;

import javax.inject.Inject;

public class TestFragment extends BaseFragment implements ITestResultsObserver, ITypeCalculator {

    private static final String TEST_STATE_EXTRA = "test_state";
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

    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        if (isVisible()) {
            bundle.putBundle(TEST_STATE_EXTRA, presenter.getTestState());
        }
    }

    @Override
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);

        Bundle savedState = bundle == null ? null : bundle.getBundle(TEST_STATE_EXTRA);
        if (savedState == null) return;

        presenter.restoreFromSavedState(savedState);
        viewModel.setProgress(presenter.getProgress());
    }

    private void initialize(View view){
        initialize();
        viewModel = new TestViewModel(presenter.getNextQuestionText(this));

        // Initialize questions
        RecyclerView questionsRecycler = getQuestionsRecycler(view);
        questionsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TestQuestionsAdapter(presenter.getFirstGroupOfQuestions(this), this::onAnswersSelected);
        questionsRecycler.setAdapter(adapter);

        getProgressBar(view).setProgressDrawable(getResources().getDrawable(R.drawable.test_progress_drawable));
    }

    void onAnswersSelected() {
        presenter.onAnswerSelected(this);
    }

    public void next() {
        presenter.onNextRequested(adapter.getAnswers(),this);
    }

    public void prev() {
        presenter.onPrevQuestionsRequested(this);
    }

    @Override
    public void showGroupOfQuestions(List<CharSequence> questionSet, boolean isPrevEnabled) {
        adapter.setQuestions(questionSet);
        viewModel.setProgress(presenter.getProgress());
        viewModel.setNextButtonText(presenter.getNextQuestionText(this));
        viewModel.setPrevButtonText(getResources().getString(R.string.prev_question_title));
        viewModel.setPrevEnabled(isPrevEnabled);
        viewModel.setNextEnabled(false);
    }

    @Override
    public void showNextButton() {
        viewModel.setNextEnabled(true);
    }

    @Override
    public void showExceptionResultDescription(){
        NavigationHelper.getInstance().showTestResults(null, getFragmentManager());
    }

    @Override
    public void showTypeDescription(Psychotype[] psychotypes) {
        NavigationHelper.getInstance().showTestResults(psychotypes, getFragmentManager());
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    protected String getTitle(){
        return getResources().getString(R.string.test);
    }

    @Override
    protected int getNavigationItemId(){
        return R.id.nav_test;
    }

    private ProgressBar getProgressBar(View view){
        return view.findViewById(R.id.test_progress);
    }

    private RecyclerView getQuestionsRecycler(View view){
        return view.findViewById(R.id.test_questions_recycler);
    }
}
