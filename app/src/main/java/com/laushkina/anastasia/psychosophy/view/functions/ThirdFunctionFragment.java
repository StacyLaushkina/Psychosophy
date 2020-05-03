package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;
import android.text.Html;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction;

public class ThirdFunctionFragment extends FunctionsDescriptionFragment {

    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_engine);
    }

    @Override
    public Drawable getImage(PsychoFunction function) {
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
        return FunctionTitleGetter.getThirdFunctionTitle(PsychoFunction.Emotion, getResources());
    }

    @Override
    public String getEmotionShortTitle() {
        return FunctionTitleGetter.getThirdFunctionShortTitle(PsychoFunction.Emotion, getResources());
    }

    @Override
    public CharSequence getFullDescription(PsychoFunction function) {
        switch (function) {
            case Emotion: return Html.fromHtml(getResources().getString(R.string.third_emotion_description));
            case Logic: return Html.fromHtml(getResources().getString(R.string.third_logic_description));
            case Physics: return Html.fromHtml(getResources().getString(R.string.third_physics_description));
            case Will: return Html.fromHtml(getResources().getString(R.string.third_will_description));
            default: throw new AssertionError();
        }
    }

    @Override
    public String getLogicShortTitle() {
        return FunctionTitleGetter.getThirdFunctionShortTitle(PsychoFunction.Logic, getResources());
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(PsychoFunction.Logic, getResources());
    }

    @Override
    public String getPhysicsShortTitle() {
        return FunctionTitleGetter.getThirdFunctionShortTitle(PsychoFunction.Physics, getResources());
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(PsychoFunction.Physics, getResources());
    }

    @Override
    public String getWillShortTitle() {
        return FunctionTitleGetter.getThirdFunctionShortTitle(PsychoFunction.Will, getResources());
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getThirdFunctionTitle(PsychoFunction.Will, getResources());
    }

}
