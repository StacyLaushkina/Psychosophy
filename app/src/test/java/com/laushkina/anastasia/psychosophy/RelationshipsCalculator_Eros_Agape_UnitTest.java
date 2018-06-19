package com.laushkina.anastasia.psychosophy;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.relationships.Relationship;
import com.laushkina.anastasia.psychosophy.domain.relationships.RelationshipsCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.domain.test.PsychotypeCalculator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RelationshipsCalculator_Eros_Agape_UnitTest {

    // Eros 1 - 3
    @Test
    public void Eros13Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Anderson, Psychotype.Berthier);
        assertEquals(Relationship.Eros_1_3_Emotion, relationship);
    }

    @Test
    public void Eros13Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Einstein, Psychotype.Bukharin);
        assertEquals(Relationship.Eros_1_3_Logic, relationship);
    }

    @Test
    public void Eros13Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Epicurus, Psychotype.Rousseau);
        assertEquals(Relationship.Eros_1_3_Physics, relationship);
    }

    @Test
    public void Eros13Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Socrates, Psychotype.Aristippus);
        assertEquals(Relationship.Eros_1_3_Will, relationship);
    }

    // Eros 3 - 1
    @Test
    public void Eros31Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Chekhov, Psychotype.Rousseau);
        assertEquals(Relationship.Eros_3_1_Emotion, relationship);
    }

    @Test
    public void Eros31Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Borgia, Psychotype.Plato);
        assertEquals(Relationship.Eros_3_1_Logic, relationship);
    }

    @Test
    public void Eros31Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Tolstoy, Psychotype.Dumas);
        assertEquals(Relationship.Eros_3_1_Physics, relationship);
    }

    @Test
    public void Eros31Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Pushkin, Psychotype.Napoleon);
        assertEquals(Relationship.Eros_3_1_Will, relationship);
    }

    // Eros 2 - 4
    @Test
    public void Eros24Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Pascal, Psychotype.Aristippus);
        assertEquals(Relationship.Eros_2_4_Emotion, relationship);
    }

    @Test
    public void Eros24Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Lenin, Psychotype.Pushkin);
        assertEquals(Relationship.Eros_2_4_Logic, relationship);
    }

    @Test
    public void Eros24Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Berthier, Psychotype.Ghazali);
        assertEquals(Relationship.Eros_2_4_Physics, relationship);
    }

    @Test
    public void Eros24Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Goethe, Psychotype.Epicurus);
        assertEquals(Relationship.Eros_2_4_Will, relationship);
    }

    // Eros 4 - 2
    @Test
    public void Eros42Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Plato, Psychotype.Borgia);
        assertEquals(Relationship.Eros_4_2_Emotion, relationship);
    }

    @Test
    public void Eros42Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Parsnip, Psychotype.Rousseau);
        assertEquals(Relationship.Eros_4_2_Logic, relationship);
    }

    @Test
    public void Eros42Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Einstein, Psychotype.Napoleon);
        assertEquals(Relationship.Eros_4_2_Physics, relationship);
    }

    @Test
    public void Eros42Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Borgia, Psychotype.Goethe);
        assertEquals(Relationship.Eros_4_2_Will, relationship);
    }

    // Agape 1 - 4
    @Test
    public void Agape14Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Rousseau, Psychotype.Plato);
        assertEquals(Relationship.Agape_1_4_Emotion, relationship);
    }

    @Test
    public void Agape14Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Einstein, Psychotype.Parsnip);
        assertEquals(Relationship.Agape_1_4_Logic, relationship);
    }

    @Test
    public void Agape14Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Epicurus, Psychotype.Akhmatova);
        assertEquals(Relationship.Agape_1_4_Physics, relationship);
    }

    @Test
    public void Agape14Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Socrates, Psychotype.Rousseau);
        assertEquals(Relationship.Agape_1_4_Will, relationship);
    }

    // Agape 4 - 1
    @Test
    public void Agape41Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Goethe, Psychotype.Pushkin);
        assertEquals(Relationship.Agape_4_1_Emotion, relationship);
    }

    @Test
    public void Agape41Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Dumas, Psychotype.Augustine);
        assertEquals(Relationship.Agape_4_1_Logic, relationship);
    }

    @Test
    public void Agape41Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Socrates, Psychotype.Chekhov);
        assertEquals(Relationship.Agape_4_1_Physics, relationship);
    }

    @Test
    public void Agape41Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Epicurus, Psychotype.Lenin);
        assertEquals(Relationship.Agape_4_1_Will, relationship);
    }

    // Agape 2 - 3
    @Test
    public void Agape23Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Pascal, Psychotype.Epicurus);
        assertEquals(Relationship.Agape_2_3_Emotion, relationship);
    }

    @Test
    public void Agape23Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Rousseau, Psychotype.Ghazali);
        assertEquals(Relationship.Agape_2_3_Logic, relationship);
    }

    @Test
    public void Agape23Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Napoleon, Psychotype.Tolstoy);
        assertEquals(Relationship.Agape_2_3_Physics, relationship);
    }

    @Test
    public void Agape23Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Goethe, Psychotype.Pushkin);
        assertEquals(Relationship.Agape_2_3_Will, relationship);
    }

    // Agape 3 - 2
    @Test
    public void Agape32Emotion() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Emotion, Psychotype.Chekhov, Psychotype.Borgia);
        assertEquals(Relationship.Agape_3_2_Emotion, relationship);
    }

    @Test
    public void Agape32Logic() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Logic, Psychotype.Akhmatova, Psychotype.Epicurus);
        assertEquals(Relationship.Agape_3_2_Logic, relationship);
    }

    @Test
    public void Agape32Physics() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Physics, Psychotype.Rousseau, Psychotype.Bukharin);
        assertEquals(Relationship.Agape_3_2_Physics, relationship);
    }

    @Test
    public void Agape32Will() throws Exception {
        Relationship relationship = RelationshipsCalculator.getRelationship(Function.Will, Psychotype.Anderson, Psychotype.Lao);
        assertEquals(Relationship.Agape_3_2_Will, relationship);
    }

}
