package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.exception.CourseNotFoundException;
import com.project.studyhut_backend.exception.PostNotFoundException;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.repository.CourseRepository;
import com.project.studyhut_backend.repository.PostRepository;
import com.project.studyhut_backend.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CourseRepository courseRepository;

    public PostServiceImpl(PostRepository postRepository, CourseRepository courseRepository) {
        this.postRepository = postRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Post findById(Integer id) {
        return this.postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    @Override
    public List<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(String keywords, String title, String notes, LocalDateTime dateTime, Course course, User user) {
        Post post = new Post(keywords, title, notes, dateTime, course, user);
        return this.postRepository.save(post);
    }

    @Override
    public List<Post> searchByCourse(Integer courseId) {
        Course course = this.courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);
        return this.postRepository.findByCourse(course);
    }

    @Override
    public List<Post> searchByKeywords(String keywords) {
        return this.postRepository.findByKeywords(keywords);
    }
}
