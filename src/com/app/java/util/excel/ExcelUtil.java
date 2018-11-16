package com.app.java.util.excel;

import com.app.java.model.SafeStatus.PiStatus;
import com.app.java.model.enums.StoryStates;
import com.app.java.model.enums.TaskStates;
import com.app.java.model.json.*;
import com.app.java.util.DateFormat;
import com.app.java.util.NonStoryTasks;
import com.app.java.util.UsersNoInProgressTasks;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.app.java.MainForm.*;

/**
 * Created by elamoureux on 2/14/2017.
 */
public class ExcelUtil {
    public static void ExportToFile() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Status");

        int rowStartPoint = 0;
        int projectBordersRowStartPoint = 0;
        int sprintBordersRowStartPoint = 0;
        int noInProgressTaskBordersRowStartPoint = 0;
        int urgentTasksBordersRowStartPoint = 0;
        int urgentTasksBordersRowStopPoint = 0;
        int recurrentTasksBordersRowStartPoint = 0;
        int recurrentTasksBordersRowStopPoint = 0;
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
        titleRowCellA.setCellValue("Weekly Projects Status");
        CellUtil.setCellStyleProperties(titleRowCellA, cellStyleValues);
//        CellUtil.setAlignment(titleRowCellA, HorizontalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol));

        rowStartPoint += 2;
        projectBordersRowStartPoint = rowStartPoint;

        Row projectRow = sheet.createRow(rowStartPoint);
        Cell projectRowCellA = projectRow.createCell(0);
        projectRowCellA.setCellValue(currentProjectName);
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol - 1));
        Cell projectRowCellI = projectRow.createCell(8);
        projectRowCellI.setCellValue("End Date");

        rowStartPoint += 1;

        if (currentReleaseId > 0) {
            Row releaseRow = sheet.createRow(rowStartPoint);
            Cell releaseRowCellA = releaseRow.createCell(0);
            releaseRowCellA.setCellValue(allReleases.get(currentReleaseId).getName());
            sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol - 1));
            Cell releaseRowCellI = releaseRow.createCell(8);
            releaseRowCellI.setCellValue(DateFormat.ExcelDateFormat(allReleases.get(currentReleaseId).getEndDate()));
            releaseRowCellI.setCellStyle(DateFormat.ExcelDateCellStyle(workbook));
        }

        rowStartPoint += 2;
        sprintBordersRowStartPoint = rowStartPoint;

        Row sprintRow = sheet.createRow(rowStartPoint);
        Cell sprintRowCellA = sprintRow.createCell(0);
        sprintRowCellA.setCellValue("Current Sprint");
        Cell sprintRowCellC = sprintRow.createCell(2);
        sprintRowCellC.setCellValue("Current #");
        Cell sprintRowCellD = sprintRow.createCell(3);
        sprintRowCellD.setCellValue("/");
        CellUtil.setAlignment(sprintRowCellD, HorizontalAlignment.CENTER);
        Cell sprintRowCellE = sprintRow.createCell(4);
        sprintRowCellE.setCellValue("Total #");
        Cell sprintRowCellI = sprintRow.createCell(8);
        sprintRowCellI.setCellValue("End Date");

        rowStartPoint += 1;

        if (currentSprintId > 0) {
            Row sprintValueRow = sheet.createRow(rowStartPoint);
            Cell sprintValueRowCellC = sprintValueRow.createCell(2);
            sprintValueRowCellC.setCellValue(allSprintInCurrentRelease.get(currentSprintId).getOrderNumber());
            CellUtil.setAlignment(sprintValueRowCellC, HorizontalAlignment.CENTER);
            Cell sprintValueRowCellD = sprintValueRow.createCell(3);
            sprintValueRowCellD.setCellValue("/");
            CellUtil.setAlignment(sprintValueRowCellD, HorizontalAlignment.CENTER);
            Cell sprintValueRowCellE = sprintValueRow.createCell(4);
            sprintValueRowCellE.setCellValue(allSprintInCurrentRelease.size());
            CellUtil.setAlignment(sprintValueRowCellE, HorizontalAlignment.CENTER);
            Cell sprintValueRowCellI = sprintValueRow.createCell(8);
            sprintValueRowCellI.setCellValue(DateFormat.ExcelDateFormat(
                    allSprintInCurrentRelease.get(currentSprintId).getEndDate()));
            sprintValueRowCellI.setCellStyle(DateFormat.ExcelDateCellStyle(workbook));
        }

        rowStartPoint += 1;

        Row sprintDetailsRow = sheet.createRow(rowStartPoint);
        Cell sprintDetailsRowCellA = sprintDetailsRow.createCell(0);
        sprintDetailsRowCellA.setCellValue("Capacity");
        Cell sprintDetailsRowCellC = sprintDetailsRow.createCell(2);
        sprintDetailsRowCellC.setCellValue("# Completed Stories");
        Cell sprintDetailsRowCellD = sprintDetailsRow.createCell(3);
        sprintDetailsRowCellD.setCellValue("/");
        CellUtil.setAlignment(sprintDetailsRowCellD, HorizontalAlignment.CENTER);
        Cell sprintDetailsRowCellE = sprintDetailsRow.createCell(4);
        sprintDetailsRowCellE.setCellValue("# Total Stories");

        rowStartPoint += 3;
        noInProgressTaskBordersRowStartPoint = rowStartPoint;

        Row noInProgressTaskRow = sheet.createRow(rowStartPoint);
        Cell noInProgressTaskRowCellA = noInProgressTaskRow.createCell(0);
        noInProgressTaskRowCellA.setCellValue("Users with no tasks in progress");
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 8));
        rowStartPoint++;
        UsersNoInProgressTasks usersNoInProgressTasks = new UsersNoInProgressTasks(allTasksInCurrentSprint);
        Set usersNoInProgressTasksSet = usersNoInProgressTasks.getUsersList().entrySet();
        Iterator usersNoInProgressTasksIterator = usersNoInProgressTasksSet.iterator();
        List list = new ArrayList();
        while (usersNoInProgressTasksIterator.hasNext()) {
            Map.Entry<Integer, User> mentry = (Map.Entry) usersNoInProgressTasksIterator.next();
            list.add(mentry.getValue().getFirstName() + " " + mentry.getValue().getLastName());
        }
        Row noInProgressTaskDetailRow = sheet.createRow(rowStartPoint);
        noInProgressTaskDetailRow.setHeightInPoints(30);
        Cell noInProgressTaskDetailRowCellA = noInProgressTaskDetailRow.createCell(0);
        noInProgressTaskDetailRowCellA.setCellValue(list.toString().replace("[", "")
                .replace("]", ""));
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 8));
        CellUtil.setCellStyleProperty(noInProgressTaskDetailRowCellA, CellUtil.WRAP_TEXT, true);

        rowStartPoint += 2;
        urgentTasksBordersRowStartPoint = rowStartPoint;

        NonStoryTasks nonStoryTasks = new NonStoryTasks(allTasksInCurrentSprint);

        Row urgentTasksRow = sheet.createRow(rowStartPoint);
        Cell urgentTasksRowCellA = urgentTasksRow.createCell(0);
        urgentTasksRowCellA.setCellValue("Urgent Tasks");
        Cell urgentTasksRowCellI = urgentTasksRow.createCell(8);
        urgentTasksRowCellI.setCellValue("Status");
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 7));
        Set urgentTasksSet = nonStoryTasks.getUrgentTasksHashMap().entrySet();
        Iterator urgentTasksIterator = urgentTasksSet.iterator();
        while (urgentTasksIterator.hasNext()) {
            rowStartPoint++;
            Map.Entry<Integer, TaskItem> mentry = (Map.Entry) urgentTasksIterator.next();
            Row urgentTaskDetailRow = sheet.createRow(rowStartPoint);
            Cell urgentTaskDetailRowCellA = urgentTaskDetailRow.createCell(0);
            urgentTaskDetailRowCellA.setCellValue(mentry.getValue().getName());
            sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 6));
            Cell urgentTaskDetailRowCellH = urgentTaskDetailRow.createCell(7);
