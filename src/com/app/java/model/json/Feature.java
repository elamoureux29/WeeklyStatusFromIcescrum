package com.app.java.model.json;

public class Feature {
    //    private String class;
    private int id;
    private int activities_count;
    private int attachments_count;
    private TimeBox backlog;
    private String color;
    private int comments_count;
    private String dateCreated;
    private String description;
    private String lastUpdated;
    private String name;
    private String notes;
    private Release parentRelease;
    private int rank;
    private Id[] stories_ids;
    private String todoDate;
    private int type;
    private int uid;
    private int value;
    private int countDoneStories;
    private int state;
    private float effort;
    private String[] tags;
    private String inProgressDate;
    private String doneDate;
    private String notes_html;

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

    public TimeBox getBacklog() {
        return backlog;
    }

    public void setBacklog(TimeBox backlog) {
        this.backlog = backlog;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Release getParentRelease() {
        return parentRelease;
    }

    public void setParentRelease(Release parentRelease) {
        this.parentRelease = parentRelease;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Id[] getStories_ids() {
        return stories_ids;
    }

    public void setStories_ids(Id[] stories_ids) {
        this.stories_ids = stories_ids;
    }

    public String getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(String todoDate) {
        this.todoDate = todoDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCountDoneStories() {
        return countDoneStories;
    }

    public void setCountDoneStories(int countDoneStories) {
        this.countDoneStories = countDoneStories;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getEffort() {
        return effort;
    }

    public void setEffort(float effort) {
        this.effort = effort;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getInProgressDate() {
        return inProgressDate;
    }

    public void setInProgressDate(String inProgressDate) {
        this.inProgressDate = inProgressDate;
    }

    public String getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(String doneDate) {
        this.doneDate = doneDate;
    }

    public String getNotes_html() {
        return notes_html;
    }

    public void setNotes_html(String notes_html) {
        this.notes_html = notes_html;
    }
}
