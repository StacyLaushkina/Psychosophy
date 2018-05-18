package com.laushkina.anastasia.psychosophy;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.TestQuestion;
import com.laushkina.anastasia.psychosophy.domain.test.TestAnswer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for checking border cases of psychotype calculator
 */
public class PsychotypeCalculatorSeveralAnswersUnitTest {

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

    private List<TestQuestion> getUnreliableAnswers(){
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(new TestQuestion(null, Function.Logic, TestAnswer.No));
        questions.add(new TestQuestion(null, Function.Emotion, TestAnswer.No));
        questions.add(new TestQuestion(null, Function.Physics, TestAnswer.No));
        questions.add(new TestQuestion(null, Function.Will, TestAnswer.No));

        return questions;
    }

    private List<TestQuestion> getLWEPorLWPEorWLEPorWLPEAnswers(){
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(new TestQuestion(null, Function.Logic, TestAnswer.Yes));
        questions.add(new TestQuestion(null, Function.Emotion, TestAnswer.No));
        questions.add(new TestQuestion(null, Function.Physics, TestAnswer.No));
        questions.add(new TestQuestion(null, Function.Will, TestAnswer.Yes));

        return questions;
    }

    private List<TestQuestion> getPEWLorPELWAnswers(){
        List<TestQuestion> questions = new ArrayList<>();
        questions.add(new TestQuestion(null, Function.Logic, TestAnswer.No));
        questions.add(new TestQuestion(null, Function.Emotion, TestAnswer.Maybe));
        questions.add(new TestQuestion(null, Function.Physics, TestAnswer.Yes));
        questions.add(new TestQuestion(null, Function.Will, TestAnswer.No));

        return questions;
    }
}