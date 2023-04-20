package com.project.studyhut_backend.model.dtos;

import com.project.studyhut_backend.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ComplaintDto {
    private LocalDateTime dateTimeCreated;
    private String content;
    private boolean isSolved;
    private User username;

    public ComplaintDto(){}

    public ComplaintDto(LocalDateTime dateTimeCreated, String content, boolean isSolved, User username){
        this.dateTimeCreated=dateTimeCreated;
        this.content=content;
        this.isSolved=isSolved;
        this.username=username;
    }
}