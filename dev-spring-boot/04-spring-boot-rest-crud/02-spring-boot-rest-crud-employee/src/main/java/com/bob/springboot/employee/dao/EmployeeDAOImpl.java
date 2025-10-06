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

    @Override
    public Employee findById(int id) {

        // Get employee
        Employee theEmployee = entityManager.find(Employee.class, id);

        // Return data employee
        return theEmployee;
    }

    @Override
    // Don't need use @Transactional, because will be handled on service
    public Employee save(Employee theEmployee) {

        // Save new employee
        Employee dbEmployee = entityManager.merge(theEmployee); // if id == 0 it will be insert data else update existing employee

        // Return the db employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {

        // Find employee by id
        Employee theEmployee = entityManager.find(Employee.class, id);

        // Remove employee
        entityManager.remove(theEmployee);
    }
}
