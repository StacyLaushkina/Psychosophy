package com.laushkina.anastasia.psychosophy.view.functions

import android.databinding.DataBindingUtil
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.databinding.FragmentFunctionsDescriptionBinding
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction
import com.laushkina.anastasia.psychosophy.view.BaseFragment
import com.laushkina.anastasia.psychosophy.view.utils.TextStyler
import com.sothree.slidinguppanel.SlidingUpPanelLayout

abstract class FunctionsDescriptionFragment: BaseFragment(), IFunctionSelectListener {
    companion object {
        const val requestedFunctionExtra = "requestedFunctionExtra"
    }

    private lateinit var viewModel: FunctionViewModel
    private lateinit var slidingUpPanel: SlidingUpPanelLayout
    private lateinit var descriptionScrollView: ScrollView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentFunctionsDescriptionBinding>(inflater, R.layout.fragment_functions_description,
                container, false)
        binding.selectListener = this

        val rootView = binding.root
        initialize(rootView)
        binding.viewModel = viewModel
        return rootView
    }

    override fun onResume() {
        super.onResume()
        val requestedFunction = getRequestedFunction() ?: return

        onFunctionDescriptionRequested(getFullDescription(requestedFunction), getTitle(requestedFunction!!), getImage(requestedFunction))
    }

    override fun onEmotionClick() {
        onFunctionDescriptionRequested(getFullDescription(PsychoFunction.Emotion), getEmotionTitle(), getImage(PsychoFunction.Emotion))
    }

    override fun onLogicClick() {
        onFunctionDescriptionRequested(getFullDescription(PsychoFunction.Logic), getLogicTitle(), getImage(PsychoFunction.Logic))
    }

    override fun onPhysicsClick() {
        onFunctionDescriptionRequested(getFullDescription(PsychoFunction.Physics), getPhysicsTitle(), getImage(PsychoFunction.Physics))
    }

    override fun onWillClick() {
        onFunctionDescriptionRequested(getFullDescription(PsychoFunction.Will), getWillTitle(), getImage(PsychoFunction.Will))
    }

    override fun getTitle(): String {
        throw UnsupportedOperationException()
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_functions
    }

    /**
     * @return image of function (general)
     */
    abstract fun getImage(): Drawable

    /**
     * @return image of concrete function : first logic or third physics
     */
    abstract fun getImage(function: PsychoFunction): Drawable

    abstract fun getFunctionDescription(): CharSequence

    abstract fun getFullDescription(function: PsychoFunction): CharSequence

    abstract fun getEmotionShortTitle(): String
    abstract fun getEmotionTitle(): String

    abstract fun getLogicShortTitle(): String
    abstract fun getLogicTitle(): String

    abstract fun getPhysicsShortTitle(): String
    abstract fun getPhysicsTitle(): String

    abstract fun getWillShortTitle(): String
    abstract fun getWillTitle(): String

    private fun initialize(rootView: View) {
        val functionImage = getImage()
        viewModel = getViewModel(functionImage)

        // Sliding panel is unique for each tab - so it should be initialized every time
        slidingUpPanel = rootView.findViewById(R.id.sliding_layout)
        descriptionScrollView = rootView.findViewById(R.id.function_description_scroller)
    }

    private fun getViewModel(functionImage: Drawable): FunctionViewModel {
        return FunctionViewModel.Builder()
                .functionTitle(getFunctionTitle())
                .functionDescription(TextStyler.style(getFunctionDescription(), activity))
                .functionImage(functionImage)
                .emotionTitle(getEmotionShortTitle())
                .logicTitle(getLogicShortTitle())
                .physicsTitle(getPhysicsShortTitle())
                .willTitle(getWillShortTitle())
                .build()
    }

    private fun getTitle(function: PsychoFunction): String {
        return when (function) {
            PsychoFunction.Will -> getWillTitle()
            PsychoFunction.Physics -> getPhysicsTitle()
            PsychoFunction.Logic -> getLogicTitle()
            PsychoFunction.Emotion -> getEmotionTitle()
        }
    }

    private fun getFunctionTitle(): String {
        return resources.getString(R.string.common_description_title)
    }

    private fun onFunctionDescriptionRequested(fullDescription: CharSequence, title: String, image: Drawable) {
        viewModel.setFunctionDescription(TextStyler.style(fullDescription, activity))
        viewModel.setFunctionTitle(title)
        viewModel.setFunctionImage(image)
        collapseBottomNavigation()
        scrollToTheTop()
    }

    private fun collapseBottomNavigation() {
        slidingUpPanel.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED

    }

    private fun scrollToTheTop() {
        descriptionScrollView.smoothScrollTo(0, 0)
    }

    private fun getRequestedFunction(): PsychoFunction? {
        if (arguments == null) {
            return null
        }
        val functionExtra = arguments.getSerializable(requestedFunctionExtra)
        return if (functionExtra == null) null else functionExtra as PsychoFunction
    }
}