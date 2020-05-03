package com.laushkina.anastasia.psychosophy.view.introduction

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.databinding.FragmentIntroductionBinding
import com.laushkina.anastasia.psychosophy.view.BaseFragment
import com.laushkina.anastasia.psychosophy.view.NavigationHelper
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsAdapter

class IntroductionFragment: BaseFragment(), IIntroductionNavigator {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentIntroductionBinding>(
                inflater,
                R.layout.fragment_introduction,
                container,
                false
        )
        binding.viewModel = getViewModel()
        binding.navigator = this

        initialize()
        return binding.root
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_introduction
    }

    override fun getTitle(): CharSequence {
        return resources.getString(R.string.introduction)
    }

    override fun navigateToFirstFunction() {
        NavigationHelper.instance.showFunctions(activity.fragmentManager, FunctionsAdapter.FIRST_FUNCTION, null)
    }

    override fun navigateToSecondFunction() {
        NavigationHelper.instance.showFunctions(activity.fragmentManager, FunctionsAdapter.SECOND_FUNCTION, null)
    }

    override fun navigateToThirdFunction() {
        NavigationHelper.instance.showFunctions(activity.fragmentManager, FunctionsAdapter.THIRD_FUNCTION, null)
    }

    override fun navigateToForthFunction() {
        NavigationHelper.instance.showFunctions(activity.fragmentManager, FunctionsAdapter.FORTH_FUNCTION, null)
    }

    override fun navigateToPsychotypes() {
        NavigationHelper.instance.showTypes(activity.fragmentManager)
    }

    override fun navigateToTest() {
        NavigationHelper.instance.showTest(activity.fragmentManager)
    }

    override fun navigateToBasesAndFunctions() {
        NavigationHelper.instance.showBasesAndFunctions(activity.fragmentManager)
    }

    override fun navigateToRelationships() {
        NavigationHelper.instance.showRelationships(activity.fragmentManager)
    }

    private fun getViewModel(): IntroductionViewModel {
        val viewModel = IntroductionViewModel()
        viewModel.psychosophyDefinition = getPsychosophyDefinition()
        viewModel.psychosophyBases = getPsychosophyBases()
        viewModel.personalitiesDescription = getPersonalitiesDescription()
        viewModel.relationshipsDescription = getRelationshipsDescription()

        return viewModel
    }

    private fun getPsychosophyDefinition(): CharSequence {
        return Html.fromHtml(resources.getString(R.string.introduction_psychosophy_definition))
    }

    private fun getPsychosophyBases(): CharSequence {
        return Html.fromHtml(resources.getString(R.string.introduction_psychosophy_definition_bases))
    }

    private fun getPersonalitiesDescription(): CharSequence {
        return Html.fromHtml(resources.getString(R.string.introduction_psychosophy_personalities))
    }

    private fun getRelationshipsDescription(): CharSequence {
        return Html.fromHtml(resources.getString(R.string.introduction_psychosophy_relationships))
    }

}