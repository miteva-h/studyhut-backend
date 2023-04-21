package com.project.studyhut_backend.model.dtos;

import com.project.studyhut_backend.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CourseDto {
    private String name;
    private String picture;
    private List<Category> categories;

    public CourseDto(){}

    public CourseDto(String name, String picture, List<Category> categories){
        this.name=name;
        this.picture=picture;
        this.categories=categories;
    }
}
