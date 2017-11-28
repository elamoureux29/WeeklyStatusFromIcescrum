package com.app.java.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by elamoureux on 1/11/2017.
 */
public class ResponseWriter {
    public static void SaveToFile(StringBuffer response, String fileName) throws IOException {
        File file;
        FileOutputStream fos = null;

        try {
            file = new File(System.getProperty("user.home") + "/" + fileName + ".json");
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
