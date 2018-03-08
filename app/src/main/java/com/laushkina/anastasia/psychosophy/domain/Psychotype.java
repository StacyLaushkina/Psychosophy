package com.laushkina.anastasia.psychosophy.domain;

import com.laushkina.anastasia.psychosophy.domain.test.Function;

public enum Psychotype {
    LEPW("Augustine", new Function[]{Function.Logic, Function.Emotion, Function.Physics, Function.Will}),
    LEWP("Pascal", new Function[]{Function.Logic, Function.Emotion, Function.Will, Function.Physics}),
    LPEW("Berthier", new Function[]{Function.Logic, Function.Physics, Function.Emotion, Function.Will}),
    LPWE("Plato", new Function[]{Function.Logic, Function.Physics, Function.Will, Function.Emotion}),
    LWPE("Lao", new Function[]{Function.Logic, Function.Will, Function.Physics, Function.Emotion}),
    LWEP("Einstein", new Function[]{Function.Logic, Function.Will, Function.Emotion, Function.Physics}),

    ELWP("Anderson", new Function[]{Function.Emotion, Function.Logic, Function.Will, Function.Physics}),
    ELPW("Rousseau", new Function[]{Function.Emotion, Function.Logic, Function.Physics, Function.Will}),
    EPLW("Bukharin", new Function[]{Function.Emotion, Function.Physics, Function.Logic, Function.Will}),
    EPWL("Pushkin", new Function[]{Function.Emotion, Function.Physics, Function.Will, Function.Logic}),
    EWLP("Ghazali", new Function[]{Function.Emotion, Function.Will, Function.Logic, Function.Physics}),
    EWPL("Parsnip", new Function[]{Function.Emotion, Function.Will, Function.Physics, Function.Logic}),

    PLWE("Aristippus", new Function[]{Function.Physics, Function.Logic, Function.Will, Function.Emotion}),
    PLEW("Epicurus", new Function[]{Function.Physics, Function.Logic, Function.Emotion, Function.Will}),
    PELW("Borgia", new Function[]{Function.Physics, Function.Emotion, Function.Logic, Function.Will}),
    PEWL("Dumas", new Function[]{Function.Physics, Function.Emotion, Function.Will, Function.Logic}),
    PWLE("Goethe", new Function[]{Function.Physics, Function.Will, Function.Logic, Function.Emotion}),
    PWEL("Chekhov", new Function[]{Function.Physics, Function.Will, Function.Emotion, Function.Logic}),

    WELP("Akhmatova", new Function[]{Function.Will, Function.Emotion, Function.Logic, Function.Physics}),
    WEPL("Tolstoy", new Function[]{Function.Will, Function.Emotion, Function.Physics, Function.Logic}),
    WLPE("Lenin", new Function[]{Function.Will, Function.Logic, Function.Physics, Function.Emotion}),
    WLEP("Socrates", new Function[]{Function.Will, Function.Logic, Function.Emotion, Function.Physics}),
    WPLE("Napoleon", new Function[]{Function.Will, Function.Physics, Function.Logic, Function.Emotion}),
    WPEL("Twardowski", new Function[]{Function.Will, Function.Physics, Function.Emotion, Function.Logic});


    private String name;
    private Function[] functions;

    Psychotype(String name, Function[] functions) {
        this.name = name;
        this.functions = functions;
    }

    public static String[] names(){
        return new String[] {
                "Augustine",
                "Pascal",
                "Berthier",
                "Plato",
                "Lao",
                "Einstein",

                "Anderson",
                "Rousseau",
                "Bukharin",
                "Pushkin",
                "Ghazali",
                "Parsnip",

                "Aristippus",
                "Epicurus",
                "Borgia",
                "Dumas",
                "Goethe",
                "Chekhov",

                "Akhmatova",
                "Tolstoy",
                "Lenin",
                "Socrates",
                "Napoleon",
                "Twardowski"
        };
    }

    public Function[] asFunctionsArray(){
        return functions;
    }

