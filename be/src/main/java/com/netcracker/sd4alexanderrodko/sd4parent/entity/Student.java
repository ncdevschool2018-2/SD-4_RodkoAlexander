package com.netcracker.sd4alexanderrodko.sd4parent.entity;

public class Student {
    private Account account;
    private long groupNumber;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(long groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("account=").append(account);
        sb.append(", groupNumber=").append(groupNumber);
        sb.append('}');
        return sb.toString();
    }
}
