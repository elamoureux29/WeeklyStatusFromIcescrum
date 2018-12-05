package com.app.java.util.task;

import com.app.java.MainForm;
import com.app.java.model.SafeStatus.*;
import com.app.java.model.enums.Projects;
import com.app.java.model.enums.ReleaseStates;
import com.app.java.model.enums.SprintStates;
import com.app.java.model.enums.TeamNames;
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
import java.util.Arrays;
import java.util.List;
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
        PiOrcaTeamStatus piOrcaTeamStatus = new PiOrcaTeamStatus();
        PiGameOfThreadsTeamStatus piGameOfThronesTeamStatus = new PiGameOfThreadsTeamStatus();
        PiStarbugsTeamStatus piStarbugsTeamStatus = new PiStarbugsTeamStatus();
        PiVoltigeursTeamStatus piVoltigeursTeamStatus = new PiVoltigeursTeamStatus();
        PiAcdcTeamStatus piAcdcTeamStatus = new PiAcdcTeamStatus();
        PiProgramStatus piProgramStatus = new PiProgramStatus();

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

            jProgressBar.setValue(10);

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

                        switch (sprint.getOrderNumber()) {
                            case 1:
                                piOrcaTeamStatus.setSprint1StartDate(sprint.getStartDate());
                                piOrcaTeamStatus.setSprint1InProgressDate(sprint.getInProgressDate());
                                piGameOfThronesTeamStatus.setSprint1StartDate(sprint.getStartDate());
                                piGameOfThronesTeamStatus.setSprint1InProgressDate(sprint.getInProgressDate());
                                piStarbugsTeamStatus.setSprint1StartDate(sprint.getStartDate());
                                piStarbugsTeamStatus.setSprint1InProgressDate(sprint.getInProgressDate());
                                piVoltigeursTeamStatus.setSprint1StartDate(sprint.getStartDate());
                                piVoltigeursTeamStatus.setSprint1InProgressDate(sprint.getInProgressDate());
                                piAcdcTeamStatus.setSprint1StartDate(sprint.getStartDate());
                                piAcdcTeamStatus.setSprint1InProgressDate(sprint.getInProgressDate());
                                piProgramStatus.setSprint1StartDate(sprint.getStartDate());
                                piProgramStatus.setSprint1InProgressDate(sprint.getInProgressDate());
                                break;
                            case 2:
                                piOrcaTeamStatus.setSprint2StartDate(sprint.getStartDate());
                                piGameOfThronesTeamStatus.setSprint2StartDate(sprint.getStartDate());
                                piStarbugsTeamStatus.setSprint2StartDate(sprint.getStartDate());
                                piVoltigeursTeamStatus.setSprint2StartDate(sprint.getStartDate());
                                piAcdcTeamStatus.setSprint2StartDate(sprint.getStartDate());
                                piProgramStatus.setSprint2StartDate(sprint.getStartDate());
                                break;
                            case 3:
                                piOrcaTeamStatus.setSprint3StartDate(sprint.getStartDate());
                                piGameOfThronesTeamStatus.setSprint3StartDate(sprint.getStartDate());
                                piStarbugsTeamStatus.setSprint3StartDate(sprint.getStartDate());
                                piVoltigeursTeamStatus.setSprint3StartDate(sprint.getStartDate());
                                piAcdcTeamStatus.setSprint3StartDate(sprint.getStartDate());
                                piProgramStatus.setSprint3StartDate(sprint.getStartDate());
                                break;
                            case 4:
                                piOrcaTeamStatus.setSprint4StartDate(sprint.getStartDate());
                                piGameOfThronesTeamStatus.setSprint4StartDate(sprint.getStartDate());
                                piStarbugsTeamStatus.setSprint4StartDate(sprint.getStartDate());
                                piVoltigeursTeamStatus.setSprint4StartDate(sprint.getStartDate());
                                piAcdcTeamStatus.setSprint4StartDate(sprint.getStartDate());
                                piProgramStatus.setSprint4StartDate(sprint.getStartDate());
                                break;
                            case 5:
                                piOrcaTeamStatus.setSprint5StartDate(sprint.getStartDate());
                                piGameOfThronesTeamStatus.setSprint5StartDate(sprint.getStartDate());
                                piStarbugsTeamStatus.setSprint5StartDate(sprint.getStartDate());
                                piVoltigeursTeamStatus.setSprint5StartDate(sprint.getStartDate());
                                piAcdcTeamStatus.setSprint5StartDate(sprint.getStartDate());
                                piProgramStatus.setSprint5StartDate(sprint.getStartDate());
                                break;
                            case 6:
                                piOrcaTeamStatus.setSprint6StartDate(sprint.getStartDate());
                                piGameOfThronesTeamStatus.setSprint6StartDate(sprint.getStartDate());
                                piStarbugsTeamStatus.setSprint6StartDate(sprint.getStartDate());
                                piVoltigeursTeamStatus.setSprint6StartDate(sprint.getStartDate());
                                piAcdcTeamStatus.setSprint6StartDate(sprint.getStartDate());
                                piProgramStatus.setSprint6StartDate(sprint.getStartDate());
                                break;
                            default:
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            jProgressBar.setValue(20);

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
                            if (story.getParentSprint().getParentReleaseId() != 0) {
                                if (story.getParentSprint().getParentReleaseId() == MainForm.currentReleaseId) {
                                    List<String> tagList = Arrays.asList(story.getTags());
                                    if (tagList.contains("Objective")) {
                                        for (String tag : story.getTags()) {
                                            if (tag.equalsIgnoreCase(TeamNames.ORCA.getIdentifier())) {
                                                piOrcaTeamStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
                                                piProgramStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
                                            } else if (tag.equalsIgnoreCase(TeamNames.GAMEOFTHREADS.getIdentifier())) {
                                                piGameOfThronesTeamStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
                                                piProgramStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
                                            } else if (tag.equalsIgnoreCase(TeamNames.STARBUGS.getIdentifier())) {
                                                piStarbugsTeamStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
                                                piProgramStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
                                            } else if (tag.equalsIgnoreCase(TeamNames.VOLTIGEURS.getIdentifier())) {
                                                piVoltigeursTeamStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
                                                piProgramStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
                                            } else if (tag.equalsIgnoreCase(TeamNames.ACDC.getIdentifier())) {
                                                piAcdcTeamStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
//                                            piProgramStatus.addObjectiveData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState());
                                            }
                                        }
                                    } else {
                                        for (String tag : story.getTags()) {
                                            if (tag.equalsIgnoreCase(TeamNames.ORCA.getIdentifier())) {
                                                piOrcaTeamStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
                                                piProgramStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
                                            } else if (tag.equalsIgnoreCase(TeamNames.GAMEOFTHREADS.getIdentifier())) {
                                                piGameOfThronesTeamStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
                                                piProgramStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
                                            } else if (tag.equalsIgnoreCase(TeamNames.STARBUGS.getIdentifier())) {
                                                piStarbugsTeamStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
                                                piProgramStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
                                            } else if (tag.equalsIgnoreCase(TeamNames.VOLTIGEURS.getIdentifier())) {
                                                piVoltigeursTeamStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
                                                piProgramStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
                                            } else if (tag.equalsIgnoreCase(TeamNames.ACDC.getIdentifier())) {
                                                piAcdcTeamStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
//                                            piProgramStatus.addStoryData(story.getName(), story.getParentSprint().getOrderNumber(), story.getDateCreated(), story.getState(), story.getEffort());
                                            }
                                        }
                                    }

                                    if (story.getParentSprint().getId() == MainForm.currentSprintId) {
                                        MainForm.allStoriesInCurrentSprint.put(story.getId(), story);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            jProgressBar.setValue(40);

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

            jProgressBar.setValue(60);

            try {
                StringBuffer stringBuffer = MainForm.icescrumFeature.getAll();
                Reader reader = new StringReader(stringBuffer.toString());
                Gson gson = new GsonBuilder().create();
                MainForm.features = gson.fromJson(reader, Feature[].class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            jProgressBar.setValue(70);

            try {
                TaktTimeStories taktTimeStories = new TaktTimeStories(MainForm.sprints);
                MainForm.taktTimeData = taktTimeStories.getTaktTimeData();
            } catch (Exception e) {
                e.printStackTrace();
            }

            jProgressBar.setValue(90);

            try {
                ExcelUtil.ExportToFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

            jProgressBar.setValue(100);

//            Added delay between project requests to prevent server from rejecting because of too many request
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            ExcelUtil.ExportPiToFile(piProgramStatus, piOrcaTeamStatus, piGameOfThronesTeamStatus, piStarbugsTeamStatus, piVoltigeursTeamStatus, piAcdcTeamStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
