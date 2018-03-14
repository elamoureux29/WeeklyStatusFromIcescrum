package com.app.java.util.task;

import com.app.java.MainForm;
import com.app.java.model.enums.ReleaseStates;
import com.app.java.model.enums.SprintStates;
import com.app.java.model.json.Release;
import com.app.java.model.json.Sprint;
import com.app.java.model.json.Story;
import com.app.java.model.json.TaskItem;
import com.app.java.util.TaktTimeStories;
import com.app.java.util.customJsonDeserializer.SprintDeserializer;
import com.app.java.util.customJsonDeserializer.StoryDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by elamoureux on 1/26/2017.
 */
public class AllData extends TaskWorker {
    public AllData(JProgressBar jProgressBar, JTabbedPane jTabbedPane) {
        super(jProgressBar, jTabbedPane);
    }

    /*
    * Main taskWorker. Executed in background thread.
    */
    @Override
    public Void doInBackground() {
//        jProgressBar.setIndeterminate(true);
        jTabbedPane.setCursor((Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)));
        jProgressBar.setStringPainted(true);
        jProgressBar.setValue(0);

        try {
            MainForm.allReleases.clear();
            StringBuffer stringBuffer = MainForm.icescrumRelease.getAll();
            Reader reader = new StringReader(stringBuffer.toString());
            Gson gson = new GsonBuilder().create();
            MainForm.releases = gson.fromJson(reader, Release[].class);

            for (Release release : MainForm.releases) {
                MainForm.allReleases.put(release.getId(), release);
                if (release.getState() == ReleaseStates.IN_PROGRESS.getIdentifier()) {
                    MainForm.currentReleaseId = release.getId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(25);

        try {
            MainForm.allSprintInCurrentRelease.clear();
            StringBuffer stringBuffer = MainForm.icescrumSprint.getAll();
            Reader reader = new StringReader(stringBuffer.toString());
            // Configure Gson
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Sprint.class, new SprintDeserializer());
            Gson gson = gsonBuilder.create();
            MainForm.sprints = gson.fromJson(reader, Sprint[].class);

            for (Sprint sprint : MainForm.sprints) {
                MainForm.allSprintInCurrentRelease.put(sprint.getId(), sprint);
                if (sprint.getState() == SprintStates.IN_PROGRESS.getIdentifier()) {
                    MainForm.currentSprintId = sprint.getId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(50);

        try {
            MainForm.allStoriesInCurrentSprint.clear();
            StringBuffer stringBuffer = MainForm.icescrumStory.getAll();
            Reader reader = new StringReader(stringBuffer.toString());
            // Configure Gson
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Story.class, new StoryDeserializer());
            Gson gson = gsonBuilder.create();
            MainForm.stories = gson.fromJson(reader, Story[].class);

            if (MainForm.currentSprintId != 0) {
                for (Story story : MainForm.stories) {
                    if (story.getParentSprint() != null) {
                        if (story.getParentSprint().getId() == MainForm.currentSprintId) {
                            MainForm.allStoriesInCurrentSprint.put(story.getId(), story);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(75);

        try {
            StringBuffer stringBuffer = MainForm.icescrumTask.getAll();
            Reader reader = new StringReader(stringBuffer.toString());
            // Configure Gson
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Sprint.class, new SprintDeserializer());
            Gson gson = gsonBuilder.create();
            MainForm.taskItems = gson.fromJson(reader, TaskItem[].class);

            if (!MainForm.allStoriesInCurrentSprint.isEmpty()) {
                for (TaskItem taskItem : MainForm.taskItems) {
                    if (taskItem.getParentStory() != null) {
                        if (MainForm.allStoriesInCurrentSprint.containsKey(taskItem.getParentStory().getId())) {
                            MainForm.allTasksInCurrentSprint.put(taskItem.getId(), taskItem);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(90);

        try {
            TaktTimeStories taktTimeStories = new TaktTimeStories(MainForm.sprints);
            MainForm.taktTimeData = taktTimeStories.getTaktTimeData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(100);

        return null;
    }
}
