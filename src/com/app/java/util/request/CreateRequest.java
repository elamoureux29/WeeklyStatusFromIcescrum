package com.app.java.util.request;

import com.app.java.util.Authentication;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by elamoureux on 1/11/2017.
 */
public class CreateRequest {
    public static StringBuffer send(String userAgent, String responseFormat, String url, DOMSource source) throws Exception {
        URL obj;
        HttpsURLConnection con;
        BufferedReader in = null;
        String inputLine;
        StringBuffer response = null;
        int responseCode;

        try {
            obj = new URL(url);
            con = (HttpsURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", userAgent);
            con.setRequestProperty("Accept", responseFormat);
//            con.setRequestProperty("Authorization", Authentication.getBasicAuth());
            con.setRequestProperty("x-icescrum-token", Authentication.getToken());
//            con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoInput(true);
            con.setDoOutput(true);

            // write the XML content to stream
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(con.getOutputStream());

            // Output to console for testing
//            StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            // Send post request
//            con.setDoOutput(true);
//            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//            wr.writeBytes(urlParameters);
//            wr.flush();
//            wr.close();

            responseCode = con.getResponseCode();

            System.out.println("\nSending request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
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
