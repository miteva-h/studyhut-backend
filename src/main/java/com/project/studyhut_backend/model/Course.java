package com.project.studyhut_backend.model;

import jakarta.persistence.*;

import java.io.File;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseID;
    private String name;
    private String picture;

//    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Category> categories;

    public Course() {
    }

    public Course(String name, String picture, List<Category> categories) {
        this.name = name;
        this.picture = picture;
        this.categories = categories;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
