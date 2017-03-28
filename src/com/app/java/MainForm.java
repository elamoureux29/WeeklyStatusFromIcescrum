package com.app.java;

import com.app.java.model.*;
import com.app.java.model.api.*;
import com.app.java.model.enums.Projects;
import com.app.java.model.enums.ReleaseStates;
import com.app.java.model.enums.SprintStates;
import com.app.java.util.ExcelUtil;
import com.app.java.util.HashMapSort;
import com.app.java.util.handler.ReleaseHandler;
import com.app.java.util.handler.SprintHandler;
import com.app.java.util.handler.StoryHandler;
import com.app.java.util.handler.TaskHandler;
import com.app.java.util.task.AllData;
import com.app.java.util.task.TaskWorker;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.util.*;

/**
 * Created by elamoureux on 1/6/2017.
 */
public class MainForm {
    public static HashMap<Integer, Release> allReleases = new HashMap<>();
    public static HashMap<Integer, Sprint> allSprintInCurrentRelease = new HashMap<>();
    public static HashMap<Integer, Story> allStoriesInCurrentSprint = new HashMap<>();
    public static HashMap<Integer, TaskItem> allTasksInCurrentSprint = new HashMap<>();
    public static String currentProjectId;
    public static String currentProjectName;
    public static int currentReleaseId;
    public static int currentSprintId;
    public static IcescrumRelease release = new IcescrumRelease();
    public static IcescrumSprint sprint = new IcescrumSprint();
    public static IcescrumStory story = new IcescrumStory();
    public static IcescrumTask taskItem = new IcescrumTask();
    public static IcescrumFeature feature = new IcescrumFeature();
    public static IcescrumActor actor = new IcescrumActor();
    public static IcescrumAvailability availability = new IcescrumAvailability();
    public static List<Integer> taktTimeData = new ArrayList<>();
    private JTabbedPane tabbedPane1;
    private JPanel tabPanel1;
    private JPanel panel1;
    private JPanel tabPanel2;
    private JPanel panel2;
    private JProgressBar progressBar1;
    private JComboBox comboBox1;
    private JButton getAllReleasesButton;
    private JButton getAllSprintsInButton;
    private JButton getAllStoriesInButton;
    private JButton getAllTasksInButton;
    private JTable table1;
    private JButton exportButton;
    private JButton populateButton;
    private JButton getDataButton;
    private JPanel buttonPanel;


    public MainForm() {
        comboBox1.addItem("Please select");
        for (Projects p : Projects.values()) {
            comboBox1.addItem(p.getPrjName());
        }
        buttonPanel.setVisible(false);

        getAllReleasesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReleaseHandler releaseHandler = new ReleaseHandler(allReleases);
                    XMLReader myReader = XMLReaderFactory.createXMLReader();
                    myReader.setContentHandler(releaseHandler);

                    InputSource is = new InputSource(new StringReader(release.getAll().toString()));
                    is.setEncoding("UTF-8");

                    myReader.parse(is);

                    /* Display content using Iterator*/
                    Map<Integer, Release> map = HashMapSort.sortReleaseByValues(allReleases);
                    Set set = map.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Release> mentry = (Map.Entry) iterator.next();
//                        System.out.println(mentry.getValue().getName());
                        if (mentry.getValue().getState().equalsIgnoreCase(ReleaseStates.IN_PROGRESS.getIdentifier())) {
                            currentReleaseId = mentry.getValue().getReleaseId();
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        getAllSprintsInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SprintHandler sprintHandler = new SprintHandler(allSprintInCurrentRelease);
                    XMLReader myReader = XMLReaderFactory.createXMLReader();
                    myReader.setContentHandler(sprintHandler);

                    InputSource is = new InputSource(new StringReader(sprint.getAll().toString()));
                    is.setEncoding("UTF-8");

                    myReader.parse(is);

                    /* Display content using Iterator*/
                    Map<Integer, Sprint> map = new TreeMap<>(allSprintInCurrentRelease);
                    Set set = map.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Sprint> mentry = (Map.Entry) iterator.next();
//                        System.out.println(mentry.getValue().getGoal() + mentry.getValue().getOrderNumber());
                        if (mentry.getValue().getState().equalsIgnoreCase(SprintStates.IN_PROGRESS.getIdentifier())) {
                            currentSprintId = mentry.getValue().getSprintId();
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        getAllStoriesInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StoryHandler storyHandler = new StoryHandler(allStoriesInCurrentSprint);
                    XMLReader myReader = XMLReaderFactory.createXMLReader();
                    myReader.setContentHandler(storyHandler);

                    for (int storyId : allSprintInCurrentRelease.get(currentSprintId).getStories()) {
                        InputSource is = new InputSource(new StringReader(story.getItem(storyId).toString()));
                        is.setEncoding("UTF-8");

                        myReader.parse(is);
                    }

                    /* Display content using Iterator*/
//                    Set set = allStoriesInCurrentSprint.entrySet();
//                    Iterator iterator = set.iterator();
//                    while (iterator.hasNext()) {
//                        Map.Entry<Integer, Story> mentry = (Map.Entry) iterator.next();
//                        System.out.println(mentry.getValue().getStoryId() + ": " + mentry.getValue().getName());
//                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        getAllTasksInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TaskHandler taskHandler = new TaskHandler(allTasksInCurrentSprint);
                    XMLReader myReader = XMLReaderFactory.createXMLReader();
                    myReader.setContentHandler(taskHandler);

                    InputSource is = new InputSource(new StringReader(taskItem.getAll().toString()));
                    is.setEncoding("UTF-8");

                    myReader.parse(is);

                    /* Display content using Iterator*/
//                    Set set = allTasksInCurrentSprint.entrySet();
//                    Iterator iterator = set.iterator();
//                    while (iterator.hasNext()) {
//                        Map.Entry<Integer, TaskItem> mentry = (Map.Entry) iterator.next();
//                        System.out.println(mentry.getValue().getName());
//                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        getDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Instances of javax.swing.SwingWorker are not reusable, so
                //we create new instances as needed.
                TaskWorker allDataTW = new AllData(progressBar1, tabbedPane1);
                allDataTW.execute();
            }
        });
        populateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DefaultTableModel model = StatusTableModel.buildTableModel();
                    table1.setModel(model);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExcelUtil.ExportToFile();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedIndex() > 0) {
                    for (Projects p : Projects.values()) {
                        if (comboBox1.getSelectedItem().toString().equalsIgnoreCase(p.getPrjName())) {
                            currentProjectId = p.getIdentifier();
                            currentProjectName = p.getPrjName();

                            release.setProject(currentProjectId);
                            sprint.setProject(currentProjectId);
                            story.setProject(currentProjectId);
                            taskItem.setProject(currentProjectId);
                            feature.setProject(currentProjectId);
                            actor.setProject(currentProjectId);
                            availability.setProject(currentProjectId);
                        }
                    }
                    buttonPanel.setVisible(true);
                } else {
                    buttonPanel.setVisible(false);
                }
            }
        });
    }

