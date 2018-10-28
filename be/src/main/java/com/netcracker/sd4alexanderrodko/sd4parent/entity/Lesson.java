package com.netcracker.sd4alexanderrodko.sd4parent.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;


    @Type(type = "timestamp")
    private Date timeStart;

    @Type(type = "timestamp")
    private Date timeEnd;

    private String description;

    @OneToOne
    private Teacher teacher;

    private String lessonType;

    private String room;

    @OneToMany(
            mappedBy = "lesson",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Visit> visits;

    @ManyToMany
    private List<Group> groups;

    public Lesson() {
    }

}
