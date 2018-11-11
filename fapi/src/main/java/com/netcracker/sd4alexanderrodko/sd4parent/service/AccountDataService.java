package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;

import java.util.List;

public interface AccountDataService {

    List<AccountViewModel> getAll();
    AccountViewModel getAccountById(Long id);
    AccountViewModel saveAccount(AccountViewModel accountViewModel);
    void deleteAccount(Long id);
}
