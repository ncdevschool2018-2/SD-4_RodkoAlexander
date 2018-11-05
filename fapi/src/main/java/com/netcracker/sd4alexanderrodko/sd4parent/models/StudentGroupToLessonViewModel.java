package com.netcracker.sd4alexanderrodko.sd4parent.models;

public class StudentGroupToLessonViewModel {
    private long id;
    private StudentGroupViewModel studentGroupsByGroupNumber;
    private LessonViewModel lessonsByLessonId;

    public StudentGroupToLessonViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StudentGroupViewModel getStudentGroupsByGroupNumber() {
        return studentGroupsByGroupNumber;
    }

    public void setStudentGroupsByGroupNumber(StudentGroupViewModel studentGroupsByGroupNumber) {
        this.studentGroupsByGroupNumber = studentGroupsByGroupNumber;
    }

    public LessonViewModel getLessonsByLessonId() {
        return lessonsByLessonId;
    }

    public void setLessonsByLessonId(LessonViewModel lessonsByLessonId) {
        this.lessonsByLessonId = lessonsByLessonId;
    }
}
