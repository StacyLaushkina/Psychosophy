package com.laushkina.anastasia.psychosophy.domain.relationships;

import android.content.Context;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

public class RelationshipsCalculator {
    public static PsychotypeRelationships calcRelationships(Psychotype fistType, Psychotype secondType, Context context){
        String fistFunctionRelation = getFunctionRelationship(fistType.getFunctions()[0], 0, secondType, context);
        String secondFunctionRelation = getFunctionRelationship(fistType.getFunctions()[1], 1, secondType, context);
        String thirdFunctionRelation = getFunctionRelationship(fistType.getFunctions()[2], 2, secondType, context);
        String forthFunctionRelation = getFunctionRelationship(fistType.getFunctions()[3], 3, secondType, context);

        return new PsychotypeRelationships(fistFunctionRelation, secondFunctionRelation, thirdFunctionRelation, forthFunctionRelation);
    }

    private static String getFunctionRelationship(Function firstFunction, int fistFunctionPosition, Psychotype secondType, Context context){
        // Position of firstFunction for secondType
        int secondPosition = getFunctionPosition(firstFunction, secondType);
        switch (firstFunction) {
            case Will: return getWillDescription(fistFunctionPosition, secondPosition, context);
            case Emotion: return getEmotionDescription(fistFunctionPosition, secondPosition, context);
            case Logic: return getLogicDescription(fistFunctionPosition, secondPosition, context);
            case Physics: return getPhysicsDescription(fistFunctionPosition, secondPosition, context);
        }

        throw new AssertionError();
    }

    private static int getFunctionPosition(Function firstFunction, Psychotype secondType){
        int position = 0;
        for (Function function : secondType.getFunctions()) {
            if (function == firstFunction) break;
            position++;
        }
        return position;
    }

    private static String getWillDescription(int firstPosition, int secondPosition, Context context) {
        if (firstPosition < 0 || firstPosition > 3 || secondPosition < 0 || secondPosition > 3)
            throw new IllegalArgumentException("Positions must be between 0 and 3");

        if (firstPosition == 0 && secondPosition == 0) return context.getString(R.string.philia_1_will);
        if (firstPosition == 0 && secondPosition == 1) return context.getString(R.string.pseudo_philia_1_2_will);
        if (firstPosition == 0 && secondPosition == 2) return context.getString(R.string.eros_1_3_will);
        if (firstPosition == 0 && secondPosition == 3) return context.getString(R.string.agape_1_4_will);

        if (firstPosition == 1 && secondPosition == 0) return context.getString(R.string.pseudo_philia_2_1_will);
        if (firstPosition == 1 && secondPosition == 1) return context.getString(R.string.philia_2_will);
        if (firstPosition == 1 && secondPosition == 2) return context.getString(R.string.agape_2_3_will);
        if (firstPosition == 1 && secondPosition == 3) return context.getString(R.string.eros_2_4_will);

        if (firstPosition == 2 && secondPosition == 0) return context.getString(R.string.eros_3_1_will);
        if (firstPosition == 2 && secondPosition == 1) return context.getString(R.string.agape_3_2_will);
        if (firstPosition == 2 && secondPosition == 2) return context.getString(R.string.philia_3_will);
        if (firstPosition == 2 && secondPosition == 3) return context.getString(R.string.pseudo_philia_3_4_will);

        if (firstPosition == 3 && secondPosition == 0) return context.getString(R.string.agape_4_1_will);
        if (firstPosition == 3 && secondPosition == 1) return context.getString(R.string.eros_4_2_will);
        if (firstPosition == 3 && secondPosition == 2) return context.getString(R.string.pseudo_philia_4_3_will);
        if (firstPosition == 3 && secondPosition == 3) return context.getString(R.string.philia_4_will);

        throw new AssertionError();
    }

    private static String getEmotionDescription(int firstPosition, int secondPosition, Context context) {
        if (firstPosition < 0 || firstPosition > 3 || secondPosition < 0 || secondPosition > 3)
            throw new IllegalArgumentException("Positions must be between 0 and 3");

        if (firstPosition == 0 && secondPosition == 0) return context.getString(R.string.philia_1_emotion);
        if (firstPosition == 0 && secondPosition == 1) return context.getString(R.string.pseudo_philia_1_2_emotion);
        if (firstPosition == 0 && secondPosition == 2) return context.getString(R.string.eros_1_3_emotion);
        if (firstPosition == 0 && secondPosition == 3) return context.getString(R.string.agape_1_4_emotion);

        if (firstPosition == 1 && secondPosition == 0) return context.getString(R.string.pseudo_philia_2_1_emotion);
        if (firstPosition == 1 && secondPosition == 1) return context.getString(R.string.philia_2_emotion);
        if (firstPosition == 1 && secondPosition == 2) return context.getString(R.string.agape_2_3_emotion);
        if (firstPosition == 1 && secondPosition == 3) return context.getString(R.string.eros_2_4_emotion);

        if (firstPosition == 2 && secondPosition == 0) return context.getString(R.string.eros_3_1_emotion);
        if (firstPosition == 2 && secondPosition == 1) return context.getString(R.string.agape_3_2_emotion);
        if (firstPosition == 2 && secondPosition == 2) return context.getString(R.string.philia_3_emotion);
        if (firstPosition == 2 && secondPosition == 3) return context.getString(R.string.pseudo_philia_3_4_emotion);

        if (firstPosition == 3 && secondPosition == 0) return context.getString(R.string.agape_4_1_emotion);
        if (firstPosition == 3 && secondPosition == 1) return context.getString(R.string.eros_4_2_emotion);
        if (firstPosition == 3 && secondPosition == 2) return context.getString(R.string.pseudo_philia_4_3_emotion);
        if (firstPosition == 3 && secondPosition == 3) return context.getString(R.string.philia_4_emotion);

        throw new AssertionError();
    }

