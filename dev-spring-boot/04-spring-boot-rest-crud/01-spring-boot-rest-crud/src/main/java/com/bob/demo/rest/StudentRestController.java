package com.bob.demo.rest;

import com.bob.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // Define @PostConstruct to load the student data ... just once !
    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Boby", "Ms"));
        theStudents.add(new Student("Catherine", "Rin"));
        theStudents.add(new Student("Marry", "Madd"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getAllStudent() {

        return theStudents;
    }

    // Define endpoint "/student/{studentId}" - return student by index
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // Check the studentId on list size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}
