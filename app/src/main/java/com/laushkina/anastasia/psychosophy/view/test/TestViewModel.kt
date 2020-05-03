package com.laushkina.anastasia.psychosophy.view.test

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.laushkina.anastasia.psychosophy.BR

class TestViewModel(private var isNextEnabled: Boolean,
                    private var isPrevEnabled: Boolean,
                    private var progress: Int): BaseObservable() {

    private lateinit var nextButtonText: CharSequence
    private var prevButtonText: CharSequence = ""

    constructor(): this(false, false, 0)

    @Bindable
    fun isNextEnabled(): Boolean {
        return isNextEnabled
    }

    fun setNextEnabled(nextEnabled: Boolean) {
        this.isNextEnabled = nextEnabled
        notifyPropertyChanged(BR.nextEnabled)
    }

    @Bindable
    fun getProgress(): Int {
        return progress
    }

    fun setProgress(progress: Int) {
        this.progress = progress
        notifyPropertyChanged(BR.progress)
    }

    @Bindable
    fun getNextButtonText(): CharSequence {
        return nextButtonText
    }

    fun setNextButtonText(nextButtonText: CharSequence) {
        this.nextButtonText = nextButtonText
        notifyPropertyChanged(BR.nextButtonText)
    }

    @Bindable
    fun getPrevButtonText(): CharSequence {
        return prevButtonText
    }

    fun setPrevButtonText(prevButtonText: CharSequence) {
        this.prevButtonText = prevButtonText
        notifyPropertyChanged(BR.prevButtonText)
    }

    @Bindable
    fun getPrevEnabled(): Boolean? {
        return isPrevEnabled
    }

    fun setPrevEnabled(prevEnabled: Boolean) {
        this.isPrevEnabled = prevEnabled
        notifyPropertyChanged(BR.prevEnabled)
    }
}