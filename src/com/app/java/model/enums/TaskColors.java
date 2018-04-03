package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskColors {
    YELLOW("#FFFF00"), BLUE("#0000FF"), GREEN("#008000"), RED("#FF0000"), ORANGE("#FFA500"), VIOLET("#EE82EE"),
    GRAY("#808080"), PINK("#FFC0CB"), LIGHTBLUE("#ADD8E6");

    private String identifier;

    TaskColors(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
