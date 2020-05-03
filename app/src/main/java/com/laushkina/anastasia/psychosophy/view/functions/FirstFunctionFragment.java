package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction;

public class FirstFunctionFragment extends FunctionsDescriptionFragment {

    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_hammer);
    }

    @Override
    public Drawable getImage(PsychoFunction function) {
        switch (function) {
            case Emotion: return getResources().getDrawable(R.drawable.ic_hammer_emotion);
            case Logic: return getResources().getDrawable(R.drawable.ic_hammer_logic);
            case Physics: return getResources().getDrawable(R.drawable.ic_hammer_physics);
            case Will: return getResources().getDrawable(R.drawable.ic_hammer_will);
            default: throw new AssertionError();
        }
    }

    @Override
    public CharSequence getFunctionDescription() {
        return Html.fromHtml(getString(R.string.first_function_description));
    }


    @Override
    public Spanned getFullDescription(PsychoFunction function) {
        switch (function) {
            case Emotion: return Html.fromHtml(getResources().getString(R.string.first_emotion_description));
            case Logic: return Html.fromHtml(getResources().getString(R.string.first_logic_description));
            case Physics: return Html.fromHtml(getResources().getString(R.string.first_physics_description));
            case Will: return Html.fromHtml(getResources().getString(R.string.first_will_description));
            default: throw new AssertionError();
        }
    }

    @Override
    public String getEmotionTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(PsychoFunction.Emotion, getResources());
    }
    @Override
    public String getEmotionShortTitle() {
        return FunctionTitleGetter.getFirstFunctionShortTitle(PsychoFunction.Emotion, getResources());
    }

    @Override
    public String getLogicShortTitle() {
        return FunctionTitleGetter.getFirstFunctionShortTitle(PsychoFunction.Logic, getResources());
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(PsychoFunction.Logic, getResources());
    }

    @Override
    public String getPhysicsShortTitle() {
        return FunctionTitleGetter.getFirstFunctionShortTitle(PsychoFunction.Physics, getResources());
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(PsychoFunction.Physics, getResources());
    }

    @Override
    public String getWillShortTitle() {
        return FunctionTitleGetter.getFirstFunctionShortTitle(PsychoFunction.Will, getResources());
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(PsychoFunction.Will, getResources());
    }

}
