package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.LessonViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.models.VisitViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class VisitDataServiceImpl implements VisitDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${visits.server.url}")
    private String studentsVisitsServerUrl;


    @Override
    public Iterable<VisitViewModel> getAll(Long groupId,Long lessonId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<VisitViewModel[]> forEntity = restTemplate.getForEntity(backendServerUrl + studentsVisitsServerUrl + "?groupId=" + groupId + "&lessonId=" + lessonId, VisitViewModel[].class);
        VisitViewModel[] visitViewModels = forEntity.getBody();
        return visitViewModels == null ? Collections.emptyList() : Arrays.asList(visitViewModels);
    }

    @Override
    public Iterable<VisitViewModel> saveVisit(Iterable<VisitViewModel> visits) {
        RestTemplate restTemplate = new RestTemplate();
        VisitViewModel[] responseEntity = restTemplate.postForEntity(backendServerUrl + studentsVisitsServerUrl, visits, VisitViewModel[].class).getBody();
        return responseEntity == null ? Collections.emptyList() : Arrays.asList(responseEntity);
    }
}
