package com.app.java.util;

import com.app.java.model.enums.SprintStates;
import com.app.java.model.json.Sprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by elamoureux on 3/24/2017.
 */
public class TaktTimeStories {
    private Sprint[] reversedSprints;
    private final int TAKTTIME_MAX_DATA = 10;
    private List<Integer> list = new ArrayList<>();

    public TaktTimeStories(Sprint[] sprints) {
        Arrays.sort(sprints, Sprint.ReverseOrderNumberComparator);
        reversedSprints = sprints;
    }

    public List<Integer> getTaktTimeData() {
        try {
            for (int i = 0; i < reversedSprints.length && list.size() < TAKTTIME_MAX_DATA; i++) {
                if (reversedSprints[i].getState() == SprintStates.DONE.getIdentifier()) {
                    list.add(reversedSprints[i].getStories_ids().length);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
