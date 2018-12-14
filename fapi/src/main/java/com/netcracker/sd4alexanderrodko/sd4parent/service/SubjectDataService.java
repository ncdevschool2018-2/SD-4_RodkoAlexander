package com.netcracker.sd4alexanderrodko.sd4parent.service;

import com.netcracker.sd4alexanderrodko.sd4parent.models.SubjectViewModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectDataService {
    SubjectViewModel saveSubjectViewModel(SubjectViewModel subject);

    void deleteSubject(Long id);

    List<SubjectViewModel> getPage(Integer page,Integer size);

    List<SubjectViewModel> findByAbbreviation(String abbreviation);

    Long count();
}
