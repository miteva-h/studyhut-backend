package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.User;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public interface PostService {
    Post findById(Integer id);
    List<Post> listAllPosts();
    Post createPost(String keywords, String title, String notes, LocalDateTime dateTime, Course course, User user);
    List<Post> searchByCourse(Integer courseId);
    List<Post> searchByKeywords(String keywords);
}
