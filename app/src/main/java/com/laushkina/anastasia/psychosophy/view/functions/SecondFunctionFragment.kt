package com.laushkina.anastasia.psychosophy.view.functions

import android.graphics.drawable.Drawable
import android.text.Html
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction

class SecondFunctionFragment: FunctionsDescriptionFragment() {
    override fun getImage(): Drawable {
        return resources.getDrawable(R.drawable.ic_sea_waves)
    }

    override fun getImage(function: PsychoFunction): Drawable {
        return when (function) {
            PsychoFunction.Emotion -> resources.getDrawable(R.drawable.ic_sea_waves_emotion)
            PsychoFunction.Logic -> resources.getDrawable(R.drawable.ic_sea_waves_logic)
            PsychoFunction.Physics -> resources.getDrawable(R.drawable.ic_sea_waves_physics)
            PsychoFunction.Will -> resources.getDrawable(R.drawable.ic_sea_waves_will)
        }
    }

    override fun getFunctionDescription(): CharSequence {
        return Html.fromHtml(getString(R.string.second_function_description))
    }

    override fun getFullDescription(function: PsychoFunction): CharSequence {
        return when (function) {
            PsychoFunction.Emotion -> Html.fromHtml(resources.getString(R.string.second_emotion_description))
            PsychoFunction.Logic -> Html.fromHtml(resources.getString(R.string.second_logic_description))
            PsychoFunction.Physics -> Html.fromHtml(resources.getString(R.string.second_physics_description))
            PsychoFunction.Will -> Html.fromHtml(resources.getString(R.string.second_will_description))
        }
    }

    override fun getEmotionShortTitle(): String {
        return FunctionTitleGetter.getSecondFunctionShortTitle(PsychoFunction.Emotion, resources)
    }

    override fun getEmotionTitle(): String {
        return FunctionTitleGetter.getSecondFunctionTitle(PsychoFunction.Emotion, resources)
    }

    override fun getLogicShortTitle(): String {
        return FunctionTitleGetter.getSecondFunctionShortTitle(PsychoFunction.Logic, resources)
    }

    override fun getLogicTitle(): String {
        return FunctionTitleGetter.getSecondFunctionTitle(PsychoFunction.Logic, resources)
    }

    override fun getPhysicsShortTitle(): String {
        return FunctionTitleGetter.getSecondFunctionShortTitle(PsychoFunction.Physics, resources)
    }

    override fun getPhysicsTitle(): String {
        return FunctionTitleGetter.getSecondFunctionTitle(PsychoFunction.Physics, resources)
    }

    override fun getWillShortTitle(): String {
        return FunctionTitleGetter.getSecondFunctionShortTitle(PsychoFunction.Will, resources)
    }

    override fun getWillTitle(): String {
        return FunctionTitleGetter.getSecondFunctionTitle(PsychoFunction.Will, resources)
    }

}