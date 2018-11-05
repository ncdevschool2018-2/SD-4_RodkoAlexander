package com.netcracker.sd4alexanderrodko.sd4parent.models;

public class StudentToLessonViewModel {
    private long id;
    private Boolean visit;
    private LessonViewModel lessonsByLessonId;
    private StudentViewModel studentsByStudentNumber;

    public StudentToLessonViewModel() {
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

    public LessonViewModel getLessonsByLessonId() {
        return lessonsByLessonId;
    }

    public void setLessonsByLessonId(LessonViewModel lessonsByLessonId) {
        this.lessonsByLessonId = lessonsByLessonId;
    }

    public StudentViewModel getStudentsByStudentNumber() {
        return studentsByStudentNumber;
    }

    public void setStudentsByStudentNumber(StudentViewModel studentsByStudentNumber) {
        this.studentsByStudentNumber = studentsByStudentNumber;
    }
}
