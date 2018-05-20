package com.laushkina.anastasia.psychosophy.view.test;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.laushkina.anastasia.psychosophy.BR;

public class TestViewModel extends BaseObservable {
    private Boolean isNextEnabled;
    private Boolean isPrevEnabled;
    private int progress;
    private CharSequence nextButtonText;
    private CharSequence prevButtonText;

    TestViewModel(CharSequence nextButtonText){
        this();
        this.nextButtonText = nextButtonText;
    }

    private TestViewModel(){
        isNextEnabled = false;
        isPrevEnabled = false;
        progress = 0;
    }

    @Bindable
    public boolean isNextEnabled() {
        return isNextEnabled;
    }

    public void setNextEnabled(boolean nextEnabled) {
        isNextEnabled = nextEnabled;
        notifyPropertyChanged(BR.nextEnabled);
    }

    @Bindable
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        notifyPropertyChanged(BR.progress);
    }

    @Bindable
    public CharSequence getNextButtonText() {
        return nextButtonText;
    }

    public void setNextButtonText(CharSequence nextButtonText) {
        this.nextButtonText = nextButtonText;
        notifyPropertyChanged(BR.nextButtonText);
    }

    @Bindable
    public CharSequence getPrevButtonText() {
        return prevButtonText;
    }

    public void setPrevButtonText(CharSequence prevButtonText) {
        this.prevButtonText = prevButtonText;
        notifyPropertyChanged(BR.prevButtonText);
    }

    @Bindable
    public Boolean getPrevEnabled() {
        return isPrevEnabled;
    }

    public void setPrevEnabled(Boolean prevEnabled) {
        isPrevEnabled = prevEnabled;
        notifyPropertyChanged(BR.prevEnabled);
    }
}
