package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiBrahmosTeamStatus extends PiStatus {
    public PiBrahmosTeamStatus() {
        super.name = TeamNames.BRAHMOS.getTeamName();
        super.avgPoints = 8;
    }
}
