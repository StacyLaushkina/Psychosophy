package com.laushkina.anastasia.psychosophy.view.test

import android.content.Context
import com.laushkina.anastasia.psychosophy.domain.Psychotype

interface ITestResultsObserver {
    fun showExceptionResultDescription()
    fun showTypeDescription(psychotype: Array<Psychotype>)

    fun showGroupOfQuestions(questionSet: List<CharSequence>, isPrevEnabled: Boolean, progress: Int, nextButtonText: String)
    fun showNextButton()

    fun getContext(): Context
}