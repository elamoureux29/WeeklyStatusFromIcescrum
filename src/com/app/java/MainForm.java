package com.app.java;

import com.app.java.model.CreateTaskItem;
import com.app.java.model.StatusTableModel;
import com.app.java.model.api.*;
import com.app.java.model.enums.Projects;
import com.app.java.model.enums.ReleaseStates;
import com.app.java.model.enums.SprintStates;
import com.app.java.model.enums.StoryTypes;
import com.app.java.model.json.Release;
import com.app.java.model.json.Sprint;
import com.app.java.model.json.Story;
import com.app.java.model.json.TaskItem;
import com.app.java.model.xml.XmlStory;
import com.app.java.util.DefaultTasksCreator;
import com.app.java.util.ExcelUtil;
import com.app.java.util.ResponseWriter;
import com.app.java.util.customJsonDeserializer.SprintDeserializer;
import com.app.java.util.customJsonDeserializer.StoryDeserializer;
import com.app.java.util.handler.StoryHandler;
import com.app.java.util.task.AllData;
import com.app.java.util.task.TaskWorker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Reader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by elamoureux on 1/6/2017.
 */
public class MainForm {
    public static HashMap<Integer, Release> allReleases = new HashMap<>();
    //    public static HashMap<Integer, XmlRelease> allReleases = new HashMap<>();

    public static HashMap<Integer, Sprint> allSprintInCurrentRelease = new HashMap<>();
    //    public static HashMap<Integer, XmlSprint> allSprintInCurrentRelease = new HashMap<>();

    public static HashMap<Integer, Story> allStoriesInCurrentSprint = new HashMap<>();
    //    public static HashMap<Integer, XmlStory> allStoriesInCurrentSprint = new HashMap<>();

    public static HashMap<Integer, TaskItem> allTasksInCurrentSprint = new HashMap<>();
//    public static HashMap<Integer, XmlTaskItem> allTasksInCurrentSprint = new HashMap<>();

    public static String currentProjectId;
    public static String currentProjectName;
    public static int currentReleaseId;
    public static int currentSprintId;
    public static Release[] releases;
    public static Sprint[] sprints;
    public static Story[] stories;
    public static TaskItem[] taskItems;
    public static IcescrumRelease icescrumRelease = new IcescrumRelease();
    public static IcescrumSprint icescrumSprint = new IcescrumSprint();
    public static IcescrumStory icescrumStory = new IcescrumStory();
    public static IcescrumTask icescrumTask = new IcescrumTask();
    public static IcescrumFeature icescrumFeature = new IcescrumFeature();
    public static IcescrumActor icescrumActor = new IcescrumActor();
    public static IcescrumAvailability icescrumAvailability = new IcescrumAvailability();
    public static List<Integer> taktTimeData = new ArrayList<>();
    private JTabbedPane tabbedPane1;
    private JPanel tabPanel1;
    private JPanel panel1;
    private JPanel tabPanel2;
    private JPanel panel2;
    private JProgressBar progressBar1;
    private JComboBox comboBox1;
    private JButton getAllReleasesButton;
    private JButton getAllSprintsButton;
    private JButton getAllStoriesButton;
    private JButton getAllTasksButton;
    private JTable table1;
    private JButton exportButton;
    private JButton populateButton;
    private JButton getDataButton;
    private JPanel getButtonPanel;
    private JPanel testPanel;
    private JPanel createButtonPanel;
    private JButton testButton;
    private JButton createDefaultTasksButton;
    private JButton createDefaultTasksInSprintButton;
    private JTextField textField1;
    private JRadioButton noneRadioButton;
    private JRadioButton consoleRadioButton;
    private JRadioButton fileRadioButton;
    private JPanel outputPanel;
    private JPanel projectSelectionPanel;
    private JLabel currentSprintLabel;


