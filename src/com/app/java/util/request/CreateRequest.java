package com.app.java.util.request;

import com.app.java.util.Authentication;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
    public static StringBuffer send(String userAgent, String responseFormat, String url) throws Exception {
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
            con.setRequestProperty("Authorization", Authentication.getBasicAuth());
            con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
//            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

//            String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("task");
            doc.appendChild(rootElement);

            // parentStory elements
            Element parentStory = doc.createElement("parentStory");
            rootElement.appendChild(parentStory);

            // set attribute to parentStory element
            Attr parentStoryAttr = doc.createAttribute("id");
            parentStoryAttr.setValue("184989");
            parentStory.setAttributeNode(parentStoryAttr);

            // sprint elements
            Element sprint = doc.createElement("sprint");
            rootElement.appendChild(sprint);

            // set attribute to sprint element
            Attr sprintAttr = doc.createAttribute("id");
            sprintAttr.setValue("76922");
            parentStory.setAttributeNode(sprintAttr);

            // shorten way
            // staff.setAttribute("id", "1");

            // name elements
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode("testTask"));
            rootElement.appendChild(name);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(con.getOutputStream());

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

//            JSONObject cred   = new JSONObject();

            // Send post request
//            con.setDoOutput(true);
//            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//            wr.writeBytes(urlParameters);
//            wr.flush();
//            wr.close();

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
