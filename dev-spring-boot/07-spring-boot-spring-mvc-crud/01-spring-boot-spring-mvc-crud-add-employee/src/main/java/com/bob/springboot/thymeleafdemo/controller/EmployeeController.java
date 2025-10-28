package com.bob.springboot.thymeleafdemo.controller;

import com.bob.springboot.thymeleafdemo.entity.Employee;
import com.bob.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // Add mapping for endpoint "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // Get the employees from DB
        List<Employee> theEmployees = employeeService.findAll();

        // Add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // Create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("employeeId") int theId, Model theModel) {
        // Get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // Set employee in the model to prepopulate the form
        theModel.addAttribute("employee", theEmployee);

        // Send over to our form
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {
        // Delete the employee
        employeeService.deleteById(theId);

        // Redirect to the list employee
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        // Save the new employee
        employeeService.save(theEmployee);

        // Use a redirect to prevent duplicate submission
        return "redirect:/employees/list";
    }
}
