package com.hibernate.CrudHibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hibernate.CrudHibernate.entity.Student;
import com.hibernate.CrudHibernate.entity.dao.StudentDAO;

@SpringBootApplication
public class CrudHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudHibernateApplication.class, args);}

        @Bean
        public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
            return runner -> {
              //  createStudent(studentDAO);

              createmultipleStudents(studentDAO);
            };
        }

        private void createmultipleStudents(StudentDAO studentDAO) {

            // create multiple students
             System.out.println("Creating 3 student object...");
             Student tempStudent1 = new Student("Jhon", "Doe", "jhon@gmail.com");
             Student tempStudent2 = new Student("Law", "jesi", "law@gmail.com");
             Student tempStudent3 = new Student("Mary", "carl", "mary@gmail.com");
            // save the students
             studentDAO.save(tempStudent1);
             studentDAO.save(tempStudent2);
             studentDAO.save(tempStudent3);

        }




        private void createStudent(StudentDAO studentDAO) {
            // create the student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");
            // save the student object
            System.out.println("Saving the student object...");
            studentDAO.save(tempStudent);
            // display id of the saved student
            System.out.println("Saved student. Generated id: " + tempStudent.getId());
        }
}