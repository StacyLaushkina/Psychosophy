package com.laushkina.anastasia.psychosophy.domain.test;

import java.util.List;

public class AnswersValidation {

    public static boolean areValid(List<Question> questions) {
        boolean isValid = true;
        for (Question question : questions) {
            if (question.getAnswer() == null) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
