package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum AcceptanceTestStates {
    TO_CHECK(1), FAILED(5), SUCCESS(10);

    private int identifier;

    AcceptanceTestStates(int s) {
        identifier = s;
    }

    public int getIdentifier() {
        return identifier;
    }
}
