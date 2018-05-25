package com.app.java.util.excel;

import com.app.java.model.json.Story;
import org.apache.poi.ss.usermodel.BorderExtent;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.Map;

public class FeatureWeeksDataToExcel {
    public FeatureWeeksDataToExcel(String weekLabel, Map<Integer, Story> doneStoriesWeek, XSSFSheet sheet, int rowStartPoint, int firstCol, int lastCol, int storiesBordersRowStartPoint) {
        for (Map.Entry<Integer, Story> me : doneStoriesWeek.entrySet()) {
            Row storyRow = sheet.createRow(rowStartPoint);
            Cell storyRowCellA = storyRow.createCell(0);
            storyRowCellA.setCellValue(me.getValue().getName());
            sheet.addMergedRegion(new CellRangeAddress(rowStartPoint, rowStartPoint, firstCol, 6));
            Cell storyRowCellH = storyRow.createCell(7);
            storyRowCellH.setCellValue("Points:");
            Cell storyRowCellI = storyRow.createCell(8);
            storyRowCellI.setCellValue(me.getValue().getEffort());

            PropertyTemplate pt = new PropertyTemplate();
            // these cells will have medium outside borders and thin inside borders
            pt.drawBorders(new CellRangeAddress(
                    storiesBordersRowStartPoint, rowStartPoint,
                    firstCol, lastCol), BorderStyle.MEDIUM, BorderExtent.OUTSIDE);
            pt.drawBorders(new CellRangeAddress(
                    storiesBordersRowStartPoint, rowStartPoint,
                    firstCol, lastCol), BorderStyle.THIN, BorderExtent.INSIDE);

            // apply borders to sheet
            pt.applyBorders(sheet);

            rowStartPoint += 1;
        }


    }
}
