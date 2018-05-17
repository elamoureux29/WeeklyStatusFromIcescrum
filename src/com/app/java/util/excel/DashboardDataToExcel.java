package com.app.java.util.excel;

import com.app.java.model.json.Feature;
import com.app.java.util.BacklogData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;
import java.util.Map;

import static com.app.java.MainForm.*;

public class DashboardDataToExcel {
    public DashboardDataToExcel(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("DashboardData");
        int rowStartPoint = 0;

        Map<String, Object> cellStyleValues = new HashMap<>();
        cellStyleValues.put(CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);
        cellStyleValues.put(CellUtil.FILL_BACKGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.AUTOMATIC.getIndex());
        cellStyleValues.put(CellUtil.FILL_PATTERN, FillPatternType.NO_FILL);

        Row titleRow = sheet.createRow(rowStartPoint);
        Cell titleRowCellA = titleRow.createCell(0);
        titleRowCellA.setCellValue("Dashboard Data");
        CellUtil.setCellStyleProperties(titleRowCellA, cellStyleValues);
//        CellUtil.setAlignment(titleRowCellA, HorizontalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, 0, 3));

        rowStartPoint += 2;

        Row numSprintRow = sheet.createRow(rowStartPoint);
        Cell numSprintRowCellA = numSprintRow.createCell(0);
        numSprintRowCellA.setCellValue("Sprint " + allSprintInCurrentRelease.get(currentSprintId).getOrderNumber()
                + "/" + allReleases.get(currentReleaseId).getSprints_count() + " is in progress.");

        rowStartPoint += 1;

        BacklogData backlogData = new BacklogData();
        int backlogEstimated;
        float backlogPercentage;
        backlogEstimated = backlogData.getEstimated() + backlogData.getPlanned() + backlogData.getInProgress()
                + backlogData.getDone();
        backlogPercentage = (backlogEstimated * 100 / backlogData.getAll());

        Row backlogRow = sheet.createRow(rowStartPoint);
        Cell backlogRowCellA = backlogRow.createCell(0);
        if (backlogEstimated < backlogData.getAll()) {
            backlogRowCellA.setCellValue("Backlog grooming is in progress (" + backlogPercentage + "% complete, "
                    + backlogEstimated + "/" + backlogData.getAll() + " Stories Estimated)");
        } else {
            backlogRowCellA.setCellValue("Backlog grooming is complete (" + backlogData.getAll() + " Stories Total)");
        }

        rowStartPoint += 2;

        for (Feature feature : features) {
            float featurePercentage = 0.0f;
            if (feature.getStories_ids().length > 0) {
                featurePercentage = (feature.getCountDoneStories() * 100 / feature.getStories_ids().length);
            }

            Row row = sheet.createRow(rowStartPoint);
            Cell rowCellA = row.createCell(0);
            rowCellA.setCellValue(feature.getName() + " (" + featurePercentage + "% complete, "
                    + feature.getCountDoneStories() + "/" + feature.getStories_ids().length + " Stories)");
            rowStartPoint++;
        }
    }
}
