package com.bob.springboot.employee.service;

import com.bob.springboot.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteById(int id);
}
