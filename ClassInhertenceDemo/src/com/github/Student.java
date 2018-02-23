package com.github;

/**
 * Created by mars on 2/22/18.
 */
public class Student extends Person {
    private String course = "";
    private String grade = "";

    public Student(String name, String address, String course, String grade) {
        super(name, address);
        this.course = course;
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
