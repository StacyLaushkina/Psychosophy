package com.laushkina.anastasia.psychosophy.domain.test;

public class AnswersValidation {

    public static boolean areValid(TestQuestion[] questions) {
        boolean isValid = true;
        for (TestQuestion question : questions) {
            if (question.getAnswer() == null) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
