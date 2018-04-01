package com.laushkina.anastasia.psychosophy.view.functions;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;

import com.laushkina.anastasia.psychosophy.BR;

public class FunctionViewModel extends BaseObservable {
    private CharSequence functionTitle;
    private CharSequence functionDescription;
    private Drawable functionImage;
    private String emotionTitle;
    private String logicTitle;
    private String physicsTitle;
    private String willTitle;

    private FunctionViewModel(Builder builder) {
        functionTitle = builder.functionTitle;
        functionDescription = builder.functionDescription;
        functionImage = builder.functionImage;
        emotionTitle = builder.emotionTitle;
        logicTitle = builder.logicTitle;
        physicsTitle = builder.physicsTitle;
        willTitle = builder.willTitle;
    }

    @Bindable
    public CharSequence getFunctionTitle() {
        return functionTitle;
    }

    void setFunctionTitle(CharSequence functionTitle) {
        this.functionTitle = functionTitle;
        notifyPropertyChanged(BR.functionTitle);
    }

    @Bindable
    public CharSequence getFunctionDescription() {
        return functionDescription;
    }

    void setFunctionDescription(CharSequence functionDescription) {
        this.functionDescription = functionDescription;
        notifyPropertyChanged(BR.functionDescription);
    }

    @Bindable
    public Drawable getFunctionImage() {
        return functionImage;
    }

    void setFunctionImage(Drawable functionImage) {
        this.functionImage = functionImage;
        notifyPropertyChanged(BR.functionImage);
    }

    public String getEmotionTitle() {
        return emotionTitle;
    }

    public String getLogicTitle() {
        return logicTitle;
    }

    public String getPhysicsTitle() {
        return physicsTitle;
    }

    public String getWillTitle() {
        return willTitle;
    }

    public static class Builder {
        private CharSequence functionTitle;
        private CharSequence functionDescription;
        private Drawable functionImage;
        private String emotionTitle;
        private String logicTitle;
        private String physicsTitle;
        private String willTitle;

        public Builder() {}

        public Builder functionTitle(CharSequence functionTitle){
            this.functionTitle = functionTitle;
            return this;
        }

        public Builder functionDescription(CharSequence functionDescription) {
            this.functionDescription = functionDescription;
            return this;
        }

        public Builder functionImage(Drawable functionImage) {
            this.functionImage = functionImage;
            return this;
        }

        public Builder emotionTitle(String emotionTitle) {
            this.emotionTitle = emotionTitle;
            return this;
        }

        public Builder logicTitle(String logicTitle) {
            this.logicTitle = logicTitle;
            return this;
        }

        public Builder physicsTitle(String physicsTitle) {
            this.physicsTitle = physicsTitle;
            return this;
        }

        public Builder willTitle(String willTitle) {
            this.willTitle = willTitle;
            return this;
        }

        public FunctionViewModel build() {
            return new FunctionViewModel(this);
        }
    }
}
