package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import org.springframework.data.repository.query.Param;

import java.io.File;
import java.util.List;

public interface CourseService {
    List<Course> listAllCourses();
    Course createCourse(String name, File picture, List<Category> categories);
    List<Course> filterByCategory(@Param("categories") List<Category> categories);
}
