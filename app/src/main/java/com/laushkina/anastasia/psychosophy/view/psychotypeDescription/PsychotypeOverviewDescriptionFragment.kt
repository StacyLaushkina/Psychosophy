package com.laushkina.anastasia.psychosophy.view.psychotypeDescription

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.databinding.FragmentPsychotypeOverviewDescriptionBinding
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.view.BaseFragment
import com.laushkina.anastasia.psychosophy.view.NavigationHelper
import com.laushkina.anastasia.psychosophy.view.PsychotypeImageGetter
import com.laushkina.anastasia.psychosophy.view.functions.FunctionTitleGetter
import com.laushkina.anastasia.psychosophy.view.functions.FunctionsAdapter
import com.laushkina.anastasia.psychosophy.view.psychotypes.PsychotypesFragment

class PsychotypeOverviewDescriptionFragment: BaseFragment(), IFunctionsNavigator {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentPsychotypeOverviewDescriptionBinding>(
                inflater,
                R.layout.fragment_psychotype_overview_description,
                container,
                false
        )
        binding.viewModel = getViewModel()
        binding.navigator = this

        initialize()
        return binding.root
    }

    override fun getTitle(): CharSequence {
        return PsychotypeDescriptionGetter.getTitle(getPsychotype(), activity)
    }

    override fun getNavigationItemId(): Int {
        return R.id.nav_psychotypes
    }

    override fun navigateToFirstFunction() {
        // Switch between drawer's tabs, so level of activity's fragment manager is needed
        NavigationHelper.instance.showFunctions(
                activity.fragmentManager,
                FunctionsAdapter.FIRST_FUNCTION,
                getPsychotype().functions[0]
        )
    }

    override fun navigateToSecondFunction() {
        NavigationHelper.instance.showFunctions(
                activity.fragmentManager,
                FunctionsAdapter.SECOND_FUNCTION,
                getPsychotype().functions[1]
        )
    }

    override fun navigateToThirdFunction() {
        NavigationHelper.instance.showFunctions(
                activity.fragmentManager,
                FunctionsAdapter.THIRD_FUNCTION,
                getPsychotype().functions[2]
        )
    }

    override fun navigateToForthFunction() {
        NavigationHelper.instance.showFunctions(
                activity.fragmentManager,
                FunctionsAdapter.FORTH_FUNCTION,
                getPsychotype().functions[3]
        )
    }

    private fun getViewModel(): DescriptionViewModel {
        val psychotype = getPsychotype()

        return DescriptionViewModel.Builder()
                .firstFunctionDescription(FunctionTitleGetter.getFirstFunctionShortTitle(psychotype.functions, resources))
                .secondFunctionDescription(FunctionTitleGetter.getSecondFunctionShortTitle(psychotype.functions, resources))
                .thirdFunctionDescription(FunctionTitleGetter.getThirdFunctionShortTitle(psychotype.functions, resources))
                .forthFunctionDescription(FunctionTitleGetter.getForthFunctionShortTitle(psychotype.functions, resources))
                .shortDescription(PsychotypeDescriptionGetter.getShort(psychotype, activity))
                .image(PsychotypeImageGetter.get(psychotype, activity))
                .build()
    }

    private fun getPsychotype(): Psychotype {
        return arguments.getSerializable(PsychotypesFragment.psychotypeExtra) as Psychotype
    }

}