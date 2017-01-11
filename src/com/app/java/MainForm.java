package com.app.java;

import com.app.java.util.Release;

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
                Release http = new Release();
                System.out.println("Testing 1 - Send Http GET request");
                try {
                    http.sendGet();
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
