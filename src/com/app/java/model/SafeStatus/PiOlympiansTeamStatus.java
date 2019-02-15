package com.app.java.model.SafeStatus;

import com.app.java.model.enums.TeamNames;

public class PiOlympiansTeamStatus extends PiStatus {
    public PiOlympiansTeamStatus() {
        super.name = TeamNames.OLYMPIANS.getTeamName();
        super.avgPoints = 8;
    }
}
