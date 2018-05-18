package com.laushkina.anastasia.psychosophy.domain.relationships;

import android.content.Context;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.Function;
import com.laushkina.anastasia.psychosophy.view.utils.RelationshipsToStringFormatter;

public class RelationshipsCalculator {

    public static Relationship getRelationship(Function firstFunction, int fistFunctionPosition, Psychotype secondType){
        // Position of firstFunction for secondType
        int secondPosition = getFunctionPosition(firstFunction, secondType);
        switch (firstFunction) {
            case Will:
                return getWillRelationship(fistFunctionPosition, secondPosition);
            case Emotion:
                return getEmotionRelationship(fistFunctionPosition, secondPosition);
            case Logic:
                return getLogicRelationship(fistFunctionPosition, secondPosition);
            case Physics:
                return getPhysicsRelationship(fistFunctionPosition, secondPosition);

            default: throw new AssertionError();
        }
    }

    private static int getFunctionPosition(Function firstFunction, Psychotype secondType){
        int position = 0;
        for (Function function : secondType.getFunctions()) {
            if (function == firstFunction) break;
            position++;
        }
        return position;
    }

    private static Relationship getWillRelationship(int firstPosition, int secondPosition) {
        if (firstPosition < 0 || firstPosition > 3 || secondPosition < 0 || secondPosition > 3)
            throw new IllegalArgumentException("Positions must be between 0 and 3");

        if (firstPosition == 0 && secondPosition == 0) return Relationship.Philia_1_Will;
        if (firstPosition == 0 && secondPosition == 1) return Relationship.PseudoPhilia_1_2_Will;
        if (firstPosition == 0 && secondPosition == 2) return Relationship.Eros_1_3_Will;
        if (firstPosition == 0 && secondPosition == 3) return Relationship.Agape_1_4_Will;

        if (firstPosition == 1 && secondPosition == 0) return Relationship.PseudoPhilia_2_1_Will;
        if (firstPosition == 1 && secondPosition == 1) return Relationship.Philia_2_Will;
        if (firstPosition == 1 && secondPosition == 2) return Relationship.Agape_2_3_Will;
        if (firstPosition == 1 && secondPosition == 3) return Relationship.Eros_2_4_Will;

        if (firstPosition == 2 && secondPosition == 0) return Relationship.Eros_3_1_Will;
        if (firstPosition == 2 && secondPosition == 1) return Relationship.Agape_3_2_Will;
        if (firstPosition == 2 && secondPosition == 2) return Relationship.Philia_3_Will;
        if (firstPosition == 2 && secondPosition == 3) return Relationship.PseudoPhilia_3_4_Will;

        if (firstPosition == 3 && secondPosition == 0) return Relationship.Agape_4_1_Will;
        if (firstPosition == 3 && secondPosition == 1) return Relationship.Eros_4_2_Will;
        if (firstPosition == 3 && secondPosition == 2) return Relationship.PseudoPhilia_4_3_Will;
        if (firstPosition == 3 && secondPosition == 3) return Relationship.Philia_4_Will;

        throw new AssertionError();
    }

    private static Relationship getEmotionRelationship(int firstPosition, int secondPosition) {
        if (firstPosition < 0 || firstPosition > 3 || secondPosition < 0 || secondPosition > 3)
            throw new IllegalArgumentException("Positions must be between 0 and 3");

        if (firstPosition == 0 && secondPosition == 0) return Relationship.Philia_1_Emotion;
        if (firstPosition == 0 && secondPosition == 1) return Relationship.PseudoPhilia_1_2_Emotion;
        if (firstPosition == 0 && secondPosition == 2) return Relationship.Eros_1_3_Emotion;
        if (firstPosition == 0 && secondPosition == 3) return Relationship.Agape_1_4_Emotion;

        if (firstPosition == 1 && secondPosition == 0) return Relationship.PseudoPhilia_2_1_Emotion;
        if (firstPosition == 1 && secondPosition == 1) return Relationship.Philia_2_Emotion;
        if (firstPosition == 1 && secondPosition == 2) return Relationship.Agape_2_3_Emotion;
        if (firstPosition == 1 && secondPosition == 3) return Relationship.Eros_2_4_Emotion;

        if (firstPosition == 2 && secondPosition == 0) return Relationship.Eros_3_1_Emotion;
        if (firstPosition == 2 && secondPosition == 1) return Relationship.Agape_3_2_Emotion;
        if (firstPosition == 2 && secondPosition == 2) return Relationship.Philia_3_Emotion;
        if (firstPosition == 2 && secondPosition == 3) return Relationship.PseudoPhilia_3_4_Emotion;

        if (firstPosition == 3 && secondPosition == 0) return Relationship.Agape_4_1_Emotion;
        if (firstPosition == 3 && secondPosition == 1) return Relationship.Eros_4_2_Emotion;
        if (firstPosition == 3 && secondPosition == 2) return Relationship.PseudoPhilia_4_3_Emotion;
        if (firstPosition == 3 && secondPosition == 3) return Relationship.Philia_4_Emotion;

        throw new AssertionError();
    }

