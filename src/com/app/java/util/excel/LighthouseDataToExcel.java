package com.app.java.util.excel;

import com.app.java.model.json.Sprint;
import com.app.java.util.DateFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static com.app.java.MainForm.*;

public class LighthouseDataToExcel {
    public LighthouseDataToExcel(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("LighthouseData");
        int rowStartPoint = 0;

        Map<String, Object> cellStyleValues = new HashMap<>();
        cellStyleValues.put(CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);
        cellStyleValues.put(CellUtil.FILL_BACKGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_PATTERN, FillPatternType.NO_FILL);

        Row titleRow = sheet.createRow(rowStartPoint);
        Cell titleRowCellA = titleRow.createCell(0);
        titleRowCellA.setCellValue("Lighthouse Data");
        CellUtil.setCellStyleProperties(titleRowCellA, cellStyleValues);
//        CellUtil.setAlignment(titleRowCellA, HorizontalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 3));

        rowStartPoint += 2;

        Row numSprintRow = sheet.createRow(rowStartPoint);
        Cell numSprintRowCellA = numSprintRow.createCell(0);
        numSprintRowCellA.setCellValue("Number of Sprints");
        Cell numSprintRowCellB = numSprintRow.createCell(1);
        numSprintRowCellB.setCellValue(allReleases.get(currentReleaseId).getSprints_count());

        rowStartPoint += 1;

        Row firstSprintStartDateRow = sheet.createRow(rowStartPoint);
        Cell firstSprintStartDateRowCellA = firstSprintStartDateRow.createCell(0);
        firstSprintStartDateRowCellA.setCellValue("First Sprint Start Date");
        Cell firstSprintStartDateRowCellB = firstSprintStartDateRow.createCell(1);
        firstSprintStartDateRowCellB.setCellValue(DateFormat.ExcelDateFormat(
                allSprintInCurrentRelease.get(firstSprintId).getStartDate()));
        firstSprintStartDateRowCellB.setCellStyle(DateFormat.ExcelDateCellStyle(workbook));

        rowStartPoint += 1;

        Row firstSprintEndDateRow = sheet.createRow(rowStartPoint);
        Cell firstSprintEndDateRowCellA = firstSprintEndDateRow.createCell(0);
        firstSprintEndDateRowCellA.setCellValue("First Sprint End Date");
        Cell firstSprintEndDateRowCellB = firstSprintEndDateRow.createCell(1);
        firstSprintEndDateRowCellB.setCellValue(DateFormat.ExcelDateFormat(
                allSprintInCurrentRelease.get(firstSprintId).getEndDate()));
        firstSprintEndDateRowCellB.setCellStyle(DateFormat.ExcelDateCellStyle(workbook));

        rowStartPoint += 2;

        Row dataTitleRow1 = sheet.createRow(rowStartPoint);
        Cell dataTitleRow1CellB = dataTitleRow1.createCell(1);
        dataTitleRow1CellB.setCellValue("At START of Sprint");
        Cell dataTitleRow1CellC = dataTitleRow1.createCell(2);
        dataTitleRow1CellC.setCellValue("At END of Sprint");

        rowStartPoint += 1;

        Row dataTitleRow2 = sheet.createRow(rowStartPoint);
        Cell dataTitleRow2CellB = dataTitleRow2.createCell(1);
        dataTitleRow2CellB.setCellValue("Story Points in Product Backlog");
        Cell dataTitleRow2CellC = dataTitleRow2.createCell(2);
        dataTitleRow2CellC.setCellValue("Story Points Done in Sprint");

        rowStartPoint += 1;

//        Need to use HashMapSort
//        Need to change XmlSprint to Sprint in HashMapSort
        Set set = allSprintInCurrentRelease.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Sprint> mentry = (Map.Entry) iterator.next();
            Row row = sheet.createRow(rowStartPoint);
            Cell rowCellA = row.createCell(0);
            rowCellA.setCellValue("Sprint " + mentry.getValue().getOrderNumber());
            Cell rowCellB = row.createCell(1);
            //Do not know how to get this data yet
            rowCellB.setCellValue(mentry.getValue().getTotalRemaining());
            Cell rowCellC = row.createCell(2);
            rowCellC.setCellValue(mentry.getValue().getVelocity());
            rowStartPoint++;
        }
    }
}
