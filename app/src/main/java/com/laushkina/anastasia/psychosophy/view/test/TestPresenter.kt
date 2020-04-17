package com.laushkina.anastasia.psychosophy.view.test

import android.os.Bundle
import android.os.Parcelable
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.domain.test.*
import dagger.Module
import dagger.Provides
import java.util.*

@Module
class TestPresenter {
    companion object {
        private const val QUESTIONS_SAVED_STATE_EXTRA = "test_questions"
        private const val AMOUNT_OF_FINISHED_SAVED_STATE_EXTRA = "test_amount_of_finished"

        private const val QUESTION_AMOUNT = 40
        private const val QUESTIONS_IN_GROUP = 4
    }

    private lateinit var questions: Array<TestQuestion?>
    private var amountOfFinishedQuestions: Int = 0

    fun isPrevButtonEnabled(): Boolean {
        return amountOfFinishedQuestions > 0
    }

    @Provides
    @Synchronized
    internal fun provideTestPresenter(): TestPresenter {
        return TestPresenter()
    }

    internal fun getTestState(): Bundle {
        val state = Bundle()
        state.putParcelableArray(QUESTIONS_SAVED_STATE_EXTRA, questions)
        state.putInt(AMOUNT_OF_FINISHED_SAVED_STATE_EXTRA, amountOfFinishedQuestions)
        return state
    }

    internal fun restoreFromSavedState(state: Bundle, resultsObserver: ITestResultsObserver) {
        val answers = state.getParcelableArray(QUESTIONS_SAVED_STATE_EXTRA) ?: return
        questions = Arrays.copyOf(answers, answers.size, Array<TestQuestion>::class.java)

        amountOfFinishedQuestions = state.getInt(AMOUNT_OF_FINISHED_SAVED_STATE_EXTRA, 0)

        resultsObserver.showGroupOfQuestions(getNextAnswers(), isPrevButtonEnabled(), getProgress(),
                getNextQuestionText(resultsObserver))
    }

    internal fun getFirstGroupOfQuestions(resultsObserver: ITestResultsObserver): List<CharSequence> {
        questions = QuestionsComposer.compose(resultsObserver.getContext())
        amountOfFinishedQuestions = 0
        return getNextAnswers()
    }

    internal fun onAnswerSelected(resultsObserver: ITestResultsObserver) {
        resultsObserver.showNextButton()
    }

    internal fun onNextRequested(answers: Array<TestAnswer?>, resultsObserver: ITestResultsObserver) {
        saveAnswers(answers)
        val isTestFinished = amountOfFinishedQuestions == QUESTION_AMOUNT
        if (isTestFinished) {
            onTestResultRequested(resultsObserver)
            return
        }

        resultsObserver.showGroupOfQuestions(getNextAnswers(), isPrevButtonEnabled(), getProgress(),
                getNextQuestionText(resultsObserver))
    }

    internal fun onPrevQuestionsRequested(resultsObserver: ITestResultsObserver) {
        amountOfFinishedQuestions -= QUESTIONS_IN_GROUP
        resultsObserver.showGroupOfQuestions(getNextAnswers(), isPrevButtonEnabled(),
                getProgress(), getNextQuestionText(resultsObserver))
    }

    internal fun getNextQuestionText(resultsObserver: ITestResultsObserver): String {
        return if (amountOfFinishedQuestions < 39)
            resultsObserver.getContext().resources.getString(R.string.next_question_title)
        else
            resultsObserver.getContext().resources.getString(R.string.finish_title)
    }

    private fun getProgress(): Int {
        return ((amountOfFinishedQuestions + 1) / 0.4).toInt()
    }

    private fun onTestResultRequested(resultsObserver: ITestResultsObserver) {
        if (AnswersValidation.areValid(questions)) {
            val psychotypes = PsychotypeCalculator.calculate(questions)
            if (psychotypes == null) {
                resultsObserver.showExceptionResultDescription()
            } else {
                resultsObserver.showTypeDescription(psychotypes.toTypedArray())
            }
        }
    }

    private fun getNextAnswers(): List<CharSequence> {
        val result = ArrayList<CharSequence>()
        for (i in 0 until QUESTIONS_IN_GROUP) {
            val question = questions[amountOfFinishedQuestions + i]
            if (question != null) {
                result.add(question.text)
            }
        }
        return result
    }

    private fun saveAnswers(answers: Array<TestAnswer?>) {
        for (i in 0 until QUESTIONS_IN_GROUP) {
            val question = questions[amountOfFinishedQuestions + i]
            if (question != null) {
                question.answer = answers[i]
            }
        }
        amountOfFinishedQuestions += QUESTIONS_IN_GROUP
    }
}