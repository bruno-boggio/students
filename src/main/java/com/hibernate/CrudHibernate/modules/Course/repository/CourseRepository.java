package com.hibernate.CrudHibernate.modules.Course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    
}


