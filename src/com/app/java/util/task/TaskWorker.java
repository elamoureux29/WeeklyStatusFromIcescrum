package com.app.java.util.task;

import javax.swing.*;
import java.awt.*;

/**
 * Created by elamoureux on 1/26/2017.
 */
public abstract class TaskWorker extends SwingWorker<Void, Void> {
    protected JProgressBar jProgressBar;
    protected JTabbedPane jTabbedPane;

    protected TaskWorker(JProgressBar jProgressBar, JTabbedPane jTabbedPane) {
        this.jProgressBar = jProgressBar;
        this.jTabbedPane = jTabbedPane;
    }

    /*
         * Executed in event dispatch thread
         */
    public void done() {
//        jProgressBar.setIndeterminate(false);
        jProgressBar.setValue(0);
        jProgressBar.setStringPainted(false);
        jTabbedPane.setEnabledAt(1, true);
        jTabbedPane.setSelectedIndex(1);
        jTabbedPane.setCursor((Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)));
    }
}
