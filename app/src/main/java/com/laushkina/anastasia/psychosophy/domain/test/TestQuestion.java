package com.laushkina.anastasia.psychosophy.domain.test;

import android.os.Parcel;
import android.os.Parcelable;

public class TestQuestion implements Parcelable {
    private String text;
    private Function type;
    private TestAnswer answer;

    public TestQuestion(String text, Function type) {
        this.text = text;
        this.type = type;
    }

    public TestQuestion(String text, Function type, TestAnswer answer) {
        this.text = text;
        this.type = type;
        this.answer = answer;
    }

    protected TestQuestion(Parcel in) {
        text = in.readString();

        String function = in.readString();
        type = function == null ? null : Function.valueOf(function);

        String testAnswer = in.readString();
        answer = testAnswer == null ? null : TestAnswer.valueOf(testAnswer);
    }

    public static final Creator<TestQuestion> CREATOR = new Creator<TestQuestion>() {
        @Override
        public TestQuestion createFromParcel(Parcel in) {
            return new TestQuestion(in);
        }

        @Override
        public TestQuestion[] newArray(int size) {
            return new TestQuestion[size];
        }
    };

    public void setAnswer(TestAnswer answer) {
        this.answer = answer;
    }

    public String getText(){
        return text;
    }

    public Function getType(){
        return type;
    }

    public TestAnswer getAnswer(){
        return answer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeString(type == null ? null : type.name());
        parcel.writeString(answer == null ? null : answer.name());
    }
}
