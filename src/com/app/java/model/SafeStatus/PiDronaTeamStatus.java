package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiDronaTeamStatus extends PiStatus {
    public PiDronaTeamStatus() {
        super.name = TeamNames.DRONA.getTeamName();
        super.avgPoints = 8;
    }
}
