package com.app.java.model;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskFilters {
    CURRENT_USER("user"), FREE("free");

    private String identifier;

    TaskFilters(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
