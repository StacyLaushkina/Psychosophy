package com.laushkina.anastasia.psychosophy.view.test

import com.laushkina.anastasia.psychosophy.domain.Psychotype

interface ITestResultsObserver {
    fun showExceptionResultDescription()
    fun showTypeDescription(psychotypes: Array<Psychotype>)

    fun showGroupOfQuestions(questionSet: List<CharSequence>, isPrevEnabled: Boolean, progress: Int, nextButtonText: String)
    fun showNextButton()
}