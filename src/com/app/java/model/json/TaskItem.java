package com.app.java.model.json;

public class TaskItem {
    //    private String class;
    private int id;
    private int activities_count;
    private int attachments_count;
    private TimeBox backlog;
    private boolean blocked;
    private String color;
    private int comments_count;
    private User creator;
    private String dateCreated;
    private String description;
    private String doneDate;
    private float estimation;
    private String inProgressDate;
    private float initial;
    private String lastUpdated;
    private String name;
    private String notes;
    private Project parentProject;
    private ParentStory parentStory;
    private int rank;
    private User responsible;
    private int state;
    private String todoDate;
    private String type;
    private int uid;
    private String[] tags;
    private Sprint sprint;
    //    private String[] commits;
//    private String[] builds;
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

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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

    public float getEstimation() {
        return estimation;
    }

    public void setEstimation(float estimation) {
        this.estimation = estimation;
    }

    public String getInProgressDate() {
        return inProgressDate;
    }

    public void setInProgressDate(String inProgressDate) {
        this.inProgressDate = inProgressDate;
    }

    public float getInitial() {
        return initial;
    }

    public void setInitial(float initial) {
        this.initial = initial;
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

    public Project getParentProject() {
        return parentProject;
    }

    public void setParentProject(Project parentProject) {
        this.parentProject = parentProject;
    }

    public ParentStory getParentStory() {
        return parentStory;
    }

    public void setParentStory(ParentStory parentStory) {
        this.parentStory = parentStory;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

//    public String[] getCommits() {
//        return commits;
//    }
//
//    public void setCommits(String[] commits) {
//        this.commits = commits;
//    }
//
//    public String[] getBuilds() {
//        return builds;
//    }
//
//    public void setBuilds(String[] builds) {
//        this.builds = builds;
//    }

    public String getNotes_html() {
        return notes_html;
    }

    public void setNotes_html(String notes_html) {
        this.notes_html = notes_html;
    }
}
