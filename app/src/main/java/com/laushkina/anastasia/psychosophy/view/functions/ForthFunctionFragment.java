package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

public class ForthFunctionFragment extends FunctionsOrderFragment {

    private static final String FUNCTION_NUMBER_PREFIX = "4 ";

    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_empty_flag);
    }

    @Override
    public String getFunctionDescription() {
        return getString(R.string.forth_function_description);
    }

    @Override
    public String getEmotionTitle() {
        return FunctionTitleGetter.getForthFunctionTitle(Function.Emotion, getActivity());
    }

    @Override
    public String getEmotionFullDescription() {
        return getResources().getString(R.string.forth_emotion_description);
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getForthFunctionTitle(Function.Logic, getActivity());
    }

    @Override
    public String getLogicFullDescription() {
        return getResources().getString(R.string.forth_logic_description);
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getForthFunctionTitle(Function.Physics, getActivity());
    }

    @Override
    public String getPhysicsFullDescription() {
        return getResources().getString(R.string.forth_physics_description);
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getForthFunctionTitle(Function.Will, getActivity());
    }

    @Override
    public String getWillFullDescription() {
        return getResources().getString(R.string.forth_will_description);
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
