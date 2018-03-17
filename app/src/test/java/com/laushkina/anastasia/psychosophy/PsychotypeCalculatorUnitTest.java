package com.laushkina.anastasia.psychosophy;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.Question;
import com.laushkina.anastasia.psychosophy.domain.test.QuestionAnswer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for checking simple and border cases of psychotype calculator
 */
public class PsychotypeCalculatorUnitTest {

    @Test
    public void Twardowski() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(getWPELAnswers());
        assertEquals(Psychotype.Twardowski, actual.get(0));
    }

    @Test
    public void Rousseau() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(getELPWAnswers());
        assertEquals(Psychotype.Rousseau, actual.get(0));
    }

    @Test
    public void twoVariants() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(getPEWLorPELWAnswers());
        List<Psychotype> expected = new ArrayList<Psychotype>() {{
            add(Psychotype.Borgia);
            add(Psychotype.Dumas);
        }};
        assertEquals(true, areCalculatedTypesEquals(expected, actual));
    }

    @Test
    public void fourVariants() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(getLWEPorLWPEorWLEPorWLPEAnswers());
        List<Psychotype> expected = new ArrayList<Psychotype>() {{
            add(Psychotype.Einstein);
            add(Psychotype.Lao);
            add(Psychotype.Socrates);
            add(Psychotype.Lenin);
        }};
        assertEquals(true, areCalculatedTypesEquals(expected, actual));
    }

    private boolean areCalculatedTypesEquals(List<Psychotype> expectedList, List<Psychotype> actualList){
        if (expectedList.size() != actualList.size()) return false;

        boolean result = true;
        for (Psychotype expected : expectedList) {
            if (!actualList.contains(expected)) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Test
    public void Unreliable() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(getUnreliableAnswers());
        assertEquals(null, actual);
    }

    private List<Question> getUnreliableAnswers(){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(null, Function.Logic, QuestionAnswer.No));
        questions.add(new Question(null, Function.Emotion, QuestionAnswer.No));
        questions.add(new Question(null, Function.Physics, QuestionAnswer.No));
        questions.add(new Question(null, Function.Will, QuestionAnswer.No));

        return questions;
    }

    private List<Question> getLWEPorLWPEorWLEPorWLPEAnswers(){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(null, Function.Logic, QuestionAnswer.Yes));
        questions.add(new Question(null, Function.Emotion, QuestionAnswer.No));
        questions.add(new Question(null, Function.Physics, QuestionAnswer.No));
        questions.add(new Question(null, Function.Will, QuestionAnswer.Yes));

        return questions;
    }

    private List<Question> getPEWLorPELWAnswers(){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(null, Function.Logic, QuestionAnswer.No));
        questions.add(new Question(null, Function.Emotion, QuestionAnswer.Maybe));
        questions.add(new Question(null, Function.Physics, QuestionAnswer.Yes));
        questions.add(new Question(null, Function.Will, QuestionAnswer.No));

        return questions;
    }

    private List<Question> getWPELAnswers(){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(null, Function.Logic, QuestionAnswer.No));
        questions.add(new Question(null, Function.Emotion, QuestionAnswer.Sometimes));
        questions.add(new Question(null, Function.Physics, QuestionAnswer.Maybe));
        questions.add(new Question(null, Function.Will, QuestionAnswer.Yes));

        return questions;
    }

    private List<Question> getELPWAnswers(){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(null, Function.Logic, QuestionAnswer.Maybe));
        questions.add(new Question(null, Function.Emotion, QuestionAnswer.Yes));
        questions.add(new Question(null, Function.Physics, QuestionAnswer.Sometimes));
        questions.add(new Question(null, Function.Will, QuestionAnswer.No));

        return questions;
    }
}