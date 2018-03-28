package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.test.Function;

public class FirstFunctionFragment extends FunctionsDescriptionFragment {

    private static final String FUNCTION_NUMBER_PREFIX = "1 ";


    @Override
    public Drawable getImage() {
        return getResources().getDrawable(R.drawable.ic_hammer);
    }

    @Override
    public Drawable getImage(Function function) {
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
    public String getEmotionTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(Function.Emotion, getActivity());
    }

    @Override
    public Spanned getFullDescription(Function function) {
        switch (function) {
            case Emotion: return Html.fromHtml(getResources().getString(R.string.first_emotion_description));
            case Logic: return Html.fromHtml(getResources().getString(R.string.first_logic_description));
            case Physics: return Html.fromHtml(getResources().getString(R.string.first_physics_description));
            case Will: return Html.fromHtml(getResources().getString(R.string.first_will_description));
            default: throw new AssertionError();
        }
    }

    @Override
    public String getLogicTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(Function.Logic, getActivity());
    }

    @Override
    public String getPhysicsTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(Function.Physics, getActivity());
    }

    @Override
    public String getWillTitle() {
        return FunctionTitleGetter.getFirstFunctionTitle(Function.Will, getActivity());
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
