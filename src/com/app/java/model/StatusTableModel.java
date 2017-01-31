package com.app.java.model;

import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by erik on 1/31/2017.
 */
public class StatusTableModel {
    public static DefaultTableModel buildTableModel(HashMap hashMap) {


        // names of columns
        Vector<String> columnNames = new Vector<String>();
//        int columnCount = metaData.getColumnCount();
//        for (int column = 1; column <= columnCount; column++) {
//            columnNames.add(metaData.getColumnName(column));
//        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
//        while (rs.next()) {
//            Vector<Object> vector = new Vector<Object>();
//            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
//                vector.add(rs.getObject(columnIndex));
//            }
//            data.add(vector);
//        }

        return new DefaultTableModel(data, columnNames);
    }
}
