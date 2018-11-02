package com.app.java.util.task;

import javax.swing.*;

/**
 * Created by elamoureux on 1/26/2017.
 */
public abstract class TaskWorkerAllProjects extends SwingWorker<Void, Void> {
    protected JProgressBar jProgressBar;
    protected JLabel jLabel;

    protected TaskWorkerAllProjects(JProgressBar jProgressBar, JLabel jLabel) {
        this.jProgressBar = jProgressBar;
        this.jLabel = jLabel;
    }

    /*
     * Executed in event dispatch thread
     */
    public void done() {
//        jProgressBar.setIndeterminate(false);
        jProgressBar.setValue(0);
        jProgressBar.setStringPainted(false);
        jLabel.setText("Done");
    }
}
