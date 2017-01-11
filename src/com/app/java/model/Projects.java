package com.app.java.model;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum Projects {
    ENTRAPASS("KT760055"),QA_IMPROVEMENT("PROJ12118");

    private String identifier;

    private Projects(String s){
        identifier = s;
    }

    public String getIdentifier(){
        return identifier;
    }
}
