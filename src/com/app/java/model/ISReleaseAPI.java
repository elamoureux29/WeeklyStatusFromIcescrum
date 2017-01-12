package com.app.java.model;

import com.app.java.util.ReadRequest;

import java.io.IOException;

/**
 * Created by elamoureux on 1/11/2017.
 */
public class ISReleaseAPI extends ISRestApi {
    private final String URL_BASE_COMMAND = "/release";

    @Override
    public StringBuffer getAll() throws IOException {
        String fullUrl = URL + PROJECT + URL_BASE_COMMAND;
        fileName = "Icescrum_All_Releases";

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

    @Override
    public StringBuffer getA(int id) throws IOException {
        String fullUrl = URL + PROJECT + URL_BASE_COMMAND;
        fileName = "Icescrum_Release_" + id;

        return ReadRequest.send(USER_AGENT, RESPONSE_FORMAT, fullUrl);
    }

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
