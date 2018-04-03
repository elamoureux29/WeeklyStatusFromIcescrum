package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum StoryTestStates {
    NO_TEST(0), TO_CHECK(1), FAILED(5), SUCCESS(10);

    private int identifier;

    StoryTestStates(int s) {
        identifier = s;
    }

    public int getIdentifier() {
        return identifier;
    }
}
