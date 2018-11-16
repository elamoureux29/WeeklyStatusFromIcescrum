package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiVoltigeursTeamStatus extends PiStatus {
    public PiVoltigeursTeamStatus() {
        super.name = TeamNames.VOLTIGEURS.getTeamName();
        super.avgPoints = 8;
    }
}
