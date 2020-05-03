package com.laushkina.anastasia.psychosophy.view.test

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.BaseFragment
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesAdapter
import java.util.*

class TestResultsFragment: BaseFragment() {

    companion object {
        const val testResultsExtra = "testResultsExtra"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_test_results, container, false)
        initialize(view)

        return view
    }

    override fun getTitle(): CharSequence {
        return resources.getString(R.string.test_results)
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_test
    }

    private fun initialize(view: View) {
        initialize()

        val testResult = getTestResults()
        getResultsDescriotionTextView(view).text = getTestResultsDescription(testResult)

        if (testResult == null) return

        val recyclerView = getResultsRecyclerView(view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = PsychotypesAdapter(testResult, activity, fragmentManager)
    }

    private fun getTestResultsDescription(results: Array<Psychotype>?): String {
        if (results == null) return resources.getString(R.string.test_results_exception_too_many_results)
        return if (results.size == 1) resources.getString(R.string.test_results_exception_one_result) else resources.getString(R.string.test_results_exception_several_results)
    }

    private fun getTestResults(): Array<Psychotype>? {
        val answers = arguments.getParcelableArray(testResultsExtra)
        return if (answers == null) null else Arrays.copyOf(answers, answers.size, Array<Psychotype>::class.java)
    }

    private fun getResultsRecyclerView(view: View): RecyclerView {
        return view.findViewById(R.id.test_results_recycler)
    }

    private fun getResultsDescriotionTextView(view: View): TextView {
        return view.findViewById(R.id.results_description)
    }
}
