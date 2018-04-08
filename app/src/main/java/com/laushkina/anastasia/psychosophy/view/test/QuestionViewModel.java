package com.laushkina.anastasia.psychosophy.view.test;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.laushkina.anastasia.psychosophy.BR;

public class QuestionViewModel extends BaseObservable {
    private CharSequence question;

    @Bindable
    public CharSequence getQuestion() {
        return question;
    }

    public void setQuestion(CharSequence question) {
        this.question = question;
        notifyPropertyChanged(BR.question);
    }
}
