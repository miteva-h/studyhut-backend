package com.project.studyhut_backend.repository;

import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findByCourse(Course course);
    List<Post> findByKeywordsLikeAndCourse_CourseID(String keywords, Integer courseId);
}
