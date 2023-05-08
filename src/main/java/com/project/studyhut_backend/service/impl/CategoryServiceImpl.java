package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.exception.CategoryNotFoundException;
import com.project.studyhut_backend.exception.CourseNotFoundException;
import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.dtos.CategoryDto;
import com.project.studyhut_backend.repository.CategoryRepository;
import com.project.studyhut_backend.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(String name) {
        Category category = new Category(name);
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> deleteCategory(Integer id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        this.categoryRepository.delete(category);
        return Optional.of(category);
    }

    @Override
    public Optional<Category> editCategory(Integer id, CategoryDto categoryDto) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        category.setName(categoryDto.getName());
        this.categoryRepository.save(category);
        return Optional.of(category);
    }
}
