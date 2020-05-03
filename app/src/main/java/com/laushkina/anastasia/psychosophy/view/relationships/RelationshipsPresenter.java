package com.laushkina.anastasia.psychosophy.view.relationships;

import android.content.Context;
import android.view.View;

import com.laushkina.anastasia.psychosophy.domain.Psychotype;
import com.laushkina.anastasia.psychosophy.domain.relationships.RelationshipsCalculator;
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction;
import com.laushkina.anastasia.psychosophy.view.utils.RelationshipsToStringFormatter;

import dagger.Module;
import dagger.Provides;

@Module
public class RelationshipsPresenter {
    @Provides
    public static RelationshipsPresenter provideRelationshipsPresenter(){
        return new RelationshipsPresenter();
    }

    Psychotype[] getPsychotypes(){
        Psychotype[] allTypes = Psychotype.values();

        Psychotype[] typesWithFirstDefault = new Psychotype[allTypes.length + 1];
        int newArrayInd = 1;
        for (Psychotype psychotype : allTypes) {
            typesWithFirstDefault[newArrayInd] = psychotype;
            newArrayInd++;
        }
        return typesWithFirstDefault;
    }

    RelationshipsViewModel calcRelationships(Psychotype fistType, Psychotype secondType, IRelationshipsResultObserver observer){
        if (fistType == null || secondType == null){
            // TODO animation rollback
            observer.setHintAndImageVisibility(View.VISIBLE);
            return new RelationshipsViewModel();
        }
        observer.setHintAndImageVisibility(View.GONE);
        return calcRelationships(fistType, secondType, observer.getContext());
    }

    private static RelationshipsViewModel calcRelationships(Psychotype fistType, Psychotype secondType, Context context){
        String fistFunctionRelation = getFunctionRelationship(fistType.getFunctions()[0], fistType, secondType, context);
        String fistFunctionRelationTitle = getFunctionRelationshipTitle(fistType.getFunctions()[0], fistType, secondType, context);

        String secondFunctionRelation = getFunctionRelationship(fistType.getFunctions()[1], fistType, secondType, context);
        String secondFunctionRelationTitle = getFunctionRelationshipTitle(fistType.getFunctions()[1], fistType, secondType, context);

        String thirdFunctionRelation = getFunctionRelationship(fistType.getFunctions()[2], fistType, secondType, context);
        String thirdFunctionRelationTitle = getFunctionRelationshipTitle(fistType.getFunctions()[2], fistType, secondType, context);

        String forthFunctionRelation = getFunctionRelationship(fistType.getFunctions()[3], fistType, secondType, context);
        String forthFunctionRelationTitle = getFunctionRelationshipTitle(fistType.getFunctions()[3], fistType, secondType, context);

        return new RelationshipsViewModel(fistFunctionRelationTitle, fistFunctionRelation,
                                          secondFunctionRelationTitle, secondFunctionRelation,
                                          thirdFunctionRelationTitle, thirdFunctionRelation,
                                          forthFunctionRelationTitle, forthFunctionRelation, View.VISIBLE);
    }

    private static String getFunctionRelationship(PsychoFunction firstFunction, Psychotype firstType, Psychotype secondType, Context context){
        return RelationshipsToStringFormatter.getDescription(RelationshipsCalculator.Companion.getRelationship(firstFunction, firstType, secondType), context.getResources());
    }

    private static String getFunctionRelationshipTitle(PsychoFunction firstFunction, Psychotype firstType, Psychotype secondType, Context context){
        return RelationshipsToStringFormatter.getTitle(RelationshipsCalculator.Companion.getRelationship(firstFunction, firstType, secondType), context.getResources());
    }
}
