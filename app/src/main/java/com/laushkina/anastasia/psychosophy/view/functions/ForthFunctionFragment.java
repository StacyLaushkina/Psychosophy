package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;
import android.text.Html;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

public class ForthFunctionFragment extends FunctionsDescriptionFragment {

    private static final String FUNCTION_NUMBER_PREFIX = "4 ";

    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_empty_flag);
    }

    @Override
    public Drawable getImage(Function function) {
        switch (function) {
            case Emotion: return getResources().getDrawable(R.drawable.ic_empty_flag_emotion);
            case Logic: return getResources().getDrawable(R.drawable.ic_empty_flag_logic);
            case Physics: return getResources().getDrawable(R.drawable.ic_empty_flag_physics);
            case Will: return getResources().getDrawable(R.drawable.ic_empty_flag_will);
            default: throw new AssertionError();
        }
    }

    @Override
    public CharSequence getFunctionDescription() {
        return Html.fromHtml(getString(R.string.forth_function_description));
    }

    @Override
    public String getEmotionTitle() {
        return FunctionTitleGetter.getForthFunctionTitle(Function.Emotion, getActivity());
    }

    @Override
    public CharSequence getFullDescription(Function function) {
        switch (function) {
            case Emotion: return Html.fromHtml(getResources().getString(R.string.forth_emotion_description));
            case Logic: return Html.fromHtml(getResources().getString(R.string.forth_logic_description));
            case Physics: return Html.fromHtml(getResources().getString(R.string.forth_physics_description));
            case Will: return Html.fromHtml(getResources().getString(R.string.forth_will_description));
            default: throw new AssertionError();
        }
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getForthFunctionTitle(Function.Logic, getActivity());
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getForthFunctionTitle(Function.Physics, getActivity());
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getForthFunctionTitle(Function.Will, getActivity());
    }

    @Override
    public String getFunctionPrefix() {
        return FUNCTION_NUMBER_PREFIX;
    }
}
