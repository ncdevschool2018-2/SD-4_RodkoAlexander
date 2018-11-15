package com.netcracker.sd4alexanderrodko.sd4parent.models;

public class VisitViewModel {
    private long id;
    private Byte visit;
    private LessonViewModel lesson;
    private UserViewModel student;


    public VisitViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Byte getVisit() {
        return visit;
    }

    public void setVisit(Byte visit) {
        this.visit = visit;
    }

    public LessonViewModel getLesson() {
        return lesson;
    }

    public void setLesson(LessonViewModel lesson) {
        this.lesson = lesson;
    }

    public UserViewModel getStudent() {
        return student;
    }

    public void setStudent(UserViewModel student) {
        this.student = student;
    }


}
