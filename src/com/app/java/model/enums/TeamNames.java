package com.app.java.model.enums;

public enum TeamNames {
    ORCA("Orca", "Orca"),
    GAMEOFTHREADS("Game Of Threads", "GameOfThreads"),
    STARBUGS("Starbugs", "Starbugs"),
    VOLTIGEURS("Voltigeurs", "Volts"),
    ACDC("ACDC", "AC/DC");

    private final String teamName;
    private final String identifier;

    TeamNames(String s1, String s2) {
        teamName = s1;
        identifier = s2;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getIdentifier() {
        return identifier;
    }
}
