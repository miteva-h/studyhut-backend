package com.project.studyhut_backend.model.dtos;

import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private String keywords;
    private String title;
    private String notes;
    private LocalDateTime dateTime;
    private Course course;
    private User username;

    public PostDto(){}

    public PostDto(String keywords, String title, String notes, LocalDateTime dateTime, Course course, User username){
        this.keywords=keywords;
        this.title=title;
        this.notes=notes;
        this.dateTime=dateTime;
        this.course=course;
        this.username=username;
    }

}
