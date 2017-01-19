package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskTypes {
    RECURRENT("10"), URGENT("11");

    private String identifier;

    TaskTypes(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
