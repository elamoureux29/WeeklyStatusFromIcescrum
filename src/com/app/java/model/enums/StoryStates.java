package com.app.java.model.enums;

import java.util.HashMap;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum StoryStates {
    SUGGESTED(1), ACCEPTED(2), ESTIMATED(3), PLANNED(4), IN_PROGRESS(5), DONE(7), FROZEN(-1);

    // Reverse-lookup map for getting the Key from an Identifier
    private static HashMap<Integer, StoryStates> lookup = new HashMap<>();

    static {
        for (StoryStates d : StoryStates.values()) {
            lookup.put(d.getIdentifier(), d);
        }
    }

    private int identifier;

    StoryStates(int s) {
        identifier = s;
    }

    public static StoryStates getKey(int identifier) {
        return lookup.get(identifier);
    }

    public int getIdentifier() {
        return identifier;
    }
}