    public MainForm() {
        comboBox1.addItem("Please select");
        for (Projects p : Projects.values()) {
            comboBox1.addItem(p.getPrjName());
        }
        getButtonPanel.setVisible(false);
        createButtonPanel.setVisible(false);
        testPanel.setVisible(false);
        noneRadioButton.setSelected(true);

        getAllReleasesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    allReleases.clear();
                    StringBuffer stringBuffer = icescrumRelease.getAll();
//                    ReleaseHandler releaseHandler = new ReleaseHandler(allReleases);
//                    XMLReader myReader = XMLReaderFactory.createXMLReader();
//                    myReader.setContentHandler(releaseHandler);

//                    InputSource is = new InputSource(new StringReader(icescrumRelease.getAll().toString()));
//                    is.setEncoding("UTF-8");

//                    System.out.println(is);
//                    myReader.parse(is);

                    Reader reader = new StringReader(stringBuffer.toString());

                    Gson gson = new GsonBuilder().create();
                    releases = gson.fromJson(reader, Release[].class);


                    /* Display content using Iterator*/
//                    Map<Integer, XmlRelease> map = HashMapSort.sortReleaseByValues(allReleases);
//                    Set set = map.entrySet();
//                    Iterator iterator = set.iterator();
//                    while (iterator.hasNext()) {
//                        Map.Entry<Integer, XmlRelease> mentry = (Map.Entry) iterator.next();
//                        System.out.println(mentry.getValue().getName());
//                        if (mentry.getValue().getState().equalsIgnoreCase(ReleaseStates.IN_PROGRESS.getIdentifier())) {
//                            currentReleaseId = mentry.getValue().getReleaseId();
//                        }
//                    }

                    for (Release release : releases) {
//                        System.out.println(release.getName());
                        allReleases.put(release.getId(), release);
                        if (release.getState() == ReleaseStates.IN_PROGRESS.getIdentifier()) {
                            currentReleaseId = release.getId();
                        }
                    }
//                    System.out.println(currentReleaseId);

                    if (consoleRadioButton.isSelected()) {
                        ResponseWriter.DisplayInConsole(stringBuffer);
                    } else if (fileRadioButton.isSelected()) {
                        ResponseWriter.SaveToFile(stringBuffer, icescrumRelease.getFileName());
                    }

                    tabbedPane1.setEnabledAt(1, false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        getAllSprintsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    allSprintInCurrentRelease.clear();
                    StringBuffer stringBuffer = icescrumSprint.getAll();
//                    SprintHandler sprintHandler = new SprintHandler(allSprintInCurrentRelease);
//                    XMLReader myReader = XMLReaderFactory.createXMLReader();
//                    myReader.setContentHandler(sprintHandler);
//
//                    InputSource is = new InputSource(new StringReader(icescrumSprint.getAll().toString()));
//                    is.setEncoding("UTF-8");
//
//                    myReader.parse(is);

                    Reader reader = new StringReader(stringBuffer.toString());

//                    Gson gson = new GsonBuilder().create();
                    // Configure Gson
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    gsonBuilder.registerTypeAdapter(Sprint.class, new SprintDeserializer());
                    Gson gson = gsonBuilder.create();
                    sprints = gson.fromJson(reader, Sprint[].class);

                    /* Display content using Iterator*/
//                    Map<Integer, XmlSprint> map = new TreeMap<>(allSprintInCurrentRelease);
//                    Set set = map.entrySet();
//                    Iterator iterator = set.iterator();
//                    while (iterator.hasNext()) {
//                        Map.Entry<Integer, XmlSprint> mentry = (Map.Entry) iterator.next();
////                        System.out.println(mentry.getValue().getGoal() + mentry.getValue().getOrderNumber());
//                        if (mentry.getValue().getState().equalsIgnoreCase(SprintStates.IN_PROGRESS.getIdentifier())) {
//                            currentSprintId = mentry.getValue().getSprintId();
//                            getAllStoriesButton.setEnabled(true);
//                        }
//                    }

                    for (Sprint sprint : sprints) {
//                        System.out.println(sprint.getId());
                        allSprintInCurrentRelease.put(sprint.getId(), sprint);
                        if (sprint.getState() == SprintStates.IN_PROGRESS.getIdentifier()) {
                            currentSprintId = sprint.getId();
                        }
                    }
//                    System.out.println(currentSprintId);

                    if (consoleRadioButton.isSelected()) {
                        ResponseWriter.DisplayInConsole(stringBuffer);
                    } else if (fileRadioButton.isSelected()) {
                        ResponseWriter.SaveToFile(stringBuffer, icescrumSprint.getFileName());
                    }

                    createDefaultTasksInSprintButton.setEnabled(true);
                    tabbedPane1.setEnabledAt(1, false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        getAllStoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    allStoriesInCurrentSprint.clear();
                    StringBuffer stringBuffer = icescrumStory.getAll();
//                    StoryHandler storyHandler = new StoryHandler(allStoriesInCurrentSprint);
//                    XMLReader myReader = XMLReaderFactory.createXMLReader();
//                    myReader.setContentHandler(storyHandler);
//
//                    for (int storyId : allSprintInCurrentRelease.get(currentSprintId).getStories()) {
//                        InputSource is = new InputSource(new StringReader(icescrumStory.getItem(storyId).toString()));
//                        is.setEncoding("UTF-8");
//
//                        myReader.parse(is);
//                    }

                    Reader reader = new StringReader(stringBuffer.toString());

//                    Gson gson = new GsonBuilder().create();
                    // Configure Gson
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    gsonBuilder.registerTypeAdapter(Story.class, new StoryDeserializer());
                    Gson gson = gsonBuilder.create();
                    stories = gson.fromJson(reader, Story[].class);

                    /* Display content using Iterator*/
//                    Set set = allStoriesInCurrentSprint.entrySet();
//                    Iterator iterator = set.iterator();
//                    while (iterator.hasNext()) {
//                        Map.Entry<Integer, XmlStory> mentry = (Map.Entry) iterator.next();
//                        System.out.println(mentry.getValue().getStoryId() + ": " + mentry.getValue().getName());
//                    }

                    if (currentSprintId != 0) {
                        for (Story story : stories) {
                            if (story.getParentSprint() != null) {
                                if (story.getParentSprint().getId() == currentSprintId) {
                                    allStoriesInCurrentSprint.put(story.getId(), story);
                                }
                            }
                        }
                    }

                    if (consoleRadioButton.isSelected()) {
                        ResponseWriter.DisplayInConsole(stringBuffer);
                    } else if (fileRadioButton.isSelected()) {
                        ResponseWriter.SaveToFile(stringBuffer, icescrumStory.getFileName());
                    }
                    if (currentSprintId != 0) {
                        SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd-MMM-yyyy");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
                        Date date = formatter.parse(allSprintInCurrentRelease.get(currentSprintId).getStartDate().replaceAll("Z$", "+0000"));

                        currentSprintLabel.setText(simpleFormatter.format(date) +
                                " " + allSprintInCurrentRelease.get(currentSprintId).getOrderNumber() + " " +
                                allSprintInCurrentRelease.get(currentSprintId).getIndex());
                        createDefaultTasksButton.setEnabled(true);
                    }
                    tabbedPane1.setEnabledAt(1, false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        getAllTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuffer stringBuffer = icescrumTask.getAll();
//                    TaskHandler taskHandler = new TaskHandler(allTasksInCurrentSprint);
//                    XMLReader myReader = XMLReaderFactory.createXMLReader();
//                    myReader.setContentHandler(taskHandler);
//
//                    InputSource is = new InputSource(new StringReader(icescrumTask.getAll().toString()));
//                    is.setEncoding("UTF-8");
//
//                    myReader.parse(is);

                    Reader reader = new StringReader(stringBuffer.toString());

//                    Gson gson = new GsonBuilder().create();
//                    TaskItem[] taskItems = gson.fromJson(reader, TaskItem[].class);

                    // Configure Gson
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    gsonBuilder.registerTypeAdapter(Sprint.class, new SprintDeserializer());
                    Gson gson = gsonBuilder.create();
                    taskItems = gson.fromJson(reader, TaskItem[].class);

                    /* Display content using Iterator*/
//                    Set set = allTasksInCurrentSprint.entrySet();
//                    Iterator iterator = set.iterator();
//                    while (iterator.hasNext()) {
//                        Map.Entry<Integer, XmlTaskItem> mentry = (Map.Entry) iterator.next();
//                        System.out.println(mentry.getValue().getName());
//                    }

                    if (!allStoriesInCurrentSprint.isEmpty()) {
                        for (TaskItem taskItem : taskItems) {
                            if (taskItem.getParentStory() != null) {
                                if (allStoriesInCurrentSprint.containsKey(taskItem.getParentStory().getId())) {
                                    allTasksInCurrentSprint.put(taskItem.getId(), taskItem);
                                }
                            }
                        }
                    }

                    if (consoleRadioButton.isSelected()) {
                        ResponseWriter.DisplayInConsole(stringBuffer);
                    } else if (fileRadioButton.isSelected()) {
                        ResponseWriter.SaveToFile(stringBuffer, icescrumTask.getFileName());
                    }

                    tabbedPane1.setEnabledAt(1, false);
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

                            icescrumRelease.setProject(currentProjectId);
                            icescrumSprint.setProject(currentProjectId);
                            icescrumStory.setProject(currentProjectId);
                            icescrumTask.setProject(currentProjectId);
                            icescrumFeature.setProject(currentProjectId);
                            icescrumActor.setProject(currentProjectId);
                            icescrumAvailability.setProject(currentProjectId);
                        }
                    }
                    getButtonPanel.setVisible(true);
                    createButtonPanel.setVisible(true);
                    testPanel.setVisible(true);
                    currentSprintLabel.setText("");
                    createDefaultTasksButton.setEnabled(false);
                    createDefaultTasksInSprintButton.setEnabled(false);
                    tabbedPane1.setEnabledAt(1, false);
                } else {
                    getButtonPanel.setVisible(false);
                    createButtonPanel.setVisible(false);
                    testPanel.setVisible(false);
                }
            }
        });
        createDefaultTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Set set = allStoriesInCurrentSprint.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, XmlStory> mentry = (Map.Entry) iterator.next();
                        if (mentry.getValue().getTasksId().isEmpty()) {
                            if (mentry.getValue().getType().equalsIgnoreCase(StoryTypes.DEFECT.getIdentifier())) {
                                ArrayList<CreateTaskItem> defaultTasks = DefaultTasksCreator.getIssueStoryDefaultTasks(
                                        currentSprintId, mentry.getValue().getStoryId());
                                for (CreateTaskItem defaultTaskItem : defaultTasks) {
                                    icescrumTask.createTask(defaultTaskItem);
                                }
                            } else {
                                ArrayList<CreateTaskItem> defaultTasks = DefaultTasksCreator.getStoryDefaultTasks(
                                        currentSprintId, mentry.getValue().getStoryId());
                                for (CreateTaskItem defaultTaskItem : defaultTasks) {
                                    icescrumTask.createTask(defaultTaskItem);
                                }
                            }
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        createDefaultTasksInSprintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!textField1.getText().isEmpty()) {
                        HashMap<Integer, XmlStory> allStoriesInSprint = new HashMap<>();
                        int sprintID = Integer.parseInt(textField1.getText());

                        StoryHandler storyHandler = new StoryHandler(allStoriesInSprint);
                        XMLReader myReader = XMLReaderFactory.createXMLReader();
                        myReader.setContentHandler(storyHandler);

//                        for (int storyId : allSprintInCurrentRelease.get(sprintID).getStories()) {
//                            InputSource is = new InputSource(new StringReader(icescrumStory.getItem(storyId).toString()));
//                            is.setEncoding("UTF-8");
//
//                            myReader.parse(is);
//                        }

                        Set set = allStoriesInSprint.entrySet();
                        Iterator iterator = set.iterator();
                        while (iterator.hasNext()) {
                            Map.Entry<Integer, XmlStory> mentry = (Map.Entry) iterator.next();
                            if (mentry.getValue().getTasksId().isEmpty()) {
                                if (mentry.getValue().getType().equalsIgnoreCase(StoryTypes.DEFECT.getIdentifier())) {
                                    ArrayList<CreateTaskItem> defaultTasks = DefaultTasksCreator.getIssueStoryDefaultTasks(
                                            sprintID, mentry.getValue().getStoryId());
                                    for (CreateTaskItem defaultTaskItem : defaultTasks) {
                                        icescrumTask.createTask(defaultTaskItem);
                                    }
                                } else {
                                    ArrayList<CreateTaskItem> defaultTasks = DefaultTasksCreator.getStoryDefaultTasks(
                                            sprintID, mentry.getValue().getStoryId());
                                    for (CreateTaskItem defaultTaskItem : defaultTasks) {
                                        icescrumTask.createTask(defaultTaskItem);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuffer stringBuffer = icescrumStory.getAll();
//                    ResponseWriter.DisplayInConsole(stringBuffer);
                    ResponseWriter.SaveToFile(stringBuffer, icescrumStory.getFileName());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

//                    ResponseWriter.DisplayInConsole(icescrumRelease.getAll());
//                    ResponseWriter.SaveToFile(icescrumRelease.getAll(), icescrumRelease.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumRelease.getItem(76926));
//                    ResponseWriter.SaveToFile(icescrumRelease.getItem(76926), icescrumRelease.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumSprint.getAll());
//                    ResponseWriter.SaveToFile(icescrumSprint.getAll(), icescrumSprint.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumSprint.getAllInRelease(76926));
//                    ResponseWriter.SaveToFile(icescrumSprint.getAllInRelease(76926), icescrumSprint.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumSprint.getItem(77848));
//                    ResponseWriter.SaveToFile(icescrumSprint.getItem(77848), icescrumSprint.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumStory.getAll());
//                    ResponseWriter.SaveToFile(icescrumStory.getAll(), icescrumStory.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumStory.getItem(185155));
//                    ResponseWriter.SaveToFile(icescrumStory.getItem(185155), icescrumStory.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumTask.getAll());
//                    ResponseWriter.SaveToFile(icescrumTask.getAll(), icescrumTask.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumTask.getAllFiltered(TaskFilters.CURRENT_USER.getFilter()));
//                    ResponseWriter.SaveToFile(icescrumTask.getAllFiltered(TaskFilters.CURRENT_USER.getFilter()), icescrumTask.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumTask.getAllInSprint(77848));
//                    ResponseWriter.SaveToFile(icescrumTask.getAllInSprint(77848), icescrumTask.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumTask.getAllFilteredInSprint(77848, TaskFilters.CURRENT_USER.getFilter()));
//                    ResponseWriter.SaveToFile(icescrumTask.getAllFilteredInSprint(77848, TaskFilters.CURRENT_USER.getFilter()), icescrumTask.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumTask.getItem(171074));
//                    ResponseWriter.SaveToFile(icescrumTask.getItem(171074), icescrumTask.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumFeature.getAll());
//                    ResponseWriter.SaveToFile(icescrumFeature.getAll(), icescrumFeature.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumFeature.getItem(14714));
//                    ResponseWriter.SaveToFile(icescrumFeature.getItem(14714), icescrumFeature.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumActor.getAll());
//                    ResponseWriter.SaveToFile(icescrumActor.getAll(), icescrumActor.getFileName());
//                    ResponseWriter.DisplayInConsole(icescrumActor.getItem(2264));
//                    ResponseWriter.SaveToFile(icescrumActor.getItem(2264), icescrumActor.getFileName());

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
