package com.laushkina.anastasia.psychosophy.view.relationships

import android.content.Context
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.AdapterView
import android.widget.RelativeLayout
import android.widget.Spinner
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.databinding.FragmentRelationshipsBinding
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.BaseFragment
import javax.inject.Inject

class RelationshipsFragment: BaseFragment(), AdapterView.OnItemSelectedListener, IRelationshipsResultObserver {

    companion object {
        private const val ANIMATION_TIME = 100
    }

    @Inject lateinit var presenter: RelationshipsPresenter
    private val viewModel = RelationshipsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentRelationshipsBinding>(
                inflater,
                R.layout.fragment_relationships,
                container,
                false
        )
        binding.relationships = viewModel

        presenter = DaggerRelationshipsComponent.create().getPresenter()

        val view = binding.root
        initialize(view)
        return view
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //Do nothing
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, p2: Int, p3: Long) {
        val firstSelected = getFirstType()
        val secondSelected = getSecondType()

        if (firstSelected == null || secondSelected == null) {
            onPromtItemSelected()
            return
        }

        animateTypesSelection()
        calculate(firstSelected, secondSelected)
        // Scroll to the top
        getRelationshipsContainer()?.scrollTo(0, 0)
    }

    override fun setHintAndImageVisibility(visibility: Int) {
        viewModel.setImageAndHintVisibility(visibility)
    }

    override fun getTitle(): CharSequence {
        return resources.getString(R.string.relationships)
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_relationships
    }

    private fun getFirstType(): Psychotype? {
        val firstTypeSpinner = getFirstTypeSpinner()
        val selectedItem = firstTypeSpinner?.selectedItem
        return if (selectedItem != null) selectedItem as Psychotype else null
    }

    private fun getSecondType(): Psychotype? {
        val secondTypeSpinner = getSecondTypeSpinner()
        val selectedItem = secondTypeSpinner?.selectedItem
        return if (selectedItem != null) selectedItem as Psychotype else null
    }

    private fun calculate(fistType: Psychotype, secondType: Psychotype) {
        val context = context
        if (context != null) {
            val relationships = presenter.calcRelationships(fistType, secondType, this, context)
            viewModel.refreshWith(relationships)
        }
    }

    private fun initialize(view: View) {
        initialize()

        initSpinner(getFirstTypeSpinner(view), resources.getString(R.string.relationships_first_type_prompt))
        initSpinner(getSecondTypeSpinner(view), resources.getString(R.string.relationships_second_type_prompt))
    }

    private fun initSpinner(spinner: Spinner, prompt: String) {
        val secondAdapter = PsychotypesAdapter(
                spinner.context,
                presenter.getPsychotypes(),
                android.R.layout.simple_list_item_1,
                prompt,
                resources.getColor(R.color.boulder)
        )
        spinner.adapter = secondAdapter
        spinner.onItemSelectedListener = this
    }

    private fun onPromtItemSelected() {
        val wasPromptAlreadySelected = getRelationshipsContainer()?.visibility != View.VISIBLE
        if (wasPromptAlreadySelected) {
            return
        }

        setHintAndImageVisibility(View.VISIBLE)

        // Animate slide to the middle of the screen
        val context = context
        if (context != null) {
            val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            val rotation = display.rotation
            val animation = getPromtSelectedAnimation(rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180)
            getSpinnersContainer()?.startAnimation(animation)
        }
    }

    private fun animateTypesSelection() {
        val fragmentContext = context ?: return

        val display = (fragmentContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val rotation = display.rotation
        val animation = getTypesSelectedAnimation(rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180)
        getSpinnersContainer()?.startAnimation(animation)
    }

    private fun getTypesSelectedAnimation(isPortrait: Boolean): TranslateAnimation {
        val metrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(metrics)

        val spinner = getSpinnersContainer()!!

        val anim: TranslateAnimation
        anim = if (isPortrait) {
            TranslateAnimation(0f, 0f, 0f, (-spinner.top).toFloat())
        } else {
            TranslateAnimation(0f, (-metrics.heightPixels / 2).toFloat(), 0f, 0f)
        }

        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                val relationships = getRelationshipsContainer() ?: return

                relationships.visibility = View.VISIBLE
                val layoutParams = spinner.layoutParams as RelativeLayout.LayoutParams
                layoutParams.removeRule(RelativeLayout.CENTER_IN_PARENT)
                if (!isPortrait) {
                    layoutParams.addRule(RelativeLayout.CENTER_VERTICAL)
                }
                spinner.layoutParams = layoutParams
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        anim.duration = ANIMATION_TIME.toLong()
        return anim
    }

    private fun getPromtSelectedAnimation(isPortrait: Boolean): TranslateAnimation? {
        val activity = activity ?: return null
        val metrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(metrics)

        val anim: TranslateAnimation
        anim = if (isPortrait) {
            TranslateAnimation(0f, 0f, 0f, (metrics.heightPixels / 2).toFloat())
        } else {
            TranslateAnimation(0f, 0f, 0f, 0f)
        }

        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                val spinner = getSpinnersContainer()!!

                getRelationshipsContainer()?.visibility = View.GONE
                val layoutParams = spinner.layoutParams as RelativeLayout.LayoutParams
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)
                if (!isPortrait) {
                    layoutParams.removeRule(RelativeLayout.CENTER_VERTICAL)
                }
                spinner.layoutParams = layoutParams
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        anim.duration = ANIMATION_TIME.toLong()
        return anim
    }

    private fun getFirstTypeSpinner(view: View): Spinner {
        return view.findViewById(R.id.first_type_spinner)
    }

    private fun getFirstTypeSpinner(): Spinner? {
        return activity?.findViewById(R.id.first_type_spinner)
    }

    private fun getSecondTypeSpinner(view: View): Spinner {
        return view.findViewById(R.id.second_type_spinner)
    }

    private fun getSecondTypeSpinner(): Spinner? {
        return activity?.findViewById(R.id.second_type_spinner)
    }

    private fun getSpinnersContainer(): View? {
        return activity?.findViewById(R.id.spinner_container)
    }

    private fun getRelationshipsContainer(): View? {
        return activity?.findViewById(R.id.relationships_scroller)
    }
}