package com.laushkina.anastasia.psychosophy.domain.relationships;

public class PsychotypeRelationships {
    private String firstFunctionRelationships;
    private String secondFunctionRelationships;
    private String thirdFunctionRelationships;
    private String forthFunctionRelationships;

    public PsychotypeRelationships(String firstFunctionRelationships, String secondFunctionRelationships,
                                   String thirdFunctionRelationships, String forthFunctionRelationships){
        this.firstFunctionRelationships = firstFunctionRelationships;
        this.secondFunctionRelationships = secondFunctionRelationships;
        this.thirdFunctionRelationships = thirdFunctionRelationships;
        this.forthFunctionRelationships = forthFunctionRelationships;
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
}
