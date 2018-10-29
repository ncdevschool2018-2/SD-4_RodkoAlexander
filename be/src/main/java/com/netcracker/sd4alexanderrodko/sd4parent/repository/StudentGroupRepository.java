package com.netcracker.sd4alexanderrodko.sd4parent.repository;

import com.netcracker.sd4alexanderrodko.sd4parent.entity.Student;
import com.netcracker.sd4alexanderrodko.sd4parent.entity.StudentGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;


@Repository
public interface StudentGroupRepository extends CrudRepository<StudentGroup, Long> {

}
