package com.laushkina.anastasia.psychosophy.view.test;

import java.util.ArrayList;
import java.util.List;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.AnswersValidation;
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.Question;
import com.laushkina.anastasia.psychosophy.domain.test.QuestionAnswer;
import com.laushkina.anastasia.psychosophy.domain.test.QusetionsComposer;

import dagger.Module;
import dagger.Provides;

@Module
class TestPresenter {

    private static final int QUESTION_AMOUNT = 40;
    private static final int QUESTIONS_IN_GROUP = 4;

    private List<Question> questions;
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

    List<CharSequence> getFirstGroupOfQuestions(ITestResultsObserver resultsObserver){
        questions = QusetionsComposer.compose(resultsObserver.getContext());
        amountOfFinishedQuestions = 0;
        return getNextAnswers();
    }

    private List<CharSequence> getNextAnswers(){
        List<CharSequence> result = new ArrayList<>();
        for (int i = 0; i < QUESTIONS_IN_GROUP; i++) {
            result.add(questions.get(amountOfFinishedQuestions + i).getText());
        }
        return result;
    }

    void onAnswerSelected(ITestResultsObserver resultsObserver) {
        resultsObserver.showNextButton();
    }

    void onNextRequested(QuestionAnswer[] answers, ITestResultsObserver resultsObserver){
        saveAnswers(answers);
        boolean isTestFinished = amountOfFinishedQuestions == QUESTION_AMOUNT;
        if (isTestFinished) {
            onTestResultRequested(resultsObserver);
            return;
        }

        resultsObserver.showNexGroupOfQuestions(getNextAnswers());
    }

    String getNextQuestionText(ITestResultsObserver resultsObserver){
        return amountOfFinishedQuestions < 39 ? resultsObserver.getContext().getResources().getString(R.string.next_question_title)
                            : resultsObserver.getContext().getResources().getString(R.string.finish_title);
    }

    private void saveAnswers(QuestionAnswer[] answers){
        for (int i =0; i < QUESTIONS_IN_GROUP; i++) {
            questions.get(amountOfFinishedQuestions + i).setAnswer(answers[i]);
        }
        amountOfFinishedQuestions += QUESTIONS_IN_GROUP;
    }

    int getProgress(){
        return (int) ((amountOfFinishedQuestions + 1)/0.4);
    }
}
