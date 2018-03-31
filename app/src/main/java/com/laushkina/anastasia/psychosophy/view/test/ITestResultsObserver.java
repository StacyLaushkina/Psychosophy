package com.laushkina.anastasia.psychosophy.view.test;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;

public interface ITestResultsObserver {
    void showExceptionResultDescription();
    void showTypeDescription(Psychotype[] psychotype);
    void showMissingAnswersMessage();
}
