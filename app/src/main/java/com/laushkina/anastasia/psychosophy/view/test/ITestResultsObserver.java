package com.laushkina.anastasia.psychosophy.view.test;

import android.content.Context;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;

import java.util.List;

public interface ITestResultsObserver {
    void showExceptionResultDescription();
    void showTypeDescription(Psychotype[] psychotype);

    void showGroupOfQuestions(List<CharSequence> questionSet, boolean isPrevEnabled, int progress, String nextButtonText);
    void showNextButton();

    Context getContext();
}
