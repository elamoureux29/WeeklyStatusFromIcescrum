package com.app.java.util;

import com.app.java.model.CreateTaskItem;
import com.app.java.model.enums.TaskColors;

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

        CreateTaskItem testsTaskItem = new CreateTaskItem(currentSprintId, parentStoryId, "Tests");
        testsTaskItem.setColor(TaskColors.BLUE);
        codeTaskItem.setEstimation(6);
        defaultTasks.add(testsTaskItem);

        return defaultTasks;
    }

//    public static void getRecurrentDefaultTasks(){
//        CreateTaskItem createTaskItem = new CreateTaskItem(currentSprintId, TaskTypes.RECURRENT, "Patate");
//
//    }
//
//    public static void getUrgentDefaultTasks(){
//        CreateTaskItem createTaskItem = new CreateTaskItem(currentSprintId, TaskTypes.URGENT, "Patate");
//
//    }
}
