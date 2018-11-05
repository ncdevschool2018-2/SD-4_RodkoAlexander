package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.TeacherViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.TeacherDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TeacherDataServiceImpl implements TeacherDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${teachers.server.url}")
    private String teacherServerUrl;

    @Override
    public List<TeacherViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        TeacherViewModel[] teacherViewModels = restTemplate.getForObject(backendServerUrl + teacherServerUrl, TeacherViewModel[].class);
        return teacherViewModels == null ? Collections.emptyList() : Arrays.asList(teacherViewModels);
    }

    @Override
    public TeacherViewModel getTeacherById(Long id) {
        return null;
    }

    @Override
    public TeacherViewModel saveTeacher(TeacherViewModel teacherViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + teacherServerUrl, teacherViewModel, TeacherViewModel.class).getBody();

    }

    @Override
    public void deleteTeacher(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + teacherServerUrl + "/" + id);
    }
}
