package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiStarbugsTeamStatus extends PiStatus {
    public PiStarbugsTeamStatus() {
        super.name = TeamNames.STARBUGS.getTeamName();
        super.avgPoints = 8;
    }
}
