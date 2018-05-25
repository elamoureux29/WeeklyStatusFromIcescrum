package com.app.java.util.excel;

import com.app.java.model.enums.StoryStates;
import com.app.java.model.enums.TaskStates;
import com.app.java.model.json.Feature;
import com.app.java.model.json.Id;
import com.app.java.model.json.Story;
import com.app.java.model.json.TaskItem;
import com.app.java.util.DateFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static com.app.java.MainForm.*;

public class FeatureDataToExcel {
    public FeatureDataToExcel(XSSFWorkbook workbook, Feature feature) {
        XSSFSheet sheet;
        if (feature.getName().length() < 10) {
            sheet = workbook.createSheet(feature.getName());
        } else {
            sheet = workbook.createSheet(feature.getName().substring(0, 9) + "...");
        }
        int rowStartPoint = 0;
        int sprintBordersRowStartPoint = 0;
        int storiesBordersRowStartPoint = 0;
        int firstCol = 0;
        int lastCol = 8;


        Map<String, Object> cellStyleValues = new HashMap<>();
        cellStyleValues.put(CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);
        cellStyleValues.put(CellUtil.FILL_BACKGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_PATTERN, FillPatternType.NO_FILL);

        Row titleRow = sheet.createRow(rowStartPoint);
        Cell titleRowCellA = titleRow.createCell(0);
        titleRowCellA.setCellValue(feature.getName());
        CellUtil.setCellStyleProperties(titleRowCellA, cellStyleValues);
//        CellUtil.setAlignment(titleRowCellA, HorizontalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol));

        rowStartPoint += 2;
        sprintBordersRowStartPoint = rowStartPoint;

        Row sprintDetailsRow = sheet.createRow(rowStartPoint);
        Cell sprintDetailsRowCellA = sprintDetailsRow.createCell(0);
        sprintDetailsRowCellA.setCellValue("Current Sprint");
        Cell sprintDetailsRowCellC = sprintDetailsRow.createCell(2);
        sprintDetailsRowCellC.setCellValue("# Completed Stories");
        Cell sprintDetailsRowCellD = sprintDetailsRow.createCell(3);
        sprintDetailsRowCellD.setCellValue("/");
        CellUtil.setAlignment(sprintDetailsRowCellD, HorizontalAlignment.CENTER);
        Cell sprintDetailsRowCellE = sprintDetailsRow.createCell(4);
        sprintDetailsRowCellE.setCellValue("# Total Stories");

        rowStartPoint += 2;

        Row sprintDetailsRow2 = sheet.createRow(rowStartPoint);
        Cell sprintDetailsRow2CellC = sprintDetailsRow2.createCell(2);
        sprintDetailsRow2CellC.setCellValue("Completed Points");
        Cell sprintDetailsRow2CellD = sprintDetailsRow2.createCell(3);
        sprintDetailsRow2CellD.setCellValue("/");
        CellUtil.setAlignment(sprintDetailsRowCellD, HorizontalAlignment.CENTER);
        Cell sprintDetailsRow2CellE = sprintDetailsRow2.createCell(4);
        sprintDetailsRow2CellE.setCellValue("Total Points");

        rowStartPoint += 3;
        storiesBordersRowStartPoint = rowStartPoint;

        float completedPoints = 0;
        float sprintTotalPoints = 0;
        int completedStories = 0;
        int sprintTotalStories = 0;
        Map<Integer, Story> doneStoriesWeek1 = new HashMap<>();
        Map<Integer, Story> doneStoriesWeek2 = new HashMap<>();
        Map<Integer, Story> doneStoriesWeek3 = new HashMap<>();
        LocalDateTime endWeek1 = DateFormat.DateParse(allSprintInCurrentRelease.get(currentSprintId).getStartDate()).plusWeeks(1);
        LocalDateTime endWeek2 = DateFormat.DateParse(allSprintInCurrentRelease.get(currentSprintId).getStartDate()).plusWeeks(2);

        for (Id storyId : feature.getStories_ids()) {
            if (allStoriesInCurrentSprint.containsKey(storyId.getId())) {
                Story story = allStoriesInCurrentSprint.get(storyId.getId());

                int tasksToDo = 0;
                int tasksInProgress = 0;
                Boolean missingUpdate = false;
                String tasksTeam = "";
                LocalDateTime latestUpdate = DateFormat.DateParse(allReleases.get(currentReleaseId).getStartDate());
                HashMap<Integer, String> teamHashMap = new HashMap<>();

                sprintTotalPoints += story.getEffort();
                sprintTotalStories++;
                if (story.getState() == StoryStates.DONE.getIdentifier()) {
                    completedPoints += story.getEffort();
                    completedStories++;
                    if (DateFormat.DateParse(story.getDoneDate()).isBefore(endWeek1)) {
                        doneStoriesWeek1.put(story.getId(), story);
                    } else if (DateFormat.DateParse(story.getDoneDate()).isBefore(endWeek2)) {
                        doneStoriesWeek2.put(story.getId(), story);
                    } else {
                        doneStoriesWeek3.put(story.getId(), story);
                    }
                } else {
                    for (Map.Entry<Integer, TaskItem> me : allTasksInCurrentSprint.entrySet()) {
                        if (me.getValue().getParentStory() != null) {
                            if (me.getValue().getParentStory().getId() == story.getId()) {
                                if (DateFormat.DateParse(me.getValue().getLastUpdated()).compareTo(latestUpdate) > 0) {
                                    latestUpdate = DateFormat.DateParse(me.getValue().getLastUpdated());
                                }

                                if (me.getValue().getState() == TaskStates.TODO.getIdentifier()) {
                                    tasksToDo++;
                                } else if (me.getValue().getState() == TaskStates.IN_PROGRESS.getIdentifier()) {
                                    tasksInProgress++;
                                }

                                if (me.getValue().getResponsible() != null) {
                                    teamHashMap.put(me.getValue().getResponsible().getId(),
                                            me.getValue().getResponsible().getFirstName() + " "
                                                    + me.getValue().getResponsible().getLastName());
                                }
                            }
                        }
                    }

                    if (tasksInProgress + story.getCountDoneTasks() != 0) {
                        missingUpdate = true;
                    }

                    Row storyRow = sheet.createRow(rowStartPoint);
                    Cell storyRowCellA = storyRow.createCell(0);
                    storyRowCellA.setCellValue(story.getName());
                    sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol));

                    rowStartPoint += 1;

                    Row storyRow1 = sheet.createRow(rowStartPoint);
                    Cell storyRow1CellA = storyRow1.createCell(0);
                    storyRow1CellA.setCellValue("Effort");
                    Cell storyRow1CellC = storyRow1.createCell(2);
                    storyRow1CellC.setCellValue("# Tasks ToDo");
                    Cell storyRow1CellD = storyRow1.createCell(3);
                    storyRow1CellD.setCellValue("/");
                    CellUtil.setAlignment(storyRow1CellD, HorizontalAlignment.CENTER);
                    Cell storyRow1CellE = storyRow1.createCell(4);
                    storyRow1CellE.setCellValue("# Tasks InProgress");
                    Cell storyRow1CellF = storyRow1.createCell(5);
                    storyRow1CellF.setCellValue("/");
                    CellUtil.setAlignment(storyRow1CellF, HorizontalAlignment.CENTER);
                    Cell storyRow1CellG = storyRow1.createCell(6);
                    storyRow1CellG.setCellValue("# Tasks Done");
                    Cell storyRow1CellI = storyRow1.createCell(8);
                    storyRow1CellI.setCellValue("Last Update");

                    rowStartPoint += 1;

                    Row storyRow2 = sheet.createRow(rowStartPoint);
                    Cell storyRow2CellA = storyRow2.createCell(0);
                    storyRow2CellA.setCellValue(story.getEffort());
                    Cell storyRow2CellC = storyRow2.createCell(2);
                    storyRow2CellC.setCellValue(tasksToDo);
                    CellUtil.setAlignment(storyRow2CellC, HorizontalAlignment.CENTER);
                    Cell storyRow2CellD = storyRow2.createCell(3);
                    storyRow2CellD.setCellValue("/");
                    CellUtil.setAlignment(storyRow2CellD, HorizontalAlignment.CENTER);
                    Cell storyRow2CellE = storyRow2.createCell(4);
                    storyRow2CellE.setCellValue(tasksInProgress);
                    CellUtil.setAlignment(storyRow2CellE, HorizontalAlignment.CENTER);
                    Cell storyRow2CellF = storyRow2.createCell(5);
                    storyRow2CellF.setCellValue("/");
                    CellUtil.setAlignment(storyRow2CellF, HorizontalAlignment.CENTER);
                    Cell storyRow2CellG = storyRow2.createCell(6);
                    storyRow2CellG.setCellValue(story.getCountDoneTasks());
                    CellUtil.setAlignment(storyRow2CellG, HorizontalAlignment.CENTER);
                    Cell storyRow2CellI = storyRow2.createCell(8);
                    storyRow2CellI.setCellValue(latestUpdate.toString());
                    storyRow2CellI.setCellStyle(
                            DateFormat.ExcelDateColorCellStyle(workbook, latestUpdate, missingUpdate));

                    rowStartPoint += 1;

                    Row storyRow3 = sheet.createRow(rowStartPoint);
                    Cell storyRow3CellA = storyRow3.createCell(0);
                    storyRow3CellA.setCellValue("");
                    CellUtil.setVerticalAlignment(storyRow3CellA, VerticalAlignment.CENTER);
                    Cell storyRow3CellH = storyRow3.createCell(7);

                    Set teamSet = teamHashMap.entrySet();
                    Iterator teamIterator = teamSet.iterator();
                    while (teamIterator.hasNext()) {
                        Map.Entry<Integer, String> teamMentry = (Map.Entry) teamIterator.next();
                        tasksTeam += teamMentry.getValue() + "\n";
                    }

                    storyRow3CellH.setCellValue(tasksTeam);
                    CellUtil.setVerticalAlignment(storyRow3CellH, VerticalAlignment.CENTER);
                    CellUtil.setCellStyleProperty(storyRow3CellH, CellUtil.WRAP_TEXT, true);

                    sheet.addMergedRegion(new CellRangeAddress(
                            rowStartPoint, rowStartPoint, firstCol, lastCol - 2));

                    PropertyTemplate pt = new PropertyTemplate();
                    // these cells will have medium outside borders and thin inside borders
                    pt.drawBorders(new CellRangeAddress(
                            storiesBordersRowStartPoint, storiesBordersRowStartPoint + 3,
                            firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
                    pt.drawBorders(new CellRangeAddress(
                            storiesBordersRowStartPoint, storiesBordersRowStartPoint + 3,
                            firstCol, lastCol), BorderStyle.THIN, BorderExtent.INSIDE);

                    // apply borders to sheet
                    pt.applyBorders(sheet);

                    rowStartPoint += 2;
                    storiesBordersRowStartPoint = rowStartPoint;
                }
            }
        }

        Row sprintDetailsValueRow = sheet.createRow(sprintBordersRowStartPoint + 1);
        Cell sprintDetailsValueRowCellC = sprintDetailsValueRow.createCell(2);
        sprintDetailsValueRowCellC.setCellValue(completedStories);
        CellUtil.setAlignment(sprintDetailsValueRowCellC, HorizontalAlignment.CENTER);
        Cell sprintDetailsValueRowCellD = sprintDetailsValueRow.createCell(3);
        sprintDetailsValueRowCellD.setCellValue("/");
        CellUtil.setAlignment(sprintDetailsValueRowCellD, HorizontalAlignment.CENTER);
        Cell sprintDetailsValueRowCellE = sprintDetailsValueRow.createCell(4);
        sprintDetailsValueRowCellE.setCellValue(sprintTotalStories);
        CellUtil.setAlignment(sprintDetailsValueRowCellE, HorizontalAlignment.CENTER);

        Row sprintDetailsValueRow2 = sheet.createRow(sprintBordersRowStartPoint + 3);
        Cell sprintDetailsValueRow2CellC = sprintDetailsValueRow2.createCell(2);
        sprintDetailsValueRow2CellC.setCellValue(completedPoints);
        CellUtil.setAlignment(sprintDetailsValueRow2CellC, HorizontalAlignment.CENTER);
        Cell sprintDetailsValueRow2CellD = sprintDetailsValueRow2.createCell(3);
        sprintDetailsValueRow2CellD.setCellValue("/");
        CellUtil.setAlignment(sprintDetailsValueRow2CellD, HorizontalAlignment.CENTER);
        Cell sprintDetailsValueRow2CellE = sprintDetailsValueRow2.createCell(4);
        sprintDetailsValueRow2CellE.setCellValue(sprintTotalPoints);
        CellUtil.setAlignment(sprintDetailsValueRow2CellE, HorizontalAlignment.CENTER);

        PropertyTemplate pt1 = new PropertyTemplate();
        // these cells will have medium outside borders
        pt1.drawBorders(new CellRangeAddress(sprintBordersRowStartPoint, sprintBordersRowStartPoint + 3,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        // apply borders to sheet
        pt1.applyBorders(sheet);

        new FeatureWeeksDataToExcel("Week 1", doneStoriesWeek1, sheet, rowStartPoint, firstCol, lastCol, storiesBordersRowStartPoint);

//        new FeatureWeeksDataToExcel("Week 2", doneStoriesWeek2, sheet, rowStartPoint, firstCol, lastCol, storiesBordersRowStartPoint);

//        new FeatureWeeksDataToExcel("Week 3", doneStoriesWeek3, sheet, rowStartPoint, firstCol, lastCol, storiesBordersRowStartPoint);

        // Auto size the column widths
        for (int columnIndex = 0; columnIndex < 10; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
}
