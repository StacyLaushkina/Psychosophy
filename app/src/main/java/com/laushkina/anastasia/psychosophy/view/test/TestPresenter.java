package com.laushkina.anastasia.psychosophy.view.test;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.AnswersValidation;
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.TestQuestion;
import com.laushkina.anastasia.psychosophy.domain.test.TestAnswer;
import com.laushkina.anastasia.psychosophy.domain.test.QusetionsComposer;

import dagger.Module;
import dagger.Provides;

@Module
class TestPresenter {

    private static final String QUESTIONS_SAVED_STATE_EXTRA = "test_questions";
    private static final String AMOUNT_OF_FINISHED_SAVED_STATE_EXTRA = "test_amount_of_finished";

    private static final int QUESTION_AMOUNT = 40;
    private static final int QUESTIONS_IN_GROUP = 4;

    private TestQuestion[] questions;
    private int amountOfFinishedQuestions;

    @Provides synchronized TestPresenter provideTestPresenter(){
        return new TestPresenter();
    }

    private void onTestResultRequested(ITestResultsObserver resultsObserver){
        if (AnswersValidation.areValid(questions)) {
            List<Psychotype> psychotypes = PsychotypeCalculator.calculate(questions);
            if (psychotypes == null) {
                resultsObserver.showExceptionResultDescription();
            } else {
                resultsObserver.showTypeDescription(psychotypes.toArray(new Psychotype[psychotypes.size()]));
            }
        }
    }

    Bundle getTestState(){
        Bundle state = new Bundle();
        state.putParcelableArray(QUESTIONS_SAVED_STATE_EXTRA, questions);
        state.putInt(AMOUNT_OF_FINISHED_SAVED_STATE_EXTRA, amountOfFinishedQuestions);
        return state;
    }

    void restoreFromSavedState(Bundle state){
        questions = (TestQuestion[]) state.getParcelableArray(QUESTIONS_SAVED_STATE_EXTRA);
        amountOfFinishedQuestions = state.getInt(AMOUNT_OF_FINISHED_SAVED_STATE_EXTRA, 0);
    }

    List<CharSequence> getFirstGroupOfQuestions(ITestResultsObserver resultsObserver){
        questions = QusetionsComposer.compose(resultsObserver.getContext());
        amountOfFinishedQuestions = 0;
        return getNextAnswers();
    }

    private List<CharSequence> getNextAnswers(){
        List<CharSequence> result = new ArrayList<>();
        for (int i = 0; i < QUESTIONS_IN_GROUP; i++) {
            result.add(questions[amountOfFinishedQuestions + i].getText());
        }
        return result;
    }

    void onAnswerSelected(ITestResultsObserver resultsObserver) {
        resultsObserver.showNextButton();
    }

    void onNextRequested(TestAnswer[] answers, ITestResultsObserver resultsObserver){
        saveAnswers(answers);
        boolean isTestFinished = amountOfFinishedQuestions == QUESTION_AMOUNT;
        if (isTestFinished) {
            onTestResultRequested(resultsObserver);
            return;
        }

        resultsObserver.showGroupOfQuestions(getNextAnswers(), true);
    }

    void onPrevQuestionsRequested(ITestResultsObserver resultsObserver){
        amountOfFinishedQuestions -= QUESTIONS_IN_GROUP;
        resultsObserver.showGroupOfQuestions(getNextAnswers(), amountOfFinishedQuestions > 0);
    }

    String getNextQuestionText(ITestResultsObserver resultsObserver){
        return amountOfFinishedQuestions < 39 ? resultsObserver.getContext().getResources().getString(R.string.next_question_title)
                            : resultsObserver.getContext().getResources().getString(R.string.finish_title);
    }

    private void saveAnswers(TestAnswer[] answers){
        for (int i =0; i < QUESTIONS_IN_GROUP; i++) {
            questions[amountOfFinishedQuestions + i].setAnswer(answers[i]);
        }
        amountOfFinishedQuestions += QUESTIONS_IN_GROUP;
    }

    int getProgress(){
        return (int) ((amountOfFinishedQuestions + 1)/0.4);
    }
}
