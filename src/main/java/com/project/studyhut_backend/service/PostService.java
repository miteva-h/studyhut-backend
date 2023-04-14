package com.project.studyhut_backend.service;

import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.User;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public interface PostService {
    List<Post> listAllPosts();
    Post createPost(String keywords, String title, String notes, LocalDateTime dateTime, Course course, User user);
}
