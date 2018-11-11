package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class StudentDataServiceImpl implements StudentDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${students.server.url}")
    private String studentsServerUrl;

    @Override
    public List<StudentViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        StudentViewModel[] studentViewModels = restTemplate.getForObject(backendServerUrl + studentsServerUrl, StudentViewModel[].class);
        return studentViewModels == null ? Collections.emptyList() : Arrays.asList(studentViewModels);
    }

    @Override
    public StudentViewModel getStudentById(Long id) {
        return null;
    }

    @Override
    public StudentViewModel saveStudent(StudentViewModel studentViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + studentsServerUrl, studentViewModel, StudentViewModel.class).getBody();
    }

    @Override
    public StudentViewModel saveStudentWithAccount(StudentViewModel studentViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + studentsServerUrl +"/save", studentViewModel, StudentViewModel.class).getBody();
    }

    @Override
    public void deleteStudent(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + studentsServerUrl + "/" + id);
    }
}
