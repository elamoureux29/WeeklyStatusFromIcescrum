package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskStates {
    TODO("0"), IN_PROGRESS("1"), DONE("2");

    private String identifier;

    TaskStates(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
