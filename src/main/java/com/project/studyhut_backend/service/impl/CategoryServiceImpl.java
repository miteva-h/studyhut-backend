package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.repository.CategoryRepository;
import com.project.studyhut_backend.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
