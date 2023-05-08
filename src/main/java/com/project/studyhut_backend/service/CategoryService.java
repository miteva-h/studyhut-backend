package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.dtos.CategoryDto;
import com.project.studyhut_backend.model.dtos.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> listAllCategories();
    Category createCategory(String name);
    Optional<Category> deleteCategory(Integer id);
    Optional<Category> editCategory(Integer id, CategoryDto categoryDto);
}
