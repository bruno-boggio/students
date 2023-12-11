package com.hibernate.CrudHibernate.modules.Student.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.CrudHibernate.modules.Course.repository.CourseEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional <StudentEntity> findByUsernameOrEmail(String username, String email);

    List<StudentEntity> findByCourse(CourseEntity course);
}
