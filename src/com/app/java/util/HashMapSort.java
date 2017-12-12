package com.app.java.util;

import com.app.java.model.xml.XmlRelease;
import com.app.java.model.xml.XmlSprint;

import java.util.*;

/**
 * Created by elamoureux on 1/26/2017.
 */
public class HashMapSort {
    public static HashMap<Integer, XmlRelease> sortReleaseByValues(HashMap<Integer, XmlRelease> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                String s1 = ((Map.Entry<Integer, XmlRelease>) (o1)).getValue().getOrderNumber();
                String s2 = ((Map.Entry<Integer, XmlRelease>) (o2)).getValue().getOrderNumber();

                return ((Comparable) Integer.parseInt(s1))
                        .compareTo(Integer.parseInt(s2));
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap<Integer, XmlRelease> sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, XmlRelease> entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static HashMap<Integer, XmlSprint> sortSprintByValues(HashMap<Integer, XmlSprint> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                String s1 = ((Map.Entry<Integer, XmlSprint>) (o1)).getValue().getOrderNumber();
                String s2 = ((Map.Entry<Integer, XmlSprint>) (o2)).getValue().getOrderNumber();

                return ((Comparable) Integer.parseInt(s1))
                        .compareTo(Integer.parseInt(s2));
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap<Integer, XmlSprint> sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, XmlSprint> entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static HashMap<Integer, XmlRelease> reverseSortReleaseByValues(HashMap<Integer, XmlRelease> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                String s1 = ((Map.Entry<Integer, XmlRelease>) (o1)).getValue().getOrderNumber();
                String s2 = ((Map.Entry<Integer, XmlRelease>) (o2)).getValue().getOrderNumber();

                return ((Comparable) Integer.parseInt(s2))
                        .compareTo(Integer.parseInt(s1));
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap<Integer, XmlRelease> sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, XmlRelease> entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static HashMap<Integer, XmlSprint> reverseSortSprintByValues(HashMap<Integer, XmlSprint> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                String s1 = ((Map.Entry<Integer, XmlSprint>) (o1)).getValue().getOrderNumber();
                String s2 = ((Map.Entry<Integer, XmlSprint>) (o2)).getValue().getOrderNumber();

                return ((Comparable) Integer.parseInt(s2))
                        .compareTo(Integer.parseInt(s1));
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap<Integer, XmlSprint> sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, XmlSprint> entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
