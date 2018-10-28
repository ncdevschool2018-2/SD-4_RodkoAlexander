package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StudentVisit implements Serializable {

    @Id
    private long studId;
    @Id
    private long lsId;


    @Column(name="is_visit")
    private boolean isVisit;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="student", referencedColumnName="id")
    /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
     * please comment out the @PrimaryKeyJoinColumn, and use the ff:
     * @JoinColumn(name = "employeeId", updatable = false, insertable = false)
     * or @JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "id")
     */
    private Student student;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="lesson", referencedColumnName="id")
    /* the same goes here:
     * if this JPA model doesn't create a table for the "PROJ_EMP" entity,
     * please comment out the @PrimaryKeyJoinColumn, and use the ff:
     * @JoinColumn(name = "projectId", updatable = false, insertable = false)
     * or @JoinColumn(name = "projectId", updatable = false, insertable = false, referencedColumnName = "id")
     */
    private Lesson lesson;

}
