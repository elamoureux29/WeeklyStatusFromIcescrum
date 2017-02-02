package com.app.java.util.task;

import com.app.java.MainForm;
import com.app.java.model.Release;
import com.app.java.model.Sprint;
import com.app.java.model.Story;
import com.app.java.model.TaskItem;
import com.app.java.model.enums.ReleaseStates;
import com.app.java.model.enums.SprintStates;
import com.app.java.util.HashMapSort;
import com.app.java.util.handler.ReleaseHandler;
import com.app.java.util.handler.SprintHandler;
import com.app.java.util.handler.StoryHandler;
import com.app.java.util.handler.TaskHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.swing.*;
import java.awt.*;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by elamoureux on 1/26/2017.
 */
public class AllData extends TaskWorker {
    public AllData(JProgressBar jProgressBar, JTabbedPane jTabbedPane) {
        super(jProgressBar, jTabbedPane);
    }

    /*
    * Main taskWorker. Executed in background thread.
    */
    @Override
    public Void doInBackground() {
        jProgressBar.setIndeterminate(true);
        jTabbedPane.setCursor((Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)));

        try {
            ReleaseHandler releaseHandler = new ReleaseHandler(MainForm.allReleases);
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(releaseHandler);

            InputSource is = new InputSource(new StringReader(MainForm.release.getAll().toString()));
            is.setEncoding("UTF-8");

            myReader.parse(is);

                    /* Display content using Iterator*/
            Map<Integer, Release> map = HashMapSort.sortByValues(MainForm.allReleases);
            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Release> mentry = (Map.Entry) iterator.next();
                System.out.println(mentry.getValue().getName());
                if (mentry.getValue().getState().equalsIgnoreCase(ReleaseStates.IN_PROGRESS.getIdentifier())) {
                    MainForm.currentReleaseId = mentry.getValue().getReleaseId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            SprintHandler sprintHandler = new SprintHandler(MainForm.allSprintInCurrentRelease);
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(sprintHandler);

            InputSource is = new InputSource(new StringReader(MainForm.sprint.getAll().toString()));
            is.setEncoding("UTF-8");

            myReader.parse(is);

                    /* Display content using Iterator*/
            Map<Integer, Sprint> map = new TreeMap<>(MainForm.allSprintInCurrentRelease);
            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Sprint> mentry = (Map.Entry) iterator.next();
                System.out.println(mentry.getValue().getGoal() + mentry.getValue().getOrderNumber());
                if (mentry.getValue().getState().equalsIgnoreCase(SprintStates.IN_PROGRESS.getIdentifier())) {
                    MainForm.currentSprintId = mentry.getValue().getSprintId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            StoryHandler storyHandler = new StoryHandler(MainForm.allStoriesInCurrentSprint);
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(storyHandler);

            for (int storyId : MainForm.allSprintInCurrentRelease.get(MainForm.currentSprintId).getStories()) {
                InputSource is = new InputSource(new StringReader(MainForm.story.getItem(storyId).toString()));
                is.setEncoding("UTF-8");

                myReader.parse(is);
            }

                    /* Display content using Iterator*/
            Set set = MainForm.allStoriesInCurrentSprint.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Story> mentry = (Map.Entry) iterator.next();
                System.out.println(mentry.getValue().getStoryId() + ": " + mentry.getValue().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            TaskHandler taskHandler = new TaskHandler(MainForm.allTasksInCurrentSprint);
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(taskHandler);

            InputSource is = new InputSource(new StringReader(MainForm.taskItem.getAll().toString()));
            is.setEncoding("UTF-8");

            myReader.parse(is);

                    /* Display content using Iterator*/
            Set set = MainForm.allTasksInCurrentSprint.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, TaskItem> mentry = (Map.Entry) iterator.next();
                System.out.println(mentry.getValue().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}