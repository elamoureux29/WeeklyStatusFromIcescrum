package com.app.java.util;

import com.app.java.model.Story;
import com.app.java.model.enums.Projects;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.app.java.MainForm.*;

/**
 * Created by elamoureux on 2/14/2017.
 */
public class ExcelUtil {
    public static void ExportToFile() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Status");

        Row titleRow = sheet.createRow(0);
        Cell a1 = titleRow.createCell(0);
        a1.setCellValue("Weekly Projects Status");
        CellUtil.setAlignment(a1, HorizontalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));

        Row projectRow = sheet.createRow(2);
        Cell a3 = projectRow.createCell(0);
        for (Projects p : Projects.values()) {
            if (currentProjectId.equalsIgnoreCase(p.getIdentifier())) {
                a3.setCellValue(p.getPrjName());
            }
        }
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 8));

        Row releaseRow = sheet.createRow(4);
        Cell a5 = releaseRow.createCell(0);
        a5.setCellValue(allReleases.get(currentReleaseId).getName());
        Cell i5 = releaseRow.createCell(8);
        try {
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S zzz");
            Date date = parser.parse(allReleases.get(currentReleaseId).getEndDate());
            SimpleDateFormat formater = new SimpleDateFormat("M/d/yyyy");

            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("d-mmm-yy"));
            i5.setCellValue(formater.parse(formater.format(date)));
            i5.setCellStyle(cellStyle);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        Row sprintRow = sheet.createRow(6);
        Cell a7 = sprintRow.createCell(0);
        a7.setCellValue("Current Sprint:");
        Cell c7 = sprintRow.createCell(2);
        c7.setCellValue("Current #");
        Cell d7 = sprintRow.createCell(3);
        d7.setCellValue("/");
        CellUtil.setAlignment(d7, HorizontalAlignment.CENTER);
        Cell e7 = sprintRow.createCell(4);
        e7.setCellValue("Total #");
        Cell i7 = sprintRow.createCell(8);
        try {
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S zzz");
            Date date = parser.parse(allSprintInCurrentRelease.get(currentSprintId).getEndDate());
            SimpleDateFormat formater = new SimpleDateFormat("M/d/yyyy");

            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("d-mmm-yy"));
            i7.setCellValue(formater.parse(formater.format(date)));
            i7.setCellStyle(cellStyle);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        Row sprintValueRow = sheet.createRow(7);
        Cell c8 = sprintValueRow.createCell(2);
        c8.setCellValue(allSprintInCurrentRelease.get(currentSprintId).getOrderNumber());
        CellUtil.setAlignment(c8, HorizontalAlignment.CENTER);
        Cell d8 = sprintValueRow.createCell(3);
        d8.setCellValue("/");
        CellUtil.setAlignment(d8, HorizontalAlignment.CENTER);
        Cell e8 = sprintValueRow.createCell(4);
        e8.setCellValue(allSprintInCurrentRelease.size());
        CellUtil.setAlignment(e8, HorizontalAlignment.CENTER);

        Row sprintDetailsRow = sheet.createRow(8);
        Cell a9 = sprintDetailsRow.createCell(0);
        a9.setCellValue("Capacity");
        Cell c9 = sprintDetailsRow.createCell(2);
        c9.setCellValue("# Completed Stories");
        Cell d9 = sprintDetailsRow.createCell(3);
        d9.setCellValue("/");
        CellUtil.setAlignment(d9, HorizontalAlignment.CENTER);
        Cell e9 = sprintDetailsRow.createCell(4);
        e9.setCellValue("# Total Stories");

        Set set = allStoriesInCurrentSprint.entrySet();
        int rowStartPoint = 11;
        int numCompletedStories = 0;
        float completedPoints = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Story> mentry = (Map.Entry) iterator.next();

            int tasksToDo = 0;
            int tasksInProgress = 0;
            int tasksDone = 0;
            String tasksTeam = "";
            HashMap<Integer, String> teamHashMap = new HashMap<>();

            if (mentry.getValue().getState().equalsIgnoreCase(StoryStates.DONE.getIdentifier())) {
                numCompletedStories++;
                completedPoints += Float.parseFloat(mentry.getValue().getEffort());
            } else {
                Row storyRow = sheet.createRow(rowStartPoint);
                Cell storyRowCellA = storyRow.createCell(0);
                storyRowCellA.setCellValue(mentry.getValue().getName());
                sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 8));

                Row storyRow1 = sheet.createRow(rowStartPoint + 1);
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

                for (int key : mentry.getValue().getTasksId()) {
                    if (allTasksInCurrentSprint.get(key).getState().equalsIgnoreCase(TaskStates.TODO.getIdentifier())) {
                        tasksToDo++;
                    } else if (allTasksInCurrentSprint.get(key).getState().equalsIgnoreCase(TaskStates.IN_PROGRESS.getIdentifier())) {
                        tasksInProgress++;
                    } else if (allTasksInCurrentSprint.get(key).getState().equalsIgnoreCase(TaskStates.DONE.getIdentifier())) {
                        tasksDone++;
                    }
                    for (Users u : Users.values()) {
                        if (allTasksInCurrentSprint.get(key).getResponsibleId() == u.getIdentifier()) {
                            teamHashMap.put(allTasksInCurrentSprint.get(key).getResponsibleId(), u.getUserName());
                        }
                    }
                }

                Row storyRow2 = sheet.createRow(rowStartPoint + 2);
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

                Row storyRow3 = sheet.createRow(rowStartPoint + 3);
                Cell storyRow3CellA = storyRow3.createCell(0);
                storyRow3CellA.setCellValue("");
                CellUtil.setVerticalAlignment(storyRow3CellA, VerticalAlignment.CENTER);
                Cell storyRow3CellH = storyRow3.createCell(7);

                Set teamSet = teamHashMap.entrySet();
                Iterator teamIterator = teamSet.iterator();
                while (teamIterator.hasNext()) {
                    Map.Entry<Integer, String> teamMentry = (Map.Entry) iterator.next();
                    tasksTeam += teamMentry.getValue() + "\n";
                }

                storyRow3CellH.setCellValue(tasksTeam);

                CellUtil.setVerticalAlignment(storyRow3CellH, VerticalAlignment.CENTER);
                CellUtil.setCellStyleProperty(storyRow3CellH, CellUtil.WRAP_TEXT, true);
                Cell storyRow3CellI = storyRow3.createCell(8);
                try {
                    SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S zzz");
                    Date date = parser.parse(mentry.getValue().getLastUpdated());
                    SimpleDateFormat formater = new SimpleDateFormat("M/d/yyyy");

                    CellStyle cellStyle = workbook.createCellStyle();
                    CreationHelper createHelper = workbook.getCreationHelper();
                    cellStyle.setDataFormat(
                            createHelper.createDataFormat().getFormat("d-mmm-yy"));
                    storyRow3CellI.setCellValue(formater.parse(formater.format(date)));
                    storyRow3CellI.setCellStyle(cellStyle);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

                Row storyRow4 = sheet.createRow(rowStartPoint + 5);
                Cell storyRow4CellI = storyRow4.createCell(8);
                try {
                    SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S zzz");
                    Date date = parser.parse(mentry.getValue().getLastUpdated());
                    SimpleDateFormat formater = new SimpleDateFormat("M/d/yyyy");

                    CellStyle cellStyle = workbook.createCellStyle();
                    CreationHelper createHelper = workbook.getCreationHelper();
                    cellStyle.setDataFormat(
                            createHelper.createDataFormat().getFormat("d-mmm-yy"));
                    storyRow4CellI.setCellValue(formater.parse(formater.format(date)));
                    storyRow4CellI.setCellStyle(cellStyle);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

                sheet.addMergedRegion(new CellRangeAddress(rowStartPoint + 3, rowStartPoint + 3, 0, 6));
//                        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint + 3,rowStartPoint + 5,0,6));
//                        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint + 3,rowStartPoint + 5,7,7));

                PropertyTemplate pt = new PropertyTemplate();
                // #1) these borders will all be medium in default color
                pt.drawBorders(new CellRangeAddress(1, 3, 1, 3),
                        BorderStyle.MEDIUM, BorderExtent.ALL);
                // #2) these cells will have medium outside borders and thin inside borders
                pt.drawBorders(new CellRangeAddress(5, 7, 1, 3),
                        BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
                pt.drawBorders(new CellRangeAddress(5, 7, 1, 3), BorderStyle.THIN,
                        BorderExtent.INSIDE);

                // apply borders to sheet
                pt.applyBorders(sheet);

                rowStartPoint += 7;
            }
        }

        Row sprintDetailsValueRow = sheet.createRow(9);
        Cell a10 = sprintDetailsValueRow.createCell(0);
        a10.setCellValue(Math.round(completedPoints) + "/" + Math.round(Float.parseFloat(allSprintInCurrentRelease.get(currentSprintId).getCapacity())));
        Cell c10 = sprintDetailsValueRow.createCell(2);
        c10.setCellValue(numCompletedStories);
        CellUtil.setAlignment(c10, HorizontalAlignment.CENTER);
        Cell d10 = sprintDetailsValueRow.createCell(3);
        d10.setCellValue("/");
        CellUtil.setAlignment(d10, HorizontalAlignment.CENTER);
        Cell e10 = sprintDetailsValueRow.createCell(4);
        e10.setCellValue(allStoriesInCurrentSprint.size());
        CellUtil.setAlignment(e10, HorizontalAlignment.CENTER);

        // Auto size the column widths
        for (int columnIndex = 0; columnIndex < 10; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
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
