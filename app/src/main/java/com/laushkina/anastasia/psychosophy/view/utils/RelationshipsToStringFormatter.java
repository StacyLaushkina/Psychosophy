package com.laushkina.anastasia.psychosophy.view.utils;

import android.content.res.Resources;

import com.laushkina.anastasia.psychosophy.R;
import com.laushkina.anastasia.psychosophy.domain.relationships.Relationship;

public class RelationshipsToStringFormatter {

    public static String getDescription(Relationship relationship, Resources resources){
        switch (relationship) {
            case Philia_1_Emotion: return resources.getString(R.string.philia_1_emotion);
            case Philia_1_Logic: return resources.getString(R.string.philia_1_logic);
            case Philia_1_Will: return resources.getString(R.string.philia_1_will);
            case Philia_1_Physics: return resources.getString(R.string.philia_1_physics);

            case Philia_2_Emotion: return resources.getString(R.string.philia_2_emotion);
            case Philia_2_Logic: return resources.getString(R.string.philia_2_logic);
            case Philia_2_Will: return resources.getString(R.string.philia_2_will);
            case Philia_2_Physics: return resources.getString(R.string.philia_2_physics);

            case Philia_3_Emotion: return resources.getString(R.string.philia_3_emotion);
            case Philia_3_Logic: return resources.getString(R.string.philia_3_logic);
            case Philia_3_Will: return resources.getString(R.string.philia_3_will);
            case Philia_3_Physics: return resources.getString(R.string.philia_3_physics);

            case Philia_4_Emotion: return resources.getString(R.string.philia_4_emotion);
            case Philia_4_Logic: return resources.getString(R.string.philia_4_logic);
            case Philia_4_Will: return resources.getString(R.string.philia_4_will);
            case Philia_4_Physics: return resources.getString(R.string.philia_4_physics);

            case PseudoPhilia_1_2_Emotion: return resources.getString(R.string.pseudo_philia_1_2_emotion);
            case PseudoPhilia_1_2_Logic: return resources.getString(R.string.pseudo_philia_1_2_logic);
            case PseudoPhilia_1_2_Will: return resources.getString(R.string.pseudo_philia_1_2_will);
            case PseudoPhilia_1_2_Physics: return resources.getString(R.string.pseudo_philia_1_2_physics);

            case PseudoPhilia_2_1_Emotion: return resources.getString(R.string.pseudo_philia_2_1_emotion);
            case PseudoPhilia_2_1_Logic: return resources.getString(R.string.pseudo_philia_2_1_logic);
            case PseudoPhilia_2_1_Will: return resources.getString(R.string.pseudo_philia_2_1_will);
            case PseudoPhilia_2_1_Physics: return resources.getString(R.string.pseudo_philia_2_1_physics);

            case PseudoPhilia_3_4_Emotion: return resources.getString(R.string.pseudo_philia_3_4_emotion);
            case PseudoPhilia_3_4_Logic: return resources.getString(R.string.pseudo_philia_3_4_logic);
            case PseudoPhilia_3_4_Will: return resources.getString(R.string.pseudo_philia_3_4_will);
            case PseudoPhilia_3_4_Physics: return resources.getString(R.string.pseudo_philia_3_4_physics);

            case PseudoPhilia_4_3_Emotion: return resources.getString(R.string.pseudo_philia_4_3_emotion);
            case PseudoPhilia_4_3_Logic: return resources.getString(R.string.pseudo_philia_4_3_logic);
            case PseudoPhilia_4_3_Will: return resources.getString(R.string.pseudo_philia_4_3_will);
            case PseudoPhilia_4_3_Physics: return resources.getString(R.string.pseudo_philia_4_3_physics);

            case Eros_1_3_Emotion: return resources.getString(R.string.eros_1_3_emotion);
            case Eros_1_3_Logic: return resources.getString(R.string.eros_1_3_logic);
            case Eros_1_3_Will: return resources.getString(R.string.eros_1_3_will);
            case Eros_1_3_Physics: return resources.getString(R.string.eros_1_3_physics);

            case Eros_3_1_Emotion: return resources.getString(R.string.eros_3_1_emotion);
            case Eros_3_1_Logic: return resources.getString(R.string.eros_3_1_logic);
            case Eros_3_1_Will: return resources.getString(R.string.eros_3_1_will);
            case Eros_3_1_Physics: return resources.getString(R.string.eros_3_1_physics);

            case Eros_2_4_Emotion: return resources.getString(R.string.eros_2_4_emotion);
            case Eros_2_4_Logic: return resources.getString(R.string.eros_2_4_logic);
            case Eros_2_4_Will: return resources.getString(R.string.eros_2_4_will);
            case Eros_2_4_Physics: return resources.getString(R.string.eros_2_4_physics);

            case Eros_4_2_Emotion: return resources.getString(R.string.eros_4_2_emotion);
            case Eros_4_2_Logic: return resources.getString(R.string.eros_4_2_logic);
            case Eros_4_2_Will: return resources.getString(R.string.eros_4_2_will);
            case Eros_4_2_Physics: return resources.getString(R.string.eros_4_2_physics);


            case Agape_1_4_Emotion: return resources.getString(R.string.agape_1_4_will);
            case Agape_1_4_Logic: return resources.getString(R.string.agape_1_4_logic);
            case Agape_1_4_Will: return resources.getString(R.string.agape_1_4_will);
            case Agape_1_4_Physics: return resources.getString(R.string.agape_1_4_physics);

            case Agape_2_3_Emotion: return resources.getString(R.string.agape_2_3_will);
            case Agape_2_3_Logic: return resources.getString(R.string.agape_2_3_logic);
            case Agape_2_3_Will: return resources.getString(R.string.agape_2_3_will);
            case Agape_2_3_Physics: return resources.getString(R.string.agape_2_3_physics);

            case Agape_3_2_Emotion: return resources.getString(R.string.agape_3_2_will);
            case Agape_3_2_Logic: return resources.getString(R.string.agape_3_2_logic);
            case Agape_3_2_Will: return resources.getString(R.string.agape_3_2_will);
            case Agape_3_2_Physics: return resources.getString(R.string.agape_3_2_physics);

            case Agape_4_1_Emotion: return resources.getString(R.string.agape_4_1_will);
            case Agape_4_1_Logic: return resources.getString(R.string.agape_4_1_logic);
            case Agape_4_1_Will: return resources.getString(R.string.agape_4_1_will);
            case Agape_4_1_Physics: return resources.getString(R.string.agape_4_1_physics);

            default: return null;
        }
    }