    public static Psychotype resolve(Function[] functions){
        if (functions == null || functions.length != 4) return null;

        //TODO redo
        if (functions[0] == Function.Logic && functions[1] == Function.Emotion &&
            functions[2] == Function.Physics && functions[3] == Function.Will ) return LEPW;

        if (functions[0] == Function.Logic && functions[1] == Function.Emotion &&
                functions[2] == Function.Will && functions[3] == Function.Physics ) return LEWP;

        if (functions[0] == Function.Logic && functions[1] == Function.Physics &&
                functions[2] == Function.Emotion && functions[3] == Function.Will ) return LPEW;

        if (functions[0] == Function.Logic && functions[1] == Function.Physics &&
                functions[2] == Function.Will && functions[3] == Function.Emotion ) return LPWE;

        if (functions[0] == Function.Emotion && functions[1] == Function.Logic &&
                functions[2] == Function.Will && functions[3] == Function.Physics ) return ELWP;

        if (functions[0] == Function.Physics && functions[1] == Function.Logic &&
                functions[2] == Function.Will && functions[3] == Function.Emotion ) return PLWE;

        if (functions[0] == Function.Will && functions[1] == Function.Emotion &&
                functions[2] == Function.Logic && functions[3] == Function.Physics ) return WELP;

        if (functions[0] == Function.Physics && functions[1] == Function.Emotion &&
                functions[2] == Function.Logic && functions[3] == Function.Will ) return PELW;

        if (functions[0] == Function.Emotion && functions[1] == Function.Physics &&
                functions[2] == Function.Logic && functions[3] == Function.Will ) return EPLW;

        if (functions[0] == Function.Emotion && functions[1] == Function.Will &&
                functions[2] == Function.Logic && functions[3] == Function.Physics ) return EWLP;

        if (functions[0] == Function.Physics && functions[1] == Function.Will &&
                functions[2] == Function.Logic && functions[3] == Function.Emotion ) return PWLE;

        if (functions[0] == Function.Physics && functions[1] == Function.Emotion &&
                functions[2] == Function.Will && functions[3] == Function.Logic ) return PEWL;

        if (functions[0] == Function.Will && functions[1] == Function.Logic &&
                functions[2] == Function.Physics && functions[3] == Function.Emotion ) return WLPE;

        if (functions[0] == Function.Logic && functions[1] == Function.Will &&
                functions[2] == Function.Physics && functions[3] == Function.Emotion ) return LWPE;

        if (functions[0] == Function.Will && functions[1] == Function.Physics &&
                functions[2] == Function.Logic && functions[3] == Function.Emotion ) return WPLE;

        if (functions[0] == Function.Emotion && functions[1] == Function.Will &&
                functions[2] == Function.Physics && functions[3] == Function.Logic ) return EWPL;

        if (functions[0] == Function.Emotion && functions[1] == Function.Physics &&
                functions[2] == Function.Will && functions[3] == Function.Logic ) return EPWL;

        if (functions[0] == Function.Emotion && functions[1] == Function.Logic &&
                functions[2] == Function.Physics && functions[3] == Function.Will ) return ELPW;

        if (functions[0] == Function.Will && functions[1] == Function.Logic &&
                functions[2] == Function.Emotion && functions[3] == Function.Physics ) return WLEP;

        if (functions[0] == Function.Will && functions[1] == Function.Emotion &&
                functions[2] == Function.Physics && functions[3] == Function.Logic ) return WEPL;

        if (functions[0] == Function.Will && functions[1] == Function.Physics &&
                functions[2] == Function.Emotion && functions[3] == Function.Logic ) return WPEL;

        if (functions[0] == Function.Physics && functions[1] == Function.Will &&
                functions[2] == Function.Emotion && functions[3] == Function.Logic ) return PWEL;

        if (functions[0] == Function.Logic && functions[1] == Function.Will &&
                functions[2] == Function.Emotion && functions[3] == Function.Physics ) return LWEP;

        return PLEW;
    }

    public String getDescription(){
        return name + ' ' + name();
    }

}
