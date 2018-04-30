package com.laushkina.anastasia.psychosophy;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PsychotypeCalculatorUnitTest {

    @Test
    public void Augustine() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Augustine));
        assertEquals(Psychotype.Augustine, actual.get(0));
    }

    @Test
    public void Pascal() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Pascal));
        assertEquals(Psychotype.Pascal, actual.get(0));
    }

    @Test
    public void Berthier() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Berthier));
        assertEquals(Psychotype.Berthier, actual.get(0));
    }

    @Test
    public void Plato() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Plato));
        assertEquals(Psychotype.Plato, actual.get(0));
    }

    @Test
    public void Lao() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Lao));
        assertEquals(Psychotype.Lao, actual.get(0));
    }

    @Test
    public void Einstein() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Einstein));
        assertEquals(Psychotype.Einstein, actual.get(0));
    }

    @Test
    public void Anderson() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Anderson));
        assertEquals(Psychotype.Anderson, actual.get(0));
    }

    @Test
    public void Rousseau() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Rousseau));
        assertEquals(Psychotype.Rousseau, actual.get(0));
    }

    @Test
    public void Bukharin() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Bukharin));
        assertEquals(Psychotype.Bukharin, actual.get(0));
    }

    @Test
    public void Pushkin() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Pushkin));
        assertEquals(Psychotype.Pushkin, actual.get(0));
    }

    @Test
    public void Ghazali() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Ghazali));
        assertEquals(Psychotype.Ghazali, actual.get(0));
    }

    @Test
    public void Parsnip() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Parsnip));
        assertEquals(Psychotype.Parsnip, actual.get(0));
    }

    @Test
    public void Aristippus() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Aristippus));
        assertEquals(Psychotype.Aristippus, actual.get(0));
    }

    @Test
    public void Epicurus() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Epicurus));
        assertEquals(Psychotype.Epicurus, actual.get(0));
    }

    @Test
    public void Borgia() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Borgia));
        assertEquals(Psychotype.Borgia, actual.get(0));
    }

    @Test
    public void Dumas() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Dumas));
        assertEquals(Psychotype.Dumas, actual.get(0));
    }

    @Test
    public void Goethe() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Goethe));
        assertEquals(Psychotype.Goethe, actual.get(0));
    }

    @Test
    public void Chekhov() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Chekhov));
        assertEquals(Psychotype.Chekhov, actual.get(0));
    }

    @Test
    public void Akhmatova() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Akhmatova));
        assertEquals(Psychotype.Akhmatova, actual.get(0));
    }

    @Test
    public void Tolstoy() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Tolstoy));
        assertEquals(Psychotype.Tolstoy, actual.get(0));
    }

    @Test
    public void Lenin() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Lenin));
        assertEquals(Psychotype.Lenin, actual.get(0));
    }

    @Test
    public void Socrates() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Socrates));
        assertEquals(Psychotype.Socrates, actual.get(0));
    }

    @Test
    public void Napoleon() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Napoleon));
        assertEquals(Psychotype.Napoleon, actual.get(0));
    }

    @Test
    public void Twardowski() throws Exception {
        List<Psychotype> actual = PsychotypeCalculator.calculate(PsychotypeAnswersFabric.getAnswers(Psychotype.Twardowski));
        assertEquals(Psychotype.Twardowski, actual.get(0));
    }
}
