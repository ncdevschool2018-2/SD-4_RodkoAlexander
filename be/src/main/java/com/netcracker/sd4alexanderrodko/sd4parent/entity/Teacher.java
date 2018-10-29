package com.netcracker.sd4alexanderrodko.sd4parent.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;

    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "surname", length = 255, nullable = false)
    private String surname;

    @OneToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;


    public Teacher() {

    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return number == teacher.number &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(surname, teacher.surname) &&
                Objects.equals(account, teacher.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, surname, account);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("number=").append(number);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", account=").append(account);
        sb.append('}');
        return sb.toString();
    }
}
