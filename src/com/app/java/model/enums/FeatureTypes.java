package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum FeatureTypes {
    FUNCTIONAL(0), ARCHITECTURAL(1);

    private int identifier;

    FeatureTypes(int s) {
        identifier = s;
    }

    public int getIdentifier() {
        return identifier;
    }
}
