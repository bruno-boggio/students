package com.hibernate.CrudHibernate.modules.Course.repository;

import java.util.List;

import com.hibernate.CrudHibernate.modules.Student.repository.StudentEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "course")
    private List<StudentEntity> students;
    
    public CourseEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
    