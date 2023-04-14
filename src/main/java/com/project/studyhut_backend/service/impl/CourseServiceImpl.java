package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.repository.CategoryRepository;
import com.project.studyhut_backend.repository.CourseRepository;
import com.project.studyhut_backend.service.CourseService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    public CourseServiceImpl(CourseRepository courseRepository, CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Course> listAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(String name, File picture, List<Category> categories) {
        Course course = new Course(name, picture, categories);
        return courseRepository.save(course);
    }

    @Override
    public List<Course> filterByCategory(List<Category> categories) {
        return courseRepository.findCoursesByCategories(categories);
    }
}
