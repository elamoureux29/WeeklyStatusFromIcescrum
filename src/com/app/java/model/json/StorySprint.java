package com.app.java.model.json;

import java.util.Comparator;

public class StorySprint implements Comparable<StorySprint> {
    public static Comparator<StorySprint> ReverseOrderNumberComparator
            = new Comparator<StorySprint>() {

        public int compare(StorySprint compareSprint1, StorySprint compareSprint2) {
            //ascending order
            return compareSprint2.getOrderNumber() - compareSprint1.getOrderNumber();

            //descending order
            //return compareSprint1.getOrderNumber() - compareSprint2.getOrderNumber();
        }
    };
    //    private String class;
    private int id;
    private int state;
    private float capacity;
    private float velocity;
    private int orderNumber;
    private int parentReleaseId;
    private boolean hasNextSprint;
    private boolean reactivable;
    private String parentReleaseName;
    private String parentReleaseOrderNumber;
    private int index;


    // GSON sets the fields directly using reflection.
    private float plannedVelocity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getParentReleaseId() {
        return parentReleaseId;
    }

    public void setParentReleaseId(int parentReleaseId) {
        this.parentReleaseId = parentReleaseId;
    }

    public boolean isHasNextSprint() {
        return hasNextSprint;
    }

    public void setHasNextSprint(boolean hasNextSprint) {
        this.hasNextSprint = hasNextSprint;
    }

    public boolean isReactivable() {
        return reactivable;
    }

    public void setReactivable(boolean reactivable) {
        this.reactivable = reactivable;
    }

    public String getParentReleaseName() {
        return parentReleaseName;
    }

    public void setParentReleaseName(String parentReleaseName) {
        this.parentReleaseName = parentReleaseName;
    }

    public String getParentReleaseOrderNumber() {
        return parentReleaseOrderNumber;
    }

    public void setParentReleaseOrderNumber(String parentReleaseOrderNumber) {
        this.parentReleaseOrderNumber = parentReleaseOrderNumber;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public float getPlannedVelocity() {
        return plannedVelocity;
    }

    public void setPlannedVelocity(float plannedVelocity) {
        this.plannedVelocity = plannedVelocity;
    }

    @Override
    public int compareTo(StorySprint compareSprint) {
        //ascending order
        return this.orderNumber - compareSprint.getOrderNumber();

        //descending order
        //return compareSprint.getOrderNumber() - this.orderNumber;
    }
}
