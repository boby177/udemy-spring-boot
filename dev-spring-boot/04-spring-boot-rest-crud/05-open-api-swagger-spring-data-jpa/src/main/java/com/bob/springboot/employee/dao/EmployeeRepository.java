package com.bob.springboot.employee.dao;

import com.bob.springboot.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // That's it, no need to write any code anymore
    // Spring data JPA will handle it
}
