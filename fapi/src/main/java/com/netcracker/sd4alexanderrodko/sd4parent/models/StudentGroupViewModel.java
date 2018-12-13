package com.netcracker.sd4alexanderrodko.sd4parent.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public class StudentGroupViewModel {
    private Long id;
    @NotNull
    private Long course;
    @NotBlank
    private String description;
    private Collection<UserViewModel> students;
    private Collection<LessonViewModel> lessons;

    public StudentGroupViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
