package com.bob.cruddemo.dao;

import com.bob.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
