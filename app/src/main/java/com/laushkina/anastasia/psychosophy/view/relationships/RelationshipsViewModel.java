package com.laushkina.anastasia.psychosophy.view.relationships;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.opengl.Visibility;
import android.text.Html;
import android.view.View;

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

    private int imageAndHintVisibility;

    RelationshipsViewModel(){
        firstFunctionRelationshipsTitle = "";
        firstFunctionRelationships = "";
        secondFunctionRelationshipsTitle = "";
        secondFunctionRelationships = "";
        thirdFunctionRelationshipsTitle = "";
        thirdFunctionRelationships = "";
        forthFunctionRelationshipsTitle = "";
        forthFunctionRelationships = "";
        imageAndHintVisibility = View.VISIBLE;
    }

    //TODO builder?
    RelationshipsViewModel(String firstTitle, String firstDescription,
                           String secondTitle, String secondDescription,
                           String thirdTitle, String thirdDescription,
                           String forthTitle, String forthDescription,
                           int imageAndHintVisibility){
        setFirstFunctionRelationshipsTitle(firstTitle);
        setFirstFunctionRelationships(firstDescription);
        setSecondFunctionRelationshipsTitle(secondTitle);
        setSecondFunctionRelationships(secondDescription);
        setThirdFunctionRelationshipsTitle(thirdTitle);
        setThirdFunctionRelationships(thirdDescription);
        setForthFunctionRelationshipsTitle(forthTitle);
        setForthFunctionRelationships(forthDescription);
        setImageAndHintVisibility(imageAndHintVisibility);
    }

    public void refreshWith(RelationshipsViewModel newValue){
        setFirstFunctionRelationshipsTitle(newValue.firstFunctionRelationshipsTitle);
        setFirstFunctionRelationships(newValue.firstFunctionRelationships);
        setSecondFunctionRelationshipsTitle(newValue.secondFunctionRelationshipsTitle);
        setSecondFunctionRelationships(newValue.secondFunctionRelationships);
        setThirdFunctionRelationshipsTitle(newValue.thirdFunctionRelationshipsTitle);
        setThirdFunctionRelationships(newValue.thirdFunctionRelationships);
        setForthFunctionRelationshipsTitle(newValue.forthFunctionRelationshipsTitle);
        setForthFunctionRelationships(newValue.forthFunctionRelationships);
    }

    @Bindable
    public CharSequence getFirstFunctionRelationships() {
        return firstFunctionRelationships;
    }

    private void setFirstFunctionRelationships(String firstFunctionRelationships) {
        setFirstFunctionRelationships(Html.fromHtml(firstFunctionRelationships));
    }

    private void setFirstFunctionRelationships(CharSequence firstFunctionRelationships) {
        this.firstFunctionRelationships = firstFunctionRelationships;
        notifyPropertyChanged(BR.firstFunctionRelationships);
    }

    @Bindable
    public CharSequence getSecondFunctionRelationships() {
        return secondFunctionRelationships;
    }

    private void setSecondFunctionRelationships(String secondFunctionRelationships) {
        setSecondFunctionRelationships(Html.fromHtml(secondFunctionRelationships));
    }

    private void setSecondFunctionRelationships(CharSequence secondFunctionRelationships) {
        this.secondFunctionRelationships = secondFunctionRelationships;
        notifyPropertyChanged(BR.secondFunctionRelationships);
    }

    @Bindable
    public CharSequence getThirdFunctionRelationships() {
        return thirdFunctionRelationships;
    }

    private void setThirdFunctionRelationships(String thirdFunctionRelationships) {
        setThirdFunctionRelationships(Html.fromHtml(thirdFunctionRelationships));
    }

    private void setThirdFunctionRelationships(CharSequence thirdFunctionRelationships) {
        this.thirdFunctionRelationships = thirdFunctionRelationships;
        notifyPropertyChanged(BR.thirdFunctionRelationships);
    }

    @Bindable
    public CharSequence getForthFunctionRelationships() {
        return forthFunctionRelationships;
    }

    private void setForthFunctionRelationships(String forthFunctionRelationships) {
        setForthFunctionRelationships(Html.fromHtml(forthFunctionRelationships));
    }

    private void setForthFunctionRelationships(CharSequence forthFunctionRelationships) {
        this.forthFunctionRelationships = forthFunctionRelationships;
        notifyPropertyChanged(BR.forthFunctionRelationships);
    }

    @Bindable
    public CharSequence getFirstFunctionRelationshipsTitle() {
        return firstFunctionRelationshipsTitle;
    }

    private void setFirstFunctionRelationshipsTitle(String firstFunctionRelationshipsTitle) {
        setFirstFunctionRelationshipsTitle(Html.fromHtml(firstFunctionRelationshipsTitle));
    }

    private void setFirstFunctionRelationshipsTitle(CharSequence firstFunctionRelationshipsTitle) {
        this.firstFunctionRelationshipsTitle = firstFunctionRelationshipsTitle;
        notifyPropertyChanged(BR.firstFunctionRelationshipsTitle);
    }

    @Bindable
    public CharSequence getSecondFunctionRelationshipsTitle() {
        return secondFunctionRelationshipsTitle;
    }

    private void setSecondFunctionRelationshipsTitle(String secondFunctionRelationshipsTitle) {
        setSecondFunctionRelationshipsTitle(Html.fromHtml(secondFunctionRelationshipsTitle));
    }

    private void setSecondFunctionRelationshipsTitle(CharSequence secondFunctionRelationshipsTitle) {
        this.secondFunctionRelationshipsTitle = secondFunctionRelationshipsTitle;
        notifyPropertyChanged(BR.secondFunctionRelationshipsTitle);
    }

    @Bindable
    public CharSequence getThirdFunctionRelationshipsTitle() {
        return thirdFunctionRelationshipsTitle;
    }

    private void setThirdFunctionRelationshipsTitle(String thirdFunctionRelationshipsTitle) {
        setThirdFunctionRelationshipsTitle(Html.fromHtml(thirdFunctionRelationshipsTitle));
    }

    private void setThirdFunctionRelationshipsTitle(CharSequence thirdFunctionRelationshipsTitle) {
        this.thirdFunctionRelationshipsTitle = thirdFunctionRelationshipsTitle;
        notifyPropertyChanged(BR.thirdFunctionRelationshipsTitle);
    }

    @Bindable
    public CharSequence getForthFunctionRelationshipsTitle() {
        return forthFunctionRelationshipsTitle;
    }

    private void setForthFunctionRelationshipsTitle(String forthFunctionRelationshipsTitle) {
        setForthFunctionRelationshipsTitle(Html.fromHtml(forthFunctionRelationshipsTitle));
    }

    private void setForthFunctionRelationshipsTitle(CharSequence forthFunctionRelationshipsTitle) {
        this.forthFunctionRelationshipsTitle = forthFunctionRelationshipsTitle;
        notifyPropertyChanged(BR.forthFunctionRelationshipsTitle);
    }

    @Bindable
    public int getImageAndHintVisibility() {
        return imageAndHintVisibility;
    }

    public void setImageAndHintVisibility(int imageAndHintVisibility) {
        this.imageAndHintVisibility = imageAndHintVisibility;
        notifyPropertyChanged(BR.imageAndHintVisibility);
    }
}
