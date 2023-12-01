package com.hibernate.CrudHibernate.entity.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.CrudHibernate.entity.Student;

import jakarta.persistence.EntityManager;


@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;


    //inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional // anot used to perform an update
    public void save(Student thestudent) {
        entityManager.persist(thestudent); // saving student;
    }   
    
}
