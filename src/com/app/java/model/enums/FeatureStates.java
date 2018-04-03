package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum FeatureStates {
    TODO(1), IN_PROGRESS(2), DONE(3);

    private int identifier;

    FeatureStates(int s) {
        identifier = s;
    }

    public int getIdentifier() {
        return identifier;
    }
}
