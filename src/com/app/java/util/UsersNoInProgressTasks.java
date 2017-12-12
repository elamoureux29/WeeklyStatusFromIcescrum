package com.app.java.util;

import com.app.java.model.enums.TaskStates;
import com.app.java.model.enums.Users;
import com.app.java.model.xml.XmlTaskItem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by elamoureux on 3/24/2017.
 */
public class UsersNoInProgressTasks {
    private HashMap<Integer, String> usersList = new HashMap<>();

    public UsersNoInProgressTasks(HashMap<Integer, XmlTaskItem> tasksMap) {
        for (Users u : Users.values()) {
            if (!u.isManager()){
                usersList.put(u.getIdentifier(), u.getUserName());
            }
        }

        Set set = tasksMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, XmlTaskItem> mentry = (Map.Entry) iterator.next();
            if (mentry.getValue().getState().equalsIgnoreCase(TaskStates.IN_PROGRESS.getIdentifier())) {
                usersList.remove(mentry.getValue().getResponsibleId());
            }
        }
//        System.out.println("Users List:" + usersList);
    }

    public HashMap<Integer, String> getUsersList() {
        return usersList;
    }
}
