package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentGroupToLessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.StudentToLessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentToLessonDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StudentToLessonDataServiceImpl implements StudentToLessonDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${svisits.server.url}")
    private String studentsVisitsServerUrl;

    @Override
    public List<StudentToLessonViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        StudentToLessonViewModel[] studentToLessonViewModels = restTemplate.getForObject(backendServerUrl + studentsVisitsServerUrl, StudentToLessonViewModel[].class);
        return studentToLessonViewModels == null ? Collections.emptyList() : Arrays.asList(studentToLessonViewModels);
    }

    @Override
    public StudentToLessonViewModel getStudentToLessonById(Long id) {
        return null;
    }

    @Override
    public StudentToLessonViewModel saveStudentToLesson(StudentToLessonViewModel studentToLessonViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + studentsVisitsServerUrl, studentToLessonViewModel, StudentToLessonViewModel.class).getBody();

    }

    @Override
    public void deleteStudentToLesson(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + studentsVisitsServerUrl + "/" + id);
    }
}
