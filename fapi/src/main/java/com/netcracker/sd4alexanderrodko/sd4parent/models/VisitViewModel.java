package com.netcracker.sd4alexanderrodko.sd4parent.models;

public class VisitViewModel {
    private long id;
    private Boolean visit;
    private LessonViewModel lesson;
    private StudentViewModel student;

    public VisitViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getVisit() {
        return visit;
    }

    public void setVisit(Boolean visit) {
        this.visit = visit;
    }

    public LessonViewModel getLesson() {
        return lesson;
    }

    public void setLesson(LessonViewModel lesson) {
        this.lesson = lesson;
    }

    public StudentViewModel getStudent() {
        return student;
    }

    public void setStudent(StudentViewModel student) {
        this.student = student;
    }
}
