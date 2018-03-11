package com.laushkina.anastasia.psychosophy.view.psychotypeDescription;

import android.graphics.drawable.Drawable;

public class DescriptionViewModel {
    private String firstFunctionDescription;
    private String secondFunctionDescription;
    private String thirdFunctionDescription;
    private String forthFunctionDescription;
    private String shortDescription;
    private Drawable image;

    private DescriptionViewModel(Builder builder) {
        firstFunctionDescription = builder.firstFunctionDescription;
        secondFunctionDescription = builder.secondFunctionDescription;
        thirdFunctionDescription = builder.thirdFunctionDescription;
        forthFunctionDescription = builder.forthFunctionDescription;
        shortDescription = builder.shortDescription;
        image = builder.image;
    }

    public String getFirstFunctionDescription() {
        return firstFunctionDescription;
    }

    public String getSecondFunctionDescription() {
        return secondFunctionDescription;
    }

    public String getThirdFunctionDescription() {
        return thirdFunctionDescription;
    }

    public String getForthFunctionDescription() {
        return forthFunctionDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Drawable getImage() {
        return image;
    }

    public static class Builder {
        private String firstFunctionDescription;
        private String secondFunctionDescription;
        private String thirdFunctionDescription;
        private String forthFunctionDescription;
        private String shortDescription;
        private Drawable image;

        public Builder() {}

        public Builder firstFunctionDescription(String firstFunctionDescription) {
            this.firstFunctionDescription = firstFunctionDescription;
            return this;
        }

        public Builder secondFunctionDescription(String secondFunctionDescription) {
            this.secondFunctionDescription = secondFunctionDescription;
            return this;
        }

        public Builder thirdFunctionDescription(String thirdFunctionDescription) {
            this.thirdFunctionDescription = thirdFunctionDescription;
            return this;
        }

        public Builder forthFunctionDescription(String forthFunctionDescription) {
            this.forthFunctionDescription = forthFunctionDescription;
            return this;
        }

        public Builder shortDescription(String shortDescription) {
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
