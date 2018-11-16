package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;

import java.util.List;

public interface AccountDataService {

    List<AccountViewModel> getAll();

    AccountViewModel getAccountById(Long id);

    AccountViewModel saveAccount(AccountViewModel accountViewModel);

    AccountViewModel saveStudent(StudentViewModel studentViewModel);

    void deleteAccount(Long id);

    long count();
}
