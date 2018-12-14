package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "lessons", schema = "backend")
public class Lesson {
    private long id;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private Subject subject;
    private String room;
    private String type;
    private User teacher;
    private Collection<StudentGroup> groups;

    public Lesson() {
    }


    @ManyToMany(
            fetch = FetchType.EAGER
    )
    public Collection<StudentGroup> getGroups() {
        return groups;
    }

    public void setGroups(Collection<StudentGroup> groups) {
        this.groups = groups;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "time_start", nullable = true)
    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }


    @Column(name = "time_end", nullable = true)
    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }


    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    @Column(name = "room", nullable = true, length = 256)
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }


    @Column(name = "type", nullable = true, length = 256)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeStart, timeEnd, room, type);
    }

    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

}
