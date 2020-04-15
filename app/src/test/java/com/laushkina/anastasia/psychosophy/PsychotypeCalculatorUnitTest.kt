package com.laushkina.anastasia.psychosophy

import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.domain.relationships.Relationship
import com.laushkina.anastasia.psychosophy.domain.relationships.RelationshipsCalculator
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator
import com.laushkina.anastasia.psychosophy.domain.test.TestAnswer
import com.laushkina.anastasia.psychosophy.domain.test.TestQuestion
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals

import org.junit.Test

class PsychotypeCalculatorUnitTest {

    @Test
    fun `test clear psychotypes calculation`() {
        val allTypes = Psychotype.values()
        for (type in allTypes) {
            val actual = PsychotypeCalculator.calculate(PsychotypeAnswersFactory.getAnswers(type))
            assertEquals("Check calculation for type: $type", type, actual!![0])
        }
    }

    @Test
    fun `check calculation result of two variants`() {
        val answers = arrayOf(
                TestQuestion(null, PsychoFunction.Logic, TestAnswer.No),
                TestQuestion(null, PsychoFunction.Emotion, TestAnswer.Maybe),
                TestQuestion(null, PsychoFunction.Physics, TestAnswer.Yes),
                TestQuestion(null, PsychoFunction.Will, TestAnswer.No)
        )
        val expected = listOf(Psychotype.Borgia, Psychotype.Dumas)
        assertTrue(areTypesEqual(expected, PsychotypeCalculator.calculate(answers)!!))
    }

    @Test
    fun `check calculation result of four variants`() {
        val answers = arrayOf(
                TestQuestion(null, PsychoFunction.Logic, TestAnswer.Yes),
                TestQuestion(null, PsychoFunction.Emotion, TestAnswer.No),
                TestQuestion(null, PsychoFunction.Physics, TestAnswer.No),
                TestQuestion(null, PsychoFunction.Will, TestAnswer.Yes)
        )
        val expected = listOf(Psychotype.Einstein, Psychotype.Lao, Psychotype.Socrates, Psychotype.Lenin)
        assertTrue(areTypesEqual(expected, PsychotypeCalculator.calculate(answers)!!))
    }

    @Test
    fun `calculation result is null when answers are unreliable`() {
        val answers = arrayOf(
                TestQuestion(null, PsychoFunction.Logic, TestAnswer.No),
                TestQuestion(null, PsychoFunction.Emotion, TestAnswer.No),
                TestQuestion(null, PsychoFunction.Physics, TestAnswer.No),
                TestQuestion(null, PsychoFunction.Will, TestAnswer.No)
        )
        assertEquals(null, PsychotypeCalculator.calculate(answers))
    }

    @Test
    fun `check philia on first function relationship`() {
        val philiaEmotion = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Pushkin, Psychotype.Parsnip)
        assertEquals("Check first emotion philia relationship", Relationship.Philia_1_Emotion, philiaEmotion)

