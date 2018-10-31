package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.AccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class AccountDataServiceImpl implements AccountDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${accounts.server.url}")
    private String accountsServerUrl;

    @Override
    public List<AccountViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        AccountViewModel[] accountViewModels = restTemplate.getForObject(backendServerUrl + accountsServerUrl, AccountViewModel[].class);
        return accountViewModels == null ? Collections.emptyList() : Arrays.asList(accountViewModels);
    }

    @Override
    public AccountViewModel getAccountById(Long id) {
        return null;
    }

    @Override
    public AccountViewModel saveAccount(AccountViewModel accountViewModel) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + accountsServerUrl, accountViewModel, AccountViewModel.class).getBody();
    }

    @Override
    public void deleteAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + accountsServerUrl + "/" + id);
    }

}
