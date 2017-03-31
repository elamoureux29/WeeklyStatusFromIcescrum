package com.app.java.util;

import com.app.java.model.Story;
import com.app.java.model.TaskItem;
import com.app.java.model.enums.StoryStates;
import com.app.java.model.enums.TaskStates;
import com.app.java.model.enums.Users;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
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
        int bordersRowStartPoint1 = 0;
        int bordersRowStartPoint2 = 0;
        int bordersRowStartPoint3 = 0;
        int bordersRowStartPoint4 = 0;
        int bordersRowStartPoint5 = 0;
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
        bordersRowStartPoint1 = rowStartPoint;

        Row projectRow = sheet.createRow(rowStartPoint);
        Cell projectRowCellA = projectRow.createCell(0);
        projectRowCellA.setCellValue(currentProjectName);
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol - 1));
        Cell projectRowCellI = projectRow.createCell(8);
        projectRowCellI.setCellValue("End Date");

        rowStartPoint += 1;

        Row releaseRow = sheet.createRow(rowStartPoint);
        Cell releaseRowCellA = releaseRow.createCell(0);
        releaseRowCellA.setCellValue(allReleases.get(currentReleaseId).getName());
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, lastCol - 1));
        Cell releaseRowCellI = releaseRow.createCell(8);
        releaseRowCellI.setCellValue(DateFormat.ExcelDateFormat(allReleases.get(currentReleaseId).getEndDate()));
        releaseRowCellI.setCellStyle(DateFormat.ExcelDateCellStyle(workbook));

        rowStartPoint += 2;
        bordersRowStartPoint2 = rowStartPoint;

        Row sprintRow = sheet.createRow(rowStartPoint);
        Cell sprintRowCellA = sprintRow.createCell(0);
        sprintRowCellA.setCellValue("Current Sprint:");
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
        bordersRowStartPoint3 = rowStartPoint;

        Row urgentTasksRow = sheet.createRow(rowStartPoint);
        Cell urgentTasksRowCellA = urgentTasksRow.createCell(0);
        urgentTasksRowCellA.setCellValue("Urgent Tasks");

        rowStartPoint += 3;
        bordersRowStartPoint4 = rowStartPoint;

        Row recurrentTasksRow = sheet.createRow(rowStartPoint);
        Cell recurrentTasksRowCellA = recurrentTasksRow.createCell(0);
        recurrentTasksRowCellA.setCellValue("Recurrent Tasks");

        rowStartPoint += 3;
        bordersRowStartPoint5 = rowStartPoint;

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
            Date latestUpdate = DateFormat.DateParse(allReleases.get(currentReleaseId).getStartDate());
            HashMap<Integer, String> teamHashMap = new HashMap<>();

            if (mentry.getValue().getState().equalsIgnoreCase(StoryStates.DONE.getIdentifier())) {
                numCompletedStories++;
                completedPoints += Float.parseFloat(mentry.getValue().getEffort());
            } else {
                for (int key : mentry.getValue().getTasksId()) {
                    TaskItem taskItem = allTasksInCurrentSprint.get(key);

                    if (DateFormat.DateParse(taskItem.getLastUpdated()).compareTo(latestUpdate) > 0) {
                        latestUpdate = DateFormat.DateParse(taskItem.getLastUpdated());
                    }

                    if (taskItem.getState().equalsIgnoreCase(TaskStates.TODO.getIdentifier())) {
                        tasksToDo++;
                    } else if (taskItem.getState().equalsIgnoreCase(TaskStates.IN_PROGRESS.getIdentifier())) {
                        tasksInProgress++;
                    } else if (taskItem.getState().equalsIgnoreCase(TaskStates.DONE.getIdentifier())) {
                        tasksDone++;
                    }

                    for (Users u : Users.values()) {
                        if (taskItem.getResponsibleId() == u.getIdentifier()) {
                            teamHashMap.put(taskItem.getResponsibleId(), u.getUserName());
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
                storyRow2CellI.setCellValue(latestUpdate);
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
                pt.drawBorders(new CellRangeAddress(bordersRowStartPoint5, bordersRowStartPoint5 + 3,
                        firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
                pt.drawBorders(new CellRangeAddress(bordersRowStartPoint5, bordersRowStartPoint5 + 3,
                        firstCol, lastCol), BorderStyle.THIN, BorderExtent.INSIDE);

                // apply borders to sheet
                pt.applyBorders(sheet);

                rowStartPoint += 2;
                bordersRowStartPoint5 = rowStartPoint;
            }
        }

        Row sprintDetailsValueRow = sheet.createRow(8);
        Cell sprintDetailsValueRowCellA = sprintDetailsValueRow.createCell(0);
        sprintDetailsValueRowCellA.setCellValue(Math.round(completedPoints) + "/" +
                Math.round(Float.parseFloat(allSprintInCurrentRelease.get(currentSprintId).getCapacity())));
        Cell sprintDetailsValueRowCellC = sprintDetailsValueRow.createCell(2);
        sprintDetailsValueRowCellC.setCellValue(numCompletedStories);
        CellUtil.setAlignment(sprintDetailsValueRowCellC, HorizontalAlignment.CENTER);
        Cell sprintDetailsValueRowCellD = sprintDetailsValueRow.createCell(3);
        sprintDetailsValueRowCellD.setCellValue("/");
        CellUtil.setAlignment(sprintDetailsValueRowCellD, HorizontalAlignment.CENTER);
        Cell sprintDetailsValueRowCellE = sprintDetailsValueRow.createCell(4);
        sprintDetailsValueRowCellE.setCellValue(allStoriesInCurrentSprint.size());
        CellUtil.setAlignment(sprintDetailsValueRowCellE, HorizontalAlignment.CENTER);

        PropertyTemplate pt1 = new PropertyTemplate();
        // these cells will have medium outside borders
        pt1.drawBorders(new CellRangeAddress(bordersRowStartPoint1, bordersRowStartPoint1 + 1,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        pt1.drawBorders(new CellRangeAddress(bordersRowStartPoint2, bordersRowStartPoint2 + 3,
                firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
        // apply borders to sheet
        pt1.applyBorders(sheet);

        // Auto size the column widths
        for (int columnIndex = 0; columnIndex < 10; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }

        try {
            File file;
            FileOutputStream fos = null;

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();

            String fileName = currentProjectName + "_" + allReleases.get(currentReleaseId).getName() + "_WeeklyStatus_"
                    + dtf.format(localDate);

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
}
