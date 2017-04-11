package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskTypes {
    RECURRENT("10", "recurrent"), URGENT("11", "urgent");

    private String identifier;
    private String name;

    TaskTypes(String s1, String s2) {
        identifier = s1;
        name = s2;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }
}
