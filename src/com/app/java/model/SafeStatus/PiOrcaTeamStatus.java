package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiOrcaTeamStatus extends PiStatus {
    public PiOrcaTeamStatus() {
        super.name = TeamNames.ORCA.getTeamName();
        super.avgPoints = 8;
    }
}
