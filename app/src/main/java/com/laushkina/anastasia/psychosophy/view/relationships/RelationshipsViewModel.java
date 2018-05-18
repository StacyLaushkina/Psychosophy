package com.laushkina.anastasia.psychosophy.view.relationships;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Html;

import com.laushkina.anastasia.psychosophy.BR;

public class RelationshipsViewModel extends BaseObservable {
    private CharSequence firstFunctionRelationshipsTitle;
    private CharSequence firstFunctionRelationships;
    private CharSequence secondFunctionRelationshipsTitle;
    private CharSequence secondFunctionRelationships;
    private CharSequence thirdFunctionRelationshipsTitle;
    private CharSequence thirdFunctionRelationships;
    private CharSequence forthFunctionRelationshipsTitle;
    private CharSequence forthFunctionRelationships;

    RelationshipsViewModel(){
        firstFunctionRelationshipsTitle = "";
        firstFunctionRelationships = "";
        secondFunctionRelationshipsTitle = "";
        secondFunctionRelationships = "";
        thirdFunctionRelationshipsTitle = "";
        thirdFunctionRelationships = "";
        forthFunctionRelationshipsTitle = "";
        forthFunctionRelationships = "";
    }

    //TODO builder?
    RelationshipsViewModel(String firstTitle, String firstDescription,
                           String secondTitle, String secondDescription,
                           String thirdTitle, String thirdDescription,
                           String forthTitle, String forthDescription){
        setFirstFunctionRelationshipsTitle(firstTitle);
        setFirstFunctionRelationships(firstDescription);
        setSecondFunctionRelationshipsTitle(secondTitle);
        setSecondFunctionRelationships(secondDescription);
        setThirdFunctionRelationshipsTitle(thirdTitle);
        setThirdFunctionRelationships(thirdDescription);
        setForthFunctionRelationshipsTitle(forthTitle);
        setForthFunctionRelationships(forthDescription);
    }

    public void refreshWith(RelationshipsViewModel newValue){
        setFirstFunctionRelationshipsTitle(newValue.firstFunctionRelationshipsTitle.toString());
        setFirstFunctionRelationships(newValue.firstFunctionRelationships.toString());
        setSecondFunctionRelationshipsTitle(newValue.secondFunctionRelationshipsTitle.toString());
        setSecondFunctionRelationships(newValue.secondFunctionRelationships.toString());
        setThirdFunctionRelationshipsTitle(newValue.thirdFunctionRelationshipsTitle.toString());
        setThirdFunctionRelationships(newValue.thirdFunctionRelationships.toString());
        setForthFunctionRelationshipsTitle(newValue.forthFunctionRelationshipsTitle.toString());
        setForthFunctionRelationships(newValue.forthFunctionRelationships.toString());
    }

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

    public void setFirstFunctionRelationshipsTitle(String firstFunctionRelationshipsTitle) {
        this.firstFunctionRelationshipsTitle = Html.fromHtml(firstFunctionRelationshipsTitle);
        notifyPropertyChanged(BR.firstFunctionRelationshipsTitle);
    }

    @Bindable
    public CharSequence getSecondFunctionRelationshipsTitle() {
        return secondFunctionRelationshipsTitle;
    }

    public void setSecondFunctionRelationshipsTitle(String secondFunctionRelationshipsTitle) {
        this.secondFunctionRelationshipsTitle = Html.fromHtml(secondFunctionRelationshipsTitle);
        notifyPropertyChanged(BR.secondFunctionRelationshipsTitle);
    }

    @Bindable
    public CharSequence getThirdFunctionRelationshipsTitle() {
        return thirdFunctionRelationshipsTitle;
    }

    public void setThirdFunctionRelationshipsTitle(String thirdFunctionRelationshipsTitle) {
        this.thirdFunctionRelationshipsTitle = Html.fromHtml(thirdFunctionRelationshipsTitle);
        notifyPropertyChanged(BR.thirdFunctionRelationshipsTitle);
    }

    @Bindable
    public CharSequence getForthFunctionRelationshipsTitle() {
        return forthFunctionRelationshipsTitle;
    }

    public void setForthFunctionRelationshipsTitle(String forthFunctionRelationshipsTitle) {
        this.forthFunctionRelationshipsTitle = Html.fromHtml(forthFunctionRelationshipsTitle);
        notifyPropertyChanged(BR.forthFunctionRelationshipsTitle);
    }
}
