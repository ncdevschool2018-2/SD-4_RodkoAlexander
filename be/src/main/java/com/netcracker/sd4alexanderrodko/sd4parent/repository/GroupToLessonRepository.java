package com.netcracker.sd4alexanderrodko.sd4parent.repository;


import com.netcracker.sd4alexanderrodko.sd4parent.entity.GroupToLesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupToLessonRepository extends CrudRepository<GroupToLesson,Long> {
}
