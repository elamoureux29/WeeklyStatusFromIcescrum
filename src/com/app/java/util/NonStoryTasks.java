package com.app.java.util;

import com.app.java.model.enums.TaskTypes;
import com.app.java.model.xml.XmlTaskItem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by elamoureux on 3/24/2017.
 */
public class NonStoryTasks {
    private HashMap<Integer, XmlTaskItem> urgentTasksHashMap = new HashMap<>();
    private HashMap<Integer, XmlTaskItem> recurrentTasksHashMap = new HashMap<>();

    public NonStoryTasks(HashMap<Integer, XmlTaskItem> tasksMap) {
        Set set = tasksMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, XmlTaskItem> mentry = (Map.Entry) iterator.next();
            if (mentry.getValue().getType().equalsIgnoreCase(TaskTypes.URGENT.getIdentifier())) {
//                System.out.println("Urgent:" + mentry.getValue().getName());
                urgentTasksHashMap.put(mentry.getKey(), mentry.getValue());
            } else if (mentry.getValue().getType().equalsIgnoreCase(TaskTypes.RECURRENT.getIdentifier())) {
//                System.out.println("Recurrent:" + mentry.getValue().getName());
                recurrentTasksHashMap.put(mentry.getKey(), mentry.getValue());
            }
        }
    }

    public HashMap<Integer, XmlTaskItem> getUrgentTasksHashMap() {
        return urgentTasksHashMap;
    }

    public HashMap<Integer, XmlTaskItem> getRecurrentTasksHashMap() {
        return recurrentTasksHashMap;
    }
}
