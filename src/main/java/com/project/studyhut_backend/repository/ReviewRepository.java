package com.project.studyhut_backend.repository;

import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findReviewsByPost(Post post);
}
