package com.laushkina.anastasia.psychosophy.view.functions

import android.graphics.drawable.Drawable
import android.text.Html
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction

class ForthFunctionFragment: FunctionsDescriptionFragment() {
    override fun getImage(): Drawable {
        return resources.getDrawable(R.drawable.ic_empty_flag)
    }

    override fun getImage(function: PsychoFunction): Drawable {
        return when (function) {
            PsychoFunction.Emotion -> resources.getDrawable(R.drawable.ic_empty_flag_emotion)
            PsychoFunction.Logic -> resources.getDrawable(R.drawable.ic_empty_flag_logic)
            PsychoFunction.Physics -> resources.getDrawable(R.drawable.ic_empty_flag_physics)
            PsychoFunction.Will -> resources.getDrawable(R.drawable.ic_empty_flag_will)
        }
    }

    override fun getFunctionDescription(): CharSequence {
        return Html.fromHtml(getString(R.string.forth_function_description))
    }

    override fun getFullDescription(function: PsychoFunction): CharSequence {
        return when (function) {
            PsychoFunction.Emotion -> Html.fromHtml(resources.getString(R.string.forth_emotion_description))
            PsychoFunction.Logic -> Html.fromHtml(resources.getString(R.string.forth_logic_description))
            PsychoFunction.Physics -> Html.fromHtml(resources.getString(R.string.forth_physics_description))
            PsychoFunction.Will -> Html.fromHtml(resources.getString(R.string.forth_will_description))
        }
    }

    override fun getEmotionShortTitle(): String {
        return FunctionTitleGetter.getForthFunctionShortTitle(PsychoFunction.Emotion, resources)
    }

    override fun getEmotionTitle(): String {
        return FunctionTitleGetter.getForthFunctionTitle(PsychoFunction.Emotion, resources)
    }

    override fun getLogicShortTitle(): String {
        return FunctionTitleGetter.getForthFunctionShortTitle(PsychoFunction.Logic, resources)
    }

    override fun getLogicTitle(): String {
        return FunctionTitleGetter.getForthFunctionTitle(PsychoFunction.Logic, resources)
    }

    override fun getPhysicsShortTitle(): String {
        return FunctionTitleGetter.getForthFunctionShortTitle(PsychoFunction.Physics, resources)
    }

    override fun getPhysicsTitle(): String {
        return FunctionTitleGetter.getForthFunctionTitle(PsychoFunction.Physics, resources)
    }

    override fun getWillShortTitle(): String {
        return FunctionTitleGetter.getForthFunctionShortTitle(PsychoFunction.Will, resources)
    }

    override fun getWillTitle(): String {
        return FunctionTitleGetter.getForthFunctionTitle(PsychoFunction.Will, resources)
    }

}