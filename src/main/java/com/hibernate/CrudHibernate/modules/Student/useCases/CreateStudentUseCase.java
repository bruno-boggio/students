package com.hibernate.CrudHibernate.modules.Student.useCases;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.CrudHibernate.modules.Course.repository.CourseEntity;
import com.hibernate.CrudHibernate.modules.Student.repository.StudentEntity;
import com.hibernate.CrudHibernate.modules.Student.repository.StudentRepository;



@Service 
public class CreateStudentUseCase {
    
    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity execute (StudentEntity studentEntity){
     this.studentRepository.findByUsernameOrEmail(studentEntity.getUsername(), studentEntity.getEmail()).ifPresent((user)-> {
      throw new IllegalArgumentException("User already exists");
        });
      return  this.studentRepository.save(studentEntity);       
    }

     public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public StudentEntity createStudent(StudentEntity studentEntity) {
        validateUsernameAndEmail(studentEntity.getUsername(), studentEntity.getEmail());
        return studentRepository.save(studentEntity);
    }

    public StudentEntity updateStudent(Long id, StudentEntity updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id);
            validateUsernameAndEmail(updatedStudent.getUsername(), updatedStudent.getEmail());
            return studentRepository.save(updatedStudent);
        }
        return null;
    }

    private void validateUsernameAndEmail(String username, String email) {
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<StudentEntity> getStudentsByCourse(CourseEntity course) {
        return studentRepository.findByCourse(course);
    }

    
}
