package com.laushkina.anastasia.psychosophy.view.psychotypeDescription

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.databinding.FragmentPsychotypeFullTextDescriptionBinding
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.BaseFragment
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment

class PsychotypeFullTextDescriptionFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentPsychotypeFullTextDescriptionBinding>(inflater, R.layout.fragment_psychotype_full_text_description,
                container, false)
        binding.fullDescription = PsychotypeDescriptionGetter.getFull(getPsychotype(), activity)
        return binding.root
    }

    override fun getTitle(): CharSequence {
        return resources.getString(R.string.psychotype_description)
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_psychotypes
    }

    private fun getPsychotype(): Psychotype? {
        val psychotype = arguments.getSerializable(PsychotypesFragment.psychotypeExtra)
        return if (psychotype != null) psychotype as Psychotype else null
    }
}