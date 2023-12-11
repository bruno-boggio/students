package com.hibernate.CrudHibernate.modules.Course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hibernate.CrudHibernate.modules.Course.repository.CourseEntity;
import com.hibernate.CrudHibernate.modules.Course.useCases.CreateCourseUseCase;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @GetMapping
    public ResponseEntity<List<CourseEntity>> getAllCourses() {
        List<CourseEntity> courses = createCourseUseCase.getAllCourses();
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable Long id) {
        Optional<CourseEntity> course = createCourseUseCase.getCourseById(id);
        return course.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            CourseEntity result = createCourseUseCase.createCourse(courseEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseEntity updatedCourse) {
        CourseEntity updated = createCourseUseCase.updateCourse(id, updatedCourse);
        if (updated != null) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        createCourseUseCase.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
    


}
