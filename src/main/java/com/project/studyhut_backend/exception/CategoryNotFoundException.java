package com.project.studyhut_backend.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
        super("Category not found.");
    }
}
