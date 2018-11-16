package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiGameOfThreadsTeamStatus extends PiStatus {
    public PiGameOfThreadsTeamStatus() {
        super.name = TeamNames.GAMEOFTHREADS.getTeamName();
        super.avgPoints = 8;
    }
}
