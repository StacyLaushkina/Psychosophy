package com.laushkina.anastasia.psychosophy.view.relationships

import android.content.Context
import android.view.View
import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.domain.relationships.RelationshipsCalculator
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction
import com.laushkina.anastasia.psychosophy.view.utils.RelationshipsToStringFormatter
import dagger.Module
import dagger.Provides

@Module
class RelationshipsPresenter {
    @Provides
    fun provideRelationshipsPresenter(): RelationshipsPresenter {
        return RelationshipsPresenter()
    }

    internal fun getPsychotypes(): Array<Psychotype?> {
        val allTypes = Psychotype.values()

        val typesWithFirstDefault = arrayOfNulls<Psychotype>(allTypes.size + 1)
        var newArrayInd = 1
        for (psychotype in allTypes) {
            typesWithFirstDefault[newArrayInd] = psychotype
            newArrayInd++
        }
        return typesWithFirstDefault
    }

    internal fun calcRelationships(fistType: Psychotype?, secondType: Psychotype?, observer: IRelationshipsResultObserver): RelationshipsViewModel {
        if (fistType == null || secondType == null) {
            // TODO animation rollback
            observer.setHintAndImageVisibility(View.VISIBLE)
            return RelationshipsViewModel()
        }
        observer.setHintAndImageVisibility(View.GONE)
        return calcRelationships(fistType, secondType, observer.getContext())
    }

    private fun calcRelationships(fistType: Psychotype, secondType: Psychotype, context: Context): RelationshipsViewModel {
        val fistFunctionRelation = getFunctionRelationship(fistType.functions[0], fistType, secondType, context)
        val fistFunctionRelationTitle = getFunctionRelationshipTitle(fistType.functions[0], fistType, secondType, context)

        val secondFunctionRelation = getFunctionRelationship(fistType.functions[1], fistType, secondType, context)
        val secondFunctionRelationTitle = getFunctionRelationshipTitle(fistType.functions[1], fistType, secondType, context)

        val thirdFunctionRelation = getFunctionRelationship(fistType.functions[2], fistType, secondType, context)
        val thirdFunctionRelationTitle = getFunctionRelationshipTitle(fistType.functions[2], fistType, secondType, context)

        val forthFunctionRelation = getFunctionRelationship(fistType.functions[3], fistType, secondType, context)
        val forthFunctionRelationTitle = getFunctionRelationshipTitle(fistType.functions[3], fistType, secondType, context)

        return RelationshipsViewModel(
                fistFunctionRelationTitle, fistFunctionRelation,
                secondFunctionRelationTitle, secondFunctionRelation,
                thirdFunctionRelationTitle, thirdFunctionRelation,
                forthFunctionRelationTitle, forthFunctionRelation, View.VISIBLE)
    }

    private fun getFunctionRelationship(firstFunction: PsychoFunction, firstType: Psychotype, secondType: Psychotype, context: Context): String? {
        return RelationshipsToStringFormatter.getDescription(RelationshipsCalculator.getRelationship(firstFunction, firstType, secondType), context.resources)
    }

    private fun getFunctionRelationshipTitle(firstFunction: PsychoFunction, firstType: Psychotype, secondType: Psychotype, context: Context): String? {
        return RelationshipsToStringFormatter.getTitle(RelationshipsCalculator.getRelationship(firstFunction, firstType, secondType), context.resources)
    }
}