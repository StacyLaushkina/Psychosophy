package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

public class SecondFunctionFragment extends FunctionsOrderFragment {

    private static final String FUNCTION_NUMBER_PREFIX = "2 ";

    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_sea_waves);
    }

    @Override
    public String getFunctionDescription() {
        return getString(R.string.second_function_description);
    }

    @Override
    public String getEmotionTitle() {
        return FunctionTitleGetter.getSecondFunctionTitle(Function.Emotion, getActivity());
    }

    @Override
    public String getEmotionFullDescription() {
        return getResources().getString(R.string.second_emotion_description);
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getSecondFunctionTitle(Function.Logic, getActivity());
    }

    @Override
    public String getLogicFullDescription() {
        return getResources().getString(R.string.second_logic_description);
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getSecondFunctionTitle(Function.Physics, getActivity());
    }

    @Override
    public String getPhysicsFullDescription() {
        return getResources().getString(R.string.second_physics_description);
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getSecondFunctionTitle(Function.Will, getActivity());
    }

    @Override
    public String getWillFullDescription() {
        return getResources().getString(R.string.second_will_description);
    }

    @Override
    public String getFunctionPrefix() {
        return FUNCTION_NUMBER_PREFIX;
    }

    @Override
    FunctionsOrderFragment getFragment() {
        return this;
    }
}
