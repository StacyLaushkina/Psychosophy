package com.laushkina.anastasia.psychosophy.view.functions

import android.graphics.drawable.Drawable
import android.text.Html
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction

class FirstFunctionFragment: FunctionsDescriptionFragment() {
    override fun getImage(): Drawable {
        return resources.getDrawable(R.drawable.ic_hammer)
    }

    override fun getImage(function: PsychoFunction): Drawable {
        return when (function) {
            PsychoFunction.Emotion -> resources.getDrawable(R.drawable.ic_hammer_emotion)
            PsychoFunction.Logic -> resources.getDrawable(R.drawable.ic_hammer_logic)
            PsychoFunction.Physics -> resources.getDrawable(R.drawable.ic_hammer_physics)
            PsychoFunction.Will -> resources.getDrawable(R.drawable.ic_hammer_will)
        }
    }

    override fun getFunctionDescription(): CharSequence {
        return Html.fromHtml(getString(R.string.first_function_description))
    }

    override fun getFullDescription(function: PsychoFunction): CharSequence {
        return when (function) {
            PsychoFunction.Emotion -> Html.fromHtml(resources.getString(R.string.first_emotion_description))
            PsychoFunction.Logic -> Html.fromHtml(resources.getString(R.string.first_logic_description))
            PsychoFunction.Physics -> Html.fromHtml(resources.getString(R.string.first_physics_description))
            PsychoFunction.Will -> Html.fromHtml(resources.getString(R.string.first_will_description))
        }
    }

    override fun getEmotionShortTitle(): String {
        return FunctionTitleGetter.getFirstFunctionShortTitle(PsychoFunction.Emotion, resources)
    }

    override fun getEmotionTitle(): String {
        return FunctionTitleGetter.getFirstFunctionTitle(PsychoFunction.Emotion, resources)
    }

    override fun getLogicShortTitle(): String {
        return FunctionTitleGetter.getFirstFunctionShortTitle(PsychoFunction.Logic, resources)
    }

    override fun getLogicTitle(): String {
        return FunctionTitleGetter.getFirstFunctionTitle(PsychoFunction.Logic, resources)
    }

    override fun getPhysicsShortTitle(): String {
        return FunctionTitleGetter.getFirstFunctionShortTitle(PsychoFunction.Physics, resources)
    }

    override fun getPhysicsTitle(): String {
        return FunctionTitleGetter.getFirstFunctionTitle(PsychoFunction.Physics, resources)
    }

    override fun getWillShortTitle(): String {
        return FunctionTitleGetter.getFirstFunctionShortTitle(PsychoFunction.Will, resources)
    }

    override fun getWillTitle(): String {
        return FunctionTitleGetter.getFirstFunctionTitle(PsychoFunction.Will, resources)
    }

}