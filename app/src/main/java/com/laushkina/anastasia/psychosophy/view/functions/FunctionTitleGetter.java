package com.laushkina.anastasia.psychosophy.view.functions;

import android.content.res.Resources;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

final public class FunctionTitleGetter {

    public static String getFirstFunctionTitle(Function[] functionsArray, Resources resources){
        if (functionsArray == null || functionsArray.length != 4 || resources == null) throw new RuntimeException("Cannot get title of first functions");

        return getFirstFunctionTitle(functionsArray[0], resources);
    }

    public static String getFirstFunctionShortTitle(Function[] functionsArray, Resources resources){
        if (functionsArray == null || functionsArray.length != 4 || resources == null) throw new RuntimeException("Cannot get title of first functions");

        return getFirstFunctionShortTitle(functionsArray[0], resources);
    }

    public static String getSecondFunctionTitle(Function[] functionsArray, Resources resources){
        if (functionsArray == null || functionsArray.length != 4 || resources == null) throw new RuntimeException("Cannot get title of second functions");

        return getSecondFunctionTitle(functionsArray[1], resources);
    }

    public static String getSecondFunctionShortTitle(Function[] functionsArray, Resources resources){
        if (functionsArray == null || functionsArray.length != 4 || resources == null) throw new RuntimeException("Cannot get title of second functions");

        return getSecondFunctionShortTitle(functionsArray[1], resources);
    }

    public static String getThirdFunctionTitle(Function[] functionsArray, Resources resources){
        if (functionsArray == null || functionsArray.length != 4 || resources == null) throw new RuntimeException("Cannot get title of third functions");

        return getThirdFunctionTitle(functionsArray[2], resources);
    }

    public static String getThirdFunctionShortTitle(Function[] functionsArray, Resources resources){
        if (functionsArray == null || functionsArray.length != 4 || resources == null) throw new RuntimeException("Cannot get title of third functions");

        return getThirdFunctionShortTitle(functionsArray[2], resources);
    }

    public static String getForthFunctionTitle(Function[] functionsArray, Resources resources){
        if (functionsArray == null || functionsArray.length != 4 || resources == null) throw new RuntimeException("Cannot get title of forth functions");

        return getForthFunctionTitle(functionsArray[3], resources);
    }

    public static String getForthFunctionShortTitle(Function[] functionsArray, Resources resources){
        if (functionsArray == null || functionsArray.length != 4 || resources == null) throw new RuntimeException("Cannot get title of forth functions");

        return getForthFunctionShortTitle(functionsArray[3], resources);
    }

    static String getFirstFunctionTitle(Function firstFunction, Resources resources) {
        switch (firstFunction){
            case Logic:
                return resources.getString(R.string.first_logic_name);
            case Emotion:
                return resources.getString(R.string.first_emotion_name);
            case Physics:
                return resources.getString(R.string.first_physics_name);
            case Will:
                return resources.getString(R.string.first_will_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    static String getFirstFunctionShortTitle(Function firstFunction, Resources resources) {
        switch (firstFunction){
            case Logic:
                return resources.getString(R.string.first_logic_short_name);
            case Emotion:
                return resources.getString(R.string.first_emotion_short_name);
            case Physics:
                return resources.getString(R.string.first_physics_short_name);
            case Will:
                return resources.getString(R.string.first_will_short_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    static String getSecondFunctionTitle(Function secondFunction, Resources resources) {
        switch (secondFunction){
            case Logic:
                return resources.getString(R.string.second_logic_name);
            case Emotion:
                return resources.getString(R.string.second_emotion_name);
            case Physics:
                return resources.getString(R.string.second_physics_name);
            case Will:
                return resources.getString(R.string.second_will_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    static String getSecondFunctionShortTitle(Function secondFunction, Resources resources) {
        switch (secondFunction){
            case Logic:
                return resources.getString(R.string.second_logic_short_name);
            case Emotion:
                return resources.getString(R.string.second_emotion_short_name);
            case Physics:
                return resources.getString(R.string.second_physics_short_name);
            case Will:
                return resources.getString(R.string.second_will_short_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    static String getThirdFunctionTitle(Function thirdFunction, Resources resources) {
        switch (thirdFunction){
            case Logic:
                return resources.getString(R.string.third_logic_name);
            case Emotion:
                return resources.getString(R.string.third_emotion_name);
            case Physics:
                return resources.getString(R.string.third_physics_name);
            case Will:
                return resources.getString(R.string.third_will_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    static String getThirdFunctionShortTitle(Function thirdFunction, Resources resources) {
        switch (thirdFunction){
            case Logic:
                return resources.getString(R.string.third_logic_short_name);
            case Emotion:
                return resources.getString(R.string.third_emotion_short_name);
            case Physics:
                return resources.getString(R.string.third_physics_short_name);
            case Will:
                return resources.getString(R.string.third_will_short_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    static String getForthFunctionTitle(Function forthFunction, Resources resources) {
        switch (forthFunction){
            case Logic:
                return resources.getString(R.string.forth_logic_name);
            case Emotion:
                return resources.getString(R.string.forth_emotion_name);
            case Physics:
                return resources.getString(R.string.forth_physics_name);
            case Will:
                return resources.getString(R.string.forth_will_name);
        }
        throw new RuntimeException("Couldn't find function");
    }

    static String getForthFunctionShortTitle(Function forthFunction, Resources resources) {
        switch (forthFunction){
            case Logic:
                return resources.getString(R.string.forth_logic_short_name);
            case Emotion:
                return resources.getString(R.string.forth_emotion_short_name);
            case Physics:
                return resources.getString(R.string.forth_physics_short_name);
            case Will:
                return resources.getString(R.string.forth_will_short_name);
        }
        throw new RuntimeException("Couldn't find function");
    }
}
