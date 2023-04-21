package com.project.studyhut_backend.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException() {
        super("Course not found.");
    }
}
