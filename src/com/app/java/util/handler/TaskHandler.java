package com.app.java.util.handler;

import com.app.java.model.Task;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by elamoureux on 1/13/2017.
 */
public class TaskHandler extends DefaultHandler {
    private HashMap<Integer, Task> taskHashMap;
    private int currentMapKey;
    private boolean btaskId;
    //    private boolean bbacklogId;
    private boolean bblocked;
    private boolean bcolor;
    private boolean bcreationDate;
    //    private boolean bcreatorId;
    private boolean bdescription;
    private boolean bdoneDate;
    private boolean bestimation;
    private boolean binProgressDate;
    private boolean binitial;
    private boolean blastUpdated;
    private boolean bname;
    //    private boolean bnotesId;
//    private boolean bparentStoryId;
//    private boolean bparticipantsId;
    private boolean brank;
    //    private boolean bresponsibleId;
    private boolean bstate;
    private boolean btype;
    private boolean buid;
//    private boolean btagsId;
//    private boolean bcommentsId;

    public TaskHandler(HashMap<Integer, Task> taskHashMap) {
        this.taskHashMap = taskHashMap;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "task":
                btaskId = true;
                currentMapKey = Integer.parseInt(attributes.getValue("id"));
                Task task = new Task();
                task.setTaskId(currentMapKey);
                taskHashMap.put(currentMapKey, task);
                break;
            case "backlog":
//                bbacklogId = true;
                taskHashMap.get(currentMapKey).setBacklogId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "blocked":
                bblocked = true;
                break;
            case "color":
                bcolor = true;
                break;
            case "creationDate":
                bcreationDate = true;
                break;
            case "creator":
//                bcreatorId = true;
                taskHashMap.get(currentMapKey).setCreatorId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "description":
                bdescription = true;
                break;
            case "doneDate":
                bdoneDate = true;
                break;
            case "estimation":
                bestimation = true;
                break;
            case "inProgressDate":
                binProgressDate = true;
                break;
            case "initial":
                binitial = true;
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
                notes = taskHashMap.get(currentMapKey).getNotesId();
                notes.add(Integer.parseInt(attributes.getValue("id")));
                taskHashMap.get(currentMapKey).setNotesId(notes);
                break;
            case "parentStory":
//                bparentStoryId = true;
                if (attributes.getValue("id") != null) {
                    taskHashMap.get(currentMapKey).setParentStoryId(Integer.parseInt(attributes.getValue("id")));
                }
                break;
            case "participant":
//                bparticipantsId = true;
                ArrayList<Integer> participants;
                participants = taskHashMap.get(currentMapKey).getParticipantsId();
                participants.add(Integer.parseInt(attributes.getValue("id")));
                taskHashMap.get(currentMapKey).setParticipantsId(participants);
                break;
            case "rank":
                brank = true;
                break;
            case "responsible":
//                bresponsibleId = true;
                if (attributes.getValue("id") != null) {
                    taskHashMap.get(currentMapKey).setResponsibleId(Integer.parseInt(attributes.getValue("id")));
                }
                break;
            case "state":
                bstate = true;
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
                tags = taskHashMap.get(currentMapKey).getTagsId();
                tags.add(Integer.parseInt(attributes.getValue("id")));
                taskHashMap.get(currentMapKey).setTagsId(tags);
                break;
            case "comment":
//                bcommentsId = true;
                ArrayList<Integer> comments;
                comments = taskHashMap.get(currentMapKey).getCommentsId();
                comments.add(Integer.parseInt(attributes.getValue("id")));
                taskHashMap.get(currentMapKey).setCommentsId(comments);
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        /*
        * Do something if Xml tag is empty except for the release case
        * which is for re initializing the currentMapKey variable.
        */
        switch (qName) {
            case "task":
                btaskId = true;
                if (btaskId) {
                    currentMapKey = 0;
                    btaskId = false;
                }
                break;
            case "blocked":
                if (bblocked) {
                    bblocked = false;
                }
                break;
            case "color":
                if (bcolor) {
                    bcolor = false;
                }
                break;
            case "creationDate":
                if (bcreationDate) {
                    bcreationDate = false;
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
            case "estimation":
                if (bestimation) {
                    bestimation = false;
                }
                break;
            case "inProgressDate":
                if (binProgressDate) {
                    binProgressDate = false;
                }
                break;
            case "initial":
                if (binitial) {
                    binitial = false;
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
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (bblocked) {
            taskHashMap.get(currentMapKey).setBlocked(new String(ch, start, length));
            bblocked = false;
        } else if (bcolor) {
            taskHashMap.get(currentMapKey).setColor(new String(ch, start, length));
            bcolor = false;
        } else if (bcreationDate) {
            taskHashMap.get(currentMapKey).setCreationDate(new String(ch, start, length));
            bcreationDate = false;
        } else if (bdescription) {
            taskHashMap.get(currentMapKey).setDescription(new String(ch, start, length));
            bdescription = false;
        } else if (bdoneDate) {
            taskHashMap.get(currentMapKey).setDoneDate(new String(ch, start, length));
            bdoneDate = false;
        } else if (bestimation) {
            taskHashMap.get(currentMapKey).setEstimation(new String(ch, start, length));
            bestimation = false;
        } else if (binProgressDate) {
            taskHashMap.get(currentMapKey).setInProgressDate(new String(ch, start, length));
            binProgressDate = false;
        } else if (binitial) {
            taskHashMap.get(currentMapKey).setInitial(new String(ch, start, length));
            binitial = false;
        } else if (blastUpdated) {
            taskHashMap.get(currentMapKey).setLastUpdated(new String(ch, start, length));
            blastUpdated = false;
        } else if (bname) {
            taskHashMap.get(currentMapKey).setName(new String(ch, start, length));
            bname = false;
        } else if (brank) {
            taskHashMap.get(currentMapKey).setRank(new String(ch, start, length));
            brank = false;
        } else if (bstate) {
            taskHashMap.get(currentMapKey).setState(new String(ch, start, length));
            bstate = false;
        } else if (btype) {
            taskHashMap.get(currentMapKey).setType(new String(ch, start, length));
            btype = false;
        } else if (buid) {
            taskHashMap.get(currentMapKey).setUid(new String(ch, start, length));
            buid = false;
        }
    }
}
