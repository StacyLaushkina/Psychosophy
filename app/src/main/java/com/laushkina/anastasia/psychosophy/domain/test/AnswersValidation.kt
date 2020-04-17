package com.laushkina.anastasia.psychosophy.domain.test

class AnswersValidation {
    companion object {
        fun areValid(questions: Array<TestQuestion?>): Boolean {
            var isValid = true
            for (question in questions) {
                if (question?.answer == null) {
                    isValid = false
                    break
                }
            }
            return isValid
        }
    }
}