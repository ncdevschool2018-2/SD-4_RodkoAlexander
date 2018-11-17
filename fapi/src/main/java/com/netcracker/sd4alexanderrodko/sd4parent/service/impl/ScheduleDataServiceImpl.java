package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;


import com.netcracker.sd4alexanderrodko.sd4parent.models.LessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.ScheduleDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ScheduleDataServiceImpl implements ScheduleDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${groups.server.url}")
    private String groupsServerUrl;

    @Value("${lessons.server.url}")
    private String lessonsServerUrl;


    @Override
    public List<LessonViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        LessonViewModel[] lessonViewModels = restTemplate
                .getForObject(backendServerUrl + lessonsServerUrl, LessonViewModel[].class);
        return lessonViewModels == null ? Collections.emptyList() : Arrays.asList(lessonViewModels);
    }


    @Override
    public LessonViewModel saveLesson(LessonViewModel lessonViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + lessonsServerUrl,
                lessonViewModel, LessonViewModel.class).getBody();
    }

    @Override
    public void deleteLesson(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + lessonsServerUrl + "/" + id);
    }

    @Override
    public List<LessonViewModel> getLessonsByTeacherId(long teacherId) {
        RestTemplate restTemplate = new RestTemplate();
        LessonViewModel[] lessonViewModels = restTemplate
                .getForObject(backendServerUrl + lessonsServerUrl + "/teacher/" + teacherId, LessonViewModel[].class);
        return lessonViewModels == null ? Collections.emptyList() : Arrays.asList(lessonViewModels);
    }

    @Override
    public List<LessonViewModel> getLessonsByGroupId(long groupId) {
        RestTemplate restTemplate = new RestTemplate();
        LessonViewModel[] lessonViewModels = restTemplate
                .getForObject(backendServerUrl + groupsServerUrl +"/" +groupId+"/lessons", LessonViewModel[].class);
        return lessonViewModels == null ? Collections.emptyList() : Arrays.asList(lessonViewModels);
    }
}