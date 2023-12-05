package com.hibernate.CrudHibernate.entity.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.CrudHibernate.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


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

    @Override
    public Student findById(Integer id) {
       return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query 
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        //update the student
        entityManager.merge(theStudent);    
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve a student
        Student theStudent = entityManager.find(Student.class, id);
        // delete a student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }   
    
    
    
}
