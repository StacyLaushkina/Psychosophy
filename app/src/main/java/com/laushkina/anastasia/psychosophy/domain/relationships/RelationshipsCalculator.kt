package com.laushkina.anastasia.psychosophy.domain.relationships

import com.laushkina.anastasia.psychosophy.domain.Psychotype
import com.laushkina.anastasia.psychosophy.domain.test.PsychoFunction

class RelationshipsCalculator {

    companion object {
        /** Calculates relationship for the function
         * @param firstTypeFunction function of the first psychotype
         * @param firstType second psychotype
         * @param secondType second psychotype
         * @return relationships between firstType and secondType based on firstTypeFunction
         */
        fun getRelationship(firstTypeFunction: PsychoFunction, firstType: Psychotype,
                            secondType: Psychotype): Relationship {
            // Position of firstTypeFunction in firstType
            val firstPosition = getFunctionPosition(firstTypeFunction, firstType)

            // Position of firstTypeFunction in secondType
            val secondPosition = getFunctionPosition(firstTypeFunction, secondType)

            return when (firstTypeFunction) {
                PsychoFunction.Will -> getWillRelationship(firstPosition, secondPosition)
                PsychoFunction.Emotion -> getEmotionRelationship(firstPosition, secondPosition)
                PsychoFunction.Logic -> getLogicRelationship(firstPosition, secondPosition)
                PsychoFunction.Physics -> getPhysicsRelationship(firstPosition, secondPosition)
            }
        }

        private fun getFunctionPosition(firstFunction: PsychoFunction, secondType: Psychotype): Int {
            var position = 0
            for (function in secondType.functions) {
                if (function == firstFunction) break
                position++
            }
            return position
        }

        private fun getWillRelationship(firstPosition: Int, secondPosition: Int): Relationship {
            require(firstPosition in 0..3 || secondPosition in 0..3) {
                "Positions must be between 0 and 3"
            }

            if (firstPosition == 0 && secondPosition == 0) return Relationship.Philia_1_Will
            if (firstPosition == 0 && secondPosition == 1) return Relationship.PseudoPhilia_1_2_Will
            if (firstPosition == 0 && secondPosition == 2) return Relationship.Eros_1_3_Will
            if (firstPosition == 0 && secondPosition == 3) return Relationship.Agape_1_4_Will

            if (firstPosition == 1 && secondPosition == 0) return Relationship.PseudoPhilia_2_1_Will
            if (firstPosition == 1 && secondPosition == 1) return Relationship.Philia_2_Will
            if (firstPosition == 1 && secondPosition == 2) return Relationship.Agape_2_3_Will
            if (firstPosition == 1 && secondPosition == 3) return Relationship.Eros_2_4_Will

            if (firstPosition == 2 && secondPosition == 0) return Relationship.Eros_3_1_Will
            if (firstPosition == 2 && secondPosition == 1) return Relationship.Agape_3_2_Will
            if (firstPosition == 2 && secondPosition == 2) return Relationship.Philia_3_Will
            if (firstPosition == 2 && secondPosition == 3) return Relationship.PseudoPhilia_3_4_Will

            if (firstPosition == 3 && secondPosition == 0) return Relationship.Agape_4_1_Will
            if (firstPosition == 3 && secondPosition == 1) return Relationship.Eros_4_2_Will
            if (firstPosition == 3 && secondPosition == 2) return Relationship.PseudoPhilia_4_3_Will
            if (firstPosition == 3 && secondPosition == 3) return Relationship.Philia_4_Will

            throw AssertionError()
        }

        private fun getEmotionRelationship(firstPosition: Int, secondPosition: Int): Relationship {
            require(firstPosition in 0..3 || secondPosition in 0..3) {
                "Positions must be between 0 and 3"
            }

            if (firstPosition == 0 && secondPosition == 0) return Relationship.Philia_1_Emotion
            if (firstPosition == 0 && secondPosition == 1) return Relationship.PseudoPhilia_1_2_Emotion
            if (firstPosition == 0 && secondPosition == 2) return Relationship.Eros_1_3_Emotion
            if (firstPosition == 0 && secondPosition == 3) return Relationship.Agape_1_4_Emotion

            if (firstPosition == 1 && secondPosition == 0) return Relationship.PseudoPhilia_2_1_Emotion
            if (firstPosition == 1 && secondPosition == 1) return Relationship.Philia_2_Emotion
            if (firstPosition == 1 && secondPosition == 2) return Relationship.Agape_2_3_Emotion
            if (firstPosition == 1 && secondPosition == 3) return Relationship.Eros_2_4_Emotion

            if (firstPosition == 2 && secondPosition == 0) return Relationship.Eros_3_1_Emotion
            if (firstPosition == 2 && secondPosition == 1) return Relationship.Agape_3_2_Emotion
            if (firstPosition == 2 && secondPosition == 2) return Relationship.Philia_3_Emotion
            if (firstPosition == 2 && secondPosition == 3) return Relationship.PseudoPhilia_3_4_Emotion

            if (firstPosition == 3 && secondPosition == 0) return Relationship.Agape_4_1_Emotion
            if (firstPosition == 3 && secondPosition == 1) return Relationship.Eros_4_2_Emotion
            if (firstPosition == 3 && secondPosition == 2) return Relationship.PseudoPhilia_4_3_Emotion
            if (firstPosition == 3 && secondPosition == 3) return Relationship.Philia_4_Emotion

            throw AssertionError()
        }

        private fun getLogicRelationship(firstPosition: Int, secondPosition: Int): Relationship {
            require(firstPosition in 0..3 || secondPosition in 0..3) {
                "Positions must be between 0 and 3"
            }

            if (firstPosition == 0 && secondPosition == 0) return Relationship.Philia_1_Logic
            if (firstPosition == 0 && secondPosition == 1) return Relationship.PseudoPhilia_1_2_Logic
            if (firstPosition == 0 && secondPosition == 2) return Relationship.Eros_1_3_Logic
            if (firstPosition == 0 && secondPosition == 3) return Relationship.Agape_1_4_Logic

            if (firstPosition == 1 && secondPosition == 0) return Relationship.PseudoPhilia_2_1_Logic
            if (firstPosition == 1 && secondPosition == 1) return Relationship.Philia_2_Logic
            if (firstPosition == 1 && secondPosition == 2) return Relationship.Agape_2_3_Logic
            if (firstPosition == 1 && secondPosition == 3) return Relationship.Eros_2_4_Logic

            if (firstPosition == 2 && secondPosition == 0) return Relationship.Eros_3_1_Logic
            if (firstPosition == 2 && secondPosition == 1) return Relationship.Agape_3_2_Logic
            if (firstPosition == 2 && secondPosition == 2) return Relationship.Philia_3_Logic
            if (firstPosition == 2 && secondPosition == 3) return Relationship.PseudoPhilia_3_4_Logic

            if (firstPosition == 3 && secondPosition == 0) return Relationship.Agape_4_1_Logic
            if (firstPosition == 3 && secondPosition == 1) return Relationship.Eros_4_2_Logic
            if (firstPosition == 3 && secondPosition == 2) return Relationship.PseudoPhilia_4_3_Logic
            if (firstPosition == 3 && secondPosition == 3) return Relationship.Philia_4_Logic

            throw AssertionError()
        }

        private fun getPhysicsRelationship(firstPosition: Int, secondPosition: Int): Relationship {
            require(firstPosition in 0..3 || secondPosition in 0..3) {
                "Positions must be between 0 and 3"
            }

            if (firstPosition == 0 && secondPosition == 0) return Relationship.Philia_1_Physics
            if (firstPosition == 0 && secondPosition == 1) return Relationship.PseudoPhilia_1_2_Physics
            if (firstPosition == 0 && secondPosition == 2) return Relationship.Eros_1_3_Physics
            if (firstPosition == 0 && secondPosition == 3) return Relationship.Agape_1_4_Physics

            if (firstPosition == 1 && secondPosition == 0) return Relationship.PseudoPhilia_2_1_Physics
            if (firstPosition == 1 && secondPosition == 1) return Relationship.Philia_2_Physics
            if (firstPosition == 1 && secondPosition == 2) return Relationship.Agape_2_3_Physics
            if (firstPosition == 1 && secondPosition == 3) return Relationship.Eros_2_4_Physics

            if (firstPosition == 2 && secondPosition == 0) return Relationship.Eros_3_1_Physics
            if (firstPosition == 2 && secondPosition == 1) return Relationship.Agape_3_2_Physics
            if (firstPosition == 2 && secondPosition == 2) return Relationship.Philia_3_Physics
            if (firstPosition == 2 && secondPosition == 3) return Relationship.PseudoPhilia_3_4_Physics

            if (firstPosition == 3 && secondPosition == 0) return Relationship.Agape_4_1_Physics
            if (firstPosition == 3 && secondPosition == 1) return Relationship.Eros_4_2_Physics
            if (firstPosition == 3 && secondPosition == 2) return Relationship.PseudoPhilia_4_3_Physics
            if (firstPosition == 3 && secondPosition == 3) return Relationship.Philia_4_Physics

            throw AssertionError()
        }
    }
}