package com.app.java.model.json;

public class TaskItemSprint {
    private int id;
    private int state;
    private int index;
    private TaskItemSprintParentRelease parentRelease;

    // GSON sets the fields directly using reflection.

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TaskItemSprintParentRelease getParentRelease() {
        return parentRelease;
    }

    public void setParentRelease(TaskItemSprintParentRelease parentRelease) {
        this.parentRelease = parentRelease;
    }
}
