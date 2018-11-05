package com.netcracker.sd4alexanderrodko.sd4parent.models;


public class StudentViewModel {


    private long number;
    private String firstName;
    private String lastName;
    private Long groupNumber;
    private AccountViewModel account;

    public StudentViewModel() {
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

    public AccountViewModel getAccount() {
        return account;
    }

    public void setAccount(AccountViewModel accountID) {
        this.account = accountID;
    }
}
