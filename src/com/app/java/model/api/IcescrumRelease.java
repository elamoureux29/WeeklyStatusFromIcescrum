package com.app.java.model.api;

import com.app.java.util.request.ReadRequest;

import java.io.IOException;

/**
 * Created by elamoureux on 1/11/2017.
 */
public class IcescrumRelease extends IcescrumRest {
    private final String URL_BASE_COMMAND = "/release";

    @Override
    public StringBuffer getAll() throws IOException {
        String fullUrl = URL + PROJECT + URL_BASE_COMMAND;
        fileName = "Icescrum_All_Releases";

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

    @Override
    public StringBuffer getItem(int id) throws IOException {
        String fullUrl = URL + PROJECT + URL_BASE_COMMAND + "/" + id;
        fileName = "Icescrum_Release_" + id;

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }
}
