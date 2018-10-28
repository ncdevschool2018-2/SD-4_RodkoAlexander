package com.netcracker.sd4alexanderrodko.sd4parent.entity;


import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    private long id;

    @Column(name="name", length = 255, nullable = false)
    private String name;


    @Column(name="surname", length = 255, nullable = false)
    private String surame;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Account account;
}
