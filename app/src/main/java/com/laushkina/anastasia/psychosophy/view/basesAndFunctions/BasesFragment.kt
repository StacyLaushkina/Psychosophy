package com.laushkina.anastasia.psychosophy.view.basesAndFunctions

import android.app.Fragment
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.laushkina.anastasia.psychosophy.R

class BasesFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_bases_and_functions_bases, container, false)
        initialize(view)
        return view
    }

    private fun initialize(view: View) {
        val basesWill = view.findViewById<TextView>(R.id.bases_info_will)
        basesWill.text = Html.fromHtml(resources.getString(R.string.bases_info_will))

        val basesLogic = view.findViewById<TextView>(R.id.bases_info_logic)
        basesLogic.text = Html.fromHtml(resources.getString(R.string.bases_info_logic))

        val basesEmotion = view.findViewById<TextView>(R.id.bases_info_emotion)
        basesEmotion.text = Html.fromHtml(resources.getString(R.string.bases_info_emotion))

        val basesPhysics = view.findViewById<TextView>(R.id.bases_info_physics)
        basesPhysics.text = Html.fromHtml(resources.getString(R.string.bases_info_physics))
    }
}