package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class StudentGroupDataServiceImpl implements StudentGroupDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${groups.server.url}")
    private String groupsServerUrl;


    @Override
    public StudentGroupViewModel saveStudentGroup(StudentGroupViewModel studentGroupViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + groupsServerUrl, studentGroupViewModel, StudentGroupViewModel.class).getBody();
    }

    @Override
    public void deleteStudentGroup(Long number) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + groupsServerUrl + "/" + number);
    }

    @Override
    public List<StudentGroupViewModel> getDescriptions(Integer page, Integer size) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StudentGroupViewModel[]> forEntity = restTemplate.getForEntity(backendServerUrl + groupsServerUrl + "/descriptions" + "?page=" + page + "&size=" + size, StudentGroupViewModel[].class);
        StudentGroupViewModel[] numbers = forEntity.getBody();
        return numbers == null ? Collections.emptyList() : Arrays.asList(numbers);

    }

    @Override
    public List<StudentGroupViewModel> findByGroupNumber(String groupNumber) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StudentGroupViewModel[]> forEntity = restTemplate.getForEntity(backendServerUrl + groupsServerUrl + "/descriptions" + "?number=" + groupNumber, StudentGroupViewModel[].class);
        StudentGroupViewModel[] numbers = forEntity.getBody();
        return numbers == null ? Collections.emptyList() : Arrays.asList(numbers);
    }

    @Override
    public Long count() {
        return new RestTemplate().getForEntity(
                backendServerUrl + groupsServerUrl + "/count",
                Long.class)
                .getBody();
    }

    @Override
    public List<StudentGroupViewModel> findGroupsByCourse(Integer course) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StudentGroupViewModel[]> forEntity = restTemplate.getForEntity(backendServerUrl + groupsServerUrl + "/descriptions" + "?course=" + course, StudentGroupViewModel[].class);
        StudentGroupViewModel[] numbers = forEntity.getBody();
        return numbers == null ? Collections.emptyList() : Arrays.asList(numbers);
    }
}
