package com.app.java.model;

import java.util.ArrayList;

/**
 * Created by elamoureux on 1/16/2017.
 */
public class Story {
    private int storyId;
    private ArrayList<Integer> acceptanceTestsId = new ArrayList<>();
    private String acceptedDate = "";
    private String actor = "";
    private String affectVersion = "";
    private String creationDate = "";
    private int creatorId;
    private int dependsOnId;
    private String description = "";
    private String doneDate = "";
    private String effort = "";
    private String estimatedDate = "";
    private String executionFrequency = "";
    private int featureId;
    private String inProgressDate = "";
    private String lastUpdated = "";
    private String name = "";
    private ArrayList<Integer> notesId = new ArrayList<>();
    private String origin = "";
    private int parentSprintId;
    private String plannedDate = "";
    private String rank = "";
    private String state = "";
    private String suggestedDate = "";
    private ArrayList<Integer> tasksId = new ArrayList<>();
    private String type = "";
    private String uid = "";
    private ArrayList<Integer> tagsId = new ArrayList<>();
    private ArrayList<Integer> dependencesId = new ArrayList<>();
    private String testState = "";
    private ArrayList<Integer> commentsId = new ArrayList<>();

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public ArrayList<Integer> getAcceptanceTestsId() {
        return acceptanceTestsId;
    }

    public void setAcceptanceTestsId(ArrayList<Integer> acceptanceTestsId) {
        this.acceptanceTestsId = acceptanceTestsId;
    }

    public String getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(String acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getAffectVersion() {
        return affectVersion;
    }

    public void setAffectVersion(String affectVersion) {
        this.affectVersion = affectVersion;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getDependsOnId() {
        return dependsOnId;
    }

    public void setDependsOnId(int dependsOnId) {
        this.dependsOnId = dependsOnId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(String doneDate) {
        this.doneDate = doneDate;
    }

    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    public String getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(String estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public String getExecutionFrequency() {
        return executionFrequency;
    }

    public void setExecutionFrequency(String executionFrequency) {
        this.executionFrequency = executionFrequency;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getInProgressDate() {
        return inProgressDate;
    }

    public void setInProgressDate(String inProgressDate) {
        this.inProgressDate = inProgressDate;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getNotesId() {
        return notesId;
    }

    public void setNotesId(ArrayList<Integer> notesId) {
        this.notesId = notesId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getParentSprintId() {
        return parentSprintId;
    }

    public void setParentSprintId(int parentSprintId) {
        this.parentSprintId = parentSprintId;
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String plannedDate) {
        this.plannedDate = plannedDate;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSuggestedDate() {
        return suggestedDate;
    }

    public void setSuggestedDate(String suggestedDate) {
        this.suggestedDate = suggestedDate;
    }

    public ArrayList<Integer> getTasksId() {
        return tasksId;
    }

    public void setTasksId(ArrayList<Integer> tasksId) {
        this.tasksId = tasksId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ArrayList<Integer> getTagsId() {
        return tagsId;
    }

    public void setTagsId(ArrayList<Integer> tagsId) {
        this.tagsId = tagsId;
    }

    public ArrayList<Integer> getDependencesId() {
        return dependencesId;
    }

    public void setDependencesId(ArrayList<Integer> dependencesId) {
        this.dependencesId = dependencesId;
    }

    public String getTestState() {
        return testState;
    }

    public void setTestState(String testState) {
        this.testState = testState;
    }

    public ArrayList<Integer> getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(ArrayList<Integer> commentsId) {
        this.commentsId = commentsId;
    }
}
