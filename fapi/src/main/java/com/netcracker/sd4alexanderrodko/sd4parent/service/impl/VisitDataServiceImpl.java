package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.models.VisitViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.VisitDataService;
import org.springframework.beans.factory.annotation.Value;
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
    public List<VisitViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        VisitViewModel[] visitViewModels = restTemplate.getForObject(backendServerUrl + studentsVisitsServerUrl, VisitViewModel[].class);
        return visitViewModels == null ? Collections.emptyList() : Arrays.asList(visitViewModels);
    }

    @Override
    public VisitViewModel getVisitById(Long id) {
        return null;
    }

    @Override
    public VisitViewModel saveVisit(VisitViewModel visitViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + studentsVisitsServerUrl, visitViewModel, VisitViewModel.class).getBody();

    }

    @Override
    public void deleteVisit(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + studentsVisitsServerUrl + "/" + id);
    }
}
