package com.laushkina.anastasia.psychosophy.domain.test

enum class PsychoFunction(val i: Int) {
    Logic(0),
    Emotion(1),
    Physics(2),
    Will(3);

    fun getNumber(): Int {
        return i
    }

    fun shortName(): Char? {
        return name.toCharArray()[0]
    }
}