package com.bob.springboot.thymeleafdemo.controller;

import com.bob.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // Create a new student object
        Student theStudent = new Student();

        // Add student object to the model
        theModel.addAttribute("student", theStudent);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudent(@ModelAttribute("student") Student theStudent) {

        // Log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " "
                + theStudent.getLastName());

        return "student-confirmation";
    }
}
