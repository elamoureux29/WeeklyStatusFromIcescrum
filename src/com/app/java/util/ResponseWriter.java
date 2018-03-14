package com.app.java.util;

import com.app.java.MainForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by elamoureux on 1/11/2017.
 */
public class ResponseWriter {
    public static void SaveToFile(StringBuffer response, String fileName) throws IOException {
        File file;
        FileOutputStream fos = null;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();

        String fullFileName = fileName + "_" + MainForm.currentProjectName + "_" + dtf.format(localDate);

        try {
            file = new File(System.getProperty("user.home") + "/" + fullFileName + ".json");
            fos = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            fos.write(response.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fos.flush();
            fos.close();

            System.out.println("Done");
        }
    }

    public static void SaveToXmlFile(StringBuffer response, String fileName) throws IOException {
        File file;
        FileOutputStream fos = null;

        try {
            file = new File(System.getProperty("user.home") + "/" + fileName + ".xml");
            fos = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            fos.write(response.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fos.flush();
            fos.close();

            System.out.println("Done");
        }
    }

    public static void DisplayInConsole(StringBuffer response) {
        System.out.println(response.toString());

    }
}
