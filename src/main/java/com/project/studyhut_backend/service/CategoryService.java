package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Category;
import java.util.List;
public interface CategoryService {
    List<Category> listAllCategories();
    Category createCategory(String name);
}
