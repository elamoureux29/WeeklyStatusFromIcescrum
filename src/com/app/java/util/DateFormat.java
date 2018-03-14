package com.app.java.util;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by elamoureux on 2/16/2017.
 */
public class DateFormat {
    public static Date DateParse(String dateString) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date date = null;

        try {
            date = parser.parse(dateString.replaceAll("Z$", "+0000"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String MediumDateFormat(String dateString) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = null;
        String returnDate = "";

        try {
            date = parser.parse(dateString.replaceAll("Z$", "+0000"));
            returnDate = formater.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return returnDate;
    }

    public static Date ExcelDateFormat(String dateString) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        SimpleDateFormat formater = new SimpleDateFormat("M/d/yyyy");
        Date date = null;
        Date returnDate = null;

        try {
            date = parser.parse(dateString.replaceAll("Z$", "+0000"));
            returnDate = formater.parse(formater.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return returnDate;
    }

    public static CellStyle ExcelDateCellStyle(XSSFWorkbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("d-mmm-yy"));

        return cellStyle;
    }

    public static CellStyle ExcelDateColorCellStyle(XSSFWorkbook workbook, Date latestUpdate, Boolean missingUpdate) {
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("d-mmm-yy"));

        if (missingUpdate) {
            Date d = new Date();
            long diff = d.getTime() - latestUpdate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);

            if (diffDays > 2) {
                cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            } else if (diffDays > 1) {
                cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }
        }

        return cellStyle;
    }
}
