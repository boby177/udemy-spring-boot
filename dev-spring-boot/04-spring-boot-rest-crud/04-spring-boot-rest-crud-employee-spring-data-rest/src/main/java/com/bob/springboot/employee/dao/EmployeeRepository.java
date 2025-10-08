package com.bob.springboot.employee.dao;

import com.bob.springboot.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // That's it, no need to write any code anymore
    // Spring data JPA will handle it
}
