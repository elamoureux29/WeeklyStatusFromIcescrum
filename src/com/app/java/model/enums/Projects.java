package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum Projects {
    ENTRAPASS("KT760055"), QA_IMPROVEMENT("PROJ12118");

    private String identifier;

    Projects(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
