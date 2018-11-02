package com.app.java.util.task;

import com.app.java.MainForm;
import com.app.java.model.enums.Projects;
import com.app.java.model.enums.ReleaseStates;
import com.app.java.model.enums.SprintStates;
import com.app.java.model.json.*;
import com.app.java.util.TaktTimeStories;
import com.app.java.util.customJsonDeserializer.SprintDeserializer;
import com.app.java.util.customJsonDeserializer.StoryDeserializer;
import com.app.java.util.excel.ExcelUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.Reader;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;

/**
 * Created by elamoureux on 1/26/2017.
 */
public class AllDataAllProjects extends TaskWorkerAllProjects {
    public AllDataAllProjects(JProgressBar jProgressBar, JLabel jLabel) {
        super(jProgressBar, jLabel);
    }

    /*
     * Main taskWorker. Executed in background thread.
     */
    @Override
    public Void doInBackground() {
        int count = 0;
        int total = Projects.values().length;

        jLabel.setText(count + " / " + total);

        for (Projects p : Projects.values()) {
            count++;
            jLabel.setText(count + " / " + total);

            MainForm.currentProjectId = p.getIdentifier();
            MainForm.currentProjectName = p.getPrjName();

            MainForm.icescrumRelease.setProject(MainForm.currentProjectId);
            MainForm.icescrumSprint.setProject(MainForm.currentProjectId);
            MainForm.icescrumStory.setProject(MainForm.currentProjectId);
            MainForm.icescrumTask.setProject(MainForm.currentProjectId);
            MainForm.icescrumFeature.setProject(MainForm.currentProjectId);
            MainForm.icescrumActor.setProject(MainForm.currentProjectId);
            MainForm.icescrumAvailability.setProject(MainForm.currentProjectId);

            //        jProgressBar.setIndeterminate(true);
            jProgressBar.setStringPainted(true);
            jProgressBar.setValue(0);

            MainForm.currentReleaseId = 0;
            MainForm.currentSprintId = 0;
            MainForm.firstSprintId = 0;

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

            jProgressBar.setValue(15);

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
                    if (sprint.getParentRelease().getId() == MainForm.currentReleaseId) {
                        MainForm.allSprintInCurrentRelease.put(sprint.getId(), sprint);

                        if (sprint.getOrderNumber() == 1) {
                            MainForm.firstSprintId = sprint.getId();
                        }

                        if (sprint.getState() == SprintStates.IN_PROGRESS.getIdentifier()) {
                            MainForm.currentSprintId = sprint.getId();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            jProgressBar.setValue(25);

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

            jProgressBar.setValue(45);

            try {
                MainForm.allTasksInCurrentSprint.clear();
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
                        } else {
                            if (taskItem.getSprint().getId() == MainForm.currentSprintId) {
                                MainForm.allTasksInCurrentSprint.put(taskItem.getId(), taskItem);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            jProgressBar.setValue(75);

            try {
                StringBuffer stringBuffer = MainForm.icescrumFeature.getAll();
                Reader reader = new StringReader(stringBuffer.toString());
                Gson gson = new GsonBuilder().create();
                MainForm.features = gson.fromJson(reader, Feature[].class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            jProgressBar.setValue(85);

            try {
                TaktTimeStories taktTimeStories = new TaktTimeStories(MainForm.sprints);
                MainForm.taktTimeData = taktTimeStories.getTaktTimeData();
            } catch (Exception e) {
                e.printStackTrace();
            }

            jProgressBar.setValue(90);

            ExcelUtil.ExportToFile();

            jProgressBar.setValue(100);

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
