package com.laushkina.anastasia.psychosophy.view.test

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.databinding.FragmentTestBinding
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.BaseFragment
import com.laushkina.anastasia.psychosophy.view.NavigationHelper
import javax.inject.Inject

class TestFragment: BaseFragment(), ITestResultsObserver, ITypeCalculator {

    companion object {
        private const val TEST_STATE_EXTRA = "test_state"
    }

    @Inject
    internal lateinit var presenter: TestPresenter
    private lateinit var viewModel: TestViewModel
    private lateinit var adapter: TestQuestionsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentTestBinding>(inflater, R.layout.fragment_test,
                container, false)
        binding.testCalculator = this

        presenter = DaggerTestComponent.create().getPresenter()
        val view = binding.root
        initialize(view)
        binding.viewModel = viewModel

        return view
    }
    
    override fun onSaveInstanceState(bundle: Bundle) {
        super.onSaveInstanceState(bundle)
        if (isVisible) {
            bundle.putBundle(TEST_STATE_EXTRA, presenter.getTestState())
        }
    }

    override fun onViewStateRestored(bundle: Bundle?) {
        super.onViewStateRestored(bundle)
        val savedState = bundle?.getBundle(TEST_STATE_EXTRA) ?: return

        presenter.restoreFromSavedState(savedState, this, context!!)
    }


    override fun getTitle(): CharSequence {
        return resources.getString(R.string.test)
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_test
    }

    override fun showExceptionResultDescription() {
        NavigationHelper.instance.showTestResults(null, fragmentManager)
    }

    override fun showTypeDescription(psychotypes: Array<Psychotype>) {
        NavigationHelper.instance.showTestResults(psychotypes, fragmentManager)
    }

    override fun showGroupOfQuestions(questionSet: List<CharSequence>, isPrevEnabled: Boolean, progress: Int, nextButtonText: String) {
        getQuestionsRecycler().scrollToPosition(0)
        adapter.setQuestions(questionSet)
        viewModel.setProgress(progress)
        viewModel.setNextButtonText(nextButtonText)
        viewModel.setPrevButtonText(resources.getString(R.string.prev_question_title))
        viewModel.setPrevEnabled(isPrevEnabled)
        viewModel.setNextEnabled(false)
    }

    override fun showNextButton() {
        viewModel.setNextEnabled(true)
    }

    override fun next() {
        val context = context
        if (context != null) {
            presenter.onNextRequested(adapter.getAnswers(), this, context)
        }
    }

    override fun prev() {
        val context = context
        if (context != null) {
            presenter.onPrevQuestionsRequested(this, context)
        }
    }

    private fun initialize(view: View) {
        initialize()
        viewModel = TestViewModel()
        viewModel.setNextButtonText(presenter.getNextQuestionText(view.context))

        // Initialize questions
        val questionsRecycler = getQuestionsRecycler(view)
        questionsRecycler.layoutManager = LinearLayoutManager(activity)
        adapter = TestQuestionsAdapter(
                presenter.getFirstGroupOfQuestions(context!!),
                object: TestQuestionsAdapter.OnAnswersSelectedListener {
                    override fun onAllAnswersSelected() {
                        presenter.onAnswerSelected(this@TestFragment)
                    }
                }
        )
        questionsRecycler.adapter = adapter

        getProgressBar(view).progressDrawable = resources.getDrawable(R.drawable.test_progress_drawable)
    }

    private fun getProgressBar(view: View): ProgressBar {
        return view.findViewById(R.id.test_progress)
    }

    private fun getQuestionsRecycler(view: View): RecyclerView {
        return view.findViewById(R.id.test_questions_recycler)
    }

    // Must be called after onAttach() and before on detach() or NPE will happen
    private fun getQuestionsRecycler(): RecyclerView {
        return activity!!.findViewById(R.id.test_questions_recycler)
    }

}