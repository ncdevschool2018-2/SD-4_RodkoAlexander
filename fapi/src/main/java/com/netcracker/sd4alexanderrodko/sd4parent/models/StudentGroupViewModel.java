package com.netcracker.sd4alexanderrodko.sd4parent.models;

import java.util.Collection;

public class StudentGroupViewModel {
    private Long number;
    private Long course;
    private String description;
    private Collection<UserViewModel> students;
    private Collection<LessonViewModel> lessons;

    public StudentGroupViewModel() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
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

    public Collection<UserViewModel> getStudents() {
        return students;
    }

    public void setStudents(Collection<UserViewModel> students) {
        this.students = students;
    }

    public Collection<LessonViewModel> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<LessonViewModel> lessons) {
        this.lessons = lessons;
    }
}
