package com.laushkina.anastasia.psychosophy.view.psychotypes

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager

import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.NavigationHelper
import com.laushkina.anastasia.psychosophy.view.PsychotypeImageGetter
import com.laushkina.anastasia.psychosophy.view.psychotypeDescription.PsychotypeDescriptionGetter

class PsychotypesAdapter(private val psychotypes: Array<Psychotype>,
                         private val context: Context,
                         private val fragmentManager: FragmentManager): RecyclerView.Adapter<PsychotypesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_psychotype_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return psychotypes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.typeTitle.text = PsychotypeDescriptionGetter.getTitle(psychotypes[position], context)
        holder.typeImage.setImageDrawable(PsychotypeImageGetter.get(psychotypes[position], context))
        holder.cardView.setOnClickListener { onClick(position) }
    }

    class ViewHolder(val cardView: View) : RecyclerView.ViewHolder(cardView) {
        val typeImage: ImageView = cardView.findViewById(R.id.psychotype_image)
        val typeTitle: TextView = cardView.findViewById(R.id.psychotype_title)
    }

    private fun onClick(position: Int) {
        NavigationHelper.instance.showTypeDescription(psychotypes[position], fragmentManager)
    }
}