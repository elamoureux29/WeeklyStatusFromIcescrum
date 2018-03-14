package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskTypes {
    RECURRENT(10, "recurrent"), URGENT(11, "urgent");

    private int identifier;
    private String name;

    TaskTypes(int s1, String s2) {
        identifier = s1;
        name = s2;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }
}
