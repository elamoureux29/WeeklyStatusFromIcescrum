package com.app.java.model;

import com.app.java.model.enums.Projects;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

import static com.app.java.MainForm.*;

/**
 * Created by erik on 1/31/2017.
 */
public class StatusTableModel {
    public static DefaultTableModel buildTableModel() {
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = 10;
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add("Patate" + column);
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        Vector<Object> vector1 = new Vector<Object>();
        vector1.add("Weekly Projects Status");
        data.add(vector1);

        Vector<Object> vector2 = new Vector<Object>();
        vector2.add("");
        data.add(vector2);

        Vector<Object> vector3 = new Vector<Object>();
        for (Projects p : Projects.values()) {
            if (currentProjectId.equalsIgnoreCase(p.getIdentifier())) {
                vector3.add(p.getPrjName());
            }
        }
        data.add(vector3);

        Vector<Object> vector4 = new Vector<Object>();
        vector4.add("");
        data.add(vector4);

        if (currentReleaseId > 0) {
            Vector<Object> vector5 = new Vector<Object>();
            vector5.add(allReleases.get(currentReleaseId).getName());
            vector5.add("");
            vector5.add("");
            vector5.add("");
            vector5.add("");
            vector5.add("");
            vector5.add("");
            vector5.add("");
            vector5.add(allReleases.get(currentReleaseId).getEndDate());
            data.add(vector5);
        }

        Vector<Object> vector6 = new Vector<Object>();
        vector6.add("");
        data.add(vector6);

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
