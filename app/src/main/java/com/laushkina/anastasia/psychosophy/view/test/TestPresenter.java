package com.laushkina.anastasia.psychosophy.view.test;

import android.content.Context;

import java.util.List;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.AnswersValidation;
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.Question;
import com.laushkina.anastasia.psychosophy.domain.test.QusetionsComposer;

import dagger.Module;
import dagger.Provides;

@Module
class TestPresenter {

    @Provides synchronized TestPresenter provideTestPresenter(){
        return new TestPresenter();
    }

    List<Question> getQuestions(Context context){
        return QusetionsComposer.compose(context);
    }

    void onTestResultRequested(List<Question> questions, ITestResultsObserver resultsObserver){
        if (AnswersValidation.areValid(questions)) {
            List<Psychotype> psychotypes = PsychotypeCalculator.calculate(questions);
            if (psychotypes == null) {
                resultsObserver.showExceptionResultDescription();
            } else {
                resultsObserver.showTypeDescription(psychotypes.toArray(new Psychotype[psychotypes.size()]));
            }

        } else {
            resultsObserver.showMissingAnswersMessage();
        }
    }
}
