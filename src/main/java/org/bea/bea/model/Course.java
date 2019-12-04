package org.bea.bea.model;

public class Course {
    private static Course ourInstance = new Course();

    public static Course getInstance() {
        return ourInstance;
    }

    private Course() {
    }
}
