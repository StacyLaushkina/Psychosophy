package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.graphics.drawable.Drawable;

public class DescriptionViewModel {
    private CharSequence firstFunctionDescription;
    private CharSequence secondFunctionDescription;
    private CharSequence thirdFunctionDescription;
    private CharSequence forthFunctionDescription;
    private CharSequence shortDescription;
    private Drawable image;

    private DescriptionViewModel(Builder builder) {
        firstFunctionDescription = builder.firstFunctionDescription;
        secondFunctionDescription = builder.secondFunctionDescription;
        thirdFunctionDescription = builder.thirdFunctionDescription;
        forthFunctionDescription = builder.forthFunctionDescription;
        shortDescription = builder.shortDescription;
        image = builder.image;
    }

    public CharSequence getFirstFunctionDescription() {
        return firstFunctionDescription;
    }

    public CharSequence getSecondFunctionDescription() {
        return secondFunctionDescription;
    }

    public CharSequence getThirdFunctionDescription() {
        return thirdFunctionDescription;
    }

    public CharSequence getForthFunctionDescription() {
        return forthFunctionDescription;
    }

    public CharSequence getShortDescription() {
        return shortDescription;
    }

    public Drawable getImage() {
        return image;
    }

    public static class Builder {
        private CharSequence firstFunctionDescription;
        private CharSequence secondFunctionDescription;
        private CharSequence thirdFunctionDescription;
        private CharSequence forthFunctionDescription;
        private CharSequence shortDescription;
        private Drawable image;

        public Builder() {}

        public Builder firstFunctionDescription(CharSequence firstFunctionDescription) {
            this.firstFunctionDescription = firstFunctionDescription;
            return this;
        }

        public Builder secondFunctionDescription(CharSequence secondFunctionDescription) {
            this.secondFunctionDescription = secondFunctionDescription;
            return this;
        }

        public Builder thirdFunctionDescription(CharSequence thirdFunctionDescription) {
            this.thirdFunctionDescription = thirdFunctionDescription;
            return this;
        }

        public Builder forthFunctionDescription(CharSequence forthFunctionDescription) {
            this.forthFunctionDescription = forthFunctionDescription;
            return this;
        }

        public Builder shortDescription(CharSequence shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public Builder image(Drawable image) {
            this.image = image;
            return this;
        }

        public DescriptionViewModel build() {
            return new DescriptionViewModel(this);
        }
    }
}
