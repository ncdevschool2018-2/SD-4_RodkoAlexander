package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupToLessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupToLessonDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class StudentGroupToLessonDataServiceImpl implements StudentGroupToLessonDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${gvisits.server.url}")
    private String groupsVisitsServerUrl;


    @Override
    public List<StudentGroupToLessonViewModel> getAll() {

        RestTemplate restTemplate = new RestTemplate();
        StudentGroupToLessonViewModel[] studentGroupToLessonViewModels = restTemplate.getForObject(backendServerUrl + groupsVisitsServerUrl, StudentGroupToLessonViewModel[].class);
        return studentGroupToLessonViewModels == null ? Collections.emptyList() : Arrays.asList(studentGroupToLessonViewModels);
    }

    @Override
    public StudentGroupToLessonViewModel getStudentGroupToLessonById(Long id) {
        return null;
    }

    @Override
    public StudentGroupToLessonViewModel saveStudentGroupToLesson(StudentGroupToLessonViewModel studentGroupToLessonViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + groupsVisitsServerUrl, studentGroupToLessonViewModel, StudentGroupToLessonViewModel.class).getBody();

    }

    @Override
    public void deleteStudentGroupToLesson(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + groupsVisitsServerUrl + "/" + id);
    }
}
