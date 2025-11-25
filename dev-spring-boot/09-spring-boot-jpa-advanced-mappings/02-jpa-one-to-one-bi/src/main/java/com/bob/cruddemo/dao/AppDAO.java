package com.bob.cruddemo.dao;

import com.bob.cruddemo.entity.Instructor;
import com.bob.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructionDetailById(int theId);
}
