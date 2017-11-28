package com.app.java.model.json;

public class Release {
    //    private String class;
    private int id;
    private int activities_count;
    private String dateCreated;
    private String description;
    private String doneDate;
    private String endDate;
    private int features_count;
    private int firstSprintIndex;
    private String goal;
    private String inProgressDate;
    private String lastUpdated;
    private String name;
    private int orderNumber;
    private Project parentProject;
    private int sprints_count;
    private String startDate;
    private int state;
    private String todoDate;
    private String vision;
    private int duration;
    private String closable;
    private String activable;
    //    private String attachments;
    private String vision_html;

    // GSON sets the fields directly using reflection.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivities_count() {
        return activities_count;
    }

    public void setActivities_count(int activities_count) {
        this.activities_count = activities_count;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getFeatures_count() {
        return features_count;
    }

    public void setFeatures_count(int features_count) {
        this.features_count = features_count;
    }

    public int getFirstSprintIndex() {
        return firstSprintIndex;
    }

    public void setFirstSprintIndex(int firstSprintIndex) {
        this.firstSprintIndex = firstSprintIndex;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Project getParentProject() {
        return parentProject;
    }

    public void setParentProject(Project parentProject) {
        this.parentProject = parentProject;
    }

    public int getSprints_count() {
        return sprints_count;
    }

    public void setSprints_count(int sprints_count) {
        this.sprints_count = sprints_count;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(String todoDate) {
        this.todoDate = todoDate;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getClosable() {
        return closable;
    }

    public void setClosable(String closable) {
        this.closable = closable;
    }

    public String getActivable() {
        return activable;
    }

    public void setActivable(String activable) {
        this.activable = activable;
    }

    public String getVision_html() {
        return vision_html;
    }

    public void setVision_html(String vision_html) {
        this.vision_html = vision_html;
    }
}
