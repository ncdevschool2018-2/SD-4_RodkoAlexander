package com.netcracker.sd4alexanderrodko.sd4parent.models;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StudentViewModel {

    @NotNull
    @Valid
    private AccountViewModel account;
    @NotNull
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
