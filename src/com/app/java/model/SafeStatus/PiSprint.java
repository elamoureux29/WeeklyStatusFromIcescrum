package com.app.java.model.SafeStatus;

import javafx.util.Pair;

import java.util.ArrayList;

public class PiSprint {

    //For listing the item names
    private ArrayList<Pair> storyList = new ArrayList<>();
    private ArrayList<Pair> objectiveList = new ArrayList<>();

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
    private int totalObjectivesRemaining;
    private int initialObjectivesPlanned;
    private int objectivesOpen;
    private int objectivesClosed;

    public ArrayList<Pair> getStoryList() {
        return storyList;
    }

    public ArrayList<Pair> getObjectiveList() {
        return objectiveList;
    }

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

    public int getTotalObjectivesRemaining() {
        return totalObjectivesRemaining;
    }

    public void addToTotalObjectivesRemaining() {
        this.totalObjectivesRemaining++;
    }

    public int getInitialObjectivesPlanned() {
        return initialObjectivesPlanned;
    }

    public void addToInitialObjectivesPlanned() {
        this.initialObjectivesPlanned++;
    }

    public int getObjectivesOpen() {
        return objectivesOpen;
    }

    public void addToObjectivesOpen() {
        this.objectivesOpen++;
    }

    public int getObjectivesClosed() {
        return objectivesClosed;
    }

    public void addToObjectivesClosed() {
        this.objectivesClosed++;
    }
}
