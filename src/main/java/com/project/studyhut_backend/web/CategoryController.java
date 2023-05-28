package com.project.studyhut_backend.web;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Complaint;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.model.dtos.CategoryDto;
import com.project.studyhut_backend.model.dtos.ComplaintDto;
import com.project.studyhut_backend.model.dtos.CourseDto;
import com.project.studyhut_backend.service.CategoryService;
import com.project.studyhut_backend.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<Category> categories = categoryService.listAllCategories();
        List<CategoryDto> categoryDtos = categories.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categoryDtos);
    }

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.createCategory(categoryDto.getName());
        CategoryDto createdCategoryDto = convertToDto(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoryDto);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Category> editCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        return this.categoryService.editCategory(id, categoryDto)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {
        return this.categoryService.deleteCategory(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    private CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setId(category.getCategoryID());
        return categoryDto;
    }
}
