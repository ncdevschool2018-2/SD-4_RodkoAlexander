package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;


@Entity
public class GroupsToLessons {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @OneToOne
    @JoinColumn(name = "group_id")
    private StudentGroup studentGroup;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

}
