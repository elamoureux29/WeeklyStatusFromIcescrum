package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiPikeTeamStatus extends PiStatus {
    public PiPikeTeamStatus() {
        super.name = TeamNames.PIKE.getTeamName();
        super.avgPoints = 8;
    }
}
