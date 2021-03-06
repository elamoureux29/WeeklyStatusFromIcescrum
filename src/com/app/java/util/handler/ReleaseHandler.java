package com.app.java.util.handler;

import com.app.java.model.xml.XmlRelease;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by elamoureux on 1/13/2017.
 */
public class ReleaseHandler extends DefaultHandler {
    private HashMap<Integer, XmlRelease> releaseHashMap;
    private int currentMapKey;
    private boolean breleaseId;
    private boolean bendDate;
    //    private boolean bfeaturesId;
    private boolean bgoal;
    private boolean blastUpdated;
    private boolean bname;
    private boolean borderNumber;
    //    private boolean bparentProductId;
    private boolean breleaseVelocity;
    //    private boolean bsprintsId;
    private boolean bstartDate;
    private boolean bstate;
    private boolean bvision;

    public ReleaseHandler(HashMap<Integer, XmlRelease> releaseHashMap) {
        this.releaseHashMap = releaseHashMap;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "release":
                breleaseId = true;
                currentMapKey = Integer.parseInt(attributes.getValue("id"));
                XmlRelease xmlRelease = new XmlRelease();
                xmlRelease.setReleaseId(currentMapKey);
                releaseHashMap.put(currentMapKey, xmlRelease);
                break;
            case "endDate":
                bendDate = true;
                break;
            case "icescrumFeature":
//                bfeaturesId = true;
                ArrayList<Integer> features;
                features = releaseHashMap.get(currentMapKey).getFeaturesId();
                features.add(Integer.parseInt(attributes.getValue("id")));
                releaseHashMap.get(currentMapKey).setFeaturesId(features);
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
//                bparentProductId = true;
                releaseHashMap.get(currentMapKey).setParentProduct(Integer.parseInt(attributes.getValue("id")));
                break;
            case "releaseVelocity":
                breleaseVelocity = true;
                break;
            case "icescrumSprint":
//                bsprintsId = true;
                ArrayList<Integer> sprints;
                sprints = releaseHashMap.get(currentMapKey).getSprintsId();
                sprints.add(Integer.parseInt(attributes.getValue("id")));
                releaseHashMap.get(currentMapKey).setSprintsId(sprints);
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
        /*
        * Do something if Xml tag is empty except for the icescrumRelease case
        * which is for re initializing the currentMapKey variable.
        */
        switch (qName) {
            case "release":
                if (breleaseId) {
                    currentMapKey = 0;
                    breleaseId = false;
                }
                break;
            case "endDate":
                if (bendDate) {
                    bendDate = false;
                }
                break;
            case "goal":
                if (bgoal) {
                    bgoal = false;
                }
                break;
            case "lastUpdated":
                if (blastUpdated) {
                    blastUpdated = false;
                }
                break;
            case "name":
                if (bname) {
                    bname = false;
                }
                break;
            case "orderNumber":
                if (borderNumber) {
                    borderNumber = false;
                }
                break;
            case "releaseVelocity":
                if (breleaseVelocity) {
                    breleaseVelocity = false;
                }
                break;
            case "startDate":
                if (bstartDate) {
                    bstartDate = false;
                }
                break;
            case "state":
                if (bstate) {
                    bstate = false;
                }
                break;
            case "vision":
                if (bvision) {
                    bvision = false;
                }
                break;
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bendDate) {
            releaseHashMap.get(currentMapKey).setEndDate(new String(ch, start, length));
            bendDate = false;
        } else if (bgoal) {
            releaseHashMap.get(currentMapKey).setGoal(new String(ch, start, length));
            bgoal = false;
        } else if (blastUpdated) {
            releaseHashMap.get(currentMapKey).setLastUpdated(new String(ch, start, length));
            blastUpdated = false;
        } else if (bname) {
            releaseHashMap.get(currentMapKey).setName(new String(ch, start, length));
            bname = false;
        } else if (borderNumber) {
            releaseHashMap.get(currentMapKey).setOrderNumber(new String(ch, start, length));
            borderNumber = false;
        } else if (breleaseVelocity) {
            releaseHashMap.get(currentMapKey).setReleaseVelocity(new String(ch, start, length));
            breleaseVelocity = false;
        } else if (bstartDate) {
            releaseHashMap.get(currentMapKey).setStartDate(new String(ch, start, length));
            bstartDate = false;
        } else if (bstate) {
            releaseHashMap.get(currentMapKey).setState(new String(ch, start, length));
            bstate = false;
        } else if (bvision) {
            releaseHashMap.get(currentMapKey).setVision(new String(ch, start, length));
            bvision = false;
        }
    }
}
