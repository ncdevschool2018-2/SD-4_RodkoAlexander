package com.netcracker.sd4alexanderrodko.sd4parent.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentViewModel {
    private long number;
    private String firstName;
    private String lastName;
    private long groupNumber;
    private long accountId;

    public StudentViewModel() {
    }

    public StudentViewModel(long number, String firstName, String lastName, long groupNumber, long accountId) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNumber = groupNumber;
        this.accountId = accountId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(long groupNumber) {
        this.groupNumber = groupNumber;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
