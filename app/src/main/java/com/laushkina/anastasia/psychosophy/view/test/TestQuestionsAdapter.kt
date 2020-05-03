package com.laushkina.anastasia.psychosophy.view.test

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.test.TestAnswer

class TestQuestionsAdapter(private var questions: List<CharSequence>,
                           private val listener: OnAnswersSelectedListener) : RecyclerView.Adapter<TestQuestionsAdapter.ViewHolder>() {
    private var lastSelectedAnswers: Array<TestAnswer?> = arrayOfNulls(questions.size)

    fun setQuestions(questions: List<CharSequence>) {
        this.questions = questions
        lastSelectedAnswers = arrayOfNulls(questions.size)
        notifyDataSetChanged()
    }

    internal fun getAnswers(): Array<TestAnswer?> {
        return lastSelectedAnswers
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_test_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.questionText.text = questions[position]
        holder.answers.clearCheck()
        holder.answers.setOnCheckedChangeListener { _, _ -> onChecked(holder, position) }
    }

    private fun onChecked(holder: ViewHolder, position: Int) {
        if (holder.yesButton.isChecked) {
            lastSelectedAnswers[position] = TestAnswer.Yes
        }
        if (holder.maybeButton.isChecked) {
            lastSelectedAnswers[position] = TestAnswer.Maybe
        }
        if (holder.sometimesButton.isChecked) {
            lastSelectedAnswers[position] = TestAnswer.Sometimes
        }
        if (holder.noButton.isChecked) {
            lastSelectedAnswers[position] = TestAnswer.No
        }

        var areAllAnswered = true
        for (answer in lastSelectedAnswers) {
            if (answer == null) {
                areAllAnswered = false
                break
            }
        }
        if (areAllAnswered) {
            listener.onAllAnswersSelected()
        }
    }

    interface OnAnswersSelectedListener {
        fun onAllAnswersSelected()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var questionText: TextView = view.findViewById(R.id.question_text)
        var answers: RadioGroup = view.findViewById(R.id.answers)
        var yesButton: RadioButton = view.findViewById(R.id.answer_yes)
        var maybeButton: RadioButton = view.findViewById(R.id.answer_maybe)
        var sometimesButton: RadioButton = view.findViewById(R.id.answer_sometimes)
        var noButton: RadioButton = view.findViewById(R.id.answer_no)

    }
}