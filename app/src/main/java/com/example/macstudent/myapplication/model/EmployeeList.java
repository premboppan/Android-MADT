package com.example.macstudent.myapplication.model;

/**
 * Created by ADMIN on 7/10/2018.
 */

public class EmployeeList {
    private String title;
    private String description;

    public EmployeeList(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

