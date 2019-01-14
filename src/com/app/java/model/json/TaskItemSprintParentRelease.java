package com.app.java.model.json;

public class TaskItemSprintParentRelease {
    private int id;
    private String name;

    // GSON sets the fields directly using reflection.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentReleaseName() {
        return name;
    }

    public void setParentReleaseName(String parentReleaseName) {
        this.name = parentReleaseName;
    }
}
