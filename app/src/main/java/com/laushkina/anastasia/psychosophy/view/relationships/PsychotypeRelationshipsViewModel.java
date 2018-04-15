package com.laushkina.anastasia.psychosophy.view.relationships;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Html;

import com.laushkina.anastasia.psychosophy.BR;

public class PsychotypeRelationshipsViewModel extends BaseObservable {
    private CharSequence firstFunctionRelationshipsTitle;
    private CharSequence firstFunctionRelationships;
    private CharSequence secondFunctionRelationshipsTitle;
    private CharSequence secondFunctionRelationships;
    private CharSequence thirdFunctionRelationshipsTitle;
    private CharSequence thirdFunctionRelationships;
    private CharSequence forthFunctionRelationshipsTitle;
    private CharSequence forthFunctionRelationships;

    PsychotypeRelationshipsViewModel(){}

    @Bindable
    public CharSequence getFirstFunctionRelationships() {
        return firstFunctionRelationships;
    }

    public void setFirstFunctionRelationships(String firstFunctionRelationships) {
        this.firstFunctionRelationships = Html.fromHtml(firstFunctionRelationships);
        notifyPropertyChanged(BR.firstFunctionRelationships);
    }

    @Bindable
    public CharSequence getSecondFunctionRelationships() {
        return secondFunctionRelationships;
    }

    public void setSecondFunctionRelationships(String secondFunctionRelationships) {
        this.secondFunctionRelationships = Html.fromHtml(secondFunctionRelationships);
        notifyPropertyChanged(BR.secondFunctionRelationships);
    }

    @Bindable
    public CharSequence getThirdFunctionRelationships() {
        return thirdFunctionRelationships;
    }

    public void setThirdFunctionRelationships(String thirdFunctionRelationships) {
        this.thirdFunctionRelationships = Html.fromHtml(thirdFunctionRelationships);
        notifyPropertyChanged(BR.thirdFunctionRelationships);
    }

    @Bindable
    public CharSequence getForthFunctionRelationships() {
        return forthFunctionRelationships;
    }

    public void setForthFunctionRelationships(String forthFunctionRelationships) {
        this.forthFunctionRelationships = Html.fromHtml(forthFunctionRelationships);
        notifyPropertyChanged(BR.forthFunctionRelationships);
    }

    @Bindable
    public CharSequence getFirstFunctionRelationshipsTitle() {
        return firstFunctionRelationshipsTitle;
    }

    public void setFirstFunctionRelationshipsTitle(CharSequence firstFunctionRelationshipsTitle) {
        this.firstFunctionRelationshipsTitle = firstFunctionRelationshipsTitle;
        notifyPropertyChanged(BR.firstFunctionRelationshipsTitle);
    }

    @Bindable
    public CharSequence getSecondFunctionRelationshipsTitle() {
        return secondFunctionRelationshipsTitle;
    }

    public void setSecondFunctionRelationshipsTitle(CharSequence secondFunctionRelationshipsTitle) {
        this.secondFunctionRelationshipsTitle = secondFunctionRelationshipsTitle;
        notifyPropertyChanged(BR.secondFunctionRelationshipsTitle);
    }

    @Bindable
    public CharSequence getThirdFunctionRelationshipsTitle() {
        return thirdFunctionRelationshipsTitle;
    }

    public void setThirdFunctionRelationshipsTitle(CharSequence thirdFunctionRelationshipsTitle) {
        this.thirdFunctionRelationshipsTitle = thirdFunctionRelationshipsTitle;
        notifyPropertyChanged(BR.thirdFunctionRelationshipsTitle);
    }

    @Bindable
    public CharSequence getForthFunctionRelationshipsTitle() {
        return forthFunctionRelationshipsTitle;
    }

    public void setForthFunctionRelationshipsTitle(CharSequence forthFunctionRelationshipsTitle) {
        this.forthFunctionRelationshipsTitle = forthFunctionRelationshipsTitle;
        notifyPropertyChanged(BR.forthFunctionRelationshipsTitle);
    }
}
