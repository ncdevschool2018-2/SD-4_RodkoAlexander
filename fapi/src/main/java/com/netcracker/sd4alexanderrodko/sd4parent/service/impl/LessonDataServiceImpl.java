package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.LessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.LessonDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class LessonDataServiceImpl implements LessonDataService {


    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public List<LessonViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        LessonViewModel[] lessonViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/lessons/", LessonViewModel[].class);
        return lessonViewModelResponse == null ? Collections.emptyList() : Arrays.asList(lessonViewModelResponse);
    }

    @Override
    public LessonViewModel getLessonById(Long id) {
        return null;
    }

    @Override
    public LessonViewModel saveLesson(LessonViewModel lessonViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/lessons", lessonViewModel, LessonViewModel.class).getBody();
    }

    @Override
    public void deleteLesson(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/lessons/" + id);
    }
}
