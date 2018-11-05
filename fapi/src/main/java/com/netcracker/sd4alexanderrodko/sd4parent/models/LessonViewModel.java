package com.netcracker.sd4alexanderrodko.sd4parent.models;

public class LessonViewModel {
    private long id;
    private String timeStart;
    private String timeEnd;
    private String description;
    private String room;
    private String type;
    private TeacherViewModel teacher;

    public LessonViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
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
}
