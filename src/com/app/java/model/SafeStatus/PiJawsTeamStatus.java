package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiJawsTeamStatus extends PiStatus {
    public PiJawsTeamStatus() {
        super.name = TeamNames.JAWS.getTeamName();
        super.avgPoints = 8;
    }
}
