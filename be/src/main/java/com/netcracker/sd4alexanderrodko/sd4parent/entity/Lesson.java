package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "lessons")
public class Lesson {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String teacher;
    private String room;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    private String subject;
    private String who;
    private String lessonType;
    private String time;




    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson that = (Lesson) o;
        return id == that.id &&
                Objects.equals(date.toString(), that.date.toString()) &&
                Objects.equals(teacher, that.teacher) &&
                Objects.equals(room, that.subject) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(who, that.who) &&
                Objects.equals(lessonType,that.lessonType) &&
                Objects.equals(time,that.time);
    }

    @Override
    public int hashCode() {


        return Objects.hash(id, date, teacher, room, subject, who,lessonType,time);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", teacher='" + teacher + '\'' +
                ", room='" + room + '\'' +
                ", subject='" + subject + '\'' +
                ", who='" + who + '\'' +
                ", lessonType='" + lessonType + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public Lesson() {
    }

}
