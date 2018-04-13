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
        numSprintRowCellA.setCellValue(allReleases.get(currentReleaseId).getSprints_count());

        rowStartPoint += 1;

        Row firstSprintStartDateRow = sheet.createRow(rowStartPoint);
        Cell firstSprintStartDateRowCellA = firstSprintStartDateRow.createCell(0);
        firstSprintStartDateRowCellA.setCellValue(DateFormat.ExcelDateFormat(
                allSprintInCurrentRelease.get(firstSprintId).getStartDate()));
        firstSprintStartDateRowCellA.setCellStyle(DateFormat.ExcelDateCellStyle(workbook));

        rowStartPoint += 1;

        Row firstSprintEndDateRow = sheet.createRow(rowStartPoint);
        Cell firstSprintEndDateRowCellA = firstSprintEndDateRow.createCell(0);
        firstSprintEndDateRowCellA.setCellValue(DateFormat.ExcelDateFormat(
                allSprintInCurrentRelease.get(firstSprintId).getEndDate()));
        firstSprintEndDateRowCellA.setCellStyle(DateFormat.ExcelDateCellStyle(workbook));

        rowStartPoint += 2;

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
            rowCellB.setCellValue(mentry.getValue().getVelocity());
            rowStartPoint++;
        }
    }
}
