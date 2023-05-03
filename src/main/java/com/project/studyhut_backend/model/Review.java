package com.project.studyhut_backend.model;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewID;
    private LocalDateTime dateTimeCreated;
    private String reviewText;
    private int rating;
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;

    public Review() {
    }

    public Review(LocalDateTime dateTimeCreated, String reviewText, int rating, User user, Post post) {
        this.dateTimeCreated = dateTimeCreated;
        this.reviewText = reviewText;
        this.rating = rating;
        this.user = user;
        this.post = post;
    }

    public Integer getReviewID() {
        return reviewID;
    }

    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(LocalDateTime dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
