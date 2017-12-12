package com.app.java.model.xml;

import java.util.ArrayList;

/**
 * Created by elamoureux on 1/16/2017.
 */
public class XmlTaskItem {
    private int taskId;
    private int backlogId;
    private String blocked = "";
    private String color = "";
    private String creationDate = "";
    private int creatorId;
    private String description = "";
    private String doneDate = "";
    private String estimation = "";
    private String inProgressDate = "";
    private String initial = "";
    private String lastUpdated = "";
    private String name = "";
    private ArrayList<Integer> notesId = new ArrayList<>();
    private int parentStoryId;
    private ArrayList<Integer> participantsId = new ArrayList<>();
    private String rank = "";
    private int responsibleId;
    private String state = "";
    private String type = "";
    private String uid = "";
    private ArrayList<Integer> tagsId = new ArrayList<>();
    private ArrayList<Integer> commentsId = new ArrayList<>();

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getBacklogId() {
        return backlogId;
    }

    public void setBacklogId(int backlogId) {
        this.backlogId = backlogId;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
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

    public String getEstimation() {
        return estimation;
    }

    public void setEstimation(String estimation) {
        this.estimation = estimation;
    }

    public String getInProgressDate() {
        return inProgressDate;
    }

    public void setInProgressDate(String inProgressDate) {
        this.inProgressDate = inProgressDate;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
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

    public ArrayList<Integer> getNotesId() {
        return notesId;
    }

    public void setNotesId(ArrayList<Integer> notesId) {
        this.notesId = notesId;
    }

    public int getParentStoryId() {
        return parentStoryId;
    }

    public void setParentStoryId(int parentStoryId) {
        this.parentStoryId = parentStoryId;
    }

    public ArrayList<Integer> getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(ArrayList<Integer> participantsId) {
        this.participantsId = participantsId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ArrayList<Integer> getTagsId() {
        return tagsId;
    }

    public void setTagsId(ArrayList<Integer> tagsId) {
        this.tagsId = tagsId;
    }

    public ArrayList<Integer> getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(ArrayList<Integer> commentsId) {
        this.commentsId = commentsId;
    }
}