//                    XmlResponse.DisplayInConsole(release.getAll());
//                    XmlResponse.SaveToFile(release.getAll(), release.getFileName());
//                    XmlResponse.DisplayInConsole(release.getItem(76926));
//                    XmlResponse.SaveToFile(release.getItem(76926), release.getFileName());
//                    XmlResponse.DisplayInConsole(sprint.getAll());
//                    XmlResponse.SaveToFile(sprint.getAll(), sprint.getFileName());
//                    XmlResponse.DisplayInConsole(sprint.getAllInRelease(76926));
//                    XmlResponse.SaveToFile(sprint.getAllInRelease(76926), sprint.getFileName());
//                    XmlResponse.DisplayInConsole(sprint.getItem(77848));
//                    XmlResponse.SaveToFile(sprint.getItem(77848), sprint.getFileName());
//                    XmlResponse.DisplayInConsole(story.getAll());
//                    XmlResponse.SaveToFile(story.getAll(), story.getFileName());
//                    XmlResponse.DisplayInConsole(story.getItem(185155));
//                    XmlResponse.SaveToFile(story.getItem(185155), story.getFileName());
//                    XmlResponse.DisplayInConsole(taskItem.getAll());
//                    XmlResponse.SaveToFile(taskItem.getAll(), taskItem.getFileName());
//                    XmlResponse.DisplayInConsole(taskItem.getAllFiltered(TaskFilters.CURRENT_USER.getFilter()));
//                    XmlResponse.SaveToFile(taskItem.getAllFiltered(TaskFilters.CURRENT_USER.getFilter()), taskItem.getFileName());
//                    XmlResponse.DisplayInConsole(taskItem.getAllInSprint(77848));
//                    XmlResponse.SaveToFile(taskItem.getAllInSprint(77848), taskItem.getFileName());
//                    XmlResponse.DisplayInConsole(taskItem.getAllFilteredInSprint(77848, TaskFilters.CURRENT_USER.getFilter()));
//                    XmlResponse.SaveToFile(taskItem.getAllFilteredInSprint(77848, TaskFilters.CURRENT_USER.getFilter()), taskItem.getFileName());
//                    XmlResponse.DisplayInConsole(taskItem.getItem(171074));
//                    XmlResponse.SaveToFile(taskItem.getItem(171074), taskItem.getFileName());
//                    XmlResponse.DisplayInConsole(feature.getAll());
//                    XmlResponse.SaveToFile(feature.getAll(), feature.getFileName());
//                    XmlResponse.DisplayInConsole(feature.getItem(14714));
//                    XmlResponse.SaveToFile(feature.getItem(14714), feature.getFileName());
//                    XmlResponse.DisplayInConsole(actor.getAll());
//                    XmlResponse.SaveToFile(actor.getAll(), actor.getFileName());
//                    XmlResponse.DisplayInConsole(actor.getItem(2264));
//                    XmlResponse.SaveToFile(actor.getItem(2264), actor.getFileName());

//    private class BtnClicked implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
