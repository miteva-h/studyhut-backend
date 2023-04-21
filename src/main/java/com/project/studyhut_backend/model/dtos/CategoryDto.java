package com.project.studyhut_backend.model.dtos;

import lombok.Data;

@Data
public class CategoryDto {
    private String name;

    public CategoryDto(){}

    public CategoryDto(String name){
        this.name=name;
    }
}
