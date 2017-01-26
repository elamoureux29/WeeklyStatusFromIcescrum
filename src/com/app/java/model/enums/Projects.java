package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum Projects {
    ENTRAPASS("EntraPass", "KT760055"), QA_IMPROVEMENTS("QA Improvements", "PROJ12118");

    private String prjName;
    private String identifier;

    Projects(String s1, String s2) {
        prjName = s1;
        identifier = s2;
    }

    public String getPrjName() {
        return prjName;
    }

    public String getIdentifier() {
        return identifier;
    }
}
