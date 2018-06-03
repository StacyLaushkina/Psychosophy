package com.laushkina.anastasia.psychosophy;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.relationships.Relationship;
import com.laushkina.anastasia.psychosophy.domain.relationships.RelationshipsCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RelationshipsCalculator_Philia_Pseudophilia_UnitTest {

    // PHILIA EMOTION

    @Test
    public void Philia1Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Pushkin, Psychotype.Parsnip);
        assertEquals(Relationship.Philia_1_Emotion, relationship);
    }

    @Test
    public void Philia2Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Akhmatova, Psychotype.Akhmatova);
        assertEquals(Relationship.Philia_2_Emotion, relationship);
    }

    @Test
    public void Philia3Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Berthier, Psychotype.Epicurus);
        assertEquals(Relationship.Philia_3_Emotion, relationship);
    }

    @Test
    public void Philia4Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Plato, Psychotype.Lao);
        assertEquals(Relationship.Philia_4_Emotion, relationship);
    }

    // PHILIA LOGIC

    @Test
    public void Philia1Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Pascal, Psychotype.Lao);
        assertEquals(Relationship.Philia_1_Logic, relationship);
    }

    @Test
    public void Philia2Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Rousseau, Psychotype.Socrates);
        assertEquals(Relationship.Philia_2_Logic, relationship);
    }

    @Test
    public void Philia3Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Napoleon, Psychotype.Borgia);
        assertEquals(Relationship.Philia_3_Logic, relationship);
    }

    @Test
    public void Philia4Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Dumas, Psychotype.Pushkin);
        assertEquals(Relationship.Philia_4_Logic, relationship);
    }

    // PHILIA PHYSICS

    @Test
    public void Philia1Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Aristippus, Psychotype.Aristippus);
        assertEquals(Relationship.Philia_1_Physics, relationship);
    }

    @Test
    public void Philia2Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Berthier, Psychotype.Bukharin);
        assertEquals(Relationship.Philia_2_Physics, relationship);
    }

    @Test
    public void Philia3Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Tolstoy, Psychotype.Lenin);
        assertEquals(Relationship.Philia_3_Physics, relationship);
    }

    @Test
    public void Philia4Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Einstein, Psychotype.Ghazali);
        assertEquals(Relationship.Philia_4_Physics, relationship);
    }

    // PHILIA WILL

    @Test
    public void Philia1Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Lenin, Psychotype.Twardowski);
        assertEquals(Relationship.Philia_1_Will, relationship);
    }

    @Test
    public void Philia2Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Lao, Psychotype.Einstein);
        assertEquals(Relationship.Philia_2_Will, relationship);
    }

    @Test
    public void Philia3Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Pushkin, Psychotype.Dumas);
        assertEquals(Relationship.Philia_3_Will, relationship);
    }

    @Test
    public void Philia4Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Epicurus, Psychotype.Berthier);
        assertEquals(Relationship.Philia_4_Will, relationship);
    }

    // PSEUDO PHILIA 1-2

    @Test
    public void PseudoPhilia12Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Anderson, Psychotype.Pascal);
        assertEquals(Relationship.PseudoPhilia_1_2_Emotion, relationship);
    }

    @Test
    public void PseudoPhilia12Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Berthier, Psychotype.Epicurus);
        assertEquals(Relationship.PseudoPhilia_1_2_Logic, relationship);
    }

    @Test
    public void PseudoPhilia12Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Goethe, Psychotype.Bukharin);
        assertEquals(Relationship.PseudoPhilia_1_2_Physics, relationship);
    }

    @Test
    public void PseudoPhilia12Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Lenin, Psychotype.Chekhov);
        assertEquals(Relationship.PseudoPhilia_1_2_Will, relationship);
    }

    // PSEUDO PHILIA 2-1

    @Test
    public void PseudoPhilia21Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Tolstoy, Psychotype.Rousseau);
        assertEquals(Relationship.PseudoPhilia_2_1_Emotion, relationship);
    }

    @Test
    public void PseudoPhilia21Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Epicurus, Psychotype.Pascal);
        assertEquals(Relationship.PseudoPhilia_2_1_Logic, relationship);
    }

    @Test
    public void PseudoPhilia21Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Plato, Psychotype.Borgia);
        assertEquals(Relationship.PseudoPhilia_2_1_Physics, relationship);
    }

    @Test
    public void PseudoPhilia21Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Chekhov, Psychotype.Napoleon);
        assertEquals(Relationship.PseudoPhilia_2_1_Will, relationship);
    }

    // PSEUDO PHILIA 3 - 4

    @Test
    public void PseudoPhilia34Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Berthier, Psychotype.Goethe);
        assertEquals(Relationship.PseudoPhilia_3_4_Emotion, relationship);
    }

    @Test
    public void PseudoPhilia34Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Napoleon, Psychotype.Parsnip);
        assertEquals(Relationship.PseudoPhilia_3_4_Logic, relationship);
    }

    @Test
    public void PseudoPhilia34Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Lenin, Psychotype.Akhmatova);
        assertEquals(Relationship.PseudoPhilia_3_4_Physics, relationship);
    }

    @Test
    public void PseudoPhilia34Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Plato, Psychotype.Augustine);
        assertEquals(Relationship.PseudoPhilia_3_4_Will, relationship);
    }

    // PSEUDO PHILIA 4 - 3

    @Test
    public void PseudoPhilia43Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Aristippus, Psychotype.Chekhov);
        assertEquals(Relationship.PseudoPhilia_4_3_Emotion, relationship);
    }

    @Test
    public void PseudoPhilia43Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Dumas, Psychotype.Napoleon);
        assertEquals(Relationship.PseudoPhilia_4_3_Logic, relationship);
    }

    @Test
    public void PseudoPhilia43Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Einstein, Psychotype.Lao);
        assertEquals(Relationship.PseudoPhilia_4_3_Physics, relationship);
    }

    @Test
    public void PseudoPhilia43Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Borgia, Psychotype.Plato);
        assertEquals(Relationship.PseudoPhilia_4_3_Will, relationship);
    }
}
