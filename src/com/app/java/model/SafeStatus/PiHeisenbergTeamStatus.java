package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiHeisenbergTeamStatus extends PiStatus {
    public PiHeisenbergTeamStatus() {
        super.name = TeamNames.HEISENBERG.getTeamName();
        super.avgPoints = 8;
    }
}
