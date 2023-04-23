package com.project.studyhut_backend.web;

import com.project.studyhut_backend.model.Complaint;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.Review;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.model.dtos.ComplaintDto;
import com.project.studyhut_backend.model.dtos.ReviewDto;
import com.project.studyhut_backend.service.PostService;
import com.project.studyhut_backend.service.ReviewService;
import com.project.studyhut_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final UserService userService;
    private final PostService postService;

//    @PostMapping("/create")
//    public ResponseEntity<Review> createReview(@RequestBody ReviewDto reviewDto) {
//        User user = this.userService.findById(reviewDto.getUserId());
//        Post post = this.postService.findById(reviewDto.getPostId());
//        return this.reviewService.createReview(reviewDto.getDateTimeCreated(), reviewDto.getReviewText(), reviewDto.getRating(), user, post)
//                .map(review -> ResponseEntity.ok().body(review))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }
}
