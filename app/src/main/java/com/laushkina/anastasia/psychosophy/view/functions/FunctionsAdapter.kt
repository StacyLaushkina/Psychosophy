package com.laushkina.anastasia.psychosophy.view.functions

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction

class FunctionsAdapter(fm: FragmentManager,
                       private val context: Context,
                       private val requestedFunction: PsychoFunction?) : FragmentPagerAdapter(fm) {
    companion object {
        const val FIRST_FUNCTION = 0
        const val SECOND_FUNCTION = 1
        const val THIRD_FUNCTION = 2
        const val FORTH_FUNCTION = 3
        private const val PAGE_AMOUNT = 4
    }

    override fun getItem(position: Int): Fragment {
        val bundle = Bundle(2)
        bundle.putSerializable(FunctionsDescriptionFragment.requestedFunctionExtra, requestedFunction)

        val fragment: FunctionsDescriptionFragment = when (position) {
            FIRST_FUNCTION -> FirstFunctionFragment()
            SECOND_FUNCTION -> SecondFunctionFragment()
            THIRD_FUNCTION -> ThirdFunctionFragment()
            FORTH_FUNCTION -> ForthFunctionFragment()
            else -> throw AssertionError()
        }

        fragment.arguments = bundle

        return fragment
    }

    override fun getCount(): Int {
        return PAGE_AMOUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> context.resources.getString(R.string.first_function_title)
            1 -> context.resources.getString(R.string.second_function_title)
            2 -> context.resources.getString(R.string.third_function_title)
            3 -> context.resources.getString(R.string.forth_function_title)
            else -> null
        }
    }

}