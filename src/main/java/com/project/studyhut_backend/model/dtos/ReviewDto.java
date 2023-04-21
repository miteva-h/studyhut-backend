package com.project.studyhut_backend.model.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDto {
    private LocalDateTime dateTimeCreated;
    private String reviewText;
    private int rating;
    private Integer userId;
    private Integer postId;

    public ReviewDto(){}

    public ReviewDto(LocalDateTime dateTimeCreated,
                     String reviewText,
                     int rating,
                     Integer userId,
                     Integer postId){
        this.dateTimeCreated=dateTimeCreated;
        this.reviewText=reviewText;
        this.rating=rating;
        this.userId=userId;
        this.postId=postId;
    }
}
