package com.netcracker.sd4alexanderrodko.sd4parent.models;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.Collection;

public class LessonViewModel {
    private long id;
    @PastOrPresent
    private Timestamp timeStart;
    @Future
    private Timestamp timeEnd;
    @NotBlank
    @Size(min=2)
    private String description;
    @NotBlank
    @Size(min=1)
    private String room;
    @NotBlank
    private String type;
    @Valid
    @NotNull
    private UserViewModel teacher;
    @NotNull
    private Collection<StudentGroupViewModel> groups;

    public LessonViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserViewModel getTeacher() {
        return teacher;
    }

    public void setTeacher(UserViewModel teacher) {
        this.teacher = teacher;
    }

    public Collection<StudentGroupViewModel> getGroups() {
        return groups;
    }

    public void setGroups(Collection<StudentGroupViewModel> groups) {
        this.groups = groups;
    }

}
