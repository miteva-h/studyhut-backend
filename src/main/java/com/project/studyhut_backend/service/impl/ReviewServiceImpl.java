package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.model.Complaint;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.Review;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.repository.PostRepository;
import com.project.studyhut_backend.repository.ReviewRepository;
import com.project.studyhut_backend.service.PostService;
import com.project.studyhut_backend.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, PostRepository postRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> listAllReviewsInPost(Post post) {
        return this.reviewRepository.findReviewsByPost(post);
    }

    @Override
    public Optional<Review> createReview(LocalDateTime dateTimeCreated, String reviewText, int rating, User user, Post post) {
        Review review = new Review(dateTimeCreated, reviewText, rating, user, post);
        this.reviewRepository.save(review);
        return Optional.of(review);
    }
}