//            for (Users u : Users.values()) {
//                if (mentry.getValue().getResponsibleId() == u.getIdentifier()) {
//                    urgentTaskDetailRowCellH.setCellValue(u.getUserName());
//                }
//            }
            urgentTaskDetailRowCellH.setCellValue(mentry.getValue().getResponsible().getFirstName()
                    + " " + mentry.getValue().getResponsible().getLastName());
            Cell urgentTaskDetailRowCellI = urgentTaskDetailRow.createCell(8);
            for (TaskStates ts : TaskStates.values()) {
                if (mentry.getValue().getState() == ts.getIdentifier()) {
                    urgentTaskDetailRowCellI.setCellValue(ts.getText());
                }
            }
        }
        urgentTasksBordersRowStopPoint = rowStartPoint;

        rowStartPoint += 2;
        recurrentTasksBordersRowStartPoint = rowStartPoint;

        Row recurrentTasksRow = sheet.createRow(rowStartPoint);
        Cell recurrentTasksRowCellA = recurrentTasksRow.createCell(0);
        recurrentTasksRowCellA.setCellValue("Recurrent Tasks");
        Cell recurrentTasksRowCellI = recurrentTasksRow.createCell(8);
        recurrentTasksRowCellI.setCellValue("Status");
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 7));
        Set recurrentTasksSet = nonStoryTasks.getRecurrentTasksHashMap().entrySet();
        Iterator recurrentTasksIterator = recurrentTasksSet.iterator();
        while (recurrentTasksIterator.hasNext()) {
            rowStartPoint++;
            Map.Entry<Integer, TaskItem> mentry = (Map.Entry) recurrentTasksIterator.next();
            Row recurrentTaskDetailRow = sheet.createRow(rowStartPoint);
            Cell recurrentTaskDetailRowCellA = recurrentTaskDetailRow.createCell(0);
            recurrentTaskDetailRowCellA.setCellValue(mentry.getValue().getName());
            sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 6));
            Cell recurrentTaskDetailRowCellH = recurrentTaskDetailRow.createCell(7);
