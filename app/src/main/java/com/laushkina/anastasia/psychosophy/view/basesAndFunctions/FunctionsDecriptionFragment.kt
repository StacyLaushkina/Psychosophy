package com.laushkina.anastasia.psychosophy.view.basesAndFunctions

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.laushkina.anastasia.psychosophy.R

class FunctionsDecriptionFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_bases_and_functions_functions, container, false)
        initialize(view)
        return view
    }

    private fun initialize(view: View) {
        val firstFunction = view.findViewById<TextView>(R.id.first_function_text)
        firstFunction.text = Html.fromHtml(resources.getString(R.string.functions_info_first))

        val secondFunction = view.findViewById<TextView>(R.id.second_function_text)
        secondFunction.text = Html.fromHtml(resources.getString(R.string.functions_info_second))

        val thirdFunction = view.findViewById<TextView>(R.id.third_function_text)
        thirdFunction.text = Html.fromHtml(resources.getString(R.string.functions_info_third))

        val forthFunction = view.findViewById<TextView>(R.id.forth_function_text)
        forthFunction.text = Html.fromHtml(resources.getString(R.string.functions_info_forth))

        val moreInfo = view.findViewById<TextView>(R.id.function_info_text)
        moreInfo.text = Html.fromHtml(resources.getString(R.string.functions_info))
    }
}