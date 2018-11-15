package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Service
public class StudentGroupDataServiceImpl implements StudentGroupDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${groups.server.url}")
    private String groupsServerUrl;

    @Override
    public List<StudentGroupViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        StudentGroupViewModel[] studentGroupViewModels = restTemplate.getForObject(backendServerUrl + groupsServerUrl, StudentGroupViewModel[].class);
        return studentGroupViewModels == null ? Collections.emptyList() : Arrays.asList(studentGroupViewModels);
    }

    @Override
    public StudentGroupViewModel getStudentGroupById(Long id) {
        return null;
    }

    @Override
    public StudentGroupViewModel saveStudentGroup(StudentGroupViewModel studentGroupViewModel) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + groupsServerUrl, studentGroupViewModel, StudentGroupViewModel.class).getBody();

    }

    @Override
    public void deleteStudentGroup(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + groupsServerUrl + "/" + id);
    }

    @Override
    public List<Long> getNumbers() {
        RestTemplate restTemplate = new RestTemplate();
        Long[] numbers = restTemplate.getForObject(backendServerUrl + groupsServerUrl + "/numbers", Long[].class);
        return numbers == null ? Collections.emptyList() : Arrays.asList(numbers);
    }

    @Override
    public List<StudentGroupViewModel> getDescriptions() {
        RestTemplate restTemplate = new RestTemplate();
        StudentGroupViewModel[] numbers = restTemplate.getForObject(backendServerUrl + groupsServerUrl + "/descriptions", StudentGroupViewModel[].class);
        return numbers == null ? Collections.emptyList() : Arrays.asList(numbers);
    }

    @Override
    public List<UserViewModel> getStudents(long groupNumber) {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userViewModels = restTemplate.getForObject(backendServerUrl + groupsServerUrl + "/" + groupNumber + "/students", UserViewModel[].class);
        return userViewModels == null ? Collections.emptyList() : Arrays.asList(userViewModels);
    }


}
