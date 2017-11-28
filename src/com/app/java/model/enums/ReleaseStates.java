package com.app.java.model.enums;

import java.util.HashMap;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum ReleaseStates {
    TODO(1), IN_PROGRESS(2), DONE(3);

    // Reverse-lookup map for getting the Key from an Identifier
    private static HashMap<Integer, ReleaseStates> lookup = new HashMap<>();

    static {
        for (ReleaseStates d : ReleaseStates.values()) {
            lookup.put(d.getIdentifier(), d);
        }
    }

    private int identifier;

    ReleaseStates(int s) {
        identifier = s;
    }

    public static ReleaseStates getKey(String identifier) {
        return lookup.get(identifier);
    }

    public int getIdentifier() {
        return identifier;
    }
}
