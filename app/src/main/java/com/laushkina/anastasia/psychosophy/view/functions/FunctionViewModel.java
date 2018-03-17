package com.laushkina.anastasia.psychosophy.view.functions;

import android.graphics.drawable.Drawable;

public class FunctionViewModel {
    private String functionDescription;
    private Drawable functionImage;
    private String emotionTitle;
    private String logicTitle;
    private String physicsTitle;
    private String willTitle;

    private FunctionViewModel(Builder builder) {
        functionDescription = builder.functionDescription;
        functionImage = builder.functionImage;
        emotionTitle = builder.emotionTitle;
        logicTitle = builder.logicTitle;
        physicsTitle = builder.physicsTitle;
        willTitle = builder.willTitle;
    }

    public String getFunctionDescription() {
        return functionDescription;
    }

    public Drawable getFunctionImage() {
        return functionImage;
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
        private String functionDescription;
        private Drawable functionImage;
        private String emotionTitle;
        private String logicTitle;
        private String physicsTitle;
        private String willTitle;

        public Builder() {}

        public Builder functionDescription(String functionDescription) {
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