//            for (Users u : Users.values()) {
//                if (mentry.getValue().getResponsibleId() == u.getIdentifier()) {
//                    recurrentTaskDetailRowCellH.setCellValue(u.getUserName());
//                }
//            }
            recurrentTaskDetailRowCellH.setCellValue(mentry.getValue().getResponsible().getFirstName() + " "
                    + mentry.getValue().getResponsible().getLastName());
            Cell recurrentTaskDetailRowCellI = recurrentTaskDetailRow.createCell(8);
            for (TaskStates ts : TaskStates.values()) {
                if (mentry.getValue().getState() == ts.getIdentifier()) {
                    recurrentTaskDetailRowCellI.setCellValue(ts.getText());
                }
            }

        }
        recurrentTasksBordersRowStopPoint = rowStartPoint;

        rowStartPoint += 2;
        storiesBordersRowStartPoint = rowStartPoint;

        Set set = allStoriesInCurrentSprint.entrySet();
        int numCompletedStories = 0;
        float completedPoints = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Story> mentry = (Map.Entry) iterator.next();

            int tasksToDo = 0;
            int tasksInProgress = 0;
            int tasksDone = 0;
            Boolean missingUpdate = false;
            String tasksTeam = "";
            LocalDateTime latestUpdate = DateFormat.DateParse(allReleases.get(currentReleaseId).getStartDate());
            HashMap<Integer, String> teamHashMap = new HashMap<>();

            if (mentry.getValue().getState() == StoryStates.DONE.getIdentifier()) {
                numCompletedStories++;
                completedPoints += mentry.getValue().getEffort();
            } else {
                for (Map.Entry<Integer, TaskItem> me : allTasksInCurrentSprint.entrySet()) {
                    if (me.getValue().getParentStory() != null) {
                        if (me.getValue().getParentStory().getId() == mentry.getValue().getId()) {
                            if (DateFormat.DateParse(me.getValue().getLastUpdated()).compareTo(latestUpdate) > 0) {
                                latestUpdate = DateFormat.DateParse(me.getValue().getLastUpdated());
                            }

                            if (me.getValue().getState() == TaskStates.TODO.getIdentifier()) {
                                tasksToDo++;
                            } else if (me.getValue().getState() == TaskStates.IN_PROGRESS.getIdentifier()) {
                                tasksInProgress++;
                            } else if (me.getValue().getState() == TaskStates.DONE.getIdentifier()) {
                                tasksDone++;
                            }

                            if (me.getValue().getResponsible() != null) {
                                teamHashMap.put(me.getValue().getResponsible().getId(),
                                        me.getValue().getResponsible().getFirstName()
                                                + " " + me.getValue().getResponsible().getLastName());
                            }
                        }
                    }
                }

                if (tasksInProgress + tasksDone != 0) {
                    missingUpdate = true;
                }

                Row storyRow = sheet.createRow(rowStartPoint);
                Cell storyRowCellA = storyRow.createCell(0);
                storyRowCellA.setCellValue(mentry.getValue().getName());
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
                storyRow2CellA.setCellValue(mentry.getValue().getEffort());
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
                storyRow2CellG.setCellValue(tasksDone);
                CellUtil.setAlignment(storyRow2CellG, HorizontalAlignment.CENTER);
                Cell storyRow2CellI = storyRow2.createCell(8);
//                storyRow2CellI.setCellValue(latestUpdate.toString());
//                storyRow2CellI.setCellValue(DateFormat.ExcelDateFormat(latestUpdate));
                storyRow2CellI.setCellValue(DateFormat.MediumDateFormat(latestUpdate));
                storyRow2CellI.setCellStyle(DateFormat.ExcelDateColorCellStyle(workbook, latestUpdate, missingUpdate));

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

                sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol - 2));

                PropertyTemplate pt = new PropertyTemplate();
                // these cells will have medium outside borders and thin inside borders
                pt.drawBorders(new CellRangeAddress(storiesBordersRowStartPoint, storiesBordersRowStartPoint + 3,
                        firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
                pt.drawBorders(new CellRangeAddress(storiesBordersRowStartPoint, storiesBordersRowStartPoint + 3,
                        firstCol, lastCol), BorderStyle.THIN, BorderExtent.INSIDE);

                // apply borders to sheet
                pt.applyBorders(sheet);

                rowStartPoint += 2;
                storiesBordersRowStartPoint = rowStartPoint;
            }
        }

        if (currentSprintId > 0) {
            Row sprintDetailsValueRow = sheet.createRow(8);
            Cell sprintDetailsValueRowCellA = sprintDetailsValueRow.createCell(0);
            sprintDetailsValueRowCellA.setCellValue(Math.round(completedPoints) + "/" +
                    Math.round(allSprintInCurrentRelease.get(currentSprintId).getCapacity()));
            Cell sprintDetailsValueRowCellC = sprintDetailsValueRow.createCell(2);
            sprintDetailsValueRowCellC.setCellValue(numCompletedStories);
            CellUtil.setAlignment(sprintDetailsValueRowCellC, HorizontalAlignment.CENTER);
            Cell sprintDetailsValueRowCellD = sprintDetailsValueRow.createCell(3);
            sprintDetailsValueRowCellD.setCellValue("/");
            CellUtil.setAlignment(sprintDetailsValueRowCellD, HorizontalAlignment.CENTER);
            Cell sprintDetailsValueRowCellE = sprintDetailsValueRow.createCell(4);
            sprintDetailsValueRowCellE.setCellValue(allStoriesInCurrentSprint.size());
            CellUtil.setAlignment(sprintDetailsValueRowCellE, HorizontalAlignment.CENTER);
        }

        PropertyTemplate pt = new PropertyTemplate();
        // these cells will have medium outside borders and thin inside borders
        pt.drawBorders(new CellRangeAddress(noInProgressTaskBordersRowStartPoint,
                        noInProgressTaskBordersRowStartPoint + 1, firstCol, lastCol),
                BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        pt.drawBorders(new CellRangeAddress(noInProgressTaskBordersRowStartPoint,
                        noInProgressTaskBordersRowStartPoint + 1, firstCol, lastCol),
                BorderStyle.THIN, BorderExtent.INSIDE);
        pt.drawBorders(new CellRangeAddress(urgentTasksBordersRowStartPoint, urgentTasksBordersRowStopPoint,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        pt.drawBorders(new CellRangeAddress(urgentTasksBordersRowStartPoint, urgentTasksBordersRowStopPoint,
                firstCol, lastCol), BorderStyle.THIN, BorderExtent.INSIDE);
        pt.drawBorders(new CellRangeAddress(recurrentTasksBordersRowStartPoint, recurrentTasksBordersRowStopPoint,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        pt.drawBorders(new CellRangeAddress(recurrentTasksBordersRowStartPoint, recurrentTasksBordersRowStopPoint,
                firstCol, lastCol), BorderStyle.THIN, BorderExtent.INSIDE);

        // apply borders to sheet
        pt.applyBorders(sheet);

        PropertyTemplate pt1 = new PropertyTemplate();
        // these cells will have medium outside borders
        pt1.drawBorders(new CellRangeAddress(projectBordersRowStartPoint, projectBordersRowStartPoint + 1,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        pt1.drawBorders(new CellRangeAddress(sprintBordersRowStartPoint, sprintBordersRowStartPoint + 3,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        // apply borders to sheet
        pt1.applyBorders(sheet);

        // Auto size the column widths
        for (int columnIndex = 0; columnIndex < 10; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }

        for (Feature feature : features) {
            for (Id storyId : feature.getStories_ids()) {
                if (allStoriesInCurrentSprint.containsKey(storyId.getId())) {
                    new FeatureDataToExcel(workbook, feature);
                    break;
                }
            }
        }

        new TaktDataToExcel(workbook);

        new LighthouseDataToExcel(workbook);

        new DashboardDataToExcel(workbook);

        try {
            File file;
            FileOutputStream fos = null;

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();

            String fileName = currentProjectName;

            if (currentReleaseId > 0) {
                fileName += "_" + allReleases.get(currentReleaseId).getName() + "_WeeklyStatus_"
                        + dtf.format(localDate);
            } else {
                fileName += "_WeeklyStatus_" + dtf.format(localDate);
            }

            file = new File(System.getProperty("user.home") + "/" + fileName + ".xlsx");
//            file = new File("c:/" + fileName + ".xlsx");
            fos = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            workbook.write(fos);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

//                try {
//                    XSSFWorkbook fWorkbook = new XSSFWorkbook();
//                    XSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
//                    XSSFFont sheetTitleFont = fWorkbook.createFont();
//                    String fileName2 = "Patate2";
//
//                    File file2 = new File("c:/" + fileName2 + ".xlsx");
//                    XSSFCellStyle cellStyle = fWorkbook.createCellStyle();
//
//                    sheetTitleFont.setBold(true);
//                    //sheetTitleFont.setColor();
//                    TableModel model = table1.getModel();
//
//
//                    for (int i = 0; i < model.getRowCount(); i++) {
//                        XSSFRow fRow = fSheet.createRow((short) i);
//                        for (int j = 0; j < model.getColumnCount(); j++) {
//                            XSSFCell cell = fRow.createCell((short) j);
//                            cell.setCellValue(model.getValueAt(i, j).toString());
//                            cell.setCellStyle(cellStyle);
//
//                        }
//
//                    }
//                    FileOutputStream fileOutputStream;
//                    fileOutputStream = new FileOutputStream(file2);
//                    BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
//                    fWorkbook.write(bos);
//                    bos.close();
//                    fileOutputStream.close();
//                } catch (Exception e2) {
//                    e2.printStackTrace();
//                }

    }

    public static void ExportPiToFile(PiStatus piStatus, PiStatus piStatus1, PiStatus piStatus2, PiStatus piStatus3, PiStatus piStatus4) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Program Status");

        int rowStartPoint = 0;
        int projectBordersRowStartPoint = 0;
        int sprintBordersRowStartPoint = 0;
        int storiesBordersRowStartPoint = 0;
        int storyPointsBordersRowStartPoint = 0;
        int objectivesBordersRowStartPoint = 0;
        int firstCol = 0;
        int lastCol = 8;

        Map<String, Object> cellStyleValues = new HashMap<>();
        cellStyleValues.put(CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);
        cellStyleValues.put(CellUtil.FILL_BACKGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_PATTERN, FillPatternType.NO_FILL);

        Row titleRow = sheet.createRow(rowStartPoint);
        Cell titleRowCellA = titleRow.createCell(0);
        titleRowCellA.setCellValue("PI Program Status");
        CellUtil.setCellStyleProperties(titleRowCellA, cellStyleValues);
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol));

        rowStartPoint += 2;
        projectBordersRowStartPoint = rowStartPoint;

        Row projectRow = sheet.createRow(rowStartPoint);
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol - 1));
        Cell projectRowCellI = projectRow.createCell(8);
        projectRowCellI.setCellValue("End Date");

        rowStartPoint += 1;

        if (currentReleaseId > 0) {
            Row releaseRow = sheet.createRow(rowStartPoint);
            Cell releaseRowCellA = releaseRow.createCell(0);
            releaseRowCellA.setCellValue(allReleases.get(currentReleaseId).getName());
            sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol - 1));
            Cell releaseRowCellI = releaseRow.createCell(8);
            releaseRowCellI.setCellValue(DateFormat.ExcelDateFormat(allReleases.get(currentReleaseId).getEndDate()));
            releaseRowCellI.setCellStyle(DateFormat.ExcelDateCellStyle(workbook));
        }

        rowStartPoint += 2;
        sprintBordersRowStartPoint = rowStartPoint;

        Row sprintRow = sheet.createRow(rowStartPoint);
        Cell sprintRowCellA = sprintRow.createCell(0);
        sprintRowCellA.setCellValue("Current Sprint");
        Cell sprintRowCellC = sprintRow.createCell(2);
        sprintRowCellC.setCellValue("Current #");
        Cell sprintRowCellD = sprintRow.createCell(3);
        sprintRowCellD.setCellValue("/");
        CellUtil.setAlignment(sprintRowCellD, HorizontalAlignment.CENTER);
        Cell sprintRowCellE = sprintRow.createCell(4);
        sprintRowCellE.setCellValue("Total #");
        Cell sprintRowCellI = sprintRow.createCell(8);
        sprintRowCellI.setCellValue("End Date");

        rowStartPoint += 1;

        if (currentSprintId > 0) {
            Row sprintValueRow = sheet.createRow(rowStartPoint);
            Cell sprintValueRowCellC = sprintValueRow.createCell(2);
            sprintValueRowCellC.setCellValue(allSprintInCurrentRelease.get(currentSprintId).getOrderNumber());
            CellUtil.setAlignment(sprintValueRowCellC, HorizontalAlignment.CENTER);
            Cell sprintValueRowCellD = sprintValueRow.createCell(3);
            sprintValueRowCellD.setCellValue("/");
            CellUtil.setAlignment(sprintValueRowCellD, HorizontalAlignment.CENTER);
            Cell sprintValueRowCellE = sprintValueRow.createCell(4);
            sprintValueRowCellE.setCellValue(allSprintInCurrentRelease.size());
            CellUtil.setAlignment(sprintValueRowCellE, HorizontalAlignment.CENTER);
            Cell sprintValueRowCellI = sprintValueRow.createCell(8);
            sprintValueRowCellI.setCellValue(DateFormat.ExcelDateFormat(
                    allSprintInCurrentRelease.get(currentSprintId).getEndDate()));
            sprintValueRowCellI.setCellStyle(DateFormat.ExcelDateCellStyle(workbook));
        }

        rowStartPoint += 2;
        storiesBordersRowStartPoint = rowStartPoint;

        Row sprintTitleRow = sheet.createRow(rowStartPoint);
        Cell sprintTitleRowCellC = sprintTitleRow.createCell(2);
        sprintTitleRowCellC.setCellValue("Sprint 1");
        Cell sprintTitleRowCellD = sprintTitleRow.createCell(3);
        sprintTitleRowCellD.setCellValue("Sprint 2");
        Cell sprintTitleRowCellE = sprintTitleRow.createCell(4);
        sprintTitleRowCellE.setCellValue("Sprint 3");
        Cell sprintTitleRowCellF = sprintTitleRow.createCell(5);
        sprintTitleRowCellF.setCellValue("Sprint 4");
        Cell sprintTitleRowCellG = sprintTitleRow.createCell(6);
        sprintTitleRowCellG.setCellValue("Sprint 5");
        Cell sprintTitleRowCellH = sprintTitleRow.createCell(7);
        sprintTitleRowCellH.setCellValue("Sprint IP");

        rowStartPoint += 1;

        Row totalStoriesRow = sheet.createRow(rowStartPoint);
        Cell totalStoriesRowCellA = totalStoriesRow.createCell(0);
        totalStoriesRowCellA.setCellValue("Total Stories");
        Cell totalStoriesRowCellC = totalStoriesRow.createCell(2);
        totalStoriesRowCellC.setCellValue(piStatus.getPiSprints()[0].getTotalStories());
        Cell totalStoriesRowCellD = totalStoriesRow.createCell(3);
        totalStoriesRowCellD.setCellValue(piStatus.getPiSprints()[1].getTotalStories());
        Cell totalStoriesRowCellE = totalStoriesRow.createCell(4);
        totalStoriesRowCellE.setCellValue(piStatus.getPiSprints()[2].getTotalStories());
        Cell totalStoriesRowCellF = totalStoriesRow.createCell(5);
        totalStoriesRowCellF.setCellValue(piStatus.getPiSprints()[3].getTotalStories());
        Cell totalStoriesRowCellG = totalStoriesRow.createCell(6);
        totalStoriesRowCellG.setCellValue(piStatus.getPiSprints()[4].getTotalStories());
        Cell totalStoriesRowCellH = totalStoriesRow.createCell(7);
        totalStoriesRowCellH.setCellValue(piStatus.getPiSprints()[5].getTotalStories());

        rowStartPoint += 1;

        Row totalStoriesRemainingRow = sheet.createRow(rowStartPoint);
        Cell totalStoriesRemainingRowCellA = totalStoriesRemainingRow.createCell(0);
        totalStoriesRemainingRowCellA.setCellValue("Total Remaining Stories");
        Cell totalStoriesRemainingRowCellC = totalStoriesRemainingRow.createCell(2);
        totalStoriesRemainingRowCellC.setCellValue(piStatus.getPiSprints()[0].getTotalStoriesRemaining());
        Cell totalStoriesRemainingRowCellD = totalStoriesRemainingRow.createCell(3);
        totalStoriesRemainingRowCellD.setCellValue(piStatus.getPiSprints()[1].getTotalStoriesRemaining());
        Cell totalStoriesRemainingRowCellE = totalStoriesRemainingRow.createCell(4);
        totalStoriesRemainingRowCellE.setCellValue(piStatus.getPiSprints()[2].getTotalStoriesRemaining());
        Cell totalStoriesRemainingRowCellF = totalStoriesRemainingRow.createCell(5);
        totalStoriesRemainingRowCellF.setCellValue(piStatus.getPiSprints()[3].getTotalStoriesRemaining());
        Cell totalStoriesRemainingRowCellG = totalStoriesRemainingRow.createCell(6);
        totalStoriesRemainingRowCellG.setCellValue(piStatus.getPiSprints()[4].getTotalStoriesRemaining());
        Cell totalStoriesRemainingRowCellH = totalStoriesRemainingRow.createCell(7);
        totalStoriesRemainingRowCellH.setCellValue(piStatus.getPiSprints()[5].getTotalStoriesRemaining());

        rowStartPoint += 1;

        Row initialStoriesPlannedRow = sheet.createRow(rowStartPoint);
        Cell initialStoriesPlannedRowCellA = initialStoriesPlannedRow.createCell(0);
        initialStoriesPlannedRowCellA.setCellValue("Initial Stories Planned");
        Cell initialStoriesPlannedRowCellC = initialStoriesPlannedRow.createCell(2);
        initialStoriesPlannedRowCellC.setCellValue(piStatus.getPiSprints()[0].getStoriesPlanned());
        Cell initialStoriesPlannedRowCellD = initialStoriesPlannedRow.createCell(3);
        initialStoriesPlannedRowCellD.setCellValue(piStatus.getPiSprints()[1].getStoriesPlanned());
        Cell initialStoriesPlannedRowCellE = initialStoriesPlannedRow.createCell(4);
        initialStoriesPlannedRowCellE.setCellValue(piStatus.getPiSprints()[2].getStoriesPlanned());
        Cell initialStoriesPlannedRowCellF = initialStoriesPlannedRow.createCell(5);
        initialStoriesPlannedRowCellF.setCellValue(piStatus.getPiSprints()[3].getStoriesPlanned());
        Cell initialStoriesPlannedRowCellG = initialStoriesPlannedRow.createCell(6);
        initialStoriesPlannedRowCellG.setCellValue(piStatus.getPiSprints()[4].getStoriesPlanned());
        Cell initialStoriesPlannedRowCellH = initialStoriesPlannedRow.createCell(7);
        initialStoriesPlannedRowCellH.setCellValue(piStatus.getPiSprints()[5].getStoriesPlanned());

        rowStartPoint += 1;

        Row storiesOpenRow = sheet.createRow(rowStartPoint);
        Cell storiesOpenRowCellA = storiesOpenRow.createCell(0);
        storiesOpenRowCellA.setCellValue("Stories Open");
        Cell storiesOpenRowCellC = storiesOpenRow.createCell(2);
        storiesOpenRowCellC.setCellValue(piStatus.getPiSprints()[0].getStoriesOpen());
        Cell storiesOpenRowCellD = storiesOpenRow.createCell(3);
        storiesOpenRowCellD.setCellValue(piStatus.getPiSprints()[1].getStoriesOpen());
        Cell storiesOpenRowCellE = storiesOpenRow.createCell(4);
        storiesOpenRowCellE.setCellValue(piStatus.getPiSprints()[2].getStoriesOpen());
        Cell storiesOpenRowCellF = storiesOpenRow.createCell(5);
        storiesOpenRowCellF.setCellValue(piStatus.getPiSprints()[3].getStoriesOpen());
        Cell storiesOpenRowCellG = storiesOpenRow.createCell(6);
        storiesOpenRowCellG.setCellValue(piStatus.getPiSprints()[4].getStoriesOpen());
        Cell storiesOpenRowCellH = storiesOpenRow.createCell(7);
        storiesOpenRowCellH.setCellValue(piStatus.getPiSprints()[5].getStoriesOpen());

        rowStartPoint += 1;

        Row storiesClosedRow = sheet.createRow(rowStartPoint);
        Cell storiesClosedRowCellA = storiesClosedRow.createCell(0);
        storiesClosedRowCellA.setCellValue("Stories Closed");
        Cell storiesClosedRowCellC = storiesClosedRow.createCell(2);
        storiesClosedRowCellC.setCellValue(piStatus.getPiSprints()[0].getStoriesClosed());
        Cell storiesClosedRowCellD = storiesClosedRow.createCell(3);
        storiesClosedRowCellD.setCellValue(piStatus.getPiSprints()[1].getStoriesClosed());
        Cell storiesClosedRowCellE = storiesClosedRow.createCell(4);
        storiesClosedRowCellE.setCellValue(piStatus.getPiSprints()[2].getStoriesClosed());
        Cell storiesClosedRowCellF = storiesClosedRow.createCell(5);
        storiesClosedRowCellF.setCellValue(piStatus.getPiSprints()[3].getStoriesClosed());
        Cell storiesClosedRowCellG = storiesClosedRow.createCell(6);
        storiesClosedRowCellG.setCellValue(piStatus.getPiSprints()[4].getStoriesClosed());
        Cell storiesClosedRowCellH = storiesClosedRow.createCell(7);
        storiesClosedRowCellH.setCellValue(piStatus.getPiSprints()[5].getStoriesClosed());

        rowStartPoint += 3;
        storyPointsBordersRowStartPoint = rowStartPoint;

        Row totalStoryPointsRow = sheet.createRow(rowStartPoint);
        Cell totalStoryPointsRowCellA = totalStoryPointsRow.createCell(0);
        totalStoryPointsRowCellA.setCellValue("Total Story Points");
        Cell totalStoryPointsRowCellC = totalStoryPointsRow.createCell(2);
        totalStoryPointsRowCellC.setCellValue(piStatus.getPiSprints()[0].getTotalStoryPoints());
        Cell totalStoryPointsRowCellD = totalStoryPointsRow.createCell(3);
        totalStoryPointsRowCellD.setCellValue(piStatus.getPiSprints()[1].getTotalStoryPoints());
        Cell totalStoryPointsRowCellE = totalStoryPointsRow.createCell(4);
        totalStoryPointsRowCellE.setCellValue(piStatus.getPiSprints()[2].getTotalStoryPoints());
        Cell totalStoryPointsRowCellF = totalStoryPointsRow.createCell(5);
        totalStoryPointsRowCellF.setCellValue(piStatus.getPiSprints()[3].getTotalStoryPoints());
        Cell totalStoryPointsRowCellG = totalStoryPointsRow.createCell(6);
        totalStoryPointsRowCellG.setCellValue(piStatus.getPiSprints()[4].getTotalStoryPoints());
        Cell totalStoryPointsRowCellH = totalStoryPointsRow.createCell(7);
        totalStoryPointsRowCellH.setCellValue(piStatus.getPiSprints()[5].getTotalStoryPoints());

        rowStartPoint += 1;

        Row totalStoryPointsRemainingRow = sheet.createRow(rowStartPoint);
        Cell totalStoryPointsRemainingRowCellA = totalStoryPointsRemainingRow.createCell(0);
        totalStoryPointsRemainingRowCellA.setCellValue("Total Story Points Remaining");
        Cell totalStoryPointsRemainingRowCellC = totalStoryPointsRemainingRow.createCell(2);
        totalStoryPointsRemainingRowCellC.setCellValue(piStatus.getPiSprints()[0].getTotalStoryPointsRemaining());
        Cell totalStoryPointsRemainingRowCellD = totalStoryPointsRemainingRow.createCell(3);
        totalStoryPointsRemainingRowCellD.setCellValue(piStatus.getPiSprints()[1].getTotalStoryPointsRemaining());
        Cell totalStoryPointsRemainingRowCellE = totalStoryPointsRemainingRow.createCell(4);
        totalStoryPointsRemainingRowCellE.setCellValue(piStatus.getPiSprints()[2].getTotalStoryPointsRemaining());
        Cell totalStoryPointsRemainingRowCellF = totalStoryPointsRemainingRow.createCell(5);
        totalStoryPointsRemainingRowCellF.setCellValue(piStatus.getPiSprints()[3].getTotalStoryPointsRemaining());
        Cell totalStoryPointsRemainingRowCellG = totalStoryPointsRemainingRow.createCell(6);
        totalStoryPointsRemainingRowCellG.setCellValue(piStatus.getPiSprints()[4].getTotalStoryPointsRemaining());
        Cell totalStoryPointsRemainingRowCellH = totalStoryPointsRemainingRow.createCell(7);
        totalStoryPointsRemainingRowCellH.setCellValue(piStatus.getPiSprints()[5].getTotalStoryPointsRemaining());

        rowStartPoint += 1;

        Row initialStoryPointsPlannedRow = sheet.createRow(rowStartPoint);
        Cell initialStoryPointsPlannedRowCellA = initialStoryPointsPlannedRow.createCell(0);
        initialStoryPointsPlannedRowCellA.setCellValue("Initial Story Points Planned");
        Cell initialStoryPointsPlannedRowCellC = initialStoryPointsPlannedRow.createCell(2);
        initialStoryPointsPlannedRowCellC.setCellValue(piStatus.getPiSprints()[0].getStoryPointsPlanned());
        Cell initialStoryPointsPlannedRowCellD = initialStoryPointsPlannedRow.createCell(3);
        initialStoryPointsPlannedRowCellD.setCellValue(piStatus.getPiSprints()[1].getStoryPointsPlanned());
        Cell initialStoryPointsPlannedRowCellE = initialStoryPointsPlannedRow.createCell(4);
        initialStoryPointsPlannedRowCellE.setCellValue(piStatus.getPiSprints()[2].getStoryPointsPlanned());
        Cell initialStoryPointsPlannedRowCellF = initialStoryPointsPlannedRow.createCell(5);
        initialStoryPointsPlannedRowCellF.setCellValue(piStatus.getPiSprints()[3].getStoryPointsPlanned());
        Cell initialStoryPointsPlannedRowCellG = initialStoryPointsPlannedRow.createCell(6);
        initialStoryPointsPlannedRowCellG.setCellValue(piStatus.getPiSprints()[4].getStoryPointsPlanned());
        Cell initialStoryPointsPlannedRowCellH = initialStoryPointsPlannedRow.createCell(7);
        initialStoryPointsPlannedRowCellH.setCellValue(piStatus.getPiSprints()[5].getStoryPointsPlanned());

        rowStartPoint += 1;

        Row storyPointsOpenRow = sheet.createRow(rowStartPoint);
        Cell storyPointsOpenRowCellA = storyPointsOpenRow.createCell(0);
        storyPointsOpenRowCellA.setCellValue("Story Points Open");
        Cell storyPointsOpenRowCellC = storyPointsOpenRow.createCell(2);
        storyPointsOpenRowCellC.setCellValue(piStatus.getPiSprints()[0].getStoryPointsOpen());
        Cell storyPointsOpenRowCellD = storyPointsOpenRow.createCell(3);
        storyPointsOpenRowCellD.setCellValue(piStatus.getPiSprints()[1].getStoryPointsOpen());
        Cell storyPointsOpenRowCellE = storyPointsOpenRow.createCell(4);
        storyPointsOpenRowCellE.setCellValue(piStatus.getPiSprints()[2].getStoryPointsOpen());
        Cell storyPointsOpenRowCellF = storyPointsOpenRow.createCell(5);
        storyPointsOpenRowCellF.setCellValue(piStatus.getPiSprints()[3].getStoryPointsOpen());
        Cell storyPointsOpenRowCellG = storyPointsOpenRow.createCell(6);
        storyPointsOpenRowCellG.setCellValue(piStatus.getPiSprints()[4].getStoryPointsOpen());
        Cell storyPointsOpenRowCellH = storyPointsOpenRow.createCell(7);
        storyPointsOpenRowCellH.setCellValue(piStatus.getPiSprints()[5].getStoryPointsOpen());

        rowStartPoint += 1;

        Row storyPointsClosedRow = sheet.createRow(rowStartPoint);
        Cell storyPointsClosedRowCellA = storyPointsClosedRow.createCell(0);
        storyPointsClosedRowCellA.setCellValue("Story Points Closed ");
        Cell storyPointsClosedRowCellC = storyPointsClosedRow.createCell(2);
        storyPointsClosedRowCellC.setCellValue(piStatus.getPiSprints()[0].getStoryPointsClosed());
        Cell storyPointsClosedRowCellD = storyPointsClosedRow.createCell(3);
        storyPointsClosedRowCellD.setCellValue(piStatus.getPiSprints()[1].getStoryPointsClosed());
        Cell storyPointsClosedRowCellE = storyPointsClosedRow.createCell(4);
        storyPointsClosedRowCellE.setCellValue(piStatus.getPiSprints()[2].getStoryPointsClosed());
        Cell storyPointsClosedRowCellF = storyPointsClosedRow.createCell(5);
        storyPointsClosedRowCellF.setCellValue(piStatus.getPiSprints()[3].getStoryPointsClosed());
        Cell storyPointsClosedRowCellG = storyPointsClosedRow.createCell(6);
        storyPointsClosedRowCellG.setCellValue(piStatus.getPiSprints()[4].getStoryPointsClosed());
        Cell storyPointsClosedRowCellH = storyPointsClosedRow.createCell(7);
        storyPointsClosedRowCellH.setCellValue(piStatus.getPiSprints()[5].getStoryPointsClosed());

        rowStartPoint += 3;
        objectivesBordersRowStartPoint = rowStartPoint;

        Row totalObjectivesRow = sheet.createRow(rowStartPoint);
        Cell totalObjectivesRowCellA = totalObjectivesRow.createCell(0);
        totalObjectivesRowCellA.setCellValue("Total Objectives");
        Cell totalObjectivesRowCellC = totalObjectivesRow.createCell(2);
        totalObjectivesRowCellC.setCellValue(piStatus.getPiSprints()[0].getTotalObjectives());
        Cell totalObjectivesRowCellD = totalObjectivesRow.createCell(3);
        totalObjectivesRowCellD.setCellValue(piStatus.getPiSprints()[1].getTotalObjectives());
        Cell totalObjectivesRowCellE = totalObjectivesRow.createCell(4);
        totalObjectivesRowCellE.setCellValue(piStatus.getPiSprints()[2].getTotalObjectives());
        Cell totalObjectivesRowCellF = totalObjectivesRow.createCell(5);
        totalObjectivesRowCellF.setCellValue(piStatus.getPiSprints()[3].getTotalObjectives());
        Cell totalObjectivesRowCellG = totalObjectivesRow.createCell(6);
        totalObjectivesRowCellG.setCellValue(piStatus.getPiSprints()[4].getTotalObjectives());
        Cell totalObjectivesRowCellH = totalObjectivesRow.createCell(7);
        totalObjectivesRowCellH.setCellValue(piStatus.getPiSprints()[5].getTotalObjectives());

        rowStartPoint += 1;

        Row initialTotalObjectivesRow = sheet.createRow(rowStartPoint);
        Cell initialTotalObjectivesRowCellA = initialTotalObjectivesRow.createCell(0);
        initialTotalObjectivesRowCellA.setCellValue("Initial Total Objectives");
        Cell initialTotalObjectivesRowCellC = initialTotalObjectivesRow.createCell(2);
        initialTotalObjectivesRowCellC.setCellValue(piStatus.getPiSprints()[0].getInitialTotalObjectives());
        Cell initialTotalObjectivesRowCellD = initialTotalObjectivesRow.createCell(3);
        initialTotalObjectivesRowCellD.setCellValue(piStatus.getPiSprints()[1].getInitialTotalObjectives());
        Cell initialTotalObjectivesRowCellE = initialTotalObjectivesRow.createCell(4);
        initialTotalObjectivesRowCellE.setCellValue(piStatus.getPiSprints()[2].getInitialTotalObjectives());
        Cell initialTotalObjectivesRowCellF = initialTotalObjectivesRow.createCell(5);
        initialTotalObjectivesRowCellF.setCellValue(piStatus.getPiSprints()[3].getInitialTotalObjectives());
        Cell initialTotalObjectivesRowCellG = initialTotalObjectivesRow.createCell(6);
        initialTotalObjectivesRowCellG.setCellValue(piStatus.getPiSprints()[4].getInitialTotalObjectives());
        Cell initialTotalObjectivesRowCellH = initialTotalObjectivesRow.createCell(7);
        initialTotalObjectivesRowCellH.setCellValue(piStatus.getPiSprints()[5].getInitialTotalObjectives());

        rowStartPoint += 1;

        Row plannedObjectivesRow = sheet.createRow(rowStartPoint);
        Cell plannedObjectivesRowCellA = plannedObjectivesRow.createCell(0);
        plannedObjectivesRowCellA.setCellValue("Initial Planned Objectives");
        Cell plannedObjectivesRowCellC = plannedObjectivesRow.createCell(2);
        plannedObjectivesRowCellC.setCellValue(piStatus.getPiSprints()[0].getInitialPlannedObjectives());
        Cell plannedObjectivesRowCellD = plannedObjectivesRow.createCell(3);
        plannedObjectivesRowCellD.setCellValue(piStatus.getPiSprints()[1].getInitialPlannedObjectives());
        Cell plannedObjectivesRowCellE = plannedObjectivesRow.createCell(4);
        plannedObjectivesRowCellE.setCellValue(piStatus.getPiSprints()[2].getInitialPlannedObjectives());
        Cell plannedObjectivesRowCellF = plannedObjectivesRow.createCell(5);
        plannedObjectivesRowCellF.setCellValue(piStatus.getPiSprints()[3].getInitialPlannedObjectives());
        Cell plannedObjectivesRowCellG = plannedObjectivesRow.createCell(6);
        plannedObjectivesRowCellG.setCellValue(piStatus.getPiSprints()[4].getInitialPlannedObjectives());
        Cell plannedObjectivesRowCellH = plannedObjectivesRow.createCell(7);
        plannedObjectivesRowCellH.setCellValue(piStatus.getPiSprints()[5].getInitialPlannedObjectives());

        rowStartPoint += 1;

        Row actualCompleteObjectivesRow = sheet.createRow(rowStartPoint);
        Cell actualCompleteObjectivesRowCellA = actualCompleteObjectivesRow.createCell(0);
        actualCompleteObjectivesRowCellA.setCellValue("Actual Completed Objectives");
        Cell actualCompleteObjectivesRowCellC = actualCompleteObjectivesRow.createCell(2);
        actualCompleteObjectivesRowCellC.setCellValue(piStatus.getPiSprints()[0].getActualCompletedObjectives());
        Cell actualCompleteObjectivesRowCellD = actualCompleteObjectivesRow.createCell(3);
        actualCompleteObjectivesRowCellD.setCellValue(piStatus.getPiSprints()[1].getActualCompletedObjectives());
        Cell actualCompleteObjectivesRowCellE = actualCompleteObjectivesRow.createCell(4);
        actualCompleteObjectivesRowCellE.setCellValue(piStatus.getPiSprints()[2].getActualCompletedObjectives());
        Cell actualCompleteObjectivesRowCellF = actualCompleteObjectivesRow.createCell(5);
        actualCompleteObjectivesRowCellF.setCellValue(piStatus.getPiSprints()[3].getActualCompletedObjectives());
        Cell actualCompleteObjectivesRowCellG = actualCompleteObjectivesRow.createCell(6);
        actualCompleteObjectivesRowCellG.setCellValue(piStatus.getPiSprints()[4].getActualCompletedObjectives());
        Cell actualCompleteObjectivesRowCellH = actualCompleteObjectivesRow.createCell(7);
        actualCompleteObjectivesRowCellH.setCellValue(piStatus.getPiSprints()[5].getActualCompletedObjectives());

        PropertyTemplate pt = new PropertyTemplate();
        // these cells will have medium outside borders
        pt.drawBorders(new CellRangeAddress(projectBordersRowStartPoint, projectBordersRowStartPoint + 1,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        pt.drawBorders(new CellRangeAddress(sprintBordersRowStartPoint, sprintBordersRowStartPoint + 1,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        pt.drawBorders(new CellRangeAddress(storiesBordersRowStartPoint, storiesBordersRowStartPoint,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        pt.drawBorders(new CellRangeAddress(storiesBordersRowStartPoint + 1, storiesBordersRowStartPoint + 18,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        // apply borders to sheet
        pt.applyBorders(sheet);

        // Auto size the column widths
        for (int columnIndex = 0; columnIndex < 10; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }

        new PiTeamDataToExcel(workbook, piStatus1);

        new PiTeamDataToExcel(workbook, piStatus2);

        new PiTeamDataToExcel(workbook, piStatus3);

        new PiTeamDataToExcel(workbook, piStatus4);

        try {
            File file;
            FileOutputStream fos = null;

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();

            String fileName = "Program";

            if (currentReleaseId > 0) {
                fileName += "_" + allReleases.get(currentReleaseId).getName() + "_ART_Status_"
                        + dtf.format(localDate);
            } else {
                fileName += "_ART_Status_" + dtf.format(localDate);
            }

            file = new File(System.getProperty("user.home") + "/" + fileName + ".xlsx");
            fos = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            workbook.write(fos);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
