package com.laushkina.anastasia.psychosophy.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.laushkina.anastasia.psychosophy.domain.test.Function;

public enum Psychotype implements Parcelable {
    Augustine(new Function[]{Function.Logic, Function.Emotion, Function.Physics, Function.Will}),
    Pascal(new Function[]{Function.Logic, Function.Emotion, Function.Will, Function.Physics}),
    Berthier(new Function[]{Function.Logic, Function.Physics, Function.Emotion, Function.Will}),
    Plato(new Function[]{Function.Logic, Function.Physics, Function.Will, Function.Emotion}),
    Lao(new Function[]{Function.Logic, Function.Will, Function.Physics, Function.Emotion}),
    Einstein(new Function[]{Function.Logic, Function.Will, Function.Emotion, Function.Physics}),

    Anderson(new Function[]{Function.Emotion, Function.Logic, Function.Will, Function.Physics}),
    Rousseau(new Function[]{Function.Emotion, Function.Logic, Function.Physics, Function.Will}),
    Bukharin(new Function[]{Function.Emotion, Function.Physics, Function.Logic, Function.Will}),
    Pushkin(new Function[]{Function.Emotion, Function.Physics, Function.Will, Function.Logic}),
    Ghazali(new Function[]{Function.Emotion, Function.Will, Function.Logic, Function.Physics}),
    Parsnip(new Function[]{Function.Emotion, Function.Will, Function.Physics, Function.Logic}),

    Aristippus(new Function[]{Function.Physics, Function.Logic, Function.Will, Function.Emotion}),
    Epicurus(new Function[]{Function.Physics, Function.Logic, Function.Emotion, Function.Will}),
    Borgia(new Function[]{Function.Physics, Function.Emotion, Function.Logic, Function.Will}),
    Dumas(new Function[]{Function.Physics, Function.Emotion, Function.Will, Function.Logic}),
    Goethe(new Function[]{Function.Physics, Function.Will, Function.Logic, Function.Emotion}),
    Chekhov(new Function[]{Function.Physics, Function.Will, Function.Emotion, Function.Logic}),

    Akhmatova(new Function[]{Function.Will, Function.Emotion, Function.Logic, Function.Physics}),
    Tolstoy(new Function[]{Function.Will, Function.Emotion, Function.Physics, Function.Logic}),
    Lenin(new Function[]{Function.Will, Function.Logic, Function.Physics, Function.Emotion}),
    Socrates(new Function[]{Function.Will, Function.Logic, Function.Emotion, Function.Physics}),
    Napoleon(new Function[]{Function.Will, Function.Physics, Function.Logic, Function.Emotion}),
    Twardowski(new Function[]{Function.Will, Function.Physics, Function.Emotion, Function.Logic});

    private Function[] functions;

    Psychotype(Function[] functions){
        this.functions = functions;
    }

    static Psychotype resolve(Parcel in) {
        return valueOf(in.readString());
    }

    public boolean areFunctionsEqual(Function[] functions){
        return functions.length == 4 &&
                this.functions[0] == functions[0] &&
                this.functions[1] == functions[1] &&
                this.functions[2] == functions[2] &&
                this.functions[3] == functions[3];
    }

    public static Psychotype resolve(Function[] functions){
        Psychotype foundType = null;
        for (Psychotype psychotype: values()) {
            if (psychotype.areFunctionsEqual(functions)) {
                foundType = psychotype;
            }
        }
        return foundType;
    }

    public Function[] getFunctions(){
        return functions;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Psychotype> CREATOR = new Creator<Psychotype>() {
        @Override
        public Psychotype createFromParcel(Parcel in) {
            return Psychotype.resolve(in);
        }

        @Override
        public Psychotype[] newArray(int size) {
            return new Psychotype[size];
        }
    };
}
