package com.netcracker.sd4alexanderrodko.sd4parent.service.impl;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Lesson;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.User;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.LessonRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.repository.StudentGroupRepository;
import com.netcracker.sd4alexanderrodko.sd4parent.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Component
public class StudentGroupServiceImpl implements StudentGroupService {

    private StudentGroupRepository studentGroupRepository;
    private LessonRepository lessonRepository;

    @Autowired
    public StudentGroupServiceImpl(StudentGroupRepository studentGroupRepository, LessonRepository lessonRepository) {
        this.studentGroupRepository = studentGroupRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public StudentGroup saveStudentGroup(StudentGroup studentGroup) {
        return studentGroupRepository.save(studentGroup);
    }

    @Override
    public void deleteStudentGroup(Long id) {
        studentGroupRepository.deleteById(id);
    }

    @Override
    public List<StudentGroup> getDescriptionsPage(Pageable page) {
        return studentGroupRepository.getDescriptionsPage(page);
    }

    @Override
    public List<StudentGroup> getDescriptions() {
        return studentGroupRepository.getDescriptions();
    }


    @Override
    public Optional<StudentGroup> getGroupWithStudentsById(long id) {
        return studentGroupRepository.getGroupWithStudentsById(id);
    }

    @Override
    public List<Lesson> getLessonsById(long id, Date dateFrom, Date dateTo) {
        Optional<StudentGroup> gr = studentGroupRepository.getGroupWithStudentsById(id);
        if (gr.isPresent()) {
            return lessonRepository.getLessonsByGroupIdByOrderByTimeStart(gr.get(), dateFrom, dateTo);
        } else return Collections.emptyList();
    }

    @Override
    public List<User> getStudentsById(long id) {
        return studentGroupRepository.getStudentsFromGroupById(id);
    }

    @Override
    public long count() {
        return studentGroupRepository.count();
    }

    @Override
    public Iterable<StudentGroup> findById(Long number) {
        return studentGroupRepository.getGroupByNumber(number+"");
    }

    @Override
    public Iterable<StudentGroup> findByCourse(Integer course) {
        return studentGroupRepository.findByCourse(course);
    }
}
