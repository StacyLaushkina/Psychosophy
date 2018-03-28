package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;
import android.text.Html;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

public class ThirdFunctionFragment extends FunctionsDescriptionFragment {

    private static final String FUNCTION_NUMBER_PREFIX = "3 ";

    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_engine);
    }

    @Override
    public Drawable getImage(Function function) {
        switch (function) {
            case Emotion: return getResources().getDrawable(R.drawable.ic_engine_emotion);
            case Logic: return getResources().getDrawable(R.drawable.ic_engine_logic);
            case Physics: return getResources().getDrawable(R.drawable.ic_engine_physics);
            case Will: return getResources().getDrawable(R.drawable.ic_engine_will);
            default: throw new AssertionError();
        }
    }

    @Override
    public CharSequence getFunctionDescription() {
        return Html.fromHtml(getString(R.string.third_function_description));
    }

    @Override
    public String getEmotionTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(Function.Emotion, getActivity());
    }

    @Override
    public CharSequence getFullDescription(Function function) {
        switch (function) {
            case Emotion: return Html.fromHtml(getResources().getString(R.string.third_emotion_description));
            case Logic: return Html.fromHtml(getResources().getString(R.string.third_logic_description));
            case Physics: return Html.fromHtml(getResources().getString(R.string.third_physics_description));
            case Will: return Html.fromHtml(getResources().getString(R.string.third_will_description));
            default: throw new AssertionError();
        }
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(Function.Logic, getActivity());
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(Function.Physics, getActivity());
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(Function.Will, getActivity());
    }

    @Override
    public String getFunctionPrefix() {
        return FUNCTION_NUMBER_PREFIX;
    }

    @Override
    FunctionsDescriptionFragment getFragment() {
        return this;
    }
}
