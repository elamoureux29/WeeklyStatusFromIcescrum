package com.app.java.model;

import java.util.ArrayList;

/**
 * Created by elamoureux on 1/16/2017.
 */
public class Sprint {
    private int sprintId;
    private String activationDate = "";
    private String capacity = "";
    private String closeDate = "";
    private String dailyWorkTime = "";
    private String deliveredVersion = "";
    private String doneDefinition = "";
    private String endDate = "";
    private String goal = "";
    private String initialRemainingTime = "";
    private String lastUpdated = "";
    private String orderNumber = "";
    private int parentReleaseId;
    private String retrospective = "";
    private String startDate = "";
    private String state = "";
    private ArrayList<Integer> storiesId = new ArrayList<>();
    private ArrayList<Integer> tasksId = new ArrayList<>();
    private String velocity = "";
    private String expectedAvailability = "";
    private String actualAvailability = "";

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getDailyWorkTime() {
        return dailyWorkTime;
    }

    public void setDailyWorkTime(String dailyWorkTime) {
        this.dailyWorkTime = dailyWorkTime;
    }

    public String getDeliveredVersion() {
        return deliveredVersion;
    }

    public void setDeliveredVersion(String deliveredVersion) {
        this.deliveredVersion = deliveredVersion;
    }

    public String getDoneDefinition() {
        return doneDefinition;
    }

    public void setDoneDefinition(String doneDefinition) {
        this.doneDefinition = doneDefinition;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getInitialRemainingTime() {
        return initialRemainingTime;
    }

    public void setInitialRemainingTime(String initialRemainingTime) {
        this.initialRemainingTime = initialRemainingTime;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getParentRelease() {
        return parentReleaseId;
    }

    public void setParentRelease(int parentRelease) {
        this.parentReleaseId = parentRelease;
    }

    public String getRetrospective() {
        return retrospective;
    }

    public void setRetrospective(String retrospective) {
        this.retrospective = retrospective;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<Integer> getStories() {
        return storiesId;
    }

    public void setStories(ArrayList<Integer> stories) {
        this.storiesId = stories;
    }

    public ArrayList<Integer> getTasks() {
        return tasksId;
    }

    public void setTasks(ArrayList<Integer> tasks) {
        this.tasksId = tasks;
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }

    public String getExpectedAvailability() {
        return expectedAvailability;
    }

    public void setExpectedAvailability(String expectedAvailability) {
        this.expectedAvailability = expectedAvailability;
    }

    public String getActualAvailability() {
        return actualAvailability;
    }

    public void setActualAvailability(String actualAvailability) {
        this.actualAvailability = actualAvailability;
    }
}
