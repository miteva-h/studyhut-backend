package com.project.studyhut_backend.web;

import com.project.studyhut_backend.service.ComplaintService;
import com.project.studyhut_backend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

}
