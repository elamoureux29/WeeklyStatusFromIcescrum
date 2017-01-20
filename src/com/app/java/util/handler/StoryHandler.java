package com.app.java.util.handler;

import com.app.java.model.Story;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by elamoureux on 1/13/2017.
 */
public class StoryHandler extends DefaultHandler {
    private HashMap<Integer, Story> storyHashMap;
    private int currentMapKey;
    private boolean bstoryId;
    //    private boolean bacceptanceTestsId;
    private boolean bacceptedDate;
    private boolean bactor;
    private boolean baffectVersion;
    private boolean bcreationDate;
    //    private boolean bcreatorId;
    private boolean bdependsOn;
    private boolean bdescription;
    private boolean bdoneDate;
    private boolean beffort;
    private boolean bestimatedDate;
    private boolean bexecutionFrequency;
    //    private boolean bfeatureId;
    private boolean binProgressDate;
    private boolean blastUpdated;
    private boolean bname;
    //    private boolean bnotesId;
    private boolean borigin;
    //    private boolean bparentSprintId;
    private boolean bplannedDate;
    private boolean brank;
    private boolean bstate;
    private boolean bsuggestedDate;
    //    private boolean btasksId;
    private boolean btype;
    private boolean buid;
    //    private boolean btagsId;
//    private boolean bdependencesId;
    private boolean btestState;
//    private boolean bcommentsId;

