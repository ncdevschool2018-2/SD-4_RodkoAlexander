package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Lesson {
    private int lessonId;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private String description;
    private String lessonType;
    private String room;

    @Id
    @Column(name = "lesson_id", nullable = false)
    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    @Basic
    @Column(name = "time_start", nullable = false)
    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    @Basic
    @Column(name = "time_end", nullable = false)
    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "lesson_type", nullable = false, length = 255)
    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    @Basic
    @Column(name = "room", nullable = true, length = 255)
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return lessonId == lesson.lessonId &&
                Objects.equals(timeStart, lesson.timeStart) &&
                Objects.equals(timeEnd, lesson.timeEnd) &&
                Objects.equals(description, lesson.description) &&
                Objects.equals(lessonType, lesson.lessonType) &&
                Objects.equals(room, lesson.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId, timeStart, timeEnd, description, lessonType, room);
    }
}
