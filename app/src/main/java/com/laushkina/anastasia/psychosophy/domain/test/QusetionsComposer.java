package com.laushkina.anastasia.psychosophy.domain.test;

import android.content.Context;

import com.laushkina.anastasia.psychosophy.R;

import java.util.ArrayList;
import java.util.List;

public class QusetionsComposer {

    private static final int questionsAmount = 40;

    public static List<Question> compose(Context context){
        List<Question> result = new ArrayList<>(questionsAmount);
        addLogicQuestions(result, context);
        addEmotionQuestions(result,context);
        addPhysicsQuestions(result, context);
        addWillQuestions(result, context);
        return result;
    }

    private static void addLogicQuestions(List<Question> list, Context context) {
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_first), Function.Logic));
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_second), Function.Logic));
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_third), Function.Logic));
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_forth), Function.Logic));
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_fifth), Function.Logic));
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_sixth), Function.Logic));
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_seventh), Function.Logic));
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_eighth), Function.Logic));
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_ninth), Function.Logic));
        list.add(new Question(context.getResources().getString(R.string.test_question_logic_tenth), Function.Logic));
    }

    private static void addEmotionQuestions(List<Question> list, Context context) {
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_first), Function.Emotion));
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_second), Function.Emotion));
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_third), Function.Emotion));
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_forth), Function.Emotion));
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_fifth), Function.Emotion));
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_sixth), Function.Emotion));
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_seventh), Function.Emotion));
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_eighth), Function.Emotion));
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_ninth), Function.Emotion));
        list.add(new Question(context.getResources().getString(R.string.test_question_emotion_tenth), Function.Emotion));
    }

    private static void addPhysicsQuestions(List<Question> list, Context context) {
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_first), Function.Physics));
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_second), Function.Physics));
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_third), Function.Physics));
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_forth), Function.Physics));
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_fifth), Function.Physics));
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_sixth), Function.Physics));
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_seventh), Function.Physics));
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_eighth), Function.Physics));
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_ninth), Function.Physics));
        list.add(new Question(context.getResources().getString(R.string.test_question_physics_tenth), Function.Physics));
    }

    private static void addWillQuestions(List<Question> list, Context context) {
        list.add(new Question(context.getResources().getString(R.string.test_question_will_first), Function.Will));
        list.add(new Question(context.getResources().getString(R.string.test_question_will_second), Function.Will));
        list.add(new Question(context.getResources().getString(R.string.test_question_will_third), Function.Will));
        list.add(new Question(context.getResources().getString(R.string.test_question_will_forth), Function.Will));
        list.add(new Question(context.getResources().getString(R.string.test_question_will_fifth), Function.Will));
        list.add(new Question(context.getResources().getString(R.string.test_question_will_sixth), Function.Will));
        list.add(new Question(context.getResources().getString(R.string.test_question_will_seventh), Function.Will));
        list.add(new Question(context.getResources().getString(R.string.test_question_will_eighth), Function.Will));
        list.add(new Question(context.getResources().getString(R.string.test_question_will_ninth), Function.Will));
        list.add(new Question(context.getResources().getString(R.string.test_question_will_tenth), Function.Will));
    }
}
