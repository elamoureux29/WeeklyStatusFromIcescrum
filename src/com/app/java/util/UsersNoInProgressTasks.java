package com.app.java.util;

import com.app.java.model.enums.TaskStates;
import com.app.java.model.json.TaskItem;
import com.app.java.model.json.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by elamoureux on 3/24/2017.
 */
public class UsersNoInProgressTasks {
    private HashMap<Integer, User> usersList = new HashMap<>();
    private HashMap<Integer, User> inProgressUsersList = new HashMap<>();

    public UsersNoInProgressTasks(HashMap<Integer, TaskItem> tasksMap) {
//        for (Users u : Users.values()) {
//            if (!u.isManager()){
//                usersList.put(u.getIdentifier(), u.getUserName());
//            }
//        }

        Set set = tasksMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, TaskItem> mentry = (Map.Entry) iterator.next();
            if (mentry.getValue().getState() == TaskStates.IN_PROGRESS.getIdentifier()) {
                inProgressUsersList.put(mentry.getValue().getResponsible().getId(), mentry.getValue().getResponsible());
            } else if ((mentry.getValue().getState() == TaskStates.TODO.getIdentifier()) && !(mentry.getValue().getResponsible() == null)) {
                usersList.put(mentry.getValue().getResponsible().getId(), mentry.getValue().getResponsible());
            }
        }

        Set set2 = inProgressUsersList.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, User> mentry = (Map.Entry) iterator2.next();
            usersList.remove(mentry.getValue().getId());
        }

        //        System.out.println("Users List:" + usersList);
    }

    public HashMap<Integer, User> getUsersList() {
        return usersList;
    }
}
