package com.app.java.util;

import com.app.java.model.enums.TaskTypes;
import com.app.java.model.json.TaskItem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by elamoureux on 3/24/2017.
 */
public class NonStoryTasks {
    private HashMap<Integer, TaskItem> urgentTasksHashMap = new HashMap<>();
    private HashMap<Integer, TaskItem> recurrentTasksHashMap = new HashMap<>();

    public NonStoryTasks(HashMap<Integer, TaskItem> tasksMap) {
        Set set = tasksMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, TaskItem> mentry = (Map.Entry) iterator.next();
            if (mentry.getValue().getType().equalsIgnoreCase(TaskTypes.URGENT.getIdentifier())) {
//                System.out.println("Urgent:" + mentry.getValue().getName());
                urgentTasksHashMap.put(mentry.getKey(), mentry.getValue());
            } else if (mentry.getValue().getType().equalsIgnoreCase(TaskTypes.RECURRENT.getIdentifier())) {
//                System.out.println("Recurrent:" + mentry.getValue().getName());
                recurrentTasksHashMap.put(mentry.getKey(), mentry.getValue());
            }
        }
    }

    public HashMap<Integer, TaskItem> getUrgentTasksHashMap() {
        return urgentTasksHashMap;
    }

    public HashMap<Integer, TaskItem> getRecurrentTasksHashMap() {
        return recurrentTasksHashMap;
    }
}
