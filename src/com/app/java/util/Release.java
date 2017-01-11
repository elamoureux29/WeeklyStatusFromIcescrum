package com.app.java.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * Created by elamoureux on 1/6/2017.
 */
public class Release {

    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request
    public void sendGet() throws Exception {

        String url = "https://www.icescrum.com/a/ws/p/KT760055/release";
        String username = "elamoureux";
        String password = "Ekimmu29";

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        //add authentication
        String userpass = username + ":" + password;
        String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());
        con.setRequestProperty("Authorization", basicAuth);

        //set to XML response
        con.setRequestProperty("Accept", "application/xml");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        File file;
        FileOutputStream fop;

        file = new File("c:/JavaRelease.xml");
        fop = new FileOutputStream(file);

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        fop.write(response.toString().getBytes());
        fop.flush();
        fop.close();

        System.out.println("Done");

//        DefaultHandler handler = new DefaultHandler() {
//
//            boolean bfname = false;
//            boolean blname = false;
//            boolean bnname = false;
//            boolean bsalary = false;
//
//            public void startElement(String uri, String localName,
//                                     String qName, Attributes attributes)
//                    throws SAXException {
//
//                System.out.println("Start Element :" + qName);
//
////                if (qName.equalsIgnoreCase("FIRSTNAME")) {
////                    bfname = true;
////                }
////
////                if (qName.equalsIgnoreCase("LASTNAME")) {
////                    blname = true;
////                }
////
////                if (qName.equalsIgnoreCase("NICKNAME")) {
////                    bnname = true;
////                }
////
////                if (qName.equalsIgnoreCase("SALARY")) {
////                    bsalary = true;
////                }
//
//            }
//
//            public void endElement(String uri, String localName,
//                                   String qName)
//                    throws SAXException {
//
//                System.out.println("End Element :" + qName);
//
//            }
//
//            public void characters(char ch[], int start, int length)
//                    throws SAXException {
//
//                System.out.println(new String(ch, start, length));
//
//
////                if (bfname) {
////                    System.out.println("First Name : "
////                            + new String(ch, start, length));
////                    bfname = false;
////                }
////
////                if (blname) {
////                    System.out.println("Last Name : "
////                            + new String(ch, start, length));
////                    blname = false;
////                }
////
////                if (bnname) {
////                    System.out.println("Nick Name : "
////                            + new String(ch, start, length));
////                    bnname = false;
////                }
////
////                if (bsalary) {
////                    System.out.println("Salary : "
////                            + new String(ch, start, length));
////                    bsalary = false;
////                }
//
//            }
//
//        };
//
//        XMLReader myReader = XMLReaderFactory.createXMLReader();
//        myReader.setContentHandler(handler);
//
//        InputSource is = new InputSource(con.getInputStream());
//        is.setEncoding("UTF-8");
//
//        myReader.parse(is);

    }

    // HTTP POST request
//    private void sendPost() throws Exception {
//
//        String url = "https://selfsolve.apple.com/wcResults.do";
//        URL obj = new URL(url);
//        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//
//        //add request header
//        con.setRequestMethod("POST");
//        con.setRequestProperty("User-Agent", USER_AGENT);
//        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//
//        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
//
//        // Send post request
//        con.setDoOutput(true);
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(urlParameters);
//        wr.flush();
//        wr.close();
//
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'POST' request to URL : " + url);
//        System.out.println("Post parameters : " + urlParameters);
//        System.out.println("Response Code : " + responseCode);
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response.toString());
//
//    }

}
