package com.laushkina.anastasia.psychosophy.domain.test;

public enum TestAnswer {
    Yes(4),
    Maybe(3),
    Sometimes(2),
    No(1);

    private final int number;
    TestAnswer(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
