package com.bob.cruddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    // Define our fields


    // Define constructors


    // Define toString


    // Annotate fields

    private int id;

    private String title;

    private Instructor instructor;

    public Course() {

    }

    // Automatically generate constructors
    public Course(String title) {
        this.title = title;
    }

    // Automatically generate getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    // Automatically generate toString()
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
