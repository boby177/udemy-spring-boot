package com.bob.springboot.employee.dao;

import com.bob.springboot.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // Define field for entity manager
    private EntityManager entityManager;

    // Setup constructor injection
    @Autowired
    public EmployeeDAOImpl (EntityManager theEntitymanager) {
        entityManager = theEntitymanager;
    }

    @Override
    public List<Employee> findAll() {

        // Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // Execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // Return the results
        return employees;
    }
}
