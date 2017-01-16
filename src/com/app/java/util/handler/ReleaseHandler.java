package com.app.java.util.handler;

import com.app.java.model.Release;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by elamoureux on 1/13/2017.
 */
public class ReleaseHandler extends DefaultHandler {
    private ArrayList<Release> releaseArrayList;
    //    private boolean brelease;
    private boolean bendDate;
    //    private boolean bfeature;
    private boolean bgoal;
    private boolean blastUpdated;
    private boolean bname;
    private boolean borderNumber;
    //    private boolean bparentProduct;
    private boolean breleaseVelocity;
    //    private boolean bsprint;
    private boolean bstartDate;
    private boolean bstate;
    private boolean bvision;

    public ReleaseHandler(ArrayList<Release> releaseArrayList) {
        this.releaseArrayList = releaseArrayList;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("Start Element :" + qName);

        switch (qName) {
            case "release":
//                brelease = true;
                Release release = new Release();
                release.setReleaseId(attributes.getValue("id"));
//                System.out.println("Release ID: " + attributes.getValue("id"));
                releaseArrayList.add(release);
                break;
            case "endDate":
                bendDate = true;
                break;
            case "feature":
//                bfeature = true;
                System.out.println("Feature ID: " + attributes.getValue("id"));
                break;
            case "goal":
                bgoal = true;
                break;
            case "lastUpdated":
                blastUpdated = true;
                break;
            case "name":
                bname = true;
                break;
            case "orderNumber":
                borderNumber = true;
                break;
            case "parentProduct":
//                bparentProduct = true;
                System.out.println("Parent Product ID: " + attributes.getValue("id"));
                break;
            case "releaseVelocity":
                breleaseVelocity = true;
                break;
            case "sprint":
//                bsprint = true;
                System.out.println("Sprint ID: " + attributes.getValue("id"));
                break;
            case "startDate":
                bstartDate = true;
                break;
            case "state":
                bstate = true;
                break;
            case "vision":
                bvision = true;
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("End Element :" + qName);

        switch (qName) {
            case "endDate":
                if (bendDate) {
                    System.out.println("Empty");
                    bendDate = false;
                }
                break;
            case "goal":
                if (bgoal) {
                    System.out.println("Empty");
                    bgoal = false;
                }
                break;
            case "lastUpdated":
                if (blastUpdated) {
                    System.out.println("Empty");
                    blastUpdated = false;
                }
                break;
            case "name":
                if (bname) {
                    System.out.println("Empty");
                    bname = false;
                }
                break;
            case "orderNumber":
                if (borderNumber) {
                    System.out.println("Empty");
                    borderNumber = false;
                }
                break;
            case "releaseVelocity":
                if (breleaseVelocity) {
                    System.out.println("Empty");
                    breleaseVelocity = false;
                }
                break;
            case "startDate":
                if (bstartDate) {
                    System.out.println("Empty");
                    bstartDate = false;
                }
                break;
            case "state":
                if (bstate) {
                    System.out.println("Empty");
                    bstate = false;
                }
                break;
            case "vision":
                if (bvision) {
                    System.out.println("Empty");
                    bvision = false;
                }
                break;
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
//        System.out.println(new String(ch, start, length));

        if (bendDate) {
            System.out.println(new String(ch, start, length));
            bendDate = false;
        } else if (bgoal) {
            System.out.println(new String(ch, start, length));
            bgoal = false;
        } else if (blastUpdated) {
            System.out.println(new String(ch, start, length));
            blastUpdated = false;
        } else if (bname) {
            System.out.println(new String(ch, start, length));
            bname = false;
        } else if (borderNumber) {
            System.out.println(new String(ch, start, length));
            borderNumber = false;
        } else if (breleaseVelocity) {
            System.out.println(new String(ch, start, length));
            breleaseVelocity = false;
        } else if (bstartDate) {
            System.out.println(new String(ch, start, length));
            bstartDate = false;
        } else if (bstate) {
            System.out.println(new String(ch, start, length));
            bstate = false;
        } else if (bvision) {
            System.out.println(new String(ch, start, length));
            bvision = false;
        }
    }
}
