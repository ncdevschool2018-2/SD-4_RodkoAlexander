package com.netcracker.sd4alexanderrodko.sd4parent.models;

import java.util.Collection;

public class StudentGroupViewModel {
    private long number;
    private Long course;
    private String description;
    private Collection<StudentViewModel> students;
    private Collection<LessonViewModel> lessons;


    public Collection<LessonViewModel> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<LessonViewModel> lessons) {
        this.lessons = lessons;
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentGroupViewModel{");
        sb.append("number=").append(number);
        sb.append(", course=").append(course);
        sb.append(", description='").append(description).append('\'');
        sb.append(", students=").append(students);
        sb.append(", lessons=").append(lessons);
        sb.append('}');
        return sb.toString();
    }
}
