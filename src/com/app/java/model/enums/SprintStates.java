package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum SprintStates {
    TODO("1"), IN_PROGRESS("2"), DONE("3");

    private String identifier;

    SprintStates(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