    private static String getLogicDescription(int firstPosition, int secondPosition, Context context) {
        if (firstPosition < 0 || firstPosition > 3 || secondPosition < 0 || secondPosition > 3)
            throw new IllegalArgumentException("Positions must be between 0 and 3");

        if (firstPosition == 0 && secondPosition == 0) return context.getString(R.string.philia_1_logic);
        if (firstPosition == 0 && secondPosition == 1) return context.getString(R.string.pseudo_philia_1_2_logic);
        if (firstPosition == 0 && secondPosition == 2) return context.getString(R.string.eros_1_3_logic);
        if (firstPosition == 0 && secondPosition == 3) return context.getString(R.string.agape_1_4_logic);

        if (firstPosition == 1 && secondPosition == 0) return context.getString(R.string.pseudo_philia_2_1_logic);
        if (firstPosition == 1 && secondPosition == 1) return context.getString(R.string.philia_2_logic);
        if (firstPosition == 1 && secondPosition == 2) return context.getString(R.string.agape_2_3_logic);
        if (firstPosition == 1 && secondPosition == 3) return context.getString(R.string.eros_2_4_logic);

        if (firstPosition == 2 && secondPosition == 0) return context.getString(R.string.eros_3_1_logic);
        if (firstPosition == 2 && secondPosition == 1) return context.getString(R.string.agape_3_2_logic);
        if (firstPosition == 2 && secondPosition == 2) return context.getString(R.string.philia_3_logic);
        if (firstPosition == 2 && secondPosition == 3) return context.getString(R.string.pseudo_philia_3_4_logic);

        if (firstPosition == 3 && secondPosition == 0) return context.getString(R.string.agape_4_1_logic);
        if (firstPosition == 3 && secondPosition == 1) return context.getString(R.string.eros_4_2_logic);
        if (firstPosition == 3 && secondPosition == 2) return context.getString(R.string.pseudo_philia_4_3_logic);
        if (firstPosition == 3 && secondPosition == 3) return context.getString(R.string.philia_4_logic);

        throw new AssertionError();
    }

    private static String getPhysicsDescription(int firstPosition, int secondPosition, Context context) {
        if (firstPosition < 0 || firstPosition > 3 || secondPosition < 0 || secondPosition > 3)
            throw new IllegalArgumentException("Positions must be between 0 and 3");

        if (firstPosition == 0 && secondPosition == 0) return context.getString(R.string.philia_1_physics);
        if (firstPosition == 0 && secondPosition == 1) return context.getString(R.string.pseudo_philia_1_2_physics);
        if (firstPosition == 0 && secondPosition == 2) return context.getString(R.string.eros_1_3_physics);
        if (firstPosition == 0 && secondPosition == 3) return context.getString(R.string.agape_1_4_physics);

        if (firstPosition == 1 && secondPosition == 0) return context.getString(R.string.pseudo_philia_2_1_physics);
        if (firstPosition == 1 && secondPosition == 1) return context.getString(R.string.philia_2_physics);
        if (firstPosition == 1 && secondPosition == 2) return context.getString(R.string.agape_2_3_physics);
        if (firstPosition == 1 && secondPosition == 3) return context.getString(R.string.eros_2_4_physics);

        if (firstPosition == 2 && secondPosition == 0) return context.getString(R.string.eros_3_1_physics);
        if (firstPosition == 2 && secondPosition == 1) return context.getString(R.string.agape_3_2_physics);
        if (firstPosition == 2 && secondPosition == 2) return context.getString(R.string.philia_3_physics);
        if (firstPosition == 2 && secondPosition == 3) return context.getString(R.string.pseudo_philia_3_4_physics);

        if (firstPosition == 3 && secondPosition == 0) return context.getString(R.string.agape_4_1_physics);
        if (firstPosition == 3 && secondPosition == 1) return context.getString(R.string.eros_4_2_physics);
        if (firstPosition == 3 && secondPosition == 2) return context.getString(R.string.pseudo_philia_4_3_physics);
        if (firstPosition == 3 && secondPosition == 3) return context.getString(R.string.philia_4_physics);

        throw new AssertionError();
    }
}
