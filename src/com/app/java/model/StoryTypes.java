package com.app.java.model;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum StoryTypes {
    USER_STORY("0"), DEFECT("2"), TECHNICAL_STORY("3");

    private String identifier;

    StoryTypes(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
