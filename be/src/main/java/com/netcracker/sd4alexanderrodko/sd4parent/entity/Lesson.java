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
    private String description;
    private String room;
    private String type;
    private User teacher;
    private Collection<StudentGroup> groups;

    public Lesson() {
    }


    @ManyToMany(
            fetch = FetchType.LAZY
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

    @Basic
    @Column(name = "time_start", nullable = true)
    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    @Basic
    @Column(name = "time_end", nullable = true)
    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 256)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "room", nullable = true, length = 256)
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 256)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeStart, timeEnd, description, room, type);
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
