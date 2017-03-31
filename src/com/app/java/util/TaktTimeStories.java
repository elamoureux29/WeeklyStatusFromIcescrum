package com.app.java.util;

import com.app.java.model.Release;
import com.app.java.model.Sprint;
import com.app.java.model.enums.ReleaseStates;
import com.app.java.model.enums.SprintStates;
import com.app.java.util.handler.SprintHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.StringReader;
import java.util.*;

import static com.app.java.MainForm.sprint;

/**
 * Created by elamoureux on 3/24/2017.
 */
public class TaktTimeStories {
    private HashMap<Integer, Release> reversedReleaseMap = new HashMap<>();
    private int currentReleaseId;
    private final int TAKTTIME_MAX_DATA = 10;
    private List<Integer> list = new ArrayList<>();

    public TaktTimeStories(HashMap<Integer, Release> allReleasesMap) {
        reversedReleaseMap = HashMapSort.reverseSortReleaseByValues(allReleasesMap);
    }

    public List<Integer> getTaktTimeData() {
        Set releaseSet = reversedReleaseMap.entrySet();
        Iterator releaseIterator = releaseSet.iterator();
        while (releaseIterator.hasNext() && list.size() < TAKTTIME_MAX_DATA) {
            HashMap<Integer, Sprint> allSprintInRelease = new HashMap<>();
            HashMap<Integer, Sprint> reversedSprintMap = new HashMap<>();

            Map.Entry<Integer, Release> releaseMentry = (Map.Entry) releaseIterator.next();
            if (releaseMentry.getValue().getState().equalsIgnoreCase(ReleaseStates.IN_PROGRESS.getIdentifier())) {
                try {
                    SprintHandler sprintHandler = new SprintHandler(allSprintInRelease);
                    XMLReader myReader = XMLReaderFactory.createXMLReader();
                    myReader.setContentHandler(sprintHandler);

                    InputSource is = new InputSource(new StringReader(sprint.getAllInRelease(
                            releaseMentry.getValue().getReleaseId()).toString()));
                    is.setEncoding("UTF-8");

                    myReader.parse(is);

                    /* Display content using Iterator*/
                    reversedSprintMap = HashMapSort.reverseSortSprintByValues(allSprintInRelease);
                    Set set = reversedSprintMap.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext() && list.size() < TAKTTIME_MAX_DATA) {
                        Map.Entry<Integer, Sprint> mentry = (Map.Entry) iterator.next();
                        if (mentry.getValue().getState().equalsIgnoreCase(SprintStates.DONE.getIdentifier())) {
                            list.add(mentry.getValue().getStories().size());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (releaseMentry.getValue().getState().equalsIgnoreCase(ReleaseStates.DONE.getIdentifier())) {
                try {
                    SprintHandler sprintHandler = new SprintHandler(allSprintInRelease);
                    XMLReader myReader = XMLReaderFactory.createXMLReader();
                    myReader.setContentHandler(sprintHandler);

                    InputSource is = new InputSource(new StringReader(sprint.getAllInRelease(
                            releaseMentry.getValue().getReleaseId()).toString()));
                    is.setEncoding("UTF-8");

                    myReader.parse(is);

                    /* Display content using Iterator*/
                    reversedSprintMap = HashMapSort.reverseSortSprintByValues(allSprintInRelease);
                    Set set = reversedSprintMap.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext() && list.size() < TAKTTIME_MAX_DATA) {
                        Map.Entry<Integer, Sprint> mentry = (Map.Entry) iterator.next();
                        list.add(mentry.getValue().getStories().size());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
//            System.out.println(list);

        return list;
    }
}
