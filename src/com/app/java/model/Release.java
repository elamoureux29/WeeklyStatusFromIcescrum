package com.app.java.model;

/**
 * Created by elamoureux on 1/16/2017.
 */
public class Release {
    private String releaseId;
    private String endDate;
    private String[] features;
    private String goal;
    private String lastUpdated;
    private String name;
    private String orderNumber;
    private String parentProduct;
    private String releaseVelocity;
    private String[] sprints;
    private String startDate;
    private String state;
    private String vision;

    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String[] getFeatures() {
        return features;
    }

    public void setFeatures(String[] features) {
        this.features = features;
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

    public String getParentProduct() {
        return parentProduct;
    }

    public void setParentProduct(String parentProduct) {
        this.parentProduct = parentProduct;
    }

    public String getReleaseVelocity() {
        return releaseVelocity;
    }

    public void setReleaseVelocity(String releaseVelocity) {
        this.releaseVelocity = releaseVelocity;
    }

    public String[] getSprints() {
        return sprints;
    }

    public void setSprints(String[] sprints) {
        this.sprints = sprints;
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
