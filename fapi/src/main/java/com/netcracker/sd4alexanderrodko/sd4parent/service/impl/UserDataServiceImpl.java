package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.UserViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Value("${users.server.url}")
    private String usersServerUrl;
    @Value("${students.addition.uri}")
    private String studentsAdditionUri;
    @Value("${groups.server.url}")
    private String groupsServerUrl;

    @Override
    public AccountViewModel getEmployerById(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForEntity(backendServerUrl + usersServerUrl + "/" + id, AccountViewModel.class).getBody();
    }

    @Override
    public AccountViewModel saveEmployer(AccountViewModel accountViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + usersServerUrl, accountViewModel, AccountViewModel.class).getBody();
    }

    @Override
    public AccountViewModel saveStudent(StudentViewModel studentViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + usersServerUrl + studentsAdditionUri, studentViewModel, AccountViewModel.class).getBody();
    }


    @Override
    public void deleteStudent(long groupId, long studentId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + usersServerUrl + studentsAdditionUri+ "/" + groupId + "/" +studentId);
    }

    @Override
    public void deleteEmployer(long employerId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + usersServerUrl + studentsAdditionUri +"/" + employerId);
    }

    @Override
    public List<AccountViewModel> getEmployers() {
        RestTemplate restTemplate = new RestTemplate();
        AccountViewModel[] employers = restTemplate.getForObject(backendServerUrl + usersServerUrl +"/employers", AccountViewModel[].class);
        return employers == null ? Collections.emptyList() : Arrays.asList(employers);
    }

    @Override
    public List<AccountViewModel> getTeachers() {
        RestTemplate restTemplate = new RestTemplate();
        AccountViewModel[] teachers = restTemplate.getForObject(backendServerUrl + usersServerUrl  +"/teachers",AccountViewModel[].class);
        return teachers == null ? Collections.emptyList() : Arrays.asList(teachers);
    }

    @Override
    public List<UserViewModel> getStudentsFromGroup(long groupId) {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] students = restTemplate.getForObject(backendServerUrl + groupsServerUrl  +"/" +groupId+ "/students", UserViewModel[].class);
        return students == null ? Collections.emptyList() : Arrays.asList(students);
    }


}
