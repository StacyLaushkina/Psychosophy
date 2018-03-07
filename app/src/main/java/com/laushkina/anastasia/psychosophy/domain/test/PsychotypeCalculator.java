package com.laushkina.anastasia.psychosophy.domain.test;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PsychotypeCalculator {

    public static Psychotype calculate(List<Question> questions){
        Map<Function, Integer> map = new HashMap<>(4);
        map.put(Function.Logic, 0);
        map.put(Function.Emotion, 0);
        map.put(Function.Physics, 0);
        map.put(Function.Will, 0);

        for (Question question : questions){
            Function function = question.getType();
            map.put(function, map.get(function) + getNumberForAnswer(question.getAnswer()));
        }

        return Psychotype.resolve(orderFunctions(map));
    }

    private static int getNumberForAnswer(QuestionAnswer answer){
        switch (answer){
            case Yes: return 4;
            case Maybe: return 3;
            case Sometimes: return 2;
            case No: return 1;
            default: return 0;
        }
    }

    //TODO redo
    private static Function[] orderFunctions(Map<Function, Integer> map){
        Function[] result = new Function[4];
        int max = -1;
        for (Map.Entry<Function, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result[0] = entry.getKey();
            }
        }
        int secondMax = -1;
        for (Map.Entry<Function, Integer> entry : map.entrySet()) {
            if (entry.getValue() > secondMax && entry.getValue() < max) {
                secondMax = entry.getValue();
                result[1] = entry.getKey();
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Function, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                result[3] = entry.getKey();
            }
        }
        int secondMin = Integer.MAX_VALUE;
        for (Map.Entry<Function, Integer> entry : map.entrySet()) {
            if (entry.getValue() < secondMin && entry.getValue() > min) {
                secondMin = entry.getValue();
                result[2] = entry.getKey();
            }
        }

        return result;
    }

}
