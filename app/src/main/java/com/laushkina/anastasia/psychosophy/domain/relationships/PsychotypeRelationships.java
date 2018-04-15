package com.laushkina.anastasia.psychosophy.domain.relationships;

public class PsychotypeRelationships {
    private String firstFunctionRelationships;
    private String firstFunctionRelationshipsTitle;
    private String secondFunctionRelationships;
    private String secondFunctionRelationshipsTitle;
    private String thirdFunctionRelationships;
    private String thirdFunctionRelationshipsTitle;
    private String forthFunctionRelationships;
    private String forthFunctionRelationshipsTitle;

    // TODO builder? Too many strings as parameters
    public PsychotypeRelationships(String firstFunctionRelationships,
                                   String firstFunctionRelationshipsTitle,
                                   String secondFunctionRelationships,
                                   String secondFunctionRelationshipsTitle,
                                   String thirdFunctionRelationships,
                                   String thirdFunctionRelationshipsTitle,
                                   String forthFunctionRelationships,
                                   String forthFunctionRelationshipsTitle){
        this.firstFunctionRelationships = firstFunctionRelationships;
        this.firstFunctionRelationshipsTitle = firstFunctionRelationshipsTitle;
        this.secondFunctionRelationshipsTitle = secondFunctionRelationshipsTitle;
        this.secondFunctionRelationships = secondFunctionRelationships;
        this.thirdFunctionRelationships = thirdFunctionRelationships;
        this.thirdFunctionRelationshipsTitle = thirdFunctionRelationshipsTitle;
        this.forthFunctionRelationships = forthFunctionRelationships;
        this.forthFunctionRelationshipsTitle = forthFunctionRelationshipsTitle;
    }

    public String getFirstFunctionRelationships() {
        return firstFunctionRelationships;
    }

    public String getSecondFunctionRelationships() {
        return secondFunctionRelationships;
    }

    public String getThirdFunctionRelationships() {
        return thirdFunctionRelationships;
    }

    public String getForthFunctionRelationships() {
        return forthFunctionRelationships;
    }

    public String getFirstFunctionRelationshipsTitle() {
        return firstFunctionRelationshipsTitle;
    }

    public String getSecondFunctionRelationshipsTitle() {
        return secondFunctionRelationshipsTitle;
    }

    public String getThirdFunctionRelationshipsTitle() {
        return thirdFunctionRelationshipsTitle;
    }

    public String getForthFunctionRelationshipsTitle() {
        return forthFunctionRelationshipsTitle;
    }
}
