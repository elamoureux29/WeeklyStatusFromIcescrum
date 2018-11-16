package com.app.java.util.excel;

import com.app.java.model.SafeStatus.PiStatus;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;
import java.util.Map;

public class PiTeamDataToExcel {
    public PiTeamDataToExcel(XSSFWorkbook workbook, PiStatus piStatus) {
        XSSFSheet sheet = workbook.createSheet(piStatus.getName());

        int rowStartPoint = 0;
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
    }
}
