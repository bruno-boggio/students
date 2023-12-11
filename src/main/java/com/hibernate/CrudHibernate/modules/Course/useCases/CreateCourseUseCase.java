package com.hibernate.CrudHibernate.modules.Course.useCases;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.CrudHibernate.modules.Course.repository.CourseEntity;
import com.hibernate.CrudHibernate.modules.Course.repository.CourseRepository;

import jakarta.validation.Valid;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<CourseEntity> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public CourseEntity createCourse(@Valid CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }

    public CourseEntity updateCourse(Long id, @Valid CourseEntity updatedCourse) {
        if (courseRepository.existsById(id)) {
            updatedCourse.setId(id);
            return courseRepository.save(updatedCourse);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