    private static Relationship getLogicRelationship(int firstPosition, int secondPosition) {
        if (firstPosition < 0 || firstPosition > 3 || secondPosition < 0 || secondPosition > 3)
            throw new IllegalArgumentException("Positions must be between 0 and 3");

        if (firstPosition == 0 && secondPosition == 0) return Relationship.Philia_1_Logic;
        if (firstPosition == 0 && secondPosition == 1) return Relationship.PseudoPhilia_1_2_Logic;
        if (firstPosition == 0 && secondPosition == 2) return Relationship.Eros_1_3_Logic;
        if (firstPosition == 0 && secondPosition == 3) return Relationship.Agape_1_4_Logic;

        if (firstPosition == 1 && secondPosition == 0) return Relationship.PseudoPhilia_2_1_Logic;
        if (firstPosition == 1 && secondPosition == 1) return Relationship.Philia_2_Logic;
        if (firstPosition == 1 && secondPosition == 2) return Relationship.Agape_2_3_Logic;
        if (firstPosition == 1 && secondPosition == 3) return Relationship.Eros_2_4_Logic;

        if (firstPosition == 2 && secondPosition == 0) return Relationship.Eros_3_1_Logic;
        if (firstPosition == 2 && secondPosition == 1) return Relationship.Agape_3_2_Logic;
        if (firstPosition == 2 && secondPosition == 2) return Relationship.Philia_3_Logic;
        if (firstPosition == 2 && secondPosition == 3) return Relationship.PseudoPhilia_3_4_Logic;

        if (firstPosition == 3 && secondPosition == 0) return Relationship.Agape_4_1_Logic;
        if (firstPosition == 3 && secondPosition == 1) return Relationship.Eros_4_2_Logic;
        if (firstPosition == 3 && secondPosition == 2) return Relationship.PseudoPhilia_4_3_Logic;
        if (firstPosition == 3 && secondPosition == 3) return Relationship.Philia_4_Logic;

        throw new AssertionError();
    }

    private static Relationship getPhysicsRelationship(int firstPosition, int secondPosition) {
        if (firstPosition < 0 || firstPosition > 3 || secondPosition < 0 || secondPosition > 3)
            throw new IllegalArgumentException("Positions must be between 0 and 3");

        if (firstPosition == 0 && secondPosition == 0) return Relationship.Philia_1_Physics;
        if (firstPosition == 0 && secondPosition == 1) return Relationship.PseudoPhilia_1_2_Physics;
        if (firstPosition == 0 && secondPosition == 2) return Relationship.Eros_1_3_Physics;
        if (firstPosition == 0 && secondPosition == 3) return Relationship.Agape_1_4_Physics;

        if (firstPosition == 1 && secondPosition == 0) return Relationship.PseudoPhilia_2_1_Physics;
        if (firstPosition == 1 && secondPosition == 1) return Relationship.Philia_2_Physics;
        if (firstPosition == 1 && secondPosition == 2) return Relationship.Agape_2_3_Physics;
        if (firstPosition == 1 && secondPosition == 3) return Relationship.Eros_2_4_Physics;

        if (firstPosition == 2 && secondPosition == 0) return Relationship.Eros_3_1_Physics;
        if (firstPosition == 2 && secondPosition == 1) return Relationship.Agape_3_2_Physics;
        if (firstPosition == 2 && secondPosition == 2) return Relationship.Philia_3_Physics;
        if (firstPosition == 2 && secondPosition == 3) return Relationship.PseudoPhilia_3_4_Physics;

        if (firstPosition == 3 && secondPosition == 0) return Relationship.Agape_4_1_Physics;
        if (firstPosition == 3 && secondPosition == 1) return Relationship.Eros_4_2_Physics;
        if (firstPosition == 3 && secondPosition == 2) return Relationship.PseudoPhilia_4_3_Physics;
        if (firstPosition == 3 && secondPosition == 3) return Relationship.Philia_4_Physics;

        throw new AssertionError();
    }
}
