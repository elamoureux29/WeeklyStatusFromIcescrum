package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum StoryTypes {
    USER_STORY(0), DEFECT(2), TECHNICAL_STORY(3);

    private int identifier;

    StoryTypes(int s) {
        identifier = s;
    }

    public int getIdentifier() {
        return identifier;
    }
}
