package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskStates {
    TODO(0, "To Do"), IN_PROGRESS(1, "In Progress"), DONE(2, "Done");

    private int identifier;
    private String text;

    TaskStates(int i, String t) {
        identifier = i;
        text = t;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getText() {
        return text;
    }
}
