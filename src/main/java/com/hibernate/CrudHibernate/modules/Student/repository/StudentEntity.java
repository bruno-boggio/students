package com.hibernate.CrudHibernate.modules.Student.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.hibernate.CrudHibernate.modules.Course.repository.CourseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    @NotBlank()
    @Pattern(regexp = "\\S+", message = "The [username] field must not contain spaces.")
    private String username;

    @Column(name = "email")
    @Email(message = "The (email) field must contain a valid email.")
    private String email;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    public StudentEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
