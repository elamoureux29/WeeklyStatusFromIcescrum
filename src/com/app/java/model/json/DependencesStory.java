package com.app.java.model.json;

public class DependencesStory {
    //    private String class;
    private int id;
    private int acceptanceTests_count;
    private String acceptedDate;
    private int activities_count;
    private int[] actors_ids;
    private String affectVersion;
    private int attachments_count;
    private TimeBox backlog;
    private int comments_count;
    private User creator;
    private String dateCreated;
    private DependencesStory dependsOn;
    private String description;
    private String doneDate;
    private float effort;
    private String estimatedDate;
    private Feature feature;
    private int followers_count;
    private String inProgressDate;
    private String lastUpdated;
    private String name;
    private String notes;
    private String origin;
    private Sprint parentSprint;
    private String plannedDate;
    private int rank;
    private int state;
    private String suggestedDate;
    private int tasks_count;
    private String todoDate;
    private int type;
    private int uid;
    private int value;
    private int voters_count;
    private int testState;
    private String[] tags;
    private DependencesStory[] dependences;
    private boolean followed;
    private int countDoneTasks;
    private int commits_count;
    private int builds_count;
    private boolean hasVotedFor;
    private String notes_html;

    // GSON sets the fields directly using reflection.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcceptanceTests_count() {
        return acceptanceTests_count;
    }

    public void setAcceptanceTests_count(int acceptanceTests_count) {
        this.acceptanceTests_count = acceptanceTests_count;
    }

    public String getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(String acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public int getActivities_count() {
        return activities_count;
    }

    public void setActivities_count(int activities_count) {
        this.activities_count = activities_count;
    }

    public int[] getActors_ids() {
        return actors_ids;
    }

    public void setActors_ids(int[] actors_ids) {
        this.actors_ids = actors_ids;
    }

    public String getAffectVersion() {
        return affectVersion;
    }

    public void setAffectVersion(String affectVersion) {
        this.affectVersion = affectVersion;
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

    public DependencesStory getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(DependencesStory dependsOn) {
        this.dependsOn = dependsOn;
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

    public float getEffort() {
        return effort;
    }

    public void setEffort(float effort) {
        this.effort = effort;
    }

    public String getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(String estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Sprint getParentSprint() {
        return parentSprint;
    }

    public void setParentSprint(Sprint parentSprint) {
        this.parentSprint = parentSprint;
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String plannedDate) {
        this.plannedDate = plannedDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSuggestedDate() {
        return suggestedDate;
    }

    public void setSuggestedDate(String suggestedDate) {
        this.suggestedDate = suggestedDate;
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

    public int getVoters_count() {
        return voters_count;
    }

    public void setVoters_count(int voters_count) {
        this.voters_count = voters_count;
    }

    public int getTestState() {
        return testState;
    }

    public void setTestState(int testState) {
        this.testState = testState;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public DependencesStory[] getDependences() {
        return dependences;
    }

    public void setDependences(DependencesStory[] dependences) {
        this.dependences = dependences;
    }

    public boolean getFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public int getCountDoneTasks() {
        return countDoneTasks;
    }

    public void setCountDoneTasks(int countDoneTasks) {
        this.countDoneTasks = countDoneTasks;
    }

    public int getCommits_count() {
        return commits_count;
    }

    public void setCommits_count(int commits_count) {
        this.commits_count = commits_count;
    }

    public int getBuilds_count() {
        return builds_count;
    }

    public void setBuilds_count(int builds_count) {
        this.builds_count = builds_count;
    }

    public boolean getHasVotedFor() {
        return hasVotedFor;
    }

    public void setHasVotedFor(boolean hasVotedFor) {
        this.hasVotedFor = hasVotedFor;
    }

    public String getNotes_html() {
        return notes_html;
    }

    public void setNotes_html(String notes_html) {
        this.notes_html = notes_html;
    }
}
