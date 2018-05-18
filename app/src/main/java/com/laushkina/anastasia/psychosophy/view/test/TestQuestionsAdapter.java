package com.laushkina.anastasia.psychosophy.view.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.TestAnswer;

import java.util.List;

public class TestQuestionsAdapter extends RecyclerView.Adapter<TestQuestionsAdapter.ViewHolder>{

    private List<CharSequence> questions;
    private TestAnswer[] lastSelectedAnswers;
    private OnAnswersSelectedListener listener;

    interface OnAnswersSelectedListener {
        void onAllAnswersSelected();
    }

    TestQuestionsAdapter(List<CharSequence> questions, OnAnswersSelectedListener listener) {
        this.questions = questions;
        this.lastSelectedAnswers = new TestAnswer[questions.size()];
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_test_item, parent, false);

        return new TestQuestionsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.questionText.setText(questions.get(position));
        holder.answers.clearCheck();
        holder.answers.setOnCheckedChangeListener(((radioGroup, i) -> onChecked(holder, position)));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    TestAnswer[] getAnswers(){
        return lastSelectedAnswers;
    }

    public void setQuestions(List<CharSequence> questions) {
        this.questions = questions;
        lastSelectedAnswers = new TestAnswer[questions.size()];
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView questionText;
        private RadioGroup answers;
        private RadioButton yesButton;
        private RadioButton maybeButton;
        private RadioButton sometimesButton;
        private RadioButton noButton;

        ViewHolder(View view){
            super(view);
            questionText = view.findViewById(R.id.question_text);
            answers = view.findViewById(R.id.answers);
            yesButton = view.findViewById(R.id.answer_yes);
            maybeButton = view.findViewById(R.id.answer_maybe);
            sometimesButton = view.findViewById(R.id.answer_sometimes);
            noButton = view.findViewById(R.id.answer_no);
        }
    }

    private void onChecked(ViewHolder holder, int position){
        if (holder.yesButton.isChecked()) {
            lastSelectedAnswers[position] = TestAnswer.Yes;
        }
        if (holder.maybeButton.isChecked()) {
            lastSelectedAnswers[position] = TestAnswer.Maybe;
        }
        if (holder.sometimesButton.isChecked()) {
            lastSelectedAnswers[position] = TestAnswer.Sometimes;
        }
        if (holder.noButton.isChecked()) {
            lastSelectedAnswers[position] = TestAnswer.No;
        }

        boolean areAllAnswered = true;
        for (TestAnswer answer : lastSelectedAnswers) {
            if (answer == null) {
                areAllAnswered = false;
                break;
            }
        }
        if (areAllAnswered) {
            listener.onAllAnswersSelected();
        }
    }
}
