package com.laushkina.anastasia.psychosophy;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.domain.test.TestQuestion;
import com.laushkina.anastasia.psychosophy.domain.test.TestAnswer;

import java.util.ArrayList;
import java.util.List;

public class PsychotypeAnswersFabric {

    private static final TestAnswer FIRST_POSITION_ANSWER = TestAnswer.Yes;
    private static final TestAnswer SECOND_POSITION_ANSWER = TestAnswer.Maybe;
    private static final TestAnswer THIRD_POSITION_ANSWER = TestAnswer.Sometimes;
    private static final TestAnswer FORTH_POSITION_ANSWER = TestAnswer.No;

    public static TestQuestion[] getAnswers(Psychotype psychotype){

        TestQuestion[] questions = new TestQuestion[4];

        switch (psychotype) {
            case Augustine:
                //LEPW
                questions[0] = new TestQuestion(null, Function.Logic, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Emotion, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Physics, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Will, FORTH_POSITION_ANSWER);
                break;
            case Pascal:
                //LEWP
                questions[0] = new TestQuestion(null, Function.Logic, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Emotion, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Will, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Physics, FORTH_POSITION_ANSWER);
                break;
            case Berthier:
                //LPEW
                questions[0] = new TestQuestion(null, Function.Logic, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Physics, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Emotion, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Will, FORTH_POSITION_ANSWER);
                break;
            case Plato:
                // LPWE
                questions[0] = (new TestQuestion(null, Function.Logic, FIRST_POSITION_ANSWER));
                questions[1] = (new TestQuestion(null, Function.Physics, SECOND_POSITION_ANSWER));
                questions[2] = (new TestQuestion(null, Function.Will, THIRD_POSITION_ANSWER));
                questions[3] = (new TestQuestion(null, Function.Emotion, FORTH_POSITION_ANSWER));
                break;
            case Lao:
                // LWPE
                questions[0] = new TestQuestion(null, Function.Logic, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Will, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Physics, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Emotion, FORTH_POSITION_ANSWER);
                break;
            case Einstein:
                // LWEP
                questions[0] = new TestQuestion(null, Function.Logic, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Will, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Emotion, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Physics, FORTH_POSITION_ANSWER);
                break;
            case Anderson:
                // ELWP
                questions[0] = new TestQuestion(null, Function.Emotion, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Logic, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Will, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Physics, FORTH_POSITION_ANSWER);
                break;
            case Rousseau:
                // ELPW
                questions[0] = new TestQuestion(null, Function.Emotion, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Logic, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Physics, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Will, FORTH_POSITION_ANSWER);
                break;
            case Bukharin:
                //EPLW
                questions[0] = new TestQuestion(null, Function.Emotion, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Physics, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Logic, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Will, FORTH_POSITION_ANSWER);
                break;
            case Pushkin:
                // EPWL
                questions[0] = new TestQuestion(null, Function.Emotion, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Physics, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Will, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Logic, FORTH_POSITION_ANSWER);
                break;
            case Ghazali:
                // EWLP
                questions[0] = new TestQuestion(null, Function.Emotion, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Will, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Logic, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Physics, FORTH_POSITION_ANSWER);
                break;
            case Parsnip:
                // EWPL
                questions[0] = new TestQuestion(null, Function.Emotion, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Will, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Physics, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Logic, FORTH_POSITION_ANSWER);
                break;
            case Aristippus:
                //PLWE
                questions[0] = new TestQuestion(null, Function.Physics, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Logic, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Will, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Emotion, FORTH_POSITION_ANSWER);
                break;
            case Epicurus:
                // PLEW
                questions[0] = new TestQuestion(null, Function.Physics, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Logic, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Emotion, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Will, FORTH_POSITION_ANSWER);
                break;
            case Borgia:
                // PELW
                questions[0] = new TestQuestion(null, Function.Physics, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Emotion, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Logic, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Will, FORTH_POSITION_ANSWER);
                break;
            case Dumas:
                // PEWL
                questions[0] = new TestQuestion(null, Function.Physics, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Emotion, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Will, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Logic, FORTH_POSITION_ANSWER);
                break;
            case Goethe:
                // PWLE
                questions[0] = new TestQuestion(null, Function.Physics, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Will, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Logic, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Emotion, FORTH_POSITION_ANSWER);
                break;
            case Chekhov:
                // PWEL
                questions[0] = new TestQuestion(null, Function.Physics, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Will, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Emotion, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Logic, FORTH_POSITION_ANSWER);
                break;
            case Akhmatova:
                // WELP
                questions[0] = new TestQuestion(null, Function.Will, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Emotion, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Logic, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Physics, FORTH_POSITION_ANSWER);
                break;
            case Tolstoy:
                // WEPL
                questions[0] = new TestQuestion(null, Function.Will, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Emotion, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Physics, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Logic, FORTH_POSITION_ANSWER);
                break;
            case Lenin:
                // WLPE
                questions[0] = new TestQuestion(null, Function.Will, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Logic, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Physics, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Emotion, FORTH_POSITION_ANSWER);
                break;
            case Socrates:
                // WLEP
                questions[0] = new TestQuestion(null, Function.Will, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Logic, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Emotion, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Physics, FORTH_POSITION_ANSWER);
                break;
            case Napoleon:
                // WPLE
                questions[0] = new TestQuestion(null, Function.Will, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Physics, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Logic, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Emotion, FORTH_POSITION_ANSWER);
                break;
            case Twardowski:
                //WPEL
                questions[0] = new TestQuestion(null, Function.Will, FIRST_POSITION_ANSWER);
                questions[1] = new TestQuestion(null, Function.Physics, SECOND_POSITION_ANSWER);
                questions[2] = new TestQuestion(null, Function.Emotion, THIRD_POSITION_ANSWER);
                questions[3] = new TestQuestion(null, Function.Logic, FORTH_POSITION_ANSWER);
                break;
        }

        return questions;
    }
}