    public static String getTitle(Relationship relationship, Resources resources){
        switch (relationship) {
            case Philia_1_Emotion: return resources.getString(R.string.philia_1_emotion_title);
            case Philia_1_Logic: return resources.getString(R.string.philia_1_logic_title);
            case Philia_1_Will: return resources.getString(R.string.philia_1_will_title);
            case Philia_1_Physics: return resources.getString(R.string.philia_1_physics_title);

            case Philia_2_Emotion: return resources.getString(R.string.philia_2_emotion_title);
            case Philia_2_Logic: return resources.getString(R.string.philia_2_logic_title);
            case Philia_2_Will: return resources.getString(R.string.philia_2_will_title);
            case Philia_2_Physics: return resources.getString(R.string.philia_2_physics_title);

            case Philia_3_Emotion: return resources.getString(R.string.philia_3_emotion_title);
            case Philia_3_Logic: return resources.getString(R.string.philia_3_logic_title);
            case Philia_3_Will: return resources.getString(R.string.philia_3_will_title);
            case Philia_3_Physics: return resources.getString(R.string.philia_3_physics_title);

            case Philia_4_Emotion: return resources.getString(R.string.philia_4_emotion_title);
            case Philia_4_Logic: return resources.getString(R.string.philia_4_logic_title);
            case Philia_4_Will: return resources.getString(R.string.philia_4_will_title);
            case Philia_4_Physics: return resources.getString(R.string.philia_4_physics_title);

            case PseudoPhilia_1_2_Emotion: return resources.getString(R.string.pseudo_philia_1_2_emotion_title);
            case PseudoPhilia_1_2_Logic: return resources.getString(R.string.pseudo_philia_1_2_logic_title);
            case PseudoPhilia_1_2_Will: return resources.getString(R.string.pseudo_philia_1_2_will_title);
            case PseudoPhilia_1_2_Physics: return resources.getString(R.string.pseudo_philia_1_2_physics_title);

            case PseudoPhilia_2_1_Emotion: return resources.getString(R.string.pseudo_philia_2_1_emotion_title);
            case PseudoPhilia_2_1_Logic: return resources.getString(R.string.pseudo_philia_2_1_logic_title);
            case PseudoPhilia_2_1_Will: return resources.getString(R.string.pseudo_philia_2_1_will_title);
            case PseudoPhilia_2_1_Physics: return resources.getString(R.string.pseudo_philia_2_1_physics_title);

            case PseudoPhilia_3_4_Emotion: return resources.getString(R.string.pseudo_philia_3_4_emotion_title);
            case PseudoPhilia_3_4_Logic: return resources.getString(R.string.pseudo_philia_3_4_logic_title);
            case PseudoPhilia_3_4_Will: return resources.getString(R.string.pseudo_philia_3_4_will_title);
            case PseudoPhilia_3_4_Physics: return resources.getString(R.string.pseudo_philia_3_4_physics_title);

            case PseudoPhilia_4_3_Emotion: return resources.getString(R.string.pseudo_philia_4_3_emotion_title);
            case PseudoPhilia_4_3_Logic: return resources.getString(R.string.pseudo_philia_4_3_logic_title);
            case PseudoPhilia_4_3_Will: return resources.getString(R.string.pseudo_philia_4_3_will_title);
            case PseudoPhilia_4_3_Physics: return resources.getString(R.string.pseudo_philia_4_3_physics_title);

            case Eros_1_3_Emotion: return resources.getString(R.string.eros_1_3_emotion_title);
            case Eros_1_3_Logic: return resources.getString(R.string.eros_1_3_logic_title);
            case Eros_1_3_Will: return resources.getString(R.string.eros_1_3_will_title);
            case Eros_1_3_Physics: return resources.getString(R.string.eros_1_3_physics_title);

            case Eros_3_1_Emotion: return resources.getString(R.string.eros_3_1_emotion_title);
            case Eros_3_1_Logic: return resources.getString(R.string.eros_3_1_logic_title);
            case Eros_3_1_Will: return resources.getString(R.string.eros_3_1_will_title);
            case Eros_3_1_Physics: return resources.getString(R.string.eros_3_1_physics_title);

            case Eros_2_4_Emotion: return resources.getString(R.string.eros_2_4_emotion_title);
            case Eros_2_4_Logic: return resources.getString(R.string.eros_2_4_logic_title);
            case Eros_2_4_Will: return resources.getString(R.string.eros_2_4_will_title);
            case Eros_2_4_Physics: return resources.getString(R.string.eros_2_4_physics_title);

            case Eros_4_2_Emotion: return resources.getString(R.string.eros_4_2_emotion_title);
            case Eros_4_2_Logic: return resources.getString(R.string.eros_4_2_logic_title);
            case Eros_4_2_Will: return resources.getString(R.string.eros_4_2_will_title);
            case Eros_4_2_Physics: return resources.getString(R.string.eros_4_2_physics_title);


            case Agape_1_4_Emotion: return resources.getString(R.string.agape_1_4_will_title);
            case Agape_1_4_Logic: return resources.getString(R.string.agape_1_4_logic_title);
            case Agape_1_4_Will: return resources.getString(R.string.agape_1_4_will_title);
            case Agape_1_4_Physics: return resources.getString(R.string.agape_1_4_physics_title);

            case Agape_2_3_Emotion: return resources.getString(R.string.agape_2_3_will_title);
            case Agape_2_3_Logic: return resources.getString(R.string.agape_2_3_logic_title);
            case Agape_2_3_Will: return resources.getString(R.string.agape_2_3_will_title);
            case Agape_2_3_Physics: return resources.getString(R.string.agape_2_3_physics_title);

            case Agape_3_2_Emotion: return resources.getString(R.string.agape_3_2_will_title);
            case Agape_3_2_Logic: return resources.getString(R.string.agape_3_2_logic_title);
            case Agape_3_2_Will: return resources.getString(R.string.agape_3_2_will_title);
            case Agape_3_2_Physics: return resources.getString(R.string.agape_3_2_physics_title);

            case Agape_4_1_Emotion: return resources.getString(R.string.agape_4_1_will_title);
            case Agape_4_1_Logic: return resources.getString(R.string.agape_4_1_logic_title);
            case Agape_4_1_Will: return resources.getString(R.string.agape_4_1_will_title);
            case Agape_4_1_Physics: return resources.getString(R.string.agape_4_1_physics_title);

            default: return null;
        }
    }
}
