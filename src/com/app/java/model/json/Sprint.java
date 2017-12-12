package com.app.java.model.json;

public class Sprint {
    //    private String class;
    private int id;
    private int activities_count;
    private int attachments_count;
    private float capacity;
    private float dailyWorkTime;
    private String dateCreated;
    private String deliveredVersion;
    private String description;
    private String doneDate;
    private String doneDefinition;
    private String endDate;
    private String goal;
    private String inProgressDate;
    private float initialRemainingTime;
    private String lastUpdated;
    private int orderNumber;
    private Release parentRelease;
    private String retrospective;
    private String startDate;
    private int state;
    private int[] stories_ids;
    private int tasks_count;
    private String todoDate;
    private float velocity;
    private boolean activable;
    private float totalRemaining;
    private int duration;
    private int index;
    private int expectedAvailability;
    private int actualAvailability;
    private String retrospective_html;
    private String doneDefinition_html;

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

    public int getAttachments_count() {
        return attachments_count;
    }

    public void setAttachments_count(int attachments_count) {
        this.attachments_count = attachments_count;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getDailyWorkTime() {
        return dailyWorkTime;
    }

    public void setDailyWorkTime(float dailyWorkTime) {
        this.dailyWorkTime = dailyWorkTime;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDeliveredVersion() {
        return deliveredVersion;
    }

    public void setDeliveredVersion(String deliveredVersion) {
        this.deliveredVersion = deliveredVersion;
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

    public String getInProgressDate() {
        return inProgressDate;
    }

    public void setInProgressDate(String inProgressDate) {
        this.inProgressDate = inProgressDate;
    }

    public float getInitialRemainingTime() {
        return initialRemainingTime;
    }

    public void setInitialRemainingTime(float initialRemainingTime) {
        this.initialRemainingTime = initialRemainingTime;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Release getParentRelease() {
        return parentRelease;
    }

    public void setParentRelease(Release parentRelease) {
        this.parentRelease = parentRelease;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int[] getStories_ids() {
        return stories_ids;
    }

    public void setStories_ids(int[] stories_ids) {
        this.stories_ids = stories_ids;
    }

    public int getTasks_count() {
        return tasks_count;
    }

    public void setTasks_count(int tasks_count) {
        this.tasks_count = tasks_count;
    }

    public String getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(String todoDate) {
        this.todoDate = todoDate;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public boolean isActivable() {
        return activable;
    }

    public void setActivable(boolean activable) {
        this.activable = activable;
    }

    public float getTotalRemaining() {
        return totalRemaining;
    }

    public void setTotalRemaining(float totalRemaining) {
        this.totalRemaining = totalRemaining;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getExpectedAvailability() {
        return expectedAvailability;
    }

    public void setExpectedAvailability(int expectedAvailability) {
        this.expectedAvailability = expectedAvailability;
    }

    public int getActualAvailability() {
        return actualAvailability;
    }

    public void setActualAvailability(int actualAvailability) {
        this.actualAvailability = actualAvailability;
    }

    public String getRetrospective_html() {
        return retrospective_html;
    }

    public void setRetrospective_html(String retrospective_html) {
        this.retrospective_html = retrospective_html;
    }

    public String getDoneDefinition_html() {
        return doneDefinition_html;
    }

    public void setDoneDefinition_html(String doneDefinition_html) {
        this.doneDefinition_html = doneDefinition_html;
    }
}
