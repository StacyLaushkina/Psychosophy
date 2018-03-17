package com.laushkina.anastasia.psychosophy.view.test;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;

import java.util.ArrayList;
import java.util.List;

public interface TestView {
    void showMissingAnswersMessage();
    void showTypeDescription(Psychotype[] psychotype);
    void showExceptionResultDescription();
}
