package com.hibernate.CrudHibernate;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.hibernate.CrudHibernate.entity.dao.StudentDAO;

@SpringBootApplication
public class CrudHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudHibernateApplication.class, args);}

        @Bean
        public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
            return runner -> {
              //  createStudent(studentDAO);

              // createmultipleStudents(studentDAO);

              // readStudent(studentDAO);

              // queryForStudents(studentDAO);

              // updateStudent(studentDAO);

              // deleteStudent(studentDAO);

              deleteAllStudents(studentDAO);
            };
        }

        private void deleteAllStudents(StudentDAO studentDAO) {
            System.out.println("Deleting all students...");
            int numRowsDeleted = studentDAO.deleteAll();
            System.out.println("Deleted row count: " + numRowsDeleted);
        }

        // private void deleteStudent(StudentDAO studentDAO) {
        //     int studentId = 3;
        //     System.out.println("Deleting the student: " + studentId);
        //     studentDAO.delete(studentId);
        // }

        // private void updateStudent(StudentDAO studentDAO) {
        //     // retrieve student by id
        //     int studentId = 1;
        //     System.out.println("Getting student with id :" + studentId);
        //     Student myStudent = studentDAO.findById(studentId);
        //     // change first name
        //     System.out.println("Updating student");
        //     myStudent.setFirstName("brian");
        //     // update the student
        //     studentDAO.update(myStudent);
        //     // display the updated student
        //     System.out.println("Updated student: " + myStudent);
        // }




        // private void queryForStudents(StudentDAO studentDAO){
                
        //     // get a list of students
        //     List<Student> theStudents = studentDAO.findAll();
            
        //     // display list of students
        //     for (Student tempStudent : theStudents){
        //         System.out.println(tempStudent);
        //     }

        //    } 

        // private void readStudent(StudentDAO studentDAO) {
        //     // create a student object
        //     System.out.println("Creating new student");
        //     Student tempStudent4 = new Student("bruno", "lopes", "bruno@hotmail.com");
        //     // save the student
        //     System.out.println("Saving the student ...");
        //     studentDAO.save(tempStudent4);
        //     // display id of the saved student
        //     int theId = tempStudent4.getId();
        //     System.out.println("Saved student. Generated id: " + theId);
        //     // retrieve student based on the id: primary key
        //     System.out.println("Retrieving student with id " + theId);
        //     Student myStudent = studentDAO.findById(theId);
        //     // display student
        //     System.out.println("Student: " + myStudent);
        // }

        // private void createmultipleStudents(StudentDAO studentDAO) {

        //     // create multiple students
        //      System.out.println("Creating 3 student object...");
        //      Student tempStudent1 = new Student("Jhon", "Doe", "jhon@gmail.com");
        //      Student tempStudent2 = new Student("Law", "jesi", "law@gmail.com");
        //      Student tempStudent3 = new Student("Mary", "carl", "mary@gmail.com");
        //     // save the students
        //      studentDAO.save(tempStudent1);
        //      studentDAO.save(tempStudent2);
        //      studentDAO.save(tempStudent3);

        // }




        // private void createStudent(StudentDAO studentDAO) {
        //     // create the student object
        //     System.out.println("Creating new student object...");
        //     Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");
        //     // save the student object
        //     System.out.println("Saving the student object...");
        //     studentDAO.save(tempStudent);
        //     // display id of the saved student
        //     System.out.println("Saved student. Generated id: " + tempStudent.getId());
        // }
}
