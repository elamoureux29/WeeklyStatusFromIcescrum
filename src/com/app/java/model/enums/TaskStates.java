package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskStates {
    TODO("0", "To Do"), IN_PROGRESS("1", "In Progress"), DONE("2", "Done");

    private String identifier;
    private String text;

    TaskStates(String i, String t) {
        identifier = i;
        text = t;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getText() {
        return text;
    }
}
