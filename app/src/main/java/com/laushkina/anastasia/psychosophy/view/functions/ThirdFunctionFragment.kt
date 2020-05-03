package com.laushkina.anastasia.psychosophy.view.functions

import android.graphics.drawable.Drawable
import android.text.Html
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction

class ThirdFunctionFragment: FunctionsDescriptionFragment() {
    override fun getImage(): Drawable {
        return resources.getDrawable(R.drawable.ic_engine)
    }

    override fun getImage(function: PsychoFunction): Drawable {
        return when (function) {
            PsychoFunction.Emotion -> resources.getDrawable(R.drawable.ic_engine_emotion)
            PsychoFunction.Logic -> resources.getDrawable(R.drawable.ic_engine_logic)
            PsychoFunction.Physics -> resources.getDrawable(R.drawable.ic_engine_physics)
            PsychoFunction.Will -> resources.getDrawable(R.drawable.ic_engine_will)
        }
    }

    override fun getFunctionDescription(): CharSequence {
        return Html.fromHtml(getString(R.string.third_function_description))
    }

    override fun getFullDescription(function: PsychoFunction): CharSequence {
        return when (function) {
            PsychoFunction.Emotion -> Html.fromHtml(resources.getString(R.string.third_emotion_description))
            PsychoFunction.Logic -> Html.fromHtml(resources.getString(R.string.third_logic_description))
            PsychoFunction.Physics -> Html.fromHtml(resources.getString(R.string.third_physics_description))
            PsychoFunction.Will -> Html.fromHtml(resources.getString(R.string.third_will_description))
        }
    }

    override fun getEmotionShortTitle(): String {
        return FunctionTitleGetter.getThirdFunctionShortTitle(PsychoFunction.Emotion, resources)
    }

    override fun getEmotionTitle(): String {
        return FunctionTitleGetter.getThirdFunctionTitle(PsychoFunction.Emotion, resources)
    }

    override fun getLogicShortTitle(): String {
        return FunctionTitleGetter.getThirdFunctionShortTitle(PsychoFunction.Logic, resources)
    }

    override fun getLogicTitle(): String {
        return FunctionTitleGetter.getThirdFunctionTitle(PsychoFunction.Logic, resources)
    }

    override fun getPhysicsShortTitle(): String {
        return FunctionTitleGetter.getThirdFunctionShortTitle(PsychoFunction.Physics, resources)
    }

    override fun getPhysicsTitle(): String {
        return FunctionTitleGetter.getThirdFunctionTitle(PsychoFunction.Physics, resources)
    }

    override fun getWillShortTitle(): String {
        return FunctionTitleGetter.getThirdFunctionShortTitle(PsychoFunction.Will, resources)
    }

    override fun getWillTitle(): String {
        return FunctionTitleGetter.getThirdFunctionTitle(PsychoFunction.Will, resources)
    }

}