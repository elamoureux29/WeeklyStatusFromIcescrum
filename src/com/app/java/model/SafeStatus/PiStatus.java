package com.app.java.model.SafeStatus;

import com.app.java.model.enums.StoryStates;
import com.app.java.util.DateFormat;
import javafx.util.Pair;

public abstract class PiStatus {
    protected String name;
    protected int avgPoints;
    protected PiSprint[] piSprints = new PiSprint[6];
    protected String[] sprintsStartDate = new String[6];
    protected String sprint1InProgressDate;

    public PiStatus() {
        for (int i = 0; i < piSprints.length; i++) {
            piSprints[i] = new PiSprint();
        }
    }

    public String getName() {
        return name;
    }

    public int getAvgPoints() {
        return avgPoints;
    }

    public PiSprint[] getPiSprints() {
        return piSprints;
    }

    public void setSprint1StartDate(String sprint1StartDate) {
        this.sprintsStartDate[0] = sprint1StartDate;
    }

    public void setSprint2StartDate(String sprint2StartDate) {
        this.sprintsStartDate[1] = sprint2StartDate;
    }

    public void setSprint3StartDate(String sprint3StartDate) {
        this.sprintsStartDate[2] = sprint3StartDate;
    }

    public void setSprint4StartDate(String sprint4StartDate) {
        this.sprintsStartDate[3] = sprint4StartDate;
    }

    public void setSprint5StartDate(String sprint5StartDate) {
        this.sprintsStartDate[4] = sprint5StartDate;
    }

    public void setSprint6StartDate(String sprint6StartDate) {
        this.sprintsStartDate[5] = sprint6StartDate;
    }

    public void setSprint1InProgressDate(String sprint1InProgressDate) {
        this.sprint1InProgressDate = sprint1InProgressDate;
    }

    public void addStoryData(String storyName, int parentSprintOrderNumber, String dateCreated, int storyState, float storyPoints) {
        if (parentSprintOrderNumber <= 6) {
            if (DateFormat.DateParse(dateCreated).isBefore(DateFormat.DateParse(sprint1InProgressDate))) {
                piSprints[parentSprintOrderNumber - 1].addToStoriesPlanned();
                piSprints[parentSprintOrderNumber - 1].addToStoryPointsPlanned(storyPoints);
            }

            if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprint1InProgressDate))) {
                for (int i = 1; i < 6; i++) {
                    piSprints[i].addToTotalStories();
                    piSprints[i].addToTotalStoryPoints(storyPoints);

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 1; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }
            } else if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprintsStartDate[1]))) {
                for (int i = 2; i < 6; i++) {
                    piSprints[i].addToTotalStories();
                    piSprints[i].addToTotalStoryPoints(storyPoints);

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 2; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }
            } else if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprintsStartDate[2]))) {
                for (int i = 3; i < 6; i++) {
                    piSprints[i].addToTotalStories();
                    piSprints[i].addToTotalStoryPoints(storyPoints);

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 3; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }
            } else if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprintsStartDate[3]))) {
                for (int i = 4; i < 6; i++) {
                    piSprints[i].addToTotalStories();
                    piSprints[i].addToTotalStoryPoints(storyPoints);

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 4; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }
            } else if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprintsStartDate[4]))) {
                for (int i = 5; i < 6; i++) {
                    piSprints[i].addToTotalStories();
                    piSprints[i].addToTotalStoryPoints(storyPoints);

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 5; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }
            } else {
                for (int i = 0; i < 6; i++) {
                    piSprints[i].addToTotalStories();
                    piSprints[i].addToTotalStoryPoints(storyPoints);

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 0; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalStoriesRemaining();
                        piSprints[i].addToTotalStoryPointsRemaining(storyPoints);
                    }
                }
            }

            if (storyState == StoryStates.DONE.getIdentifier()) {
                piSprints[parentSprintOrderNumber - 1].addToStoriesClosed();
                piSprints[parentSprintOrderNumber - 1].addToStoryPointsClosed(storyPoints);
            } else {
                piSprints[parentSprintOrderNumber - 1].addToStoriesOpen();
                piSprints[parentSprintOrderNumber - 1].addToStoryPointsOpen(storyPoints);
            }

            Pair<String, String> myPair = new Pair<>(storyName, StoryStates.getKey(storyState).toString());
            piSprints[parentSprintOrderNumber - 1].getStoryList().add(myPair);
        }
    }

    public void addObjectiveData(String objectiveName, int parentSprintOrderNumber, String dateCreated, int storyState) {
        if (parentSprintOrderNumber <= 6) {
//            Temporary change from sprint1InProgressDate to sprintsStartDate[1]
            if (DateFormat.DateParse(dateCreated).isBefore(DateFormat.DateParse(sprintsStartDate[1]))) {
                piSprints[parentSprintOrderNumber - 1].addToInitialObjectivesPlanned();
            }

            if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprint1InProgressDate))) {
//            Temporary change from i = 1 to i = 0
                for (int i = 0; i < 6; i++) {
                    piSprints[i].addToTotalObjectives();

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 1; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }
            } else if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprintsStartDate[1]))) {
                for (int i = 2; i < 6; i++) {
                    piSprints[i].addToTotalObjectives();

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 2; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }
            } else if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprintsStartDate[2]))) {
                for (int i = 3; i < 6; i++) {
                    piSprints[i].addToTotalObjectives();

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 3; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }
            } else if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprintsStartDate[3]))) {
                for (int i = 4; i < 6; i++) {
                    piSprints[i].addToTotalObjectives();

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 4; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }
            } else if (DateFormat.DateParse(dateCreated).isAfter(DateFormat.DateParse(sprintsStartDate[4]))) {
                for (int i = 5; i < 6; i++) {
                    piSprints[i].addToTotalObjectives();

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 5; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }
            } else {
                for (int i = 0; i < 6; i++) {
                    piSprints[i].addToTotalObjectives();

                    if (storyState != StoryStates.DONE.getIdentifier()) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }

                if (storyState == StoryStates.DONE.getIdentifier()) {
                    for (int i = 0; i < parentSprintOrderNumber - 1; i++) {
                        piSprints[i].addToTotalObjectivesRemaining();
                    }
                }
            }

            if (storyState == StoryStates.DONE.getIdentifier()) {
                piSprints[parentSprintOrderNumber - 1].addToObjectivesClosed();
            } else {
                piSprints[parentSprintOrderNumber - 1].addToObjectivesOpen();
            }

            Pair<String, String> myPair = new Pair<>(objectiveName, StoryStates.getKey(storyState).toString());
            piSprints[parentSprintOrderNumber - 1].getObjectiveList().add(myPair);
        }
    }
}