    public StoryHandler(HashMap<Integer, Story> storyHashMap) {
        this.storyHashMap = storyHashMap;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "story":
                bstoryId = true;
                currentMapKey = Integer.parseInt(attributes.getValue("id"));
                Story story = new Story();
                story.setStoryId(currentMapKey);
                storyHashMap.put(currentMapKey, story);
                break;
            case "acceptanceTest":
//                bacceptanceTestsId = true;
                ArrayList<Integer> acceptanceTests;
                acceptanceTests = storyHashMap.get(currentMapKey).getNotesId();
                acceptanceTests.add(Integer.parseInt(attributes.getValue("id")));
                storyHashMap.get(currentMapKey).setNotesId(acceptanceTests);
                break;
            case "acceptedDate":
                bacceptedDate = true;
                break;
            case "actor":
                bactor = true;
                break;
            case "affectVersion":
                baffectVersion = true;
                break;
            case "creationDate":
                bcreationDate = true;
                break;
            case "creator":
//                bcreatorId = true;
                storyHashMap.get(currentMapKey).setCreatorId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "dependsOn":
                bdependsOn = true;
                break;
            case "description":
                bdescription = true;
                break;
            case "doneDate":
                bdoneDate = true;
                break;
            case "effort":
                beffort = true;
                break;
            case "estimatedDate":
                bestimatedDate = true;
                break;
            case "executionFrequency":
                bexecutionFrequency = true;
                break;
            case "feature":
//                bfeatureId = true;
                if (attributes.getValue("id") != null) {
                    storyHashMap.get(currentMapKey).setFeatureId(Integer.parseInt(attributes.getValue("id")));
                }
                break;
            case "inProgressDate":
                binProgressDate = true;
                break;
            case "lastUpdated":
                blastUpdated = true;
                break;
            case "name":
                bname = true;
                break;
            case "note":
//                bnotesId = true;
                ArrayList<Integer> notes;
                notes = storyHashMap.get(currentMapKey).getNotesId();
                notes.add(Integer.parseInt(attributes.getValue("id")));
                storyHashMap.get(currentMapKey).setNotesId(notes);
                break;
            case "origin":
                borigin = true;
                break;
            case "parentSprint":
//                bparentSprintId = true;
                if (attributes.getValue("id") != null) {
                    storyHashMap.get(currentMapKey).setParentSprintId(Integer.parseInt(attributes.getValue("id")));
                }
                break;
            case "plannedDate":
                bplannedDate = true;
                break;
            case "rank":
                brank = true;
                break;
            case "state":
                bstate = true;
                break;
            case "suggestedDate":
                bsuggestedDate = true;
                break;
            case "task":
//                btasksId = true;
                ArrayList<Integer> tasks;
                tasks = storyHashMap.get(currentMapKey).getTasksId();
                tasks.add(Integer.parseInt(attributes.getValue("id")));
                storyHashMap.get(currentMapKey).setTasksId(tasks);
                break;
            case "type":
                btype = true;
                break;
            case "uid":
                buid = true;
                break;
            case "tag":
//                btagsId = true;
                ArrayList<Integer> tags;
                tags = storyHashMap.get(currentMapKey).getTagsId();
                tags.add(Integer.parseInt(attributes.getValue("id")));
                storyHashMap.get(currentMapKey).setTagsId(tags);
                break;
            case "dependence":
//                bdependencesId = true;
                ArrayList<Integer> dependences;
                dependences = storyHashMap.get(currentMapKey).getDependencesId();
                dependences.add(Integer.parseInt(attributes.getValue("id")));
                storyHashMap.get(currentMapKey).setDependencesId(dependences);
                break;
            case "testState":
                btestState = true;
                break;
            case "comment":
//                bcommentsId = true;
                ArrayList<Integer> comments;
                comments = storyHashMap.get(currentMapKey).getCommentsId();
                comments.add(Integer.parseInt(attributes.getValue("id")));
                storyHashMap.get(currentMapKey).setCommentsId(comments);
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        /*
        * Do something if Xml tag is empty except for the release case
        * which is for re initializing the currentMapKey variable.
        */
        switch (qName) {
            case "story":
                if (bstoryId) {
                    currentMapKey = 0;
                    bstoryId = false;
                }
                break;
            case "acceptedDate":
                if (bacceptedDate) {
                    bacceptedDate = false;
                }
                break;
            case "actor":
                if (bactor) {
                    bactor = false;
                }
                break;
            case "affectVersion":
                if (baffectVersion) {
                    baffectVersion = false;
                }
                break;
            case "creationDate":
                if (bcreationDate) {
                    bcreationDate = false;
                }
                break;
            case "dependsOn":
                if (bdependsOn) {
                    bdependsOn = false;
                }
                break;
            case "description":
                if (bdescription) {
                    bdescription = false;
                }
                break;
            case "doneDate":
                if (bdoneDate) {
                    bdoneDate = false;
                }
                break;
            case "effort":
                if (beffort) {
                    beffort = false;
                }
                break;
            case "estimatedDate":
                if (bestimatedDate) {
                    bestimatedDate = false;
                }
                break;
            case "executionFrequency":
                if (bexecutionFrequency) {
                    bexecutionFrequency = false;
                }
                break;
            case "inProgressDate":
                if (binProgressDate) {
                    binProgressDate = false;
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
            case "origin":
                if (borigin) {
                    borigin = false;
                }
                break;
            case "plannedDate":
                if (bplannedDate) {
                    bplannedDate = false;
                }
                break;
            case "rank":
                if (brank) {
                    brank = false;
                }
                break;
            case "state":
                if (bstate) {
                    bstate = false;
                }
                break;
            case "suggestedDate":
                if (bsuggestedDate) {
                    bsuggestedDate = false;
                }
                break;
            case "type":
                if (btype) {
                    btype = false;
                }
                break;
            case "uid":
                if (buid) {
                    buid = false;
                }
                break;
            case "testState":
                if (btestState) {
                    btestState = false;
                }
                break;
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bacceptedDate) {
            storyHashMap.get(currentMapKey).setAcceptedDate(new String(ch, start, length));
            bacceptedDate = false;
        } else if (bactor) {
            storyHashMap.get(currentMapKey).setActor(new String(ch, start, length));
            bactor = false;
        } else if (baffectVersion) {
            storyHashMap.get(currentMapKey).setAffectVersion(new String(ch, start, length));
            baffectVersion = false;
        } else if (bcreationDate) {
            storyHashMap.get(currentMapKey).setCreationDate(new String(ch, start, length));
            bcreationDate = false;
        } else if (bdependsOn) {
            storyHashMap.get(currentMapKey).setDependsOn(new String(ch, start, length));
            bdependsOn = false;
        } else if (bdescription) {
            storyHashMap.get(currentMapKey).setDescription(new String(ch, start, length));
            bdescription = false;
        } else if (bdoneDate) {
            storyHashMap.get(currentMapKey).setDoneDate(new String(ch, start, length));
            bdoneDate = false;
        } else if (beffort) {
            storyHashMap.get(currentMapKey).setEffort(new String(ch, start, length));
            beffort = false;
        } else if (bestimatedDate) {
            storyHashMap.get(currentMapKey).setEstimatedDate(new String(ch, start, length));
            bestimatedDate = false;
        } else if (bexecutionFrequency) {
            storyHashMap.get(currentMapKey).setExecutionFrequency(new String(ch, start, length));
            bexecutionFrequency = false;
        } else if (binProgressDate) {
            storyHashMap.get(currentMapKey).setInProgressDate(new String(ch, start, length));
            binProgressDate = false;
        } else if (blastUpdated) {
            storyHashMap.get(currentMapKey).setLastUpdated(new String(ch, start, length));
            blastUpdated = false;
        } else if (bname) {
            storyHashMap.get(currentMapKey).setName(new String(ch, start, length));
            bname = false;
        } else if (borigin) {
            storyHashMap.get(currentMapKey).setOrigin(new String(ch, start, length));
            borigin = false;
        } else if (bplannedDate) {
            storyHashMap.get(currentMapKey).setPlannedDate(new String(ch, start, length));
            bplannedDate = false;
        } else if (brank) {
            storyHashMap.get(currentMapKey).setRank(new String(ch, start, length));
            brank = false;
        } else if (bstate) {
            storyHashMap.get(currentMapKey).setState(new String(ch, start, length));
            bstate = false;
        } else if (bsuggestedDate) {
            storyHashMap.get(currentMapKey).setSuggestedDate(new String(ch, start, length));
            bsuggestedDate = false;
        } else if (btype) {
            storyHashMap.get(currentMapKey).setType(new String(ch, start, length));
            btype = false;
        } else if (buid) {
            storyHashMap.get(currentMapKey).setUid(new String(ch, start, length));
            buid = false;
        } else if (btestState) {
            storyHashMap.get(currentMapKey).setTestState(new String(ch, start, length));
            btestState = false;
        }
    }
}
