package com.app.java.model.json;

public class SprintTaskItem {
    private String name;
    private String color;
    private float estimation;
    private int type;
    private SprintTaskItemTimeBox backlog;

    public SprintTaskItemTimeBox getBacklog() {
        return backlog;
    }

    public void setBacklog(SprintTaskItemTimeBox backlog) {
        this.backlog = backlog;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getEstimation() {
        return estimation;
    }

    public void setEstimation(float estimation) {
        this.estimation = estimation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
