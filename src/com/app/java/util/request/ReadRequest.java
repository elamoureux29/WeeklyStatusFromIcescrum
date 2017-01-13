package com.app.java.util.request;

import com.app.java.util.Authentication;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by elamoureux on 1/11/2017.
 */
public class ReadRequest {

    public static StringBuffer send(String userAgent, String responseFormat, String url) throws IOException {

        URL obj;
        HttpsURLConnection con;
        BufferedReader in = null;
        String inputLine;
        StringBuffer response = null;
        int responseCode;

        try {

            obj = new URL(url);
            con = (HttpsURLConnection) obj.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", userAgent);
            con.setRequestProperty("Accept", responseFormat);
            con.setRequestProperty("Authorization", Authentication.getBasicAuth());

            responseCode = con.getResponseCode();

            System.out.println("\nSending request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }

        return response;
    }
}
