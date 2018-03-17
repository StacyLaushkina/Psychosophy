package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

public class FirstFunctionFragment extends FunctionsOrderFragment {

    private static final String FUNCTION_NUMBER_PREFIX = "1 ";


    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_hammer);
    }

    @Override
    public String getFunctionDescription() {
        return getString(R.string.first_function_description);
    }

    @Override
    public String getEmotionTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(Function.Emotion, getActivity());
    }

    @Override
    public String getEmotionFullDescription() {
        return getResources().getString(R.string.first_emotion_description);
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(Function.Logic, getActivity());
    }

    @Override
    public String getLogicFullDescription() {
        return getResources().getString(R.string.first_logic_description);
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(Function.Physics, getActivity());
    }

    @Override
    public String getPhysicsFullDescription() {
        return getResources().getString(R.string.first_physics_description);
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(Function.Will, getActivity());
    }

    @Override
    public String getWillFullDescription() {
        return getResources().getString(R.string.first_will_description);
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
