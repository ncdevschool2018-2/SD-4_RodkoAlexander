package com.netcracker.sd4alexanderrodko.sd4parent.entity;


import javax.persistence.*;

@Entity
@Table(name = "subjects", schema = "backend")
public class Subject {

    private long id;
    private String abbreviation;
    private String fullName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "abbreviation", nullable = false)
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }


    @Column(name = "fullName", nullable = false, length = 256)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
