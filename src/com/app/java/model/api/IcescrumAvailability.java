package com.app.java.model.api;

import com.app.java.util.request.ReadRequest;

import java.io.IOException;

/**
 * Created by elamoureux on 1/11/2017.
 */
public class IcescrumAvailability extends IcescrumRest {
    private final String URL_BASE_COMMAND = "/availability";

    @Override
    public StringBuffer getAll() throws IOException {
        String fullUrl = URL + project + URL_BASE_COMMAND;
        fileName = "Icescrum_All_Availabilities";

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

//    public StringBuffer getAllInSprint(int id) throws IOException {
//        String fullUrl = URL + project + "/" + id + URL_BASE_COMMAND;
//        fileName = "Icescrum_All_Availabilities_In_Sprint_" + id;
//
//        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
//    }

    @Override
    public StringBuffer getItem(int id) throws IOException {
        String fullUrl = URL + project + URL_BASE_COMMAND + "/" + id;
        fileName = "Icescrum_All_Availabilities_For_User_" + id;

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

//    public StringBuffer getForUserInSprint(int userId, int sprintId) throws IOException {
//        String fullUrl = URL + project + "/" + sprintId + URL_BASE_COMMAND + "/" + userId;
//        fileName = "Icescrum_Availabilities_For_User_" + userId + "In_Sprint_" + sprintId;
//
//        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
//    }
}
