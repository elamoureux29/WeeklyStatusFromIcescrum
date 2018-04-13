package com.app.java.util.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;
import java.util.Map;

import static com.app.java.MainForm.stories;
import static com.app.java.MainForm.taktTimeData;

public class TaktDataToExcel {
    public TaktDataToExcel(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("TaktData");
        int rowStartPoint = 0;

        Map<String, Object> cellStyleValues = new HashMap<>();
        cellStyleValues.put(CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);
        cellStyleValues.put(CellUtil.FILL_BACKGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_PATTERN, FillPatternType.NO_FILL);

        Row titleRow = sheet.createRow(rowStartPoint);
        Cell titleRowCellA = titleRow.createCell(0);
        titleRowCellA.setCellValue("Takt Data");
        CellUtil.setCellStyleProperties(titleRowCellA, cellStyleValues);
//        CellUtil.setAlignment(titleRowCellA, HorizontalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 3));

        rowStartPoint += 2;
        int sprintNumber = 1;

        for (int i : taktTimeData) {
            Row row = sheet.createRow(rowStartPoint);
            Cell rowCellA = row.createCell(0);
            rowCellA.setCellValue("Sprint " + sprintNumber);
            Cell rowCellB = row.createCell(1);
            rowCellB.setCellValue(i);
            rowStartPoint++;
            sprintNumber++;
        }

        rowStartPoint += 2;

        Row workItemsRow = sheet.createRow(rowStartPoint);
        Cell workItemsRowCellA = workItemsRow.createCell(0);
        workItemsRowCellA.setCellValue("Work Items");
        Cell workItemsRowCellB = workItemsRow.createCell(1);
        workItemsRowCellB.setCellValue(stories.length);
    }
}
