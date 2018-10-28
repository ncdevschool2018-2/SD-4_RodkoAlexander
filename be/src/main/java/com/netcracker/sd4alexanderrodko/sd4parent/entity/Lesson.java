package com.netcracker.sd4alexanderrodko.sd4parent.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @OneToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;


    @Type(type = "timestamp")
    private Date start;
    @Type(type = "timestamp")
    private Date end;


    @OneToMany(mappedBy="lesson")
    private List<StudentVisit> students;
    private String lessonType;
    private String room;
    private String description;



    @ManyToMany(mappedBy = "lessons")
    private List<StudentGroup> groups;
}
