package com.netcracker.sd4alexanderrodko.sd4parent.models;

public class StudentViewModel {

    private AccountViewModel account;
    private long groupId;

    public StudentViewModel() {
    }


    public AccountViewModel getAccount() {
        return account;
    }

    public void setAccount(AccountViewModel account) {
        this.account = account;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
