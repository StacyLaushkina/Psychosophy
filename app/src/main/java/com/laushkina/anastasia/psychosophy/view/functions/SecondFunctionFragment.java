package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;
import android.text.Html;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction;

public class SecondFunctionFragment extends FunctionsDescriptionFragment {

    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_sea_waves);
    }

    @Override
    public Drawable getImage(PsychoFunction function) {
        switch (function) {
            case Emotion: return getResources().getDrawable(R.drawable.ic_sea_waves_emotion);
            case Logic: return getResources().getDrawable(R.drawable.ic_sea_waves_logic);
            case Physics: return getResources().getDrawable(R.drawable.ic_sea_waves_physics);
            case Will: return getResources().getDrawable(R.drawable.ic_sea_waves_will);
            default: throw new AssertionError();
        }
    }

    @Override
    public CharSequence getFunctionDescription() {
        return Html.fromHtml(getString(R.string.second_function_description));
    }

    @Override
    public String getEmotionTitle() {
        return FunctionTitleGetter.getSecondFunctionTitle(PsychoFunction.Emotion, getResources());
    }

    @Override
    public String getLogicShortTitle() {
        return FunctionTitleGetter.getSecondFunctionShortTitle(PsychoFunction.Logic, getResources());
    }

    @Override
    public CharSequence getFullDescription(PsychoFunction function) {
        switch (function) {
            case Emotion: return Html.fromHtml(getResources().getString(R.string.second_emotion_description));
            case Logic: return Html.fromHtml(getResources().getString(R.string.second_logic_description));
            case Physics: return Html.fromHtml(getResources().getString(R.string.second_physics_description));
            case Will: return Html.fromHtml(getResources().getString(R.string.second_will_description));
            default: throw new AssertionError();
        }
    }

    @Override
    public String getEmotionShortTitle() {
        return FunctionTitleGetter.getSecondFunctionShortTitle(PsychoFunction.Emotion, getResources());
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getSecondFunctionTitle(PsychoFunction.Logic, getResources());
    }

    @Override
    public String getPhysicsShortTitle() {
        return FunctionTitleGetter.getSecondFunctionShortTitle(PsychoFunction.Physics, getResources());
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getSecondFunctionTitle(PsychoFunction.Physics, getResources());
    }

    @Override
    public String getWillShortTitle() {
        return FunctionTitleGetter.getSecondFunctionShortTitle(PsychoFunction.Will, getResources());
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getSecondFunctionTitle(PsychoFunction.Will, getResources());
    }

}
