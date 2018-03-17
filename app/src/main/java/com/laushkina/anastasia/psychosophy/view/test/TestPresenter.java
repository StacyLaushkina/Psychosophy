package com.laushkina.anastasia.psychosophy.view.test;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.AnswersValidation;
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.Question;
import com.laushkina.anastasia.psychosophy.domain.test.QusetionsComposer;

class TestPresenter {

    private TestView testView;

    TestPresenter(TestView testView) {
        this.testView = testView;
    }

    List<Question> getQuestions(Context context){
        return QusetionsComposer.compose(context);
    }

    void onTestResultRequested(List<Question> questions){
        if (AnswersValidation.areValid(questions)) {
            List<Psychotype> psychotypes = PsychotypeCalculator.calculate(questions);
            if (psychotypes == null) {
                testView.showExceptionResultDescription();
            } else {
                testView.showTypeDescription(psychotypes.toArray(new Psychotype[psychotypes.size()]));
            }

        } else {
            testView.showMissingAnswersMessage();
        }
    }
}
