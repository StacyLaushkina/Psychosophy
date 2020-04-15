package com.laushkina.anastasia.psychosophy

import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction
import com.laushkina.anastasia.psychosophy.domain.test.TestAnswer
import com.laushkina.anastasia.psychosophy.domain.test.TestQuestion

class PsychotypeAnswersFactory {
    companion object {
        private val FIRST_POSITION_ANSWER = TestAnswer.Yes
        private val SECOND_POSITION_ANSWER = TestAnswer.Maybe
        private val THIRD_POSITION_ANSWER = TestAnswer.Sometimes
        private val FORTH_POSITION_ANSWER = TestAnswer.No

        fun getAnswers(psychotype: Psychotype): Array<TestQuestion?> {

            val questions = arrayOfNulls<TestQuestion>(4)

            when (psychotype) {
                Psychotype.Augustine -> {
                    //LEPW
                    questions[0] = TestQuestion(null, PsychoFunction.Logic, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Emotion, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Physics, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Will, FORTH_POSITION_ANSWER)
                }
                Psychotype.Pascal -> {
                    //LEWP
                    questions[0] = TestQuestion(null, PsychoFunction.Logic, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Emotion, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Will, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Physics, FORTH_POSITION_ANSWER)
                }
                Psychotype.Berthier -> {
                    //LPEW
                    questions[0] = TestQuestion(null, PsychoFunction.Logic, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Physics, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Emotion, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Will, FORTH_POSITION_ANSWER)
                }
                Psychotype.Plato -> {
                    // LPWE
                    questions[0] = TestQuestion(null, PsychoFunction.Logic, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Physics, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Will, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Emotion, FORTH_POSITION_ANSWER)
                }
                Psychotype.Lao -> {
                    // LWPE
                    questions[0] = TestQuestion(null, PsychoFunction.Logic, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Will, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Physics, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Emotion, FORTH_POSITION_ANSWER)
                }
                Psychotype.Einstein -> {
                    // LWEP
                    questions[0] = TestQuestion(null, PsychoFunction.Logic, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Will, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Emotion, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Physics, FORTH_POSITION_ANSWER)
                }
                Psychotype.Anderson -> {
                    // ELWP
                    questions[0] = TestQuestion(null, PsychoFunction.Emotion, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Logic, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Will, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Physics, FORTH_POSITION_ANSWER)
                }
                Psychotype.Rousseau -> {
                    // ELPW
                    questions[0] = TestQuestion(null, PsychoFunction.Emotion, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Logic, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Physics, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Will, FORTH_POSITION_ANSWER)
                }
                Psychotype.Bukharin -> {
                    //EPLW
                    questions[0] = TestQuestion(null, PsychoFunction.Emotion, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Physics, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Logic, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Will, FORTH_POSITION_ANSWER)
                }
                Psychotype.Pushkin -> {
                    // EPWL
                    questions[0] = TestQuestion(null, PsychoFunction.Emotion, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Physics, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Will, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Logic, FORTH_POSITION_ANSWER)
                }
                Psychotype.Ghazali -> {
                    // EWLP
                    questions[0] = TestQuestion(null, PsychoFunction.Emotion, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Will, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Logic, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Physics, FORTH_POSITION_ANSWER)
                }
                Psychotype.Parsnip -> {
                    // EWPL
                    questions[0] = TestQuestion(null, PsychoFunction.Emotion, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Will, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Physics, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Logic, FORTH_POSITION_ANSWER)
                }
                Psychotype.Aristippus -> {
                    //PLWE
                    questions[0] = TestQuestion(null, PsychoFunction.Physics, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Logic, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Will, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Emotion, FORTH_POSITION_ANSWER)
                }
                Psychotype.Epicurus -> {
                    // PLEW
                    questions[0] = TestQuestion(null, PsychoFunction.Physics, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Logic, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Emotion, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Will, FORTH_POSITION_ANSWER)
                }
                Psychotype.Borgia -> {
                    // PELW
                    questions[0] = TestQuestion(null, PsychoFunction.Physics, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Emotion, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Logic, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Will, FORTH_POSITION_ANSWER)
                }
                Psychotype.Dumas -> {
                    // PEWL
                    questions[0] = TestQuestion(null, PsychoFunction.Physics, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Emotion, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Will, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Logic, FORTH_POSITION_ANSWER)
                }
                Psychotype.Goethe -> {
                    // PWLE
                    questions[0] = TestQuestion(null, PsychoFunction.Physics, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Will, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Logic, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Emotion, FORTH_POSITION_ANSWER)
                }
                Psychotype.Chekhov -> {
                    // PWEL
                    questions[0] = TestQuestion(null, PsychoFunction.Physics, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Will, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Emotion, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Logic, FORTH_POSITION_ANSWER)
                }
                Psychotype.Akhmatova -> {
                    // WELP
                    questions[0] = TestQuestion(null, PsychoFunction.Will, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Emotion, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Logic, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Physics, FORTH_POSITION_ANSWER)
                }
                Psychotype.Tolstoy -> {
                    // WEPL
                    questions[0] = TestQuestion(null, PsychoFunction.Will, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Emotion, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Physics, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Logic, FORTH_POSITION_ANSWER)
                }
                Psychotype.Lenin -> {
                    // WLPE
                    questions[0] = TestQuestion(null, PsychoFunction.Will, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Logic, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Physics, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Emotion, FORTH_POSITION_ANSWER)
                }
                Psychotype.Socrates -> {
                    // WLEP
                    questions[0] = TestQuestion(null, PsychoFunction.Will, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Logic, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Emotion, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Physics, FORTH_POSITION_ANSWER)
                }
                Psychotype.Napoleon -> {
                    // WPLE
                    questions[0] = TestQuestion(null, PsychoFunction.Will, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Physics, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Logic, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Emotion, FORTH_POSITION_ANSWER)
                }
                Psychotype.Twardowski -> {
                    //WPEL
                    questions[0] = TestQuestion(null, PsychoFunction.Will, FIRST_POSITION_ANSWER)
                    questions[1] = TestQuestion(null, PsychoFunction.Physics, SECOND_POSITION_ANSWER)
                    questions[2] = TestQuestion(null, PsychoFunction.Emotion, THIRD_POSITION_ANSWER)
                    questions[3] = TestQuestion(null, PsychoFunction.Logic, FORTH_POSITION_ANSWER)
                }
            }

            return questions
        }
    }
}