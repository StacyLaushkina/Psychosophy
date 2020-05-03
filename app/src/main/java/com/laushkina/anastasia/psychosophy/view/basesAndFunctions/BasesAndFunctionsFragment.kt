package com.laushkina.anastasia.psychosophy.view.basesAndFunctions

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.view.BaseFragment

class BasesAndFunctionsFragment: BaseFragment() {
    private lateinit var basesAndFunctionsPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_bases_and_functions, container, false)
        initialize(view)

        return view
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_bases_and_functions
    }

    override fun getTitle(): CharSequence {
        return resources.getString(R.string.bases_and_functions)
    }

    private fun initialize(view: View) {
        initialize()
        basesAndFunctionsPager = getBasesAndFunctionsPager(view)
        basesAndFunctionsPager.adapter = BasesAndFunctionsAdapter(childFragmentManager)
        basesAndFunctionsPager.addOnPageChangeListener(
                object : ViewPager.OnPageChangeListener {
                    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

                    override fun onPageSelected(position: Int) {
                        onPageChanged(position)
                    }

                    override fun onPageScrollStateChanged(state: Int) {}
                }
        )
        getSwitchLayout(view).setOnClickListener { switchPage(basesAndFunctionsPager.currentItem) }
    }

    private fun switchPage(current: Int) {
        when (current) {
            BasesAndFunctionsAdapter.FUNCTIONS -> {
                basesAndFunctionsPager.currentItem = BasesAndFunctionsAdapter.BASES
            }
            BasesAndFunctionsAdapter.BASES -> {
                basesAndFunctionsPager.currentItem = BasesAndFunctionsAdapter.FUNCTIONS
            }
        }
    }

    private fun onPageChanged(current: Int) {
        val switchText = getSwitchText()

        when (current) {
            BasesAndFunctionsAdapter.BASES -> {
                getMoreImageButton().visibility = View.VISIBLE
                getLessImageButton().visibility = View.INVISIBLE
                switchText.text = resources.getString(R.string.functions_title)
            }
            BasesAndFunctionsAdapter.FUNCTIONS -> {
                getMoreImageButton().visibility = View.INVISIBLE
                getLessImageButton().visibility = View.VISIBLE
                switchText.text = resources.getString(R.string.bases_title)
            }
        }
    }

    private fun getMoreImageButton(): ImageButton {
        return activity.findViewById(R.id.switch_more_button)
    }

    private fun getLessImageButton(): ImageButton {
        return activity.findViewById(R.id.switch_less_button)
    }

    private fun getSwitchText(): TextView {
        return activity.findViewById(R.id.switch_text_view)
    }

    private fun getSwitchLayout(view: View): View {
        return view.findViewById(R.id.switch_layout)
    }

    private fun getBasesAndFunctionsPager(view: View): ViewPager {
        return view.findViewById(R.id.bases_and_functions_pager)
    }

}