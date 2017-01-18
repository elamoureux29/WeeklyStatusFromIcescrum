package com.app.java.util.handler;

import com.app.java.model.Sprint;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by elamoureux on 1/13/2017.
 */
public class SprintHandler extends DefaultHandler {
    private HashMap<Integer, Sprint> sprintHashMap;
    private int currentMapKey;
    private boolean bsprintId;
    private boolean bactivationDate;
    private boolean bcapacity;
    private boolean bcloseDate;
    private boolean bdailyWorkTime;
    private boolean bdeliveredVersion;
    private boolean bdoneDefinition;
    private boolean bendDate;
    private boolean bgoal;
    private boolean binitialRemainingTime;
    private boolean blastUpdated;
    private boolean borderNumber;
    //    private boolean bparentReleaseId;
    private boolean bretrospective;
    private boolean bstartDate;
    private boolean bstate;
    //    private boolean bstoriesId;
//    private boolean btasksId;
    private boolean bvelocity;
    private boolean bexpectedAvailability;
    private boolean bactualAvailability;

    public SprintHandler(HashMap<Integer, Sprint> sprintHashMap) {
        this.sprintHashMap = sprintHashMap;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "sprint":
                bsprintId = true;
                currentMapKey = Integer.parseInt(attributes.getValue("id"));
                Sprint sprint = new Sprint();
                sprint.setSprintId(currentMapKey);
                sprintHashMap.put(currentMapKey, sprint);
                break;
            case "activationDate":
                bactivationDate = true;
                break;
            case "capacity":
                bcapacity = true;
                break;
            case "closeDate":
                bcloseDate = true;
                break;
            case "dailyWorkTime":
                bdailyWorkTime = true;
                break;
            case "deliveredVersion":
                bdeliveredVersion = true;
                break;
            case "doneDefinition":
                bdoneDefinition = true;
                break;
            case "endDate":
                bendDate = true;
                break;
            case "goal":
                bgoal = true;
                break;
            case "initialRemainingTime":
                binitialRemainingTime = true;
                break;
            case "lastUpdated":
                blastUpdated = true;
                break;
            case "orderNumber":
                borderNumber = true;
                break;
            case "parentRelease":
//                bparentReleaseId = true;
                sprintHashMap.get(currentMapKey).setParentRelease(Integer.parseInt(attributes.getValue("id")));
                break;
            case "retrospective":
                bretrospective = true;
                break;
            case "startDate":
                bstartDate = true;
                break;
            case "state":
                bstate = true;
                break;
            case "story":
//                bstoriesId = true;
                ArrayList<Integer> stories;
                stories = sprintHashMap.get(currentMapKey).getStories();
                stories.add(Integer.parseInt(attributes.getValue("id")));
                sprintHashMap.get(currentMapKey).setStories(stories);
                break;
            case "task":
//                btasksId = true;
                ArrayList<Integer> tasks;
                tasks = sprintHashMap.get(currentMapKey).getTasks();
                tasks.add(Integer.parseInt(attributes.getValue("id")));
                sprintHashMap.get(currentMapKey).setTasks(tasks);
                break;
            case "velocity":
                bvelocity = true;
                break;
            case "expectedAvailability":
                bexpectedAvailability = true;
                break;
            case "actualAvailability":
                bactualAvailability = true;
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        /*
        * Do something if Xml tag is empty except for the release case
        * which is for re initializing the currentMapKey variable.
        */
        switch (qName) {
            case "sprint":
                if (bsprintId) {
                    currentMapKey = 0;
                    bsprintId = false;
                }
                break;
            case "activationDate":
                if (bactivationDate) {
                    bactivationDate = false;
                }
                break;
            case "capacity":
                if (bcapacity) {
                    bcapacity = false;
                }
                break;
            case "closeDate":
                if (bcloseDate) {
                    bcloseDate = false;
                }
                break;
            case "dailyWorkTime":
                if (bdailyWorkTime) {
                    bdailyWorkTime = false;
                }
                break;
            case "deliveredVersion":
                if (bdeliveredVersion) {
                    bdeliveredVersion = false;
                }
                break;
            case "doneDefinition":
                if (bdoneDefinition) {
                    bdoneDefinition = false;
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
            case "initialRemainingTime":
                if (binitialRemainingTime) {
                    binitialRemainingTime = false;
                }
                break;
            case "lastUpdated":
                if (blastUpdated) {
                    blastUpdated = false;
                }
                break;
            case "orderNumber":
                if (borderNumber) {
                    borderNumber = false;
                }
                break;
            case "retrospective":
                if (bretrospective) {
                    bretrospective = false;
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
            case "velocity":
                if (bvelocity) {
                    bvelocity = false;
                }
                break;
            case "expectedAvailability":
                if (bexpectedAvailability) {
                    bexpectedAvailability = false;
                }
                break;
            case "actualAvailability":
                if (bactualAvailability) {
                    bactualAvailability = false;
                }
                break;
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bactivationDate) {
            sprintHashMap.get(currentMapKey).setActivationDate(new String(ch, start, length));
            bactivationDate = false;
        } else if (bcapacity) {
            sprintHashMap.get(currentMapKey).setCapacity(new String(ch, start, length));
            bcapacity = false;
        } else if (bcloseDate) {
            sprintHashMap.get(currentMapKey).setCloseDate(new String(ch, start, length));
            bcloseDate = false;
        } else if (bdailyWorkTime) {
            sprintHashMap.get(currentMapKey).setDailyWorkTime(new String(ch, start, length));
            bdailyWorkTime = false;
        } else if (bdeliveredVersion) {
            sprintHashMap.get(currentMapKey).setDeliveredVersion(new String(ch, start, length));
            bdeliveredVersion = false;
        } else if (bdoneDefinition) {
            sprintHashMap.get(currentMapKey).setDoneDefinition(new String(ch, start, length));
            bdoneDefinition = false;
        } else if (bendDate) {
            sprintHashMap.get(currentMapKey).setEndDate(new String(ch, start, length));
            bendDate = false;
        } else if (bgoal) {
            sprintHashMap.get(currentMapKey).setGoal(new String(ch, start, length));
            bgoal = false;
        } else if (binitialRemainingTime) {
            sprintHashMap.get(currentMapKey).setInitialRemainingTime(new String(ch, start, length));
            binitialRemainingTime = false;
        } else if (blastUpdated) {
            sprintHashMap.get(currentMapKey).setLastUpdated(new String(ch, start, length));
            blastUpdated = false;
        } else if (borderNumber) {
            sprintHashMap.get(currentMapKey).setOrderNumber(new String(ch, start, length));
            borderNumber = false;
        } else if (bretrospective) {
            sprintHashMap.get(currentMapKey).setRetrospective(new String(ch, start, length));
            bretrospective = false;
        } else if (bstartDate) {
            sprintHashMap.get(currentMapKey).setStartDate(new String(ch, start, length));
            bstartDate = false;
        } else if (bstate) {
            sprintHashMap.get(currentMapKey).setState(new String(ch, start, length));
            bstate = false;
        } else if (bvelocity) {
            sprintHashMap.get(currentMapKey).setVelocity(new String(ch, start, length));
            bvelocity = false;
        } else if (bexpectedAvailability) {
            sprintHashMap.get(currentMapKey).setExpectedAvailability(new String(ch, start, length));
            bexpectedAvailability = false;
        } else if (bactualAvailability) {
            sprintHashMap.get(currentMapKey).setActualAvailability(new String(ch, start, length));
            bactualAvailability = false;
        }
    }
}
