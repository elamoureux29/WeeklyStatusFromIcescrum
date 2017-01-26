package com.app.java.util;

import com.app.java.model.Release;

import java.util.*;

/**
 * Created by elamoureux on 1/26/2017.
 */
public class HashMapSort {
    public static HashMap<Integer, Release> sortByValues(HashMap<Integer, Release> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                String s1 = ((Map.Entry<Integer, Release>) (o1)).getValue().getOrderNumber();
                String s2 = ((Map.Entry<Integer, Release>) (o2)).getValue().getOrderNumber();

                return ((Comparable) Integer.parseInt(s1))
                        .compareTo(Integer.parseInt(s2));
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
}
