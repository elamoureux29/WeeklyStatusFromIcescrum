package com.app.java.model.json;

public class Project {
    //    private String class;
    private int id;

    // GSON sets the fields directly using reflection.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
