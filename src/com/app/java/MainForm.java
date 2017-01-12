package com.app.java;

import com.app.java.model.ISReleaseAPI;
import com.app.java.model.ISRestApi;
import com.app.java.util.XmlResponse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by elamoureux on 1/6/2017.
 */
public class MainForm {
    private JButton button1;
    private JLabel label1;
    private JPanel panel1;

    public MainForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ISRestApi release = new ISReleaseAPI();

                try {
//                    XmlResponse.DisplayInConsole(release.getAll());
                    XmlResponse.SaveToFile(release.getAll(), release.getFileName());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

//    private class BtnClicked implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
