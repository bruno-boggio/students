package com.hibernate.CrudHibernate.entity.dao;

import java.util.List;

import com.hibernate.CrudHibernate.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
