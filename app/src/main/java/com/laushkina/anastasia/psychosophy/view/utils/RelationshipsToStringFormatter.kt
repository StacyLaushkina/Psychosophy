package com.laushkina.anastasia.psychosophy.view.utils

import android.content.res.Resources
import com.laushkina.anastasia.psychosophy.R
import com.laushkina.anastasia.psychosophy.domain.relationships.Relationship

class RelationshipsToStringFormatter {
    companion object {
        fun getDescription(relationship: Relationship, resources: Resources): String? {
            when (relationship) {
                Relationship.Philia_1_Emotion -> return resources.getString(R.string.philia_1_emotion)
                Relationship.Philia_1_Logic -> return resources.getString(R.string.philia_1_logic)
                Relationship.Philia_1_Will -> return resources.getString(R.string.philia_1_will)
                Relationship.Philia_1_Physics -> return resources.getString(R.string.philia_1_physics)

                Relationship.Philia_2_Emotion -> return resources.getString(R.string.philia_2_emotion)
                Relationship.Philia_2_Logic -> return resources.getString(R.string.philia_2_logic)
                Relationship.Philia_2_Will -> return resources.getString(R.string.philia_2_will)
                Relationship.Philia_2_Physics -> return resources.getString(R.string.philia_2_physics)

                Relationship.Philia_3_Emotion -> return resources.getString(R.string.philia_3_emotion)
                Relationship.Philia_3_Logic -> return resources.getString(R.string.philia_3_logic)
                Relationship.Philia_3_Will -> return resources.getString(R.string.philia_3_will)
                Relationship.Philia_3_Physics -> return resources.getString(R.string.philia_3_physics)

                Relationship.Philia_4_Emotion -> return resources.getString(R.string.philia_4_emotion)
                Relationship.Philia_4_Logic -> return resources.getString(R.string.philia_4_logic)
                Relationship.Philia_4_Will -> return resources.getString(R.string.philia_4_will)
                Relationship.Philia_4_Physics -> return resources.getString(R.string.philia_4_physics)

                Relationship.PseudoPhilia_1_2_Emotion -> return resources.getString(R.string.pseudo_philia_1_2_emotion)
                Relationship.PseudoPhilia_1_2_Logic -> return resources.getString(R.string.pseudo_philia_1_2_logic)
                Relationship.PseudoPhilia_1_2_Will -> return resources.getString(R.string.pseudo_philia_1_2_will)
                Relationship.PseudoPhilia_1_2_Physics -> return resources.getString(R.string.pseudo_philia_1_2_physics)

                Relationship.PseudoPhilia_2_1_Emotion -> return resources.getString(R.string.pseudo_philia_2_1_emotion)
                Relationship.PseudoPhilia_2_1_Logic -> return resources.getString(R.string.pseudo_philia_2_1_logic)
                Relationship.PseudoPhilia_2_1_Will -> return resources.getString(R.string.pseudo_philia_2_1_will)
                Relationship.PseudoPhilia_2_1_Physics -> return resources.getString(R.string.pseudo_philia_2_1_physics)

                Relationship.PseudoPhilia_3_4_Emotion -> return resources.getString(R.string.pseudo_philia_3_4_emotion)
                Relationship.PseudoPhilia_3_4_Logic -> return resources.getString(R.string.pseudo_philia_3_4_logic)
                Relationship.PseudoPhilia_3_4_Will -> return resources.getString(R.string.pseudo_philia_3_4_will)
                Relationship.PseudoPhilia_3_4_Physics -> return resources.getString(R.string.pseudo_philia_3_4_physics)

                Relationship.PseudoPhilia_4_3_Emotion -> return resources.getString(R.string.pseudo_philia_4_3_emotion)
                Relationship.PseudoPhilia_4_3_Logic -> return resources.getString(R.string.pseudo_philia_4_3_logic)
                Relationship.PseudoPhilia_4_3_Will -> return resources.getString(R.string.pseudo_philia_4_3_will)
                Relationship.PseudoPhilia_4_3_Physics -> return resources.getString(R.string.pseudo_philia_4_3_physics)

                Relationship.Eros_1_3_Emotion -> return resources.getString(R.string.eros_1_3_emotion)
                Relationship.Eros_1_3_Logic -> return resources.getString(R.string.eros_1_3_logic)
                Relationship.Eros_1_3_Will -> return resources.getString(R.string.eros_1_3_will)
                Relationship.Eros_1_3_Physics -> return resources.getString(R.string.eros_1_3_physics)

                Relationship.Eros_3_1_Emotion -> return resources.getString(R.string.eros_3_1_emotion)
                Relationship.Eros_3_1_Logic -> return resources.getString(R.string.eros_3_1_logic)
                Relationship.Eros_3_1_Will -> return resources.getString(R.string.eros_3_1_will)
                Relationship.Eros_3_1_Physics -> return resources.getString(R.string.eros_3_1_physics)

                Relationship.Eros_2_4_Emotion -> return resources.getString(R.string.eros_2_4_emotion)
                Relationship.Eros_2_4_Logic -> return resources.getString(R.string.eros_2_4_logic)
                Relationship.Eros_2_4_Will -> return resources.getString(R.string.eros_2_4_will)
                Relationship.Eros_2_4_Physics -> return resources.getString(R.string.eros_2_4_physics)

                Relationship.Eros_4_2_Emotion -> return resources.getString(R.string.eros_4_2_emotion)
                Relationship.Eros_4_2_Logic -> return resources.getString(R.string.eros_4_2_logic)
                Relationship.Eros_4_2_Will -> return resources.getString(R.string.eros_4_2_will)
                Relationship.Eros_4_2_Physics -> return resources.getString(R.string.eros_4_2_physics)


                Relationship.Agape_1_4_Emotion -> return resources.getString(R.string.agape_1_4_emotion)
                Relationship.Agape_1_4_Logic -> return resources.getString(R.string.agape_1_4_logic)
                Relationship.Agape_1_4_Will -> return resources.getString(R.string.agape_1_4_will)
                Relationship.Agape_1_4_Physics -> return resources.getString(R.string.agape_1_4_physics)

                Relationship.Agape_2_3_Emotion -> return resources.getString(R.string.agape_2_3_emotion)
                Relationship.Agape_2_3_Logic -> return resources.getString(R.string.agape_2_3_logic)
                Relationship.Agape_2_3_Will -> return resources.getString(R.string.agape_2_3_will)
                Relationship.Agape_2_3_Physics -> return resources.getString(R.string.agape_2_3_physics)

                Relationship.Agape_3_2_Emotion -> return resources.getString(R.string.agape_3_2_emotion)
                Relationship.Agape_3_2_Logic -> return resources.getString(R.string.agape_3_2_logic)
                Relationship.Agape_3_2_Will -> return resources.getString(R.string.agape_3_2_will)
                Relationship.Agape_3_2_Physics -> return resources.getString(R.string.agape_3_2_physics)

                Relationship.Agape_4_1_Emotion -> return resources.getString(R.string.agape_4_1_emotion)
                Relationship.Agape_4_1_Logic -> return resources.getString(R.string.agape_4_1_logic)
                Relationship.Agape_4_1_Will -> return resources.getString(R.string.agape_4_1_will)
                Relationship.Agape_4_1_Physics -> return resources.getString(R.string.agape_4_1_physics)

                else -> return null
            }
        }

        fun getTitle(relationship: Relationship, resources: Resources): String? {
            when (relationship) {
                Relationship.Philia_1_Emotion -> return resources.getString(R.string.philia_1_emotion_title)
                Relationship.Philia_1_Logic -> return resources.getString(R.string.philia_1_logic_title)
                Relationship.Philia_1_Will -> return resources.getString(R.string.philia_1_will_title)
                Relationship.Philia_1_Physics -> return resources.getString(R.string.philia_1_physics_title)

                Relationship.Philia_2_Emotion -> return resources.getString(R.string.philia_2_emotion_title)
                Relationship.Philia_2_Logic -> return resources.getString(R.string.philia_2_logic_title)
                Relationship.Philia_2_Will -> return resources.getString(R.string.philia_2_will_title)
                Relationship.Philia_2_Physics -> return resources.getString(R.string.philia_2_physics_title)

                Relationship.Philia_3_Emotion -> return resources.getString(R.string.philia_3_emotion_title)
                Relationship.Philia_3_Logic -> return resources.getString(R.string.philia_3_logic_title)
                Relationship.Philia_3_Will -> return resources.getString(R.string.philia_3_will_title)
                Relationship.Philia_3_Physics -> return resources.getString(R.string.philia_3_physics_title)

                Relationship.Philia_4_Emotion -> return resources.getString(R.string.philia_4_emotion_title)
                Relationship.Philia_4_Logic -> return resources.getString(R.string.philia_4_logic_title)
                Relationship.Philia_4_Will -> return resources.getString(R.string.philia_4_will_title)
                Relationship.Philia_4_Physics -> return resources.getString(R.string.philia_4_physics_title)

                Relationship.PseudoPhilia_1_2_Emotion -> return resources.getString(R.string.pseudo_philia_1_2_emotion_title)
                Relationship.PseudoPhilia_1_2_Logic -> return resources.getString(R.string.pseudo_philia_1_2_logic_title)
                Relationship.PseudoPhilia_1_2_Will -> return resources.getString(R.string.pseudo_philia_1_2_will_title)
                Relationship.PseudoPhilia_1_2_Physics -> return resources.getString(R.string.pseudo_philia_1_2_physics_title)

                Relationship.PseudoPhilia_2_1_Emotion -> return resources.getString(R.string.pseudo_philia_2_1_emotion_title)
                Relationship.PseudoPhilia_2_1_Logic -> return resources.getString(R.string.pseudo_philia_2_1_logic_title)
                Relationship.PseudoPhilia_2_1_Will -> return resources.getString(R.string.pseudo_philia_2_1_will_title)
                Relationship.PseudoPhilia_2_1_Physics -> return resources.getString(R.string.pseudo_philia_2_1_physics_title)

                Relationship.PseudoPhilia_3_4_Emotion -> return resources.getString(R.string.pseudo_philia_3_4_emotion_title)
                Relationship.PseudoPhilia_3_4_Logic -> return resources.getString(R.string.pseudo_philia_3_4_logic_title)
                Relationship.PseudoPhilia_3_4_Will -> return resources.getString(R.string.pseudo_philia_3_4_will_title)
                Relationship.PseudoPhilia_3_4_Physics -> return resources.getString(R.string.pseudo_philia_3_4_physics_title)

                Relationship.PseudoPhilia_4_3_Emotion -> return resources.getString(R.string.pseudo_philia_4_3_emotion_title)
                Relationship.PseudoPhilia_4_3_Logic -> return resources.getString(R.string.pseudo_philia_4_3_logic_title)
                Relationship.PseudoPhilia_4_3_Will -> return resources.getString(R.string.pseudo_philia_4_3_will_title)
                Relationship.PseudoPhilia_4_3_Physics -> return resources.getString(R.string.pseudo_philia_4_3_physics_title)

                Relationship.Eros_1_3_Emotion -> return resources.getString(R.string.eros_1_3_emotion_title)
                Relationship.Eros_1_3_Logic -> return resources.getString(R.string.eros_1_3_logic_title)
                Relationship.Eros_1_3_Will -> return resources.getString(R.string.eros_1_3_will_title)
                Relationship.Eros_1_3_Physics -> return resources.getString(R.string.eros_1_3_physics_title)

                Relationship.Eros_3_1_Emotion -> return resources.getString(R.string.eros_3_1_emotion_title)
                Relationship.Eros_3_1_Logic -> return resources.getString(R.string.eros_3_1_logic_title)
                Relationship.Eros_3_1_Will -> return resources.getString(R.string.eros_3_1_will_title)
                Relationship.Eros_3_1_Physics -> return resources.getString(R.string.eros_3_1_physics_title)

                Relationship.Eros_2_4_Emotion -> return resources.getString(R.string.eros_2_4_emotion_title)
                Relationship.Eros_2_4_Logic -> return resources.getString(R.string.eros_2_4_logic_title)
                Relationship.Eros_2_4_Will -> return resources.getString(R.string.eros_2_4_will_title)
                Relationship.Eros_2_4_Physics -> return resources.getString(R.string.eros_2_4_physics_title)

                Relationship.Eros_4_2_Emotion -> return resources.getString(R.string.eros_4_2_emotion_title)
                Relationship.Eros_4_2_Logic -> return resources.getString(R.string.eros_4_2_logic_title)
                Relationship.Eros_4_2_Will -> return resources.getString(R.string.eros_4_2_will_title)
                Relationship.Eros_4_2_Physics -> return resources.getString(R.string.eros_4_2_physics_title)


                Relationship.Agape_1_4_Emotion -> return resources.getString(R.string.agape_1_4_emotion_title)
                Relationship.Agape_1_4_Logic -> return resources.getString(R.string.agape_1_4_logic_title)
                Relationship.Agape_1_4_Will -> return resources.getString(R.string.agape_1_4_will_title)
                Relationship.Agape_1_4_Physics -> return resources.getString(R.string.agape_1_4_physics_title)

                Relationship.Agape_2_3_Emotion -> return resources.getString(R.string.agape_2_3_emotion_title)
                Relationship.Agape_2_3_Logic -> return resources.getString(R.string.agape_2_3_logic_title)
                Relationship.Agape_2_3_Will -> return resources.getString(R.string.agape_2_3_will_title)
                Relationship.Agape_2_3_Physics -> return resources.getString(R.string.agape_2_3_physics_title)

                Relationship.Agape_3_2_Emotion -> return resources.getString(R.string.agape_3_2_emotion_title)
                Relationship.Agape_3_2_Logic -> return resources.getString(R.string.agape_3_2_logic_title)
                Relationship.Agape_3_2_Will -> return resources.getString(R.string.agape_3_2_will_title)
                Relationship.Agape_3_2_Physics -> return resources.getString(R.string.agape_3_2_physics_title)

                Relationship.Agape_4_1_Emotion -> return resources.getString(R.string.agape_4_1_emotion_title)
                Relationship.Agape_4_1_Logic -> return resources.getString(R.string.agape_4_1_logic_title)
                Relationship.Agape_4_1_Will -> return resources.getString(R.string.agape_4_1_will_title)
                Relationship.Agape_4_1_Physics -> return resources.getString(R.string.agape_4_1_physics_title)

                else -> return null
            }
        }
    }
}