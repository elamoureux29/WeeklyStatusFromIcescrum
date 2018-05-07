package com.app.java.util;

import com.app.java.model.json.Release;
import com.app.java.model.json.Sprint;

import java.util.*;

/**
 * Created by elamoureux on 1/26/2017.
 */
public class HashMapSort {
    public static HashMap<Integer, Release> sortReleaseByValues(HashMap<Integer, Release> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                int s1 = ((Map.Entry<Integer, Release>) (o1)).getValue().getOrderNumber();
                int s2 = ((Map.Entry<Integer, Release>) (o2)).getValue().getOrderNumber();

                return ((Comparable) s1)
                        .compareTo(s2);
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap<Integer, Release> sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Release> entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static HashMap<Integer, Sprint> sortSprintByValues(HashMap<Integer, Sprint> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                int s1 = ((Map.Entry<Integer, Sprint>) (o1)).getValue().getOrderNumber();
                int s2 = ((Map.Entry<Integer, Sprint>) (o2)).getValue().getOrderNumber();

                return ((Comparable) s1)
                        .compareTo(s2);
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap<Integer, Sprint> sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Sprint> entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static HashMap<Integer, Release> reverseSortReleaseByValues(HashMap<Integer, Release> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                int s1 = ((Map.Entry<Integer, Release>) (o1)).getValue().getOrderNumber();
                int s2 = ((Map.Entry<Integer, Release>) (o2)).getValue().getOrderNumber();

                return ((Comparable) s2)
                        .compareTo(s1);
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap<Integer, Release> sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Release> entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static HashMap<Integer, Sprint> reverseSortSprintByValues(HashMap<Integer, Sprint> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                int s1 = ((Map.Entry<Integer, Sprint>) (o1)).getValue().getOrderNumber();
                int s2 = ((Map.Entry<Integer, Sprint>) (o2)).getValue().getOrderNumber();

                return ((Comparable) s2)
                        .compareTo(s1);
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap<Integer, Sprint> sortedHashMap = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Sprint> entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
