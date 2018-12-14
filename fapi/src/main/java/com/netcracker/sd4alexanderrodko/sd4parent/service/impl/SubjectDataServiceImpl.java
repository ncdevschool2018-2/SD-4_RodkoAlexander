package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;


import com.netcracker.sd4alexanderrodko.sd4parent.models.SubjectViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.SubjectDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubjectDataServiceImpl implements SubjectDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Value("${subjects.server.url}")
    private String subjectsServerUrl;

    @Override
    public SubjectViewModel saveSubjectViewModel(SubjectViewModel subject) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + subjectsServerUrl, subject, SubjectViewModel.class).getBody();
    }

    @Override
    public void deleteSubject(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + subjectsServerUrl + "/" + id);
    }

    @Override
    public List<SubjectViewModel> getPage(Integer page,Integer size) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SubjectViewModel[]> forEntity = restTemplate.getForEntity(backendServerUrl + subjectsServerUrl +  "?page=" + page + "&size=" + size,SubjectViewModel[].class);
        SubjectViewModel[] subjectViewModels = forEntity.getBody();
        return subjectViewModels == null ? Collections.emptyList() : Arrays.asList(subjectViewModels);
    }

    @Override
    public List<SubjectViewModel> findByAbbreviation(String abbreviation) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SubjectViewModel[]> forEntity = restTemplate.getForEntity(backendServerUrl + subjectsServerUrl +  "?abb=" + abbreviation,SubjectViewModel[].class);
        SubjectViewModel[] subjectViewModels = forEntity.getBody();
        return subjectViewModels == null ? Collections.emptyList() : Arrays.asList(subjectViewModels);
    }

    @Override
    public Long count() {
        return new RestTemplate().getForEntity(
                backendServerUrl + subjectsServerUrl + "/count",
                Long.class)
                .getBody();
    }
}
