package com.laushkina.anastasia.psychosophy.view.test;

import android.content.Context;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.AnswersValidation;
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.Question;
import com.laushkina.anastasia.psychosophy.domain.test.QuestionAnswer;
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
            Psychotype psychotype = PsychotypeCalculator.calculate(questions);
            testView.showTypeDescription(psychotype);
        } else {
            testView.showMissingAnswersMessage();
        }
    }
}
