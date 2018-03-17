package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

public class ThirdFunctionFragment extends FunctionsOrderFragment {

    private static final String FUNCTION_NUMBER_PREFIX = "3 ";

    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_engine);
    }

    @Override
    public String getFunctionDescription() {
        return getString(R.string.third_function_description);
    }

    @Override
    public String getEmotionTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(Function.Emotion, getActivity());
    }

    @Override
    public String getEmotionFullDescription() {
        return getResources().getString(R.string.third_emotion_description);
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(Function.Logic, getActivity());
    }

    @Override
    public String getLogicFullDescription() {
        return getResources().getString(R.string.third_logic_description);
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(Function.Physics, getActivity());
    }

    @Override
    public String getPhysicsFullDescription() {
        return getResources().getString(R.string.third_physics_description);
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(Function.Will, getActivity());
    }

    @Override
    public String getWillFullDescription() {
        return getResources().getString(R.string.third_will_description);
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
