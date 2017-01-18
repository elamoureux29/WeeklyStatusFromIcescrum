package com.app.java.model;

/**
 * Created by elamoureux on 1/11/2017.
 */
public enum TaskFilters {
    CURRENT_USER("user"), FREE("free");

    private String filter;

    TaskFilters(String s) {
        filter = s;
    }

    public String getFilter() {
        return filter;
    }
}
