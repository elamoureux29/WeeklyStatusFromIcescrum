package com.app.java.util.task;

import com.app.java.MainForm;
import com.app.java.model.enums.ReleaseStates;
import com.app.java.model.enums.SprintStates;
import com.app.java.model.xml.XmlRelease;
import com.app.java.model.xml.XmlSprint;
import com.app.java.util.HashMapSort;
import com.app.java.util.TaktTimeStories;
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
//        jProgressBar.setIndeterminate(true);
        jTabbedPane.setCursor((Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)));
        jProgressBar.setStringPainted(true);
        jProgressBar.setValue(0);

        try {
            ReleaseHandler releaseHandler = new ReleaseHandler(MainForm.allReleases);
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(releaseHandler);

            InputSource is = new InputSource(new StringReader(MainForm.icescrumRelease.getAll().toString()));
            is.setEncoding("UTF-8");

            myReader.parse(is);

                    /* Display content using Iterator*/
            Map<Integer, XmlRelease> map = HashMapSort.sortReleaseByValues(MainForm.allReleases);
            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, XmlRelease> mentry = (Map.Entry) iterator.next();
//                System.out.println(mentry.getValue().getName());
                if (mentry.getValue().getState().equalsIgnoreCase(Integer.toString(ReleaseStates.IN_PROGRESS.getIdentifier()))) {
                    MainForm.currentReleaseId = mentry.getValue().getReleaseId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(25);

        try {
            SprintHandler sprintHandler = new SprintHandler(MainForm.allSprintInCurrentRelease);
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(sprintHandler);

            InputSource is = new InputSource(new StringReader(MainForm.icescrumSprint.getAll().toString()));
            is.setEncoding("UTF-8");

            myReader.parse(is);

                    /* Display content using Iterator*/
            Map<Integer, XmlSprint> map = new TreeMap<>(MainForm.allSprintInCurrentRelease);
            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, XmlSprint> mentry = (Map.Entry) iterator.next();
//                System.out.println(mentry.getValue().getGoal() + mentry.getValue().getOrderNumber());
                if (mentry.getValue().getState().equalsIgnoreCase(Integer.toString(SprintStates.IN_PROGRESS.getIdentifier()))) {
                    MainForm.currentSprintId = mentry.getValue().getSprintId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(50);

        try {
            StoryHandler storyHandler = new StoryHandler(MainForm.allStoriesInCurrentSprint);
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(storyHandler);

            for (int storyId : MainForm.allSprintInCurrentRelease.get(MainForm.currentSprintId).getStories()) {
                InputSource is = new InputSource(new StringReader(MainForm.icescrumStory.getItem(storyId).toString()));
                is.setEncoding("UTF-8");

                myReader.parse(is);
            }

                    /* Display content using Iterator*/
//            Set set = MainForm.allStoriesInCurrentSprint.entrySet();
//            Iterator iterator = set.iterator();
//            while (iterator.hasNext()) {
//                Map.Entry<Integer, XmlStory> mentry = (Map.Entry) iterator.next();
//                System.out.println(mentry.getValue().getStoryId() + ": " + mentry.getValue().getName());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(75);

        try {
            TaskHandler taskHandler = new TaskHandler(MainForm.allTasksInCurrentSprint);
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(taskHandler);

            InputSource is = new InputSource(new StringReader(MainForm.icescrumTask.getAll().toString()));
            is.setEncoding("UTF-8");

            myReader.parse(is);

                    /* Display content using Iterator*/
//            Set set = MainForm.allTasksInCurrentSprint.entrySet();
//            Iterator iterator = set.iterator();
//            while (iterator.hasNext()) {
//                Map.Entry<Integer, XmlTaskItem> mentry = (Map.Entry) iterator.next();
//                System.out.println(mentry.getValue().getName());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(90);

        try {
            TaktTimeStories taktTimeStories = new TaktTimeStories(MainForm.allReleases);
            MainForm.taktTimeData = taktTimeStories.getTaktTimeData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        jProgressBar.setValue(100);

        return null;
    }
}
