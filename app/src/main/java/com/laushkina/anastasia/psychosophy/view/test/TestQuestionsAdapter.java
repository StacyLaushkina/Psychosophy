package com.laushkina.anastasia.psychosophy.view.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Question;
import com.laushkina.anastasia.psychosophy.domain.test.QuestionAnswer;

import java.util.List;

public class TestQuestionsAdapter extends RecyclerView.Adapter<TestQuestionsAdapter.ViewHolder>{

    private List<Question> questions;

    TestQuestionsAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_test_question_item, parent, false);

        return new TestQuestionsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.questionText.setText(questions.get(position).getText());

        holder.answers.setOnCheckedChangeListener(((radioGroup, i) -> onChecked(i, position)));

        if (questions.get(position).getAnswer() == null) {
            holder.answers.clearCheck();
            return;
        }

        holder.answerYes.setChecked(questions.get(position).getAnswer() == QuestionAnswer.Yes);
        holder.answerMaybe.setChecked(questions.get(position).getAnswer() == QuestionAnswer.Maybe);
        holder.answerSometimes.setChecked(questions.get(position).getAnswer() == QuestionAnswer.Sometimes);
        holder.answerNo.setChecked(questions.get(position).getAnswer() == QuestionAnswer.No);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    List<Question> getQuestions(){
        return questions;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView questionText;
        private RadioButton answerYes;
        private RadioButton answerMaybe;
        private RadioButton answerSometimes;
        private RadioButton answerNo;
        private RadioGroup answers;

        ViewHolder(View view){
            super(view);
            questionText = view.findViewById(R.id.question_text);
            answerYes = view.findViewById(R.id.answer_yes);
            answerMaybe = view.findViewById(R.id.answer_maybe);
            answerSometimes = view.findViewById(R.id.answer_sometimes);
            answerNo = view.findViewById(R.id.answer_no);
            answers = view.findViewById(R.id.answers);
        }
    }

    private void onChecked(int id, int position){
        switch (id){
            case R.id.answer_yes:
                questions.get(position).setAnswer(QuestionAnswer.Yes);
                break;
            case R.id.answer_maybe:
                questions.get(position).setAnswer(QuestionAnswer.Maybe);
                break;
            case R.id.answer_sometimes:
                questions.get(position).setAnswer(QuestionAnswer.Sometimes);
                break;
            case R.id.answer_no:
                questions.get(position).setAnswer(QuestionAnswer.No);
        }
    }
}
