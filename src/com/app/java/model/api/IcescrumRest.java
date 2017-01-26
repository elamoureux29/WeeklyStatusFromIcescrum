package com.app.java.model.api;

import java.io.IOException;

/**
 * Created by elamoureux on 1/11/2017.
 */
public abstract class IcescrumRest {
    public final String USER_AGENT = "Mozilla/5.0";
    public final String RESPONSE_FORMAT = "application/xml";
    public final String URL = "https://www.icescrum.com/a/ws/p/";

    protected String project = "";
    protected String fileName = "";

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public abstract StringBuffer getAll() throws IOException;

    public abstract StringBuffer getItem(int id) throws IOException;
}
