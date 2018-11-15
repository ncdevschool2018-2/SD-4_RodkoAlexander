package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${users.server.url}")
    private String userServerUrl;

    @Override
    public List<UserViewModel> getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userViewModels = restTemplate.getForObject(backendServerUrl + userServerUrl, UserViewModel[].class);
        return userViewModels == null ? Collections.emptyList() : Arrays.asList(userViewModels);
    }

    @Override
    public Optional<UserViewModel> getUserById(Long id) {
        return null;
    }

    @Override
    public UserViewModel saveUser(UserViewModel userViewModel) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + userServerUrl, userViewModel, UserViewModel.class).getBody();
    }

    @Override
    public void deleteUser(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + userServerUrl + "/" + id);
    }

    @Override
    public Iterable<UserViewModel> getStudents() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userViewModels = restTemplate.getForObject(backendServerUrl + userServerUrl + "/students", UserViewModel[].class);
        return userViewModels == null ? Collections.emptyList() : Arrays.asList(userViewModels);
    }

    @Override
    public Iterable<UserViewModel> getTeachers() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userViewModels = restTemplate.getForObject(backendServerUrl + userServerUrl + "/teachers", UserViewModel[].class);
        return userViewModels == null ? Collections.emptyList() : Arrays.asList(userViewModels);
    }

    @Override
    public Iterable<UserViewModel> getAdministrators() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userViewModels = restTemplate.getForObject(backendServerUrl + userServerUrl + "/administrators", UserViewModel[].class);
        return userViewModels == null ? Collections.emptyList() : Arrays.asList(userViewModels);
    }
}
