package com.app.java.model.api;

import com.app.java.model.enums.Projects;

import java.io.IOException;

/**
 * Created by elamoureux on 1/11/2017.
 */
public abstract class IcescrumRest {
    public final String USER_AGENT = "Mozilla/5.0";
    public final String RESPONSE_FORMAT = "application/xml";
    public final String URL = "https://www.icescrum.com/a/ws/p/";
    public final String PROJECT = Projects.ENTRAPASS.getIdentifier();
    protected String fileName = "";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public abstract StringBuffer getAll() throws IOException;

    public abstract StringBuffer getItem(int id) throws IOException;
}
