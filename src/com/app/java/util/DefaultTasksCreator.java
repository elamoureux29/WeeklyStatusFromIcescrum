package com.app.java.util;

import com.app.java.model.CreateTaskItem;
import com.app.java.model.enums.TaskColors;
import com.app.java.model.enums.TaskTypes;

import java.util.ArrayList;

/**
 * Created by elamoureux on 4/21/2017.
 */
public class DefaultTasksCreator {
    public static ArrayList<CreateTaskItem> getStoryDefaultTasks(int currentSprintId, int parentStoryId) {
        ArrayList<CreateTaskItem> defaultTasks = new ArrayList<>();

        CreateTaskItem codeTaskItem = new CreateTaskItem(currentSprintId, parentStoryId, "Code");
        codeTaskItem.setColor(TaskColors.YELLOW);
        defaultTasks.add(codeTaskItem);

        CreateTaskItem debugTaskItem = new CreateTaskItem(currentSprintId, parentStoryId, "Debug");
        debugTaskItem.setColor(TaskColors.RED);
        defaultTasks.add(debugTaskItem);

        CreateTaskItem codeReviewTaskItem = new CreateTaskItem(currentSprintId, parentStoryId, "Code Review");
        codeReviewTaskItem.setColor(TaskColors.ORANGE);
        defaultTasks.add(codeReviewTaskItem);

        CreateTaskItem tpTaskItem = new CreateTaskItem(currentSprintId, parentStoryId, "Test Plan");
        tpTaskItem.setColor(TaskColors.LIGHTBLUE);
        defaultTasks.add(tpTaskItem);

        CreateTaskItem testsTaskItem = new CreateTaskItem(currentSprintId, parentStoryId, "Tests");
        testsTaskItem.setColor(TaskColors.BLUE);
        defaultTasks.add(testsTaskItem);

        return defaultTasks;
    }

    public static ArrayList<CreateTaskItem> getIssueStoryDefaultTasks(int currentSprintId, int parentStoryId) {
        ArrayList<CreateTaskItem> defaultTasks = new ArrayList<>();

        CreateTaskItem codeTaskItem = new CreateTaskItem(currentSprintId, parentStoryId, "Code");
        codeTaskItem.setColor(TaskColors.YELLOW);
        codeTaskItem.setEstimation(12);
        defaultTasks.add(codeTaskItem);

        CreateTaskItem codeReviewTaskItem = new CreateTaskItem(currentSprintId, parentStoryId, "Code Review");
        codeReviewTaskItem.setColor(TaskColors.ORANGE);
        codeReviewTaskItem.setEstimation(2);
        defaultTasks.add(codeReviewTaskItem);

        CreateTaskItem testsTaskItem = new CreateTaskItem(currentSprintId, parentStoryId, "Tests");
        testsTaskItem.setColor(TaskColors.BLUE);
        codeTaskItem.setEstimation(6);
        defaultTasks.add(testsTaskItem);

        return defaultTasks;
    }

    public static ArrayList<CreateTaskItem> getRecurrentDefaultTasks(int currentSprintId) {
        ArrayList<CreateTaskItem> defaultTasks = new ArrayList<>();

        CreateTaskItem createTaskItem1 = new CreateTaskItem(currentSprintId, TaskTypes.RECURRENT, "Patate1");
        createTaskItem1.setColor(TaskColors.YELLOW);
        createTaskItem1.setEstimation(12);
        defaultTasks.add(createTaskItem1);

        CreateTaskItem createTaskItem2 = new CreateTaskItem(currentSprintId, TaskTypes.RECURRENT, "Patate2");
        createTaskItem2.setColor(TaskColors.YELLOW);
        createTaskItem2.setEstimation(12);
        defaultTasks.add(createTaskItem2);

        return defaultTasks;
    }

    public static ArrayList<CreateTaskItem> getUrgentDefaultTasks(int currentSprintId) {
        ArrayList<CreateTaskItem> defaultTasks = new ArrayList<>();

        CreateTaskItem createTaskItem1 = new CreateTaskItem(currentSprintId, TaskTypes.URGENT, "Patate1");
        createTaskItem1.setColor(TaskColors.YELLOW);
        createTaskItem1.setEstimation(12);
        defaultTasks.add(createTaskItem1);

        CreateTaskItem createTaskItem2 = new CreateTaskItem(currentSprintId, TaskTypes.URGENT, "Patate2");
        createTaskItem2.setColor(TaskColors.YELLOW);
        defaultTasks.add(createTaskItem2);

        return defaultTasks;
    }
}
