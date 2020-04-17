package com.laushkina.anastasia.psychosophy.view.relationships

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionGetter

class PsychotypesAdapter(context: Context,
                         private val resourceLayout: Int,
                         psychotypes: Array<Psychotype?>,
                         private val promtTest: String,
                         private val firstItemColor: Int): ArrayAdapter<Psychotype?>(context, resourceLayout, psychotypes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resourceLayout, null)
        }

        initText(convertView!!, position)
        return convertView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var newConvertView = convertView
        if (newConvertView == null) {
            newConvertView = LayoutInflater.from(context).inflate(resourceLayout, null)
        }

        initText(newConvertView!!, position)
        return newConvertView
    }

    private fun initText(convertView: View, position: Int) {
        val textView = convertView.findViewById<TextView>(android.R.id.text1)
        textView.setText(getText(position))
        if (position == 0) {
            textView.setTextColor(firstItemColor)
        } else {
            textView.setTextColor(Color.BLACK)
        }
    }

    private fun getText(position: Int): CharSequence {
        val psychotype = getItem(position)
        //First item is prompt
        return if (position == 0) promtTest else PsychotypeDescriptionGetter.getTitle(psychotype, context)
    }
}