package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.dtos.CourseDto;
import org.springframework.data.repository.query.Param;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> listAllCourses();
    Optional<Course> createCourse(String name, String picture, List<Integer> categoryIds);
    List<Course> filterByCategory(@Param("categories") List<Integer> categories);
    Optional<Course> editCourse(Integer id, CourseDto courseDto);
    Optional<Course> deleteCourse(Integer id);
}
