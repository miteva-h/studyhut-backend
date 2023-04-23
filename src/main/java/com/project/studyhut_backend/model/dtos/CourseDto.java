package com.project.studyhut_backend.model.dtos;

import com.project.studyhut_backend.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CourseDto {
    private String name;
    private String picture;
    private List<Integer> categoryIds;

    public CourseDto(){}

    public CourseDto(String name, String picture, List<Integer> categoryIds){
        this.name=name;
        this.picture=picture;
        this.categoryIds=categoryIds;
    }
}
