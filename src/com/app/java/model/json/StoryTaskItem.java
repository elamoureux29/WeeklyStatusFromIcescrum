package com.app.java.model.json;

public class StoryTaskItem {
    private String name;
    private String color;
    //    private float estimation;
    private StoryTaskItemStory parentStory;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

//    public float getEstimation() {
//        return estimation;
//    }
//
//    public void setEstimation(float estimation) {
//        this.estimation = estimation;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StoryTaskItemStory getParentStory() {
        return parentStory;
    }

    public void setParentStory(StoryTaskItemStory parentStory) {
        this.parentStory = parentStory;
    }
}
