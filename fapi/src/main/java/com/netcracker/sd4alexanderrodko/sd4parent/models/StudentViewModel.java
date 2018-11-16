package com.netcracker.sd4alexanderrodko.sd4parent.models;

public class StudentViewModel {

    private AccountViewModel account;
    private long groupNumber;

    public StudentViewModel() {
    }


    public AccountViewModel getAccount() {
        return account;
    }

    public void setAccount(AccountViewModel account) {
        this.account = account;
    }

    public long getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(long groupNumber) {
        this.groupNumber = groupNumber;
    }
}
