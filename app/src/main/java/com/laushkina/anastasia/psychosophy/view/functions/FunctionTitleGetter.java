package com.laushkina.anastasia.psychosophy.view.functions;

import android.content.Context;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

final public class FunctionTitleGetter {

    public static String getFirstFunctionTitle(Function[] functionsArray, Context context){
        if (functionsArray == null || functionsArray.length != 4 || context == null) throw new RuntimeException("Cannot get title of first functions");

        return getFirstFunctionTitle(functionsArray[0], context);
    }

    public static String getSecondFunctionTitle(Function[] functionsArray, Context context){
        if (functionsArray == null || functionsArray.length != 4 || context == null) throw new RuntimeException("Cannot get title of second functions");

        return getSecondFunctionTitle(functionsArray[1], context);
    }

    public static String getThirdFunctionTitle(Function[] functionsArray, Context context){
        if (functionsArray == null || functionsArray.length != 4 || context == null) throw new RuntimeException("Cannot get title of third functions");

        return getThirdFunctionTitle(functionsArray[2], context);
    }

    public static String getForthFunctionTitle(Function[] functionsArray, Context context){
        if (functionsArray == null || functionsArray.length != 4 || context == null) throw new RuntimeException("Cannot get title of forth functions");

        return getForthFunctionTitle(functionsArray[3], context);
    }

    private static String getFirstFunctionTitle(Function firstFunction, Context context) {
        switch (firstFunction){
            case Logic:
                return context.getResources().getString(R.string.first_logic_name);
            case Emotion:
                return context.getResources().getString(R.string.first_emotion_name);
            case Physics:
                return context.getResources().getString(R.string.first_physics_name);
            case Will:
                return context.getResources().getString(R.string.first_will_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    private static String getSecondFunctionTitle(Function secondFunction, Context context) {
        switch (secondFunction){
            case Logic:
                return context.getResources().getString(R.string.second_logic_name);
            case Emotion:
                return context.getResources().getString(R.string.second_emotion_name);
            case Physics:
                return context.getResources().getString(R.string.second_physics_name);
            case Will:
                return context.getResources().getString(R.string.second_will_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    private static String getThirdFunctionTitle(Function thirdFunction, Context context) {
        switch (thirdFunction){
            case Logic:
                return context.getResources().getString(R.string.third_logic_name);
            case Emotion:
                return context.getResources().getString(R.string.third_emotion_name);
            case Physics:
                return context.getResources().getString(R.string.third_physics_name);
            case Will:
                return context.getResources().getString(R.string.third_will_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    private static String getForthFunctionTitle(Function forthFunction, Context context) {
        switch (forthFunction){
            case Logic:
                return context.getResources().getString(R.string.forth_logic_name);
            case Emotion:
                return context.getResources().getString(R.string.forth_emotion_name);
            case Physics:
                return context.getResources().getString(R.string.forth_physics_name);
            case Will:
                return context.getResources().getString(R.string.forth_will_name);
        }
        throw new RuntimeException("Couldn't find function");
    }
}
