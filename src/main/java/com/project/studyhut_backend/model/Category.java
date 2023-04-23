package com.project.studyhut_backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryID;
    private String name;
//    @ManyToMany(mappedBy = "categories")
//    private List<Course> courses;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }

    public void setName(String name) {
        this.name = name;
    }
}
