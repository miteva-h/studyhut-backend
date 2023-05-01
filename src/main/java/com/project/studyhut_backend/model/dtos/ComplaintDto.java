package com.project.studyhut_backend.model.dtos;

import com.project.studyhut_backend.model.User;
import lombok.Data;


@Data
public class ComplaintDto {
    private String content;
    private User username;

    public ComplaintDto(){}

    public ComplaintDto(String content,User username){
        this.content=content;
        this.username=username;
    }
}