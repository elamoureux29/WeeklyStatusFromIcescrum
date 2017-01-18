package com.app.java.model;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum StoryStates {
    SUGGESTED("1"), ACCEPTED("2"), ESTIMATED("3"), PLANNED("4"), IN_PROGRESS("5"), DONE("7");

    private String identifier;

    StoryStates(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
