package com.laushkina.anastasia.psychosophy.domain.test;

public enum Function {
    Logic(0),
    Emotion(1),
    Physics(2),
    Will(3);

    private final int i;

    Function(int i) {
        this.i = i;
    }

    public int getNumber(){
        return i;
    }

    public Character shortName(){
        return name().toCharArray()[0];
    }
}
