package com.laushkina.anastasia.psychosophy.view.relationships;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.relationships.PsychotypeRelationships;
import com.laushkina.anastasia.psychosophy.domain.relationships.RelationshipsCalculator;

import dagger.Module;
import dagger.Provides;

@Module
public class RelationshipsPresenter {
    @Provides
    public static RelationshipsPresenter provideRelationshipsPresenter(){
        return new RelationshipsPresenter();
    }

    PsychotypeRelationships calcRelationships(Psychotype fistType, Psychotype secondType, IRelationshipsResultObserver observer){
        if (fistType == null || secondType == null){
            observer.showHint();
            return new PsychotypeRelationships("","",
                    "",""); // nulls cannot be returned because of Html.fromHtml()
        }
        observer.hideHint();
        return RelationshipsCalculator.calcRelationships(fistType, secondType, observer.getContext());
    }
}
