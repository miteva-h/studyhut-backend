package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Complaint;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.Review;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.model.dtos.ReviewDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> listAllReviewsInPost(Post post);
    Optional<Review> createReview(String dateTimeCreated, String reviewText, int rating, User user, Post post);
}
