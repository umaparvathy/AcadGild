package com.uv.acadgild;

/**
 * Created by venkatsr on 12/11/15.
 */
public class Courses {
    private String course;
    private String mentor;

    public Courses(String course, String mentor) {
        this.course = course;
        this.mentor = mentor;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }
}
