package com.netcracker.sd4alexanderrodko.sd4parent.models;

import java.sql.Date;
import java.util.Collection;

public class LessonViewModel {
    private long id;
    private Date timeStart;
    private Date timeEnd;
    private String description;
    private String room;
    private String type;
    private TeacherViewModel teacher;
    private Collection<StudentGroupViewModel> groups;

    public Collection<StudentGroupViewModel> getGroups() {
        return groups;
    }

    public void setGroups(Collection<StudentGroupViewModel> groups) {
        this.groups = groups;
    }

    public LessonViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
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

    public TeacherViewModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherViewModel teacher) {
        this.teacher = teacher;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LessonViewModel{");
        sb.append("id=").append(id);
        sb.append(", timeStart=").append(timeStart);
        sb.append(", timeEnd=").append(timeEnd);
        sb.append(", description='").append(description).append('\'');
        sb.append(", room='").append(room).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", teacher=").append(teacher);
        sb.append(", groups=").append(groups);
        sb.append('}');
        return sb.toString();
    }
}
