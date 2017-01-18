package com.app.java.model;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum StoryTestStates {
    NO_TEST("0"), TO_CHECK("1"), FAILED("5"), SUCCESS("10");

    private String identifier;

    StoryTestStates(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
