package com.netcracker.sd4alexanderrodko.sd4parent.models;

public class VisitViewModel {
    private long id;
    private Byte visit;
    private LessonViewModel lesson;

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

    public AccountViewModel getStudent() {
        return student;
    }

    public void setStudent(AccountViewModel student) {
        this.student = student;
    }

    private AccountViewModel student;


}
