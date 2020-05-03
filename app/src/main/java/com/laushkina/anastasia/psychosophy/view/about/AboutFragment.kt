package com.laushkina.anastasia.psychosophy.view.about

import android.os.Bundle
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.view.BaseFragment

class AboutFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_about, container, false)
        initialize(view)
        return view
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_about
    }

    override fun getTitle(): CharSequence {
        return resources.getString(R.string.about)
    }

    private fun initialize(view: View) {
        val developerAddressLink = view.findViewById<TextView>(R.id.developer_info_link)
        Linkify.addLinks(developerAddressLink, Linkify.WEB_URLS or Linkify.EMAIL_ADDRESSES)
        developerAddressLink.setLinkTextColor(resources.getColor(R.color.colorPrimaryDark))

        val designerAddressLink = view.findViewById<TextView>(R.id.designer_info_link)
        Linkify.addLinks(designerAddressLink, Linkify.WEB_URLS or Linkify.EMAIL_ADDRESSES)
        designerAddressLink.setLinkTextColor(resources.getColor(R.color.colorPrimaryDark))

        val afanasievAddressLink = view.findViewById<TextView>(R.id.afanasiev_info_link)
        Linkify.addLinks(afanasievAddressLink, Linkify.WEB_URLS)
        afanasievAddressLink.setLinkTextColor(resources.getColor(R.color.colorPrimaryDark))

        val relationshipsAddressLink = view.findViewById<TextView>(R.id.relationships_info_link)
        Linkify.addLinks(relationshipsAddressLink, Linkify.WEB_URLS)
        relationshipsAddressLink.setLinkTextColor(resources.getColor(R.color.colorPrimaryDark))

        val introductionAddressLink = view.findViewById<TextView>(R.id.introduction_info_link)
        Linkify.addLinks(introductionAddressLink, Linkify.WEB_URLS)
        introductionAddressLink.setLinkTextColor(resources.getColor(R.color.colorPrimaryDark))

        val functionGeneralAddressLink = view.findViewById<TextView>(R.id.function_general_info_link)
        Linkify.addLinks(functionGeneralAddressLink, Linkify.WEB_URLS)
        functionGeneralAddressLink.setLinkTextColor(resources.getColor(R.color.colorPrimaryDark))

        initialize()
    }
}