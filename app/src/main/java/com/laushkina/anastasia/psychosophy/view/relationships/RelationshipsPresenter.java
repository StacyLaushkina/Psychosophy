package com.laushkina.anastasia.psychosophy.view.relationships;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;

class RelationshipsPresenter {
    private Psychotype fistType;
    private Psychotype secondTYpe;

    RelationshipsPresenter(){}

    void setFistType(Psychotype fistType) {
        this.fistType = fistType;
    }

    void setSecondTYpe(Psychotype secondTYpe) {
        this.secondTYpe = secondTYpe;
    }

    String calcRelationships(){
        return "Some type";
    }
}
