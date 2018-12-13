package com.netcracker.sd4alexanderrodko.sd4parent.models;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VisitViewModel {
    private long id;
    @NotNull
    private Boolean visit;
    @NotNull
    @Valid
    private LessonViewModel lesson;
    @NotNull
    @Valid
    private UserViewModel student;


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

    public UserViewModel getStudent() {
        return student;
    }

    public void setStudent(UserViewModel student) {
        this.student = student;
    }


}
