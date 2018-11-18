package com.netcracker.sd4alexanderrodko.sd4parent.entity;

public class Student {
    private Account account;
    private long groupId;

    public Student() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

}
