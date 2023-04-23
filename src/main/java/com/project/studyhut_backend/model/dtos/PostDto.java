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
    private String dateTime;
    private Integer courseId;
    private Integer userId;

    public PostDto(){}

    public PostDto(String keywords, String title, String notes, String dateTime, Integer courseId, Integer userId){
        this.keywords=keywords;
        this.title=title;
        this.notes=notes;
        this.dateTime=dateTime;
        this.courseId=courseId;
        this.userId=userId;
    }

}
