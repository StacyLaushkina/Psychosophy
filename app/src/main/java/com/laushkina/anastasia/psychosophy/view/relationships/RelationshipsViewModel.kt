package com.laushkina.anastasia.psychosophy.view.relationships

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import android.text.Html
import android.view.View
import com.laushkina.anastasia.psychosophy.BR

class RelationshipsViewModel(private var firstFunctionRelationshipsTitle: CharSequence?,
                             private var firstFunctionRelationships: CharSequence?,
                             private var secondFunctionRelationshipsTitle: CharSequence?,
                             private var secondFunctionRelationships: CharSequence?,
                             private var thirdFunctionRelationshipsTitle: CharSequence?,
                             private var thirdFunctionRelationships: CharSequence?,
                             private var forthFunctionRelationshipsTitle: CharSequence?,
                             private var forthFunctionRelationships: CharSequence?,
                             private var imageAndHintVisibility: Int) : BaseObservable() {
    constructor() : this("", "", "", "", "", "", "", "", View.VISIBLE)

    constructor(firstTitle: String,
                firstDescription: String,
                secondTitle: String,
                secondDescription: String,
                thirdTitle: String,
                thirdDescription: String,
                forthTitle: String,
                forthDescription: String,
                imageAndHintVisibility: String) : this()

    init {
        setFirstFunctionRelationshipsTitle(firstFunctionRelationshipsTitle)
        setFirstFunctionRelationships(firstFunctionRelationships)
        setSecondFunctionRelationshipsTitle(secondFunctionRelationshipsTitle)
        setSecondFunctionRelationships(secondFunctionRelationships)
        setThirdFunctionRelationshipsTitle(thirdFunctionRelationshipsTitle)
        setThirdFunctionRelationships(thirdFunctionRelationships)
        setForthFunctionRelationshipsTitle(forthFunctionRelationshipsTitle)
        setForthFunctionRelationships(forthFunctionRelationships)
        setImageAndHintVisibility(imageAndHintVisibility)
    }

    fun refreshWith(newValue: RelationshipsViewModel) {
        setFirstFunctionRelationshipsTitle(newValue.firstFunctionRelationshipsTitle)
        setFirstFunctionRelationships(newValue.firstFunctionRelationships)
        setSecondFunctionRelationshipsTitle(newValue.secondFunctionRelationshipsTitle)
        setSecondFunctionRelationships(newValue.secondFunctionRelationships)
        setThirdFunctionRelationshipsTitle(newValue.thirdFunctionRelationshipsTitle)
        setThirdFunctionRelationships(newValue.thirdFunctionRelationships)
        setForthFunctionRelationshipsTitle(newValue.forthFunctionRelationshipsTitle)
        setForthFunctionRelationships(newValue.forthFunctionRelationships)
    }

    @Bindable
    fun getFirstFunctionRelationships(): CharSequence? {
        return firstFunctionRelationships
    }

    private fun setFirstFunctionRelationships(firstFunctionRelationships: CharSequence?) {
        this.firstFunctionRelationships = fromHml(firstFunctionRelationships)
        notifyPropertyChanged(BR.firstFunctionRelationships)
    }

    @Bindable
    fun getSecondFunctionRelationships(): CharSequence? {
        return secondFunctionRelationships
    }

    private fun setSecondFunctionRelationships(secondFunctionRelationships: CharSequence?) {
        this.secondFunctionRelationships = fromHml(secondFunctionRelationships)
        notifyPropertyChanged(BR.secondFunctionRelationships)
    }

    @Bindable
    fun getThirdFunctionRelationships(): CharSequence? {
        return thirdFunctionRelationships
    }

    private fun setThirdFunctionRelationships(thirdFunctionRelationships: CharSequence?) {
        this.thirdFunctionRelationships = fromHml(thirdFunctionRelationships)
        notifyPropertyChanged(BR.thirdFunctionRelationships)
    }

    @Bindable
    fun getForthFunctionRelationships(): CharSequence? {
        return forthFunctionRelationships
    }

    private fun setForthFunctionRelationships(forthFunctionRelationships: CharSequence?) {
        this.forthFunctionRelationships = fromHml(forthFunctionRelationships)
        notifyPropertyChanged(BR.forthFunctionRelationships)
    }

    @Bindable
    fun getFirstFunctionRelationshipsTitle(): CharSequence? {
        return firstFunctionRelationshipsTitle
    }

    private fun setFirstFunctionRelationshipsTitle(firstFunctionRelationshipsTitle: CharSequence?) {
        this.firstFunctionRelationshipsTitle = firstFunctionRelationshipsTitle
        notifyPropertyChanged(BR.firstFunctionRelationshipsTitle)
    }

    @Bindable
    fun getSecondFunctionRelationshipsTitle(): CharSequence? {
        return secondFunctionRelationshipsTitle
    }

    private fun setSecondFunctionRelationshipsTitle(secondFunctionRelationshipsTitle: CharSequence?) {
        this.secondFunctionRelationshipsTitle = secondFunctionRelationshipsTitle
        notifyPropertyChanged(BR.secondFunctionRelationshipsTitle)
    }

    @Bindable
    fun getThirdFunctionRelationshipsTitle(): CharSequence? {
        return thirdFunctionRelationshipsTitle
    }

    private fun setThirdFunctionRelationshipsTitle(thirdFunctionRelationshipsTitle: CharSequence?) {
        this.thirdFunctionRelationshipsTitle = thirdFunctionRelationshipsTitle
        notifyPropertyChanged(BR.thirdFunctionRelationshipsTitle)
    }

    @Bindable
    fun getForthFunctionRelationshipsTitle(): CharSequence? {
        return forthFunctionRelationshipsTitle
    }

    private fun setForthFunctionRelationshipsTitle(forthFunctionRelationshipsTitle: CharSequence?) {
        this.forthFunctionRelationshipsTitle = forthFunctionRelationshipsTitle
        notifyPropertyChanged(BR.forthFunctionRelationshipsTitle)
    }

    @Bindable
    fun getImageAndHintVisibility(): Int {
        return imageAndHintVisibility
    }

    fun setImageAndHintVisibility(imageAndHintVisibility: Int) {
        this.imageAndHintVisibility = imageAndHintVisibility
        notifyPropertyChanged(BR.imageAndHintVisibility)
    }

    private fun fromHml(charSequence: CharSequence?): CharSequence {
        if (charSequence != null && charSequence is String) {
            return Html.fromHtml(charSequence)
        }
        return charSequence ?: ""
    }
}