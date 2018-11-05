package com.netcracker.sd4alexanderrodko.sd4parent.models;

public class TeacherViewModel {
    private long number;
    private String firstName;
    private String lastName;
    private AccountViewModel account;

    public TeacherViewModel() {
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

    public AccountViewModel getAccount() {
        return account;
    }

    public void setAccount(AccountViewModel account) {
        this.account = account;
    }
}
