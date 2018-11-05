package com.netcracker.sd4alexanderrodko.sd4parent.models;

import java.util.Collection;

public class StudentGroupViewModel {
    private long number;
    private Long course;
    private String description;
    private Collection<StudentViewModel> students;

    public StudentGroupViewModel() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<StudentViewModel> getStudents() {
        return students;
    }

    public void setStudents(Collection<StudentViewModel> students) {
        this.students = students;
    }
}
