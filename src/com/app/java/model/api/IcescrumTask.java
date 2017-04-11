package com.app.java.model.api;

import com.app.java.model.CreateTaskItem;
import com.app.java.util.request.CreateRequest;
import com.app.java.util.request.ReadRequest;

import java.io.IOException;

/**
 * Created by elamoureux on 1/11/2017.
 */
public class IcescrumTask extends IcescrumRest {
    private final String URL_BASE_COMMAND = "/task";

    @Override
    public StringBuffer getAll() throws IOException {
        String fullUrl = URL + project + URL_BASE_COMMAND;
        fileName = "Icescrum_All_Tasks_In_Current_Sprint";

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

    public StringBuffer getAllFiltered(String filter) throws IOException {
        String fullUrl = URL + project + URL_BASE_COMMAND + "/" + filter;
        fileName = "Icescrum_All_" + filter + "_Tasks_In_Current_Sprint";

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

    public StringBuffer getAllInSprint(int id) throws IOException {
        String fullUrl = URL + project + "/" + id + URL_BASE_COMMAND;
        fileName = "Icescrum_All_Tasks_In_Sprint_" + id;

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

    public StringBuffer getAllFilteredInSprint(int id, String filter) throws IOException {
        String fullUrl = URL + project + "/" + id + URL_BASE_COMMAND + "/" + filter;
        fileName = "Icescrum_All_" + filter + "_Tasks_In_Sprint_" + id;

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

    @Override
    public StringBuffer getItem(int id) throws IOException {
        String fullUrl = URL + project + URL_BASE_COMMAND + "/" + id;
        fileName = "Icescrum_Task_" + id;

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

    public StringBuffer createTask(CreateTaskItem createTaskItem) throws Exception {
        String fullUrl = URL + project + URL_BASE_COMMAND;

        return CreateRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl, createTaskItem.createDOMSource());
    }
}
