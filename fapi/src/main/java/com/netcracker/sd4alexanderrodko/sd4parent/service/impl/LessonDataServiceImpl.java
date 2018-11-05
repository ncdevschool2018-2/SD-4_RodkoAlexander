package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;


import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
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

    @Value("${lessons.server.url}")
    private String lessonServerUrl;


    @Override
    public List<LessonViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        LessonViewModel[] lessonViewModels = restTemplate
                .getForObject(backendServerUrl + lessonServerUrl, LessonViewModel[].class);
        return lessonViewModels == null ? Collections.emptyList() : Arrays.asList(lessonViewModels);
    }

    @Override
    public LessonViewModel getLessonById(Long id) {
        return null;
    }

    @Override
    public LessonViewModel saveLesson(LessonViewModel lessonViewModel) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + lessonServerUrl,
                lessonViewModel, LessonViewModel.class).getBody();
    }

    @Override
    public void deleteLesson(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + lessonServerUrl + "/" + id);
    }
}