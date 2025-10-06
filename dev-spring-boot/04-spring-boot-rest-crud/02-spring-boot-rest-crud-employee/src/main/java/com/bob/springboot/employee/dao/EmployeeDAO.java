package com.bob.springboot.employee.dao;

import com.bob.springboot.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteById(int id);
}
