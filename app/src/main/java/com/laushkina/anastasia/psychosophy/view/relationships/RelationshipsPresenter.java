package com.laushkina.anastasia.psychosophy.view.relationships;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;

import dagger.Module;
import dagger.Provides;

@Module
public class RelationshipsPresenter {
    @Provides
    public static RelationshipsPresenter provideRelationshipsPresenter(){
        return new RelationshipsPresenter();
    }

    String calcRelationships(Psychotype fistType, Psychotype secondTYpe){
        return "Some type";
    }
}