        val philiaLogic = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Pascal, Psychotype.Lao)
        assertEquals("Check first logic philia relationship", Relationship.Philia_1_Logic, philiaLogic)

        val philiaPhysics = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Aristippus, Psychotype.Aristippus)
        assertEquals("Check first physics philia relationship", Relationship.Philia_1_Physics, philiaPhysics)

        val philiaWill = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Lenin, Psychotype.Twardowski)
        assertEquals("Check first will philia relationship", Relationship.Philia_1_Will, philiaWill)
    }

    @Test
    fun `check philia on second function relationship`() {
        val philiaEmotion = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Akhmatova, Psychotype.Akhmatova)
        assertEquals("Check second emotion philia relationship", Relationship.Philia_2_Emotion, philiaEmotion)

        val philiaLogic = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Rousseau, Psychotype.Socrates)
        assertEquals("Check second logic philia relationship", Relationship.Philia_2_Logic, philiaLogic)

        val philiaPhysics = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Berthier, Psychotype.Bukharin)
        assertEquals("Check second physics philia relationship", Relationship.Philia_2_Physics, philiaPhysics)

        val philiaWill = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Lao, Psychotype.Einstein)
        assertEquals("Check second will philia relationship", Relationship.Philia_2_Will, philiaWill)
    }

    @Test
    fun `check philia on third function relationship`() {
        val philiaEmotion = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Berthier, Psychotype.Epicurus)
        assertEquals("Check third emotion philia relationship", Relationship.Philia_3_Emotion, philiaEmotion)

        val philiaLogic = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Napoleon, Psychotype.Borgia)
        assertEquals("Check third logic philia relationship", Relationship.Philia_3_Logic, philiaLogic)

        val philiaPhysics = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Tolstoy, Psychotype.Lenin)
        assertEquals("Check third physics philia relationship", Relationship.Philia_3_Physics, philiaPhysics)

        val philiaWill = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Pushkin, Psychotype.Dumas)
        assertEquals("Check third will philia relationship", Relationship.Philia_3_Will, philiaWill)
    }

    @Test
    fun `check philia on forth function relationship`() {
        val philiaEmotion = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Plato, Psychotype.Lao)
        assertEquals("Check forth emotion philia relationship", Relationship.Philia_4_Emotion, philiaEmotion)

        val philiaLogic = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Dumas, Psychotype.Pushkin)
        assertEquals("Check forth logic philia relationship", Relationship.Philia_4_Logic, philiaLogic)

        val philiaPhysics = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Einstein, Psychotype.Ghazali)
        assertEquals("Check forth physics philia relationship", Relationship.Philia_4_Physics, philiaPhysics)

        val philiaWill = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Epicurus, Psychotype.Berthier)
        assertEquals("Check forth will philia relationship", Relationship.Philia_4_Will, philiaWill)
    }

    @Test
    fun `check pseudo philia on first and second functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Anderson, Psychotype.Pascal)
        assertEquals("Check 1-2 emotion pseudo philia relationship", Relationship.PseudoPhilia_1_2_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Berthier, Psychotype.Epicurus)
        assertEquals("Check 1-2 logic pseudo philia relationship", Relationship.PseudoPhilia_1_2_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Goethe, Psychotype.Bukharin)
        assertEquals("Check 1-2 logic pseudo philia relationship", Relationship.PseudoPhilia_1_2_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Lenin, Psychotype.Chekhov)
        assertEquals("Check 1-2 will pseudo philia relationship", Relationship.PseudoPhilia_1_2_Will, willRelationship)
    }

    @Test
    fun `check pseudo philia on second and first functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Tolstoy, Psychotype.Rousseau)
        assertEquals("Check 2-1 emotion pseudo philia relationship", Relationship.PseudoPhilia_2_1_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Epicurus, Psychotype.Pascal)
        assertEquals("Check 2-1 logic pseudo philia relationship", Relationship.PseudoPhilia_2_1_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Plato, Psychotype.Borgia)
        assertEquals("Check 2-1 physics pseudo philia relationship", Relationship.PseudoPhilia_2_1_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Chekhov, Psychotype.Napoleon)
        assertEquals("Check 2-1 will pseudo philia relationship", Relationship.PseudoPhilia_2_1_Will, willRelationship)
    }

    @Test
    fun `check pseudo philia on third and forth functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Berthier, Psychotype.Goethe)
        assertEquals("Check 3-4 emotion pseudo philia relationship", Relationship.PseudoPhilia_3_4_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Napoleon, Psychotype.Parsnip)
        assertEquals("Check 3-4 logic pseudo philia relationship", Relationship.PseudoPhilia_3_4_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Lenin, Psychotype.Akhmatova)
        assertEquals("Check 3-4 physics pseudo philia relationship", Relationship.PseudoPhilia_3_4_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Plato, Psychotype.Augustine)
        assertEquals("Check 3-4 will pseudo philia relationship", Relationship.PseudoPhilia_3_4_Will, willRelationship)
    }

    @Test
    fun `check pseudo philia on forth and third functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Aristippus, Psychotype.Chekhov)
        assertEquals("Check 4-3 emotion pseudo philia relationship", Relationship.PseudoPhilia_4_3_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Dumas, Psychotype.Napoleon)
        assertEquals("Check 4-3 logic pseudo philia relationship", Relationship.PseudoPhilia_4_3_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Einstein, Psychotype.Lao)
        assertEquals("Check 4-3 physics pseudo philia relationship", Relationship.PseudoPhilia_4_3_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Borgia, Psychotype.Plato)
        assertEquals("Check 4-3 will pseudo philia relationship", Relationship.PseudoPhilia_4_3_Will, willRelationship)
    }

    @Test
    fun `check eros on first and third functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Anderson, Psychotype.Berthier)
        assertEquals("Check 1-3 emotion eros relationship", Relationship.Eros_1_3_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Einstein, Psychotype.Bukharin)
        assertEquals("Check 1-3 logic eros relationship", Relationship.Eros_1_3_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Epicurus, Psychotype.Rousseau)
        assertEquals("Check 1-3 physics eros relationship", Relationship.Eros_1_3_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Socrates, Psychotype.Aristippus)
        assertEquals("Check 1-3 will eros relationship", Relationship.Eros_1_3_Will, willRelationship)
    }

    @Test
    fun `check eros on third and first functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Chekhov, Psychotype.Rousseau)
        assertEquals("Check 3-1 emotion eros relationship", Relationship.Eros_3_1_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Borgia, Psychotype.Plato)
        assertEquals("Check 3-1 logic eros relationship", Relationship.Eros_3_1_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Tolstoy, Psychotype.Dumas)
        assertEquals("Check 3-1 physics eros relationship", Relationship.Eros_3_1_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Pushkin, Psychotype.Napoleon)
        assertEquals("Check 3-1 will eros relationship", Relationship.Eros_3_1_Will, willRelationship)
    }

    @Test
    fun `check eros on second and forth functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Pascal, Psychotype.Aristippus)
        assertEquals("Check 2-4 emotion eros relationship", Relationship.Eros_2_4_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Lenin, Psychotype.Pushkin)
        assertEquals("Check 2-4 logic eros relationship", Relationship.Eros_2_4_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Berthier, Psychotype.Ghazali)
        assertEquals("Check 2-4 physics eros relationship", Relationship.Eros_2_4_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Goethe, Psychotype.Epicurus)
        assertEquals("Check 2-4 will eros relationship", Relationship.Eros_2_4_Will, willRelationship)
    }

    @Test
    fun `check eros on forth and second functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Plato, Psychotype.Borgia)
        assertEquals("Check 4-2 emotion eros relationship", Relationship.Eros_4_2_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Parsnip, Psychotype.Rousseau)
        assertEquals("Check 4-2 logic eros relationship", Relationship.Eros_4_2_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Einstein, Psychotype.Napoleon)
        assertEquals("Check 4-2 physics eros relationship", Relationship.Eros_4_2_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Borgia, Psychotype.Goethe)
        assertEquals("Check 4-2 will eros relationship", Relationship.Eros_4_2_Will, willRelationship)
    }

    @Test
    fun `check agape on first and forth functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Rousseau, Psychotype.Plato)
        assertEquals("Check 1-4 emotion agape relationship", Relationship.Agape_1_4_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Einstein, Psychotype.Parsnip)
        assertEquals("Check 1-4 logic agape relationship", Relationship.Agape_1_4_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Epicurus, Psychotype.Akhmatova)
        assertEquals("Check 1-4 physics agape relationship", Relationship.Agape_1_4_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Socrates, Psychotype.Rousseau)
        assertEquals("Check 1-4 will agape relationship", Relationship.Agape_1_4_Will, willRelationship)
    }

    @Test
    fun `check agape on forth and first functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Goethe, Psychotype.Pushkin)
        assertEquals("Check 1-4 emotion agape relationship", Relationship.Agape_4_1_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Dumas, Psychotype.Augustine)
        assertEquals("Check 1-4 logic agape relationship", Relationship.Agape_4_1_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Socrates, Psychotype.Chekhov)
        assertEquals("Check 1-4 physics agape relationship", Relationship.Agape_4_1_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Epicurus, Psychotype.Lenin)
        assertEquals("Check 1-4 will agape relationship", Relationship.Agape_4_1_Will, willRelationship)
    }

    @Test
    fun `check agape on second and third functions`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Pascal, Psychotype.Epicurus)
        assertEquals("Check 2-3 emotion agape relationship", Relationship.Agape_2_3_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Rousseau, Psychotype.Ghazali)
        assertEquals("Check 2-3 logic agape relationship", Relationship.Agape_2_3_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Napoleon, Psychotype.Tolstoy)
        assertEquals("Check 2-3 physics agape relationship", Relationship.Agape_2_3_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Goethe, Psychotype.Pushkin)
        assertEquals("Check 2-3 will agape relationship", Relationship.Agape_2_3_Will, willRelationship)
    }

    @Test
    fun `check agape on third and second function`() {
        val emotionRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Emotion, Psychotype.Chekhov, Psychotype.Borgia)
        assertEquals("Check 3-2 emotion agape relationship", Relationship.Agape_3_2_Emotion, emotionRelationship)

        val logicRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Logic, Psychotype.Akhmatova, Psychotype.Epicurus)
        assertEquals("Check 3-2 logic agape relationship", Relationship.Agape_3_2_Logic, logicRelationship)

        val physicsRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Physics, Psychotype.Rousseau, Psychotype.Bukharin)
        assertEquals("Check 3-2 physics agape relationship", Relationship.Agape_3_2_Physics, physicsRelationship)

        val willRelationship = RelationshipsCalculator.getRelationship(PsychoFunction.Will, Psychotype.Anderson, Psychotype.Lao)
        assertEquals("Check 3-2 will agape relationship", Relationship.Agape_3_2_Will, willRelationship)
    }

    private fun areTypesEqual(expectedList: List<Psychotype>, actualList: List<Psychotype>): Boolean {
        if (expectedList.size != actualList.size) {
            return false
        }

        var result = true
        for (expected in expectedList) {
            if (!actualList.contains(expected)) {
                result = false
                break
            }
        }
        return result
    }
}