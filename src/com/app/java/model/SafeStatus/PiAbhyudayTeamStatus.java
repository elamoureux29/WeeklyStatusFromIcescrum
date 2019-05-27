package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiAbhyudayTeamStatus extends PiStatus {
    public PiAbhyudayTeamStatus() {
        super.name = TeamNames.ABHYUDAY.getTeamName();
        super.avgPoints = 8;
    }
}
