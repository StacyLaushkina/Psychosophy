package com.laushkina.anastasia.psychosophy.view.psychotypes

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.BaseFragment

class PsychotypesFragment : BaseFragment() {
    companion object {
        const val psychotypeExtra = "psychotypeExtra"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_psychotypes, container, false)
        initialize(view)

        return view
    }

    override fun getTitle(): CharSequence {
        return resources.getString(R.string.psychotypes)
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_psychotypes
    }

    private fun initialize(view: View) {
        initialize()

        val recyclerView = getTypesRecyclerView(view)
        recyclerView.setLayoutManager(GridLayoutManager(activity, getColumnAmount()))

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.basic_margin)
        recyclerView.addItemDecoration(SpacesPsychotypeItemDecoration(spacingInPixels))
        recyclerView.adapter = PsychotypesAdapter(Psychotype.values(), activity, fragmentManager)
    }

    private fun getTypesRecyclerView(view: View): RecyclerView {
        return view.findViewById(R.id.psychotypes_recycler)
    }

    private fun getColumnAmount(): Int {
        val displayMetrics = resources.displayMetrics
        return (displayMetrics.widthPixels / resources.getDimension(R.dimen.psychotype_card_size)).toInt()
    }

    private class SpacesPsychotypeItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View,
                                    parent: RecyclerView, state: RecyclerView.State) {
            outRect.left = space
            outRect.right = space
            outRect.bottom = space
        }
    }
}