package com.laushkina.anastasia.psychosophy.view.introduction;

public class IntroductionViewModel {
    private CharSequence psychosophyDefinition;
    private CharSequence personalitiesDescription;
    private CharSequence relationshipsDescription;

    IntroductionViewModel(){}

    public CharSequence getPsychosophyDefinition() {
        return psychosophyDefinition;
    }

    public void setPsychosophyDefinition(CharSequence psychosophyDefinition) {
        this.psychosophyDefinition = psychosophyDefinition;
    }

    public CharSequence getPersonalitiesDescription() {
        return personalitiesDescription;
    }

    public void setPersonalitiesDescription(CharSequence personalitiesDescription) {
        this.personalitiesDescription = personalitiesDescription;
    }

    public CharSequence getRelationshipsDescription() {
        return relationshipsDescription;
    }

    public void setRelationshipsDescription(CharSequence relationshipsDescription) {
        this.relationshipsDescription = relationshipsDescription;
    }
}
