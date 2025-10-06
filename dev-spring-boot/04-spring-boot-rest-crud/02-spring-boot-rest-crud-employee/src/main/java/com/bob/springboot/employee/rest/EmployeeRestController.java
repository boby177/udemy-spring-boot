package com.bob.springboot.employee.rest;

import com.bob.springboot.employee.entity.Employee;
import com.bob.springboot.employee.service.EmployeeService;
import com.bob.springboot.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // New endpoint GET employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
           throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // New endpoint POST add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0); // we set on employee is private int id

        // but if set private Integer id, the employee id is:
        // theEmployee.setId(null)

        Employee newEmployee = employeeService.save(theEmployee);

        return newEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        // Using same method on save as add new employee endpoint
        Employee updateEmployee = employeeService.save(theEmployee);

        return updateEmployee;
    }
}
