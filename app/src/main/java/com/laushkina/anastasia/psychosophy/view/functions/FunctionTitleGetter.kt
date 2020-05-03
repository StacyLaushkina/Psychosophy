package com.laushkina.anastasia.psychosophy.view.functions

import android.content.res.Resources
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction

class FunctionTitleGetter {
    companion object {
        fun getFirstFunctionTitle(functionsArray: Array<PsychoFunction>?, resources: Resources?): String {
            if (functionsArray == null || functionsArray.size != 4 || resources == null) throw RuntimeException("Cannot get title of first FUNCTIONS")

            return getFirstFunctionTitle(functionsArray[0], resources)
        }

        fun getFirstFunctionShortTitle(functionsArray: Array<PsychoFunction>?, resources: Resources?): String {
            if (functionsArray == null || functionsArray.size != 4 || resources == null) throw RuntimeException("Cannot get title of first FUNCTIONS")

            return getFirstFunctionShortTitle(functionsArray[0], resources)
        }

        fun getSecondFunctionTitle(functionsArray: Array<PsychoFunction>?, resources: Resources?): String {
            if (functionsArray == null || functionsArray.size != 4 || resources == null) throw RuntimeException("Cannot get title of second FUNCTIONS")

            return getSecondFunctionTitle(functionsArray[1], resources)
        }

        fun getSecondFunctionShortTitle(functionsArray: Array<PsychoFunction>?, resources: Resources?): String {
            if (functionsArray == null || functionsArray.size != 4 || resources == null) throw RuntimeException("Cannot get title of second FUNCTIONS")

            return getSecondFunctionShortTitle(functionsArray[1], resources)
        }

        fun getThirdFunctionTitle(functionsArray: Array<PsychoFunction>?, resources: Resources?): String {
            if (functionsArray == null || functionsArray.size != 4 || resources == null) throw RuntimeException("Cannot get title of third FUNCTIONS")

            return getThirdFunctionTitle(functionsArray[2], resources)
        }

        fun getThirdFunctionShortTitle(functionsArray: Array<PsychoFunction>?, resources: Resources?): String {
            if (functionsArray == null || functionsArray.size != 4 || resources == null) throw RuntimeException("Cannot get title of third FUNCTIONS")

            return getThirdFunctionShortTitle(functionsArray[2], resources)
        }

        fun getForthFunctionTitle(functionsArray: Array<PsychoFunction>?, resources: Resources?): String {
            if (functionsArray == null || functionsArray.size != 4 || resources == null) throw RuntimeException("Cannot get title of forth FUNCTIONS")

            return getForthFunctionTitle(functionsArray[3], resources)
        }

        fun getForthFunctionShortTitle(functionsArray: Array<PsychoFunction>?, resources: Resources?): String {
            if (functionsArray == null || functionsArray.size != 4 || resources == null) throw RuntimeException("Cannot get title of forth FUNCTIONS")

            return getForthFunctionShortTitle(functionsArray[3], resources)
        }

        internal fun getFirstFunctionTitle(firstFunction: PsychoFunction, resources: Resources): String {
            return when (firstFunction) {
                PsychoFunction.Logic -> resources.getString(R.string.first_logic_name)
                PsychoFunction.Emotion -> resources.getString(R.string.first_emotion_name)
                PsychoFunction.Physics -> resources.getString(R.string.first_physics_name)
                PsychoFunction.Will -> resources.getString(R.string.first_will_name)
            }
        }

        internal fun getFirstFunctionShortTitle(firstFunction: PsychoFunction, resources: Resources): String {
            return when (firstFunction) {
                PsychoFunction.Logic -> resources.getString(R.string.first_logic_short_name)
                PsychoFunction.Emotion -> resources.getString(R.string.first_emotion_short_name)
                PsychoFunction.Physics -> resources.getString(R.string.first_physics_short_name)
                PsychoFunction.Will -> resources.getString(R.string.first_will_short_name)
            }
        }

        internal fun getSecondFunctionTitle(secondFunction: PsychoFunction, resources: Resources): String {
            return when (secondFunction) {
                PsychoFunction.Logic -> resources.getString(R.string.second_logic_name)
                PsychoFunction.Emotion -> resources.getString(R.string.second_emotion_name)
                PsychoFunction.Physics -> resources.getString(R.string.second_physics_name)
                PsychoFunction.Will -> resources.getString(R.string.second_will_name)
            }
        }

        internal fun getSecondFunctionShortTitle(secondFunction: PsychoFunction, resources: Resources): String {
            return when (secondFunction) {
                PsychoFunction.Logic -> resources.getString(R.string.second_logic_short_name)
                PsychoFunction.Emotion -> resources.getString(R.string.second_emotion_short_name)
                PsychoFunction.Physics -> resources.getString(R.string.second_physics_short_name)
                PsychoFunction.Will -> resources.getString(R.string.second_will_short_name)
            }
        }

        internal fun getThirdFunctionTitle(thirdFunction: PsychoFunction, resources: Resources): String {
            return when (thirdFunction) {
                PsychoFunction.Logic -> resources.getString(R.string.third_logic_name)
                PsychoFunction.Emotion -> resources.getString(R.string.third_emotion_name)
                PsychoFunction.Physics -> resources.getString(R.string.third_physics_name)
                PsychoFunction.Will -> resources.getString(R.string.third_will_name)
            }
        }

        internal fun getThirdFunctionShortTitle(thirdFunction: PsychoFunction, resources: Resources): String {
            return when (thirdFunction) {
                PsychoFunction.Logic -> resources.getString(R.string.third_logic_short_name)
                PsychoFunction.Emotion -> resources.getString(R.string.third_emotion_short_name)
                PsychoFunction.Physics -> resources.getString(R.string.third_physics_short_name)
                PsychoFunction.Will -> resources.getString(R.string.third_will_short_name)
            }
        }

        internal fun getForthFunctionTitle(forthFunction: PsychoFunction, resources: Resources): String {
            return when (forthFunction) {
                PsychoFunction.Logic -> resources.getString(R.string.forth_logic_name)
                PsychoFunction.Emotion -> resources.getString(R.string.forth_emotion_name)
                PsychoFunction.Physics -> resources.getString(R.string.forth_physics_name)
                PsychoFunction.Will -> resources.getString(R.string.forth_will_name)
            }
        }

        internal fun getForthFunctionShortTitle(forthFunction: PsychoFunction, resources: Resources): String {
            return when (forthFunction) {
                PsychoFunction.Logic -> resources.getString(R.string.forth_logic_short_name)
                PsychoFunction.Emotion -> resources.getString(R.string.forth_emotion_short_name)
                PsychoFunction.Physics -> resources.getString(R.string.forth_physics_short_name)
                PsychoFunction.Will -> resources.getString(R.string.forth_will_short_name)
            }
        }
    }
}