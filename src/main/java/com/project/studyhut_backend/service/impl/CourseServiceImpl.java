package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.exception.CategoryNotFoundException;
import com.project.studyhut_backend.exception.CourseNotFoundException;
import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.dtos.CourseDto;
import com.project.studyhut_backend.repository.CategoryRepository;
import com.project.studyhut_backend.repository.CourseRepository;
import com.project.studyhut_backend.service.CourseService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Course> createCourse(String name, String picture, List<Integer> categoryIds) {
        List<Category> categories = new ArrayList<>();
        for(Integer id : categoryIds) {
            Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
            categories.add(category);
        }
        Course course = new Course(name, picture, categories);
        courseRepository.save(course);
        return Optional.of(course);
    }

    @Override
    public List<Course> filterByCategory(List<Integer> categories) {
        List<Category> list = new ArrayList<>();
        for(Integer id : categories) {
            Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
            list.add(category);
        }
        return courseRepository.findByCategoriesIn(list);
    }

    @Override
    public Optional<Course> editCourse(Integer id, CourseDto courseDto) {
        Course course = this.courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        course.setName(courseDto.getName());
        course.setPicture(courseDto.getPicture());
        List<Category> categories = new ArrayList<>();
        if(courseDto.getCategoryIds() != null) {
            for(Integer catId : courseDto.getCategoryIds()) {
                Category category = this.categoryRepository.findById(catId).orElseThrow(CategoryNotFoundException::new);
                categories.add(category);
            }
            course.setCategories(categories);
        }
        this.courseRepository.save(course);
        return Optional.of(course);
    }

    @Override
    public Optional<Course> deleteCourse(Integer id) {
        Course course = this.courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        this.courseRepository.delete(course);
        return Optional.of(course);
    }
}
