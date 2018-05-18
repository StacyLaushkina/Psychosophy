package com.laushkina.anastasia.psychosophy.domain.test;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PsychotypeCalculator {

    private static class Pair {
        private Function function;
        private int amount;

        Pair(Function function, int amount) {
            this.amount = amount;
            this.function = function;
        }
    }

    public static List<Psychotype> calculate(TestQuestion[] questions){
        List<Pair> pairs = new ArrayList<>();

        int[] sums = new int[4];
        for (TestQuestion question : questions){
            Function function = question.getType();
            sums[function.getNumber()] += question.getAnswer().getNumber();
        }

        pairs.add(new Pair(Function.Logic, sums[Function.Logic.getNumber()]));
        pairs.add(new Pair(Function.Emotion, sums[Function.Emotion.getNumber()]));
        pairs.add(new Pair(Function.Physics, sums[Function.Physics.getNumber()]));
        pairs.add(new Pair(Function.Will, sums[Function.Will.getNumber()]));

        Collections.sort(pairs, (p1, p2) -> p2.amount - p1.amount);

       return areResultsUnreliable(pairs) ? null
                                          : !isExceptionCase(pairs) ? resolveSingleType(pairs)
                                                                  : resolveMultipleTypes(pairs);
    }

    private static List<Psychotype> resolveSingleType(List<Pair> pairs){
        return new ArrayList<Psychotype>() {{
            add((Psychotype.resolve(injectFunctions(pairs))));
        }};
    }

    private static List<Psychotype> resolveMultipleTypes(List<Pair> pairs){
        List<Function[]> typeVariants = new ArrayList<>();

        Function[] functionsOrder = injectFunctions(pairs);
        typeVariants.add(functionsOrder);

        Function tmp;
        for (int i = 0; i < 3; i++) {
            if (pairs.get(i).amount == pairs.get(i+1).amount) {
                Function[] assumption = Arrays.copyOf(functionsOrder, 4);
                tmp = assumption[i];
                assumption[i] = assumption[i+1];
                assumption[i+1] = tmp;
                typeVariants.add(assumption);
                for (int j = i + 1; j < 3; j++) {
                    if (pairs.get(j).amount == pairs.get(j+1).amount) {
                        Function[] assumptio2n = Arrays.copyOf(assumption, 4);
                        tmp = assumptio2n[j];
                        assumptio2n[j] = assumptio2n[j+1];
                        assumptio2n[j+1] = tmp;
                        typeVariants.add(assumptio2n);
                    }
                }
            }
        }

        List<Psychotype> result = new ArrayList<>();
        for (Function[] assuption : typeVariants) {
            result.add(Psychotype.resolve(assuption));
        }

        return result;
    }

    private static boolean isExceptionCase(List<Pair> pairs){
        return pairs.get(0).amount == pairs.get(1).amount ||
               pairs.get(1).amount == pairs.get(2).amount ||
               pairs.get(2).amount == pairs.get(3).amount;
    }

    // If user has more then two functions with same answer, results are not reliable
    private static boolean areResultsUnreliable(List<Pair> pairs){
        return pairs.get(0).amount == pairs.get(1).amount &&
                pairs.get(1).amount == pairs.get(2).amount &&
                pairs.get(2).amount == pairs.get(3).amount;
    }

    private static Function[] injectFunctions(List<Pair> pairs){
        Function[] result = new Function[4];
        result[0] = pairs.get(0).function;
        result[1] = pairs.get(1).function;
        result[2] = pairs.get(2).function;
        result[3] = pairs.get(3).function;
        return result;
    }

}
