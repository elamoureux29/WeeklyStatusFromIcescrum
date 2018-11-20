package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiAcdcTeamStatus extends PiStatus {
    public PiAcdcTeamStatus() {
        super.name = TeamNames.ACDC.getTeamName();
        super.avgPoints = 8;
    }
}
