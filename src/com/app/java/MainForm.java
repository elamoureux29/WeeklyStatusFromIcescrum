package com.app.java;

import com.app.java.model.IcescrumActorAPI;
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
//                IcescrumReleaseAPI release = new IcescrumReleaseAPI();
//                IcescrumSprintAPI sprint = new IcescrumSprintAPI();
//                IcescrumStoryAPI story = new IcescrumStoryAPI();
//                IcescrumTaskAPI task = new IcescrumTaskAPI();
//                IcescrumFeatureAPI feature = new IcescrumFeatureAPI();
                IcescrumActorAPI actor = new IcescrumActorAPI();

                try {
//                    XmlResponse.DisplayInConsole(release.getAll());
//                    XmlResponse.SaveToFile(release.getAll(), release.getFileName());
//                    XmlResponse.DisplayInConsole(release.getItem(76926));
//                    XmlResponse.SaveToFile(release.getItem(76926), release.getFileName());
//                    XmlResponse.DisplayInConsole(sprint.getAll());
//                    XmlResponse.SaveToFile(sprint.getAll(), sprint.getFileName());
//                    XmlResponse.DisplayInConsole(sprint.getAllInRelease(76926));
//                    XmlResponse.SaveToFile(sprint.getAllInRelease(76926), sprint.getFileName());
//                    XmlResponse.DisplayInConsole(sprint.getItem(77848));
//                    XmlResponse.SaveToFile(sprint.getItem(77848), sprint.getFileName());
//                    XmlResponse.DisplayInConsole(story.getAll());
//                    XmlResponse.SaveToFile(story.getAll(), story.getFileName());
//                    XmlResponse.DisplayInConsole(story.getItem(185155));
//                    XmlResponse.SaveToFile(story.getItem(185155), story.getFileName());
//                    XmlResponse.DisplayInConsole(task.getAll());
//                    XmlResponse.SaveToFile(task.getAll(), task.getFileName());
//                    XmlResponse.DisplayInConsole(task.getAllFiltered(TaskFilters.CURRENT_USER.getIdentifier()));
//                    XmlResponse.SaveToFile(task.getAllFiltered(TaskFilters.CURRENT_USER.getIdentifier()), task.getFileName());
//                    XmlResponse.DisplayInConsole(task.getAllInSprint(77848));
//                    XmlResponse.SaveToFile(task.getAllInSprint(77848), task.getFileName());
//                    XmlResponse.DisplayInConsole(task.getAllFilteredInSprint(77848, TaskFilters.CURRENT_USER.getIdentifier()));
//                    XmlResponse.SaveToFile(task.getAllFilteredInSprint(77848, TaskFilters.CURRENT_USER.getIdentifier()), task.getFileName());
//                    XmlResponse.DisplayInConsole(task.getItem(171074));
//                    XmlResponse.SaveToFile(task.getItem(171074), task.getFileName());
//                    XmlResponse.DisplayInConsole(feature.getAll());
//                    XmlResponse.SaveToFile(feature.getAll(), feature.getFileName());
//                    XmlResponse.DisplayInConsole(feature.getItem(14714));
//                    XmlResponse.SaveToFile(feature.getItem(14714), feature.getFileName());
//                    XmlResponse.DisplayInConsole(actor.getAll());
//                    XmlResponse.SaveToFile(actor.getAll(), actor.getFileName());
//                    XmlResponse.DisplayInConsole(actor.getItem(2264));
                    XmlResponse.SaveToFile(actor.getItem(2264), actor.getFileName());
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
