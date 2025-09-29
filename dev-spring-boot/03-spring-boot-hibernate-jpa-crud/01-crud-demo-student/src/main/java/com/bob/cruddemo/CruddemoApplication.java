package com.bob.cruddemo;

import com.bob.cruddemo.dao.StudentDAO;
import com.bob.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRuner(StudentDAO studentDAO) {

        return runner -> {
            // createStudent(studentDAO);
            // createMultipleStudents(studentDAO);

            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        // Create a student object
        System.out.println("Createing a new student ...");
        Student tempStudent = new Student("Michael", "Joshua", "michaels.josh@gmail.com");

        // Save the student
        System.out.println("Saving data student ...");
        studentDAO.save(tempStudent);

        // Display id of the saved student
        int studentId = tempStudent.getId();
        System.out.println("Saved student. Generate id: " + studentId);

        // Retrieve student basen od the id: primary key
        System.out.println("Retrieving student by id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // Display student data
        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // Create the student object
        System.out.println("Creating multiple student object ...");
        Student tempStudent1 = new Student("John", "Doe", "john.due@gmail.com");
        Student tempStudent2 = new Student("Miller", "John", "miller@gmail.com");
        Student tempStudent3 = new Student("Yamada", "Tanaka", "yamada.tan@gmail.com");

        // Save the student objects
        System.out.println("Saving the students data ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // Create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Boby", "Ms", "boby.ms378@gmail.com");

        // Save the student object
        System.out.println("Saving the student data ...");
        studentDAO.save(tempStudent);

        // Display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
