package com.app.java.model.SafeStatus;

public class PiSprint {

    //For Burnup based on Stories
    private int totalStories;
    private int totalStoriesRemaining;
    private int initialStoriesPlanned;
    private int storiesOpen;
    private int storiesClosed;

    //For Burnup based on Points
    private int totalStoryPoints;
    private int totalStoryPointsRemaining;
    private int initialStoryPointsPlanned;
    private int storyPointsOpen;
    private int storyPointsClosed;

    //For Burnup based on Objectives
    private int totalObjectives;
    private int initialTotalObjectives;
    private int initialplannedObjectives;
    private int actualCompletedObjectives;

    public int getTotalStories() {
        return totalStories;
    }

    public void addToTotalStories() {
        this.totalStories++;
    }

    public int getTotalStoriesRemaining() {
        return totalStoriesRemaining;
    }

    public void addToTotalStoriesRemaining() {
        this.totalStoriesRemaining++;
    }

    public int getStoriesPlanned() {
        return initialStoriesPlanned;
    }

    public void addToStoriesPlanned() {
        this.initialStoriesPlanned++;
    }

    public int getStoriesOpen() {
        return storiesOpen;
    }

    public void addToStoriesOpen() {
        this.storiesOpen++;
    }

    public int getStoriesClosed() {
        return storiesClosed;
    }

    public void addToStoriesClosed() {
        this.storiesClosed++;
    }

    public int getTotalStoryPoints() {
        return totalStoryPoints;
    }

    public void addToTotalStoryPoints(float totalStoryPointsIncrement) {
        this.totalStoryPoints += totalStoryPointsIncrement;
    }

    public int getTotalStoryPointsRemaining() {
        return totalStoryPointsRemaining;
    }

    public void addToTotalStoryPointsRemaining(float totalStoryPointsRemainingIncrement) {
        this.totalStoryPointsRemaining += totalStoryPointsRemainingIncrement;
    }

    public int getStoryPointsPlanned() {
        return initialStoryPointsPlanned;
    }

    public void addToStoryPointsPlanned(float storyPointsPlannedIncrement) {
        this.initialStoryPointsPlanned += storyPointsPlannedIncrement;
    }

    public int getStoryPointsOpen() {
        return storyPointsOpen;
    }

    public void addToStoryPointsOpen(float storyPointsOpenIncrement) {
        this.storyPointsOpen += storyPointsOpenIncrement;
    }

    public int getStoryPointsClosed() {
        return storyPointsClosed;
    }

    public void addToStoryPointsClosed(float storyPointsClosedIncrement) {
        this.storyPointsClosed += storyPointsClosedIncrement;
    }

    public int getTotalObjectives() {
        return totalObjectives;
    }

    public void addToTotalObjectives() {
        this.totalObjectives++;
    }

    public int getInitialTotalObjectives() {
        return initialTotalObjectives;
    }

    public void addToInitialTotalObjectives() {
        this.initialTotalObjectives++;
    }

    public int getInitialPlannedObjectives() {
        return initialplannedObjectives;
    }

    public void addToInitialPlannedObjectives() {
        this.initialplannedObjectives++;
    }

    public int getActualCompletedObjectives() {
        return actualCompletedObjectives;
    }

    public void addToActualCompletedObjectives() {
        this.actualCompletedObjectives++;
    }
}
