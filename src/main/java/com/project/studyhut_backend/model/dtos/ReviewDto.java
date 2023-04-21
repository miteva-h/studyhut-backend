package com.project.studyhut_backend.model.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDto {
    private LocalDateTime dateTimeCreated;
    private String reviewText;
    private int rating;
    private String username;
    private String post;

    public ReviewDto(){}

    public ReviewDto(LocalDateTime dateTimeCreated,
                     String reviewText,
                     int rating,
                     String username,
                     String post){
        this.dateTimeCreated=dateTimeCreated;
        this.reviewText=reviewText;
        this.rating=rating;
        this.username=username;
        this.post=post;
    }
}
