package com.hibernate.CrudHibernate.modules.Student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hibernate.CrudHibernate.modules.Student.repository.StudentEntity;
import com.hibernate.CrudHibernate.modules.Student.useCases.CreateStudentUseCase;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private CreateStudentUseCase createStudentUseCase;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> students = createStudentUseCase.getAllStudents();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
        Optional<StudentEntity> student = createStudentUseCase.getStudentById(id);
        return student.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody StudentEntity studentEntity) {
        try {
            StudentEntity result = createStudentUseCase.createStudent(studentEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentEntity updatedStudent) {
        StudentEntity updated = createStudentUseCase.updateStudent(id, updatedStudent);
        if (updated != null) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        createStudentUseCase.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
