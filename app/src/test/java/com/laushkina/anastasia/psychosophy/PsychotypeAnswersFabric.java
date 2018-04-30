package com.laushkina.anastasia.psychosophy;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.domain.test.Question;
import com.laushkina.anastasia.psychosophy.domain.test.QuestionAnswer;

import java.util.ArrayList;
import java.util.List;

public class PsychotypeAnswersFabric {

    private static final QuestionAnswer FIRST_POSITION_ANSWER = QuestionAnswer.Yes;
    private static final QuestionAnswer SECOND_POSITION_ANSWER = QuestionAnswer.Maybe;
    private static final QuestionAnswer THIRD_POSITION_ANSWER = QuestionAnswer.Sometimes;
    private static final QuestionAnswer FORTH_POSITION_ANSWER = QuestionAnswer.No;

    public static List<Question> getAnswers(Psychotype psychotype){

        List<Question> questions = new ArrayList<>();

        switch (psychotype) {
            case Augustine:
                //LEPW
                questions.add(new Question(null, Function.Logic, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, FORTH_POSITION_ANSWER));
                break;
            case Pascal:
                //LEWP
                questions.add(new Question(null, Function.Logic, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, FORTH_POSITION_ANSWER));
                break;
            case Berthier:
                //LPEW
                questions.add(new Question(null, Function.Logic, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, FORTH_POSITION_ANSWER));
                break;
            case Plato:
                // LPWE
                questions.add(new Question(null, Function.Logic, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, FORTH_POSITION_ANSWER));
                break;
            case Lao:
                // LWPE
                questions.add(new Question(null, Function.Logic, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, FORTH_POSITION_ANSWER));
                break;
            case Einstein:
                // LWEP
                questions.add(new Question(null, Function.Logic, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, FORTH_POSITION_ANSWER));
                break;
            case Anderson:
                // ELWP
                questions.add(new Question(null, Function.Emotion, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, FORTH_POSITION_ANSWER));
                break;
            case Rousseau:
                // ELPW
                questions.add(new Question(null, Function.Emotion, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, FORTH_POSITION_ANSWER));
                break;
            case Bukharin:
                //EPLW
                questions.add(new Question(null, Function.Emotion, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, FORTH_POSITION_ANSWER));
                break;
            case Pushkin:
                // EPWL
                questions.add(new Question(null, Function.Emotion, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, FORTH_POSITION_ANSWER));
                break;
            case Ghazali:
                // EWLP
                questions.add(new Question(null, Function.Emotion, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, FORTH_POSITION_ANSWER));
                break;
            case Parsnip:
                // EWPL
                questions.add(new Question(null, Function.Emotion, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, FORTH_POSITION_ANSWER));
                break;
            case Aristippus:
                //PLWE
                questions.add(new Question(null, Function.Physics, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, FORTH_POSITION_ANSWER));
                break;
            case Epicurus:
                // PLEW
                questions.add(new Question(null, Function.Physics, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, FORTH_POSITION_ANSWER));
                break;
            case Borgia:
                // PELW
                questions.add(new Question(null, Function.Physics, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, FORTH_POSITION_ANSWER));
                break;
            case Dumas:
                // PEWL
                questions.add(new Question(null, Function.Physics, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, FORTH_POSITION_ANSWER));
                break;
            case Goethe:
                // PWLE
                questions.add(new Question(null, Function.Physics, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, FORTH_POSITION_ANSWER));
                break;
            case Chekhov:
                // PWEL
                questions.add(new Question(null, Function.Physics, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Will, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, FORTH_POSITION_ANSWER));
                break;
            case Akhmatova:
                // WELP
                questions.add(new Question(null, Function.Will, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, FORTH_POSITION_ANSWER));
                break;
            case Tolstoy:
                // WEPL
                questions.add(new Question(null, Function.Will, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, FORTH_POSITION_ANSWER));
                break;
            case Lenin:
                // WLPE
                questions.add(new Question(null, Function.Will, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, FORTH_POSITION_ANSWER));
                break;
            case Socrates:
                // WLEP
                questions.add(new Question(null, Function.Will, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, FORTH_POSITION_ANSWER));
                break;
            case Napoleon:
                // WPLE
                questions.add(new Question(null, Function.Will, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, FORTH_POSITION_ANSWER));
                break;
            case Twardowski:
                //WPEL
                questions.add(new Question(null, Function.Will, FIRST_POSITION_ANSWER));
                questions.add(new Question(null, Function.Physics, SECOND_POSITION_ANSWER));
                questions.add(new Question(null, Function.Emotion, THIRD_POSITION_ANSWER));
                questions.add(new Question(null, Function.Logic, FORTH_POSITION_ANSWER));
                break;
        }

        return questions;
    }
}
