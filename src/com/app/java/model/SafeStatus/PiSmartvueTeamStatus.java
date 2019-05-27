package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiSmartvueTeamStatus extends PiStatus {
    public PiSmartvueTeamStatus() {
        super.name = TeamNames.SMARTVUE.getTeamName();
        super.avgPoints = 8;
    }
}
