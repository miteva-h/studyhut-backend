package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Complaint;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.Review;
import com.project.studyhut_backend.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewService {
    List<Review> listAllReviewsInPost(Post post);
    Review createReview(LocalDateTime dateTimeCreated, String reviewText, int rating, User user, Post post);
}