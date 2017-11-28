package com.app.java.util;

/**
 * Created by elamoureux on 1/12/2017.
 */
public class Authentication {
    private static final String USERNAME = "elamoureux";
    private static final String PASSWORD = "Ekimmu29";
    private static final String TOKEN = "96512df630954f01a4dc0ed3d57503ef";

    public static String getBasicAuth() {
        String userpass = USERNAME + ":" + PASSWORD;
        String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

        return basicAuth;
    }

    public static String getToken() {
        return TOKEN;
    }
}
