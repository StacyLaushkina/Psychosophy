package com.laushkina.anastasia.psychosophy.domain.test;

public class Question {
    private String text;
    private Function type;
    private QuestionAnswer answer;

    public Question(String text, Function type) {
        this.text = text;
        this.type = type;
    }

    public Question(String text, Function type, QuestionAnswer answer) {
        this.text = text;
        this.type = type;
        this.answer = answer;
    }

    public void setAnswer(QuestionAnswer answer) {
        this.answer = answer;
    }

    public String getText(){
        return text;
    }

    public Function getType(){
        return type;
    }

    public QuestionAnswer getAnswer(){
        return answer;
    }

}
