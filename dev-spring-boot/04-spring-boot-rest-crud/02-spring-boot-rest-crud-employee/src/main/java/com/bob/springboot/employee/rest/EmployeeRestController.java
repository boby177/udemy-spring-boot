package com.bob.springboot.employee.rest;

import com.bob.springboot.employee.entity.Employee;
import com.bob.springboot.employee.service.EmployeeService;
import com.bob.springboot.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // Inject employee DAO (use constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeServiceImpl theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // Expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployee() {
        return employeeService.findAll();
    }
}
