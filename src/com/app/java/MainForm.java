package com.app.java;

import com.app.java.model.Release;
import com.app.java.model.Sprint;
import com.app.java.model.Story;
import com.app.java.model.Task;
import com.app.java.model.api.*;
import com.app.java.model.enums.Projects;
import com.app.java.model.enums.ReleaseStates;
import com.app.java.model.enums.SprintStates;
import com.app.java.util.XmlResponse;
import com.app.java.util.handler.ReleaseHandler;
import com.app.java.util.handler.SprintHandler;
import com.app.java.util.handler.StoryHandler;
import com.app.java.util.handler.TaskHandler;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by elamoureux on 1/6/2017.
 */
public class MainForm {
    public HashMap<Integer, Release> allReleases = new HashMap<>();
    public HashMap<Integer, Sprint> allSprintInCurrentRelease = new HashMap<>();
    public HashMap<Integer, Story> allStoriesInCurrentRelease = new HashMap<>();
    public HashMap<Integer, Task> allTasksInCurrentSprint = new HashMap<>();
    private int currentReleaseId;
    private int currentSprintId;
    private IcescrumRelease release = new IcescrumRelease();
    private IcescrumSprint sprint = new IcescrumSprint();
    private IcescrumStory story = new IcescrumStory();
    private IcescrumTask task = new IcescrumTask();
    private IcescrumFeature feature = new IcescrumFeature();
    private IcescrumActor actor = new IcescrumActor();
    private JButton getAllReleasesButton;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JProgressBar progressBar1;
    private JButton getAllSprintsInButton;
    private JButton getAllTasksInButton;
    private JTabbedPane tabbedPane1;
    private JPanel tabPanel1;
    private JPanel tabPanel2;
    private JPanel panel2;
    private JTable table1;
    private JButton exportButton;
    private JButton populateButton;
    private JButton getAllStoriesInButton;


    public MainForm() {
        comboBox1.addItem("Please select");
        for (Projects p : Projects.values()) {
            comboBox1.addItem(p);
        }

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
                    Set set = allReleases.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Release> mentry = (Map.Entry) iterator.next();
                        System.out.println(mentry.getValue().getName());
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
                    Set set = allSprintInCurrentRelease.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Sprint> mentry = (Map.Entry) iterator.next();
                        System.out.println(mentry.getValue().getGoal() + mentry.getValue().getOrderNumber());
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
                    StoryHandler storyHandler = new StoryHandler(allStoriesInCurrentRelease);
                    XMLReader myReader = XMLReaderFactory.createXMLReader();
                    myReader.setContentHandler(storyHandler);

                    for (int storyId : allSprintInCurrentRelease.get(currentSprintId).getStories()) {
                        InputSource is = new InputSource(new StringReader(story.getItem(storyId).toString()));
                        is.setEncoding("UTF-8");

                        myReader.parse(is);
                    }

                    /* Display content using Iterator*/
                    Set set = allStoriesInCurrentRelease.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Story> mentry = (Map.Entry) iterator.next();
                        System.out.println(mentry.getValue().getName());
                    }
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

                    InputSource is = new InputSource(new StringReader(task.getAll().toString()));
                    is.setEncoding("UTF-8");

                    myReader.parse(is);

                    /* Display content using Iterator*/
                    Set set = allTasksInCurrentSprint.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Task> mentry = (Map.Entry) iterator.next();
                        System.out.println(mentry.getValue().getName());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        populateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
//                    XmlResponse.DisplayInConsole(story.getItem(185054));
                    XmlResponse.SaveToFile(story.getItem(185054), story.getFileName());

                    StoryHandler storyHandler = new StoryHandler(allStoriesInCurrentRelease);
                    XMLReader myReader = XMLReaderFactory.createXMLReader();
                    myReader.setContentHandler(storyHandler);

                    InputSource is = new InputSource(new StringReader(story.getItem(185054).toString()));
                    is.setEncoding("UTF-8");

                    myReader.parse(is);

                    /* Display content using Iterator*/
                    Set set = allStoriesInCurrentRelease.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Story> mentry = (Map.Entry) iterator.next();
                        System.out.println(mentry.getValue().getName());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Java Books");

                Object[][] bookData = {
                        {"Head First Java", "Kathy Serria", 79},
                        {"Effective Java", "Joshua Bloch", 36},
                        {"Clean Code", "Robert martin", 42},
                        {"Thinking in Java", "Bruce Eckel", 35},
                };

                int rowCount = 0;

                for (Object[] aBook : bookData) {
                    Row row = sheet.createRow(++rowCount);

                    int columnCount = 0;

                    for (Object field : aBook) {
                        Cell cell = row.createCell(++columnCount);
                        if (field instanceof String) {
                            cell.setCellValue((String) field);
                        } else if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        }
                    }

                }

                try {
                    File file;
                    FileOutputStream fos = null;
                    String fileName = "Patate";

                    file = new File("c:/" + fileName + ".xlsx");
                    fos = new FileOutputStream(file);

                    // if file doesnt exists, then create it
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    workbook.write(fos);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                try {
                    XSSFWorkbook fWorkbook = new XSSFWorkbook();
                    XSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
                    XSSFFont sheetTitleFont = fWorkbook.createFont();
                    String fileName2 = "Patate2";

                    File file2 = new File("c:/" + fileName2 + ".xlsx");
                    XSSFCellStyle cellStyle = fWorkbook.createCellStyle();

                    sheetTitleFont.setBold(true);
                    //sheetTitleFont.setColor();
                    TableModel model = table1.getModel();


                    for (int i = 0; i < model.getRowCount(); i++) {
                        XSSFRow fRow = fSheet.createRow((short) i);
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            XSSFCell cell = fRow.createCell((short) j);
                            cell.setCellValue(model.getValueAt(i, j).toString());
                            cell.setCellStyle(cellStyle);

                        }

                    }
                    FileOutputStream fileOutputStream;
                    fileOutputStream = new FileOutputStream(file2);
                    BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
                    fWorkbook.write(bos);
                    bos.close();
                    fileOutputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
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
//                    XmlResponse.DisplayInConsole(task.getAll());
//                    XmlResponse.SaveToFile(task.getAll(), task.getFileName());
//                    XmlResponse.DisplayInConsole(task.getAllFiltered(TaskFilters.CURRENT_USER.getFilter()));
//                    XmlResponse.SaveToFile(task.getAllFiltered(TaskFilters.CURRENT_USER.getFilter()), task.getFileName());
//                    XmlResponse.DisplayInConsole(task.getAllInSprint(77848));
//                    XmlResponse.SaveToFile(task.getAllInSprint(77848), task.getFileName());
//                    XmlResponse.DisplayInConsole(task.getAllFilteredInSprint(77848, TaskFilters.CURRENT_USER.getFilter()));
//                    XmlResponse.SaveToFile(task.getAllFilteredInSprint(77848, TaskFilters.CURRENT_USER.getFilter()), task.getFileName());
//                    XmlResponse.DisplayInConsole(task.getItem(171074));
//                    XmlResponse.SaveToFile(task.getItem(171074), task.getFileName());
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
