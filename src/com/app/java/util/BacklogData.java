package com.app.java.util;

import com.app.java.model.enums.StoryStates;
import com.app.java.model.json.Story;

import java.util.HashMap;

import static com.app.java.MainForm.stories;

public class BacklogData {
    private HashMap<Integer, Story> storiesInCurrentReleaseHashMap = new HashMap<>();
    private int suggested;
    private int accepted;
    private int estimated;
    private int planned;
    private int inProgress;
    private int done;
    private int all;

    public BacklogData() {
        for (Story story : stories) {
            if (story.getState() == StoryStates.SUGGESTED.getIdentifier()) {
                suggested++;
            } else if (story.getState() == StoryStates.ACCEPTED.getIdentifier()) {
                accepted++;
            } else if (story.getState() == StoryStates.ESTIMATED.getIdentifier()) {
                estimated++;
            } else if (story.getState() == StoryStates.PLANNED.getIdentifier()) {
                planned++;
            } else if (story.getState() == StoryStates.IN_PROGRESS.getIdentifier()) {
                inProgress++;
            } else if (story.getState() == StoryStates.DONE.getIdentifier()) {
                done++;
            }
        }

        all = stories.length;
    }

    public int getSuggested() {
        return suggested;
    }

    public int getAccepted() {
        return accepted;
    }

    public int getEstimated() {
        return estimated;
    }

    public int getPlanned() {
        return planned;
    }

    public int getInProgress() {
        return inProgress;
    }

    public int getDone() {
        return done;
    }

    public int getAll() {
        return all;
    }
}
