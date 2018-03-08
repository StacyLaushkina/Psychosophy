package com.laushkina.anastasia.psychosophy.domain.test;

public enum Function {
    Logic,
    Emotion,
    Physics,
    Will;

    public Character shortName(){
        return name().toCharArray()[0];
    }
}
