package com.app.java.model.enums;

public enum TeamNames {
    ORCA("Orca", "Orca"),
    GAMEOFTHREADS("Game Of Threads", "GameOfThreads"),
    ACDC("ACDC", "AC/DC"),
    JAWS("Jaws", "Jaws"),
    STARBUGS("Starbugs", "Starbugs"),
    VOLTIGEURS("Voltigeurs", "Volts"),
    //    HEISENBERG("Heisenberg", "Heisenberg"),
    ABHYUDAY("Abhyuday", "Abhyuday"),
    DRONA("Drona", "Drona"),
    OLYMPIANS("Olympians", "Olympians"),
    BRAHMOS("Brahmos", "Brahmos"),
    PIKE("Pike", "Pike"),
    SMARTVUE("Smartvue", "Smartvue");

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
