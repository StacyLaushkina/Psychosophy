package com.laushkina.anastasia.psychosophy.domain.test

import android.content.Context
import com.laushkina.anastasia.psychosophy.R
import java.util.ArrayList

class QuestionsComposer {
    companion object {
        private const val questionsAmount = 40

        fun compose(context: Context): Array<TestQuestion?> {
            val result = ArrayList<TestQuestion>(questionsAmount)
            addLogicQuestions(result, context)
            addEmotionQuestions(result, context)
            addPhysicsQuestions(result, context)
            addWillQuestions(result, context)
            return result.toTypedArray()
        }

        private fun addLogicQuestions(list: MutableList<TestQuestion>, context: Context) {
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_first), PsychoFunction.Logic))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_second), PsychoFunction.Logic))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_third), PsychoFunction.Logic))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_forth), PsychoFunction.Logic))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_fifth), PsychoFunction.Logic))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_sixth), PsychoFunction.Logic))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_seventh), PsychoFunction.Logic))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_eighth), PsychoFunction.Logic))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_ninth), PsychoFunction.Logic))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_logic_tenth), PsychoFunction.Logic))
        }

        private fun addEmotionQuestions(list: MutableList<TestQuestion>, context: Context) {
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_first), PsychoFunction.Emotion))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_second), PsychoFunction.Emotion))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_third), PsychoFunction.Emotion))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_forth), PsychoFunction.Emotion))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_fifth), PsychoFunction.Emotion))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_sixth), PsychoFunction.Emotion))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_seventh), PsychoFunction.Emotion))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_eighth), PsychoFunction.Emotion))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_ninth), PsychoFunction.Emotion))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_emotion_tenth), PsychoFunction.Emotion))
        }

        private fun addPhysicsQuestions(list: MutableList<TestQuestion>, context: Context) {
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_first), PsychoFunction.Physics))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_second), PsychoFunction.Physics))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_third), PsychoFunction.Physics))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_forth), PsychoFunction.Physics))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_fifth), PsychoFunction.Physics))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_sixth), PsychoFunction.Physics))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_seventh), PsychoFunction.Physics))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_eighth), PsychoFunction.Physics))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_ninth), PsychoFunction.Physics))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_physics_tenth), PsychoFunction.Physics))
        }

        private fun addWillQuestions(list: MutableList<TestQuestion>, context: Context) {
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_first), PsychoFunction.Will))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_second), PsychoFunction.Will))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_third), PsychoFunction.Will))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_forth), PsychoFunction.Will))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_fifth), PsychoFunction.Will))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_sixth), PsychoFunction.Will))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_seventh), PsychoFunction.Will))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_eighth), PsychoFunction.Will))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_ninth), PsychoFunction.Will))
            list.add(TestQuestion(context.resources.getString(R.string.test_question_will_tenth), PsychoFunction.Will))
        }
    }
}