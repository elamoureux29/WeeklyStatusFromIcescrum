package com.app.java.model.enums;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskColors {
    YELLOW("yellow"), BLUE("blue"), GREEN("green"), RED("red"), ORANGE("orange"), VIOLET("violet"),
    GRAY("gray"), PINK("pink"), LIGHTBLUE("bluelight");

    private String identifier;

    TaskColors(String s) {
        identifier = s;
    }

    public String getIdentifier() {
        return identifier;
    }
}
