package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum Projects {
    ENTRAPASSV730("EntraPass v6.02 - v7.30", "KT760055"), ENTRAPASSV740("EntraPass v7.40", "TSP1323"), ENTRAPASSV750("EntraPass v7.50", "TSP1329"), ENTRAPASSV800("EntraPass v8.00", "TSP1326"), QA_IMPROVEMENTS("QA Improvements", "PROJ12118");

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
