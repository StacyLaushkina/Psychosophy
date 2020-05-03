package com.laushkina.anastasia.psychosophy.view.psychotypeDescription

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.BaseFragment
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment

class PsychotypeDescriptionFragment: BaseFragment() {

    private lateinit var descriptionViewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_psychotype_description, container, false)
        initialize(view)

        return view
    }
    override fun getTitle(): CharSequence {
        return resources.getString(R.string.psychotype_description)
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_psychotypes
    }

    private fun initialize(view: View) {
        descriptionViewPager = getDescriptionsViewPager(view)
        descriptionViewPager.adapter = PsychotypeDescriptionAdapter(childFragmentManager, getPsychotype())
        descriptionViewPager.addOnPageChangeListener(
                object : ViewPager.OnPageChangeListener {
                    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

                    override fun onPageSelected(position: Int) {
                        onPageChanged(position)
                    }

                    override fun onPageScrollStateChanged(state: Int) {}
                }
        )

        getSwitchButton(view).setOnClickListener({ v -> switchPage(descriptionViewPager.getCurrentItem()) })
    }

    private fun onPageChanged(current: Int) {
        val switchButton = getSwitchButton()

        when (current) {
            PsychotypeDescriptionAdapter.PREVIEW_DESCRIPTION -> {
                switchButton.scaleType = ImageView.ScaleType.FIT_END
                switchButton.setImageDrawable(resources.getDrawable(R.drawable.ic_action_more))
            }
            PsychotypeDescriptionAdapter.FULL_TEXT_DESCRIPTION -> {
                switchButton.scaleType = ImageView.ScaleType.FIT_START
                switchButton.setImageDrawable(resources.getDrawable(R.drawable.ic_action_less))
            }
        }
    }

    private fun switchPage(current: Int) {
        when (current) {
            PsychotypeDescriptionAdapter.PREVIEW_DESCRIPTION -> {
                descriptionViewPager.currentItem = PsychotypeDescriptionAdapter.FULL_TEXT_DESCRIPTION
            }
            PsychotypeDescriptionAdapter.FULL_TEXT_DESCRIPTION -> {
                descriptionViewPager.currentItem = PsychotypeDescriptionAdapter.PREVIEW_DESCRIPTION
            }
        }
    }

    private fun getDescriptionsViewPager(view: View): ViewPager {
        return view.findViewById(R.id.description_pager)
    }

    private fun getPsychotype(): Psychotype {
        return arguments.getSerializable(PsychotypesFragment.psychotypeExtra) as Psychotype
    }

    private fun getSwitchButton(): ImageButton {
        return activity.findViewById(R.id.switch_button)
    }

    private fun getSwitchButton(view: View): ImageButton {
        return view.findViewById(R.id.switch_button)
    }

}