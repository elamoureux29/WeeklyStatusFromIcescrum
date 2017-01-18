package com.app.java.model;

import java.util.ArrayList;

/**
 * Created by elamoureux on 1/16/2017.
 */
public class Release {
    private int releaseId;
    private String endDate = "";
    private ArrayList<Integer> featuresId = new ArrayList<>();
    private String goal = "";
    private String lastUpdated = "";
    private String name = "";
    private String orderNumber = "";
    private int parentProductId;
    private String releaseVelocity = "";
    private ArrayList<Integer> sprintsId = new ArrayList<>();
    private String startDate = "";
    private String state = "";
    private String vision = "";

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Integer> getFeaturesId() {
        return featuresId;
    }

    public void setFeaturesId(ArrayList<Integer> featuresId) {
        this.featuresId = featuresId;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getParentProduct() {
        return parentProductId;
    }

    public void setParentProduct(int parentProduct) {
        this.parentProductId = parentProduct;
    }

    public String getReleaseVelocity() {
        return releaseVelocity;
    }

    public void setReleaseVelocity(String releaseVelocity) {
        this.releaseVelocity = releaseVelocity;
    }

    public ArrayList<Integer> getSprintsId() {
        return sprintsId;
    }

    public void setSprintsId(ArrayList<Integer> sprintsId) {
        this.sprintsId = sprintsId;
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

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }
}
