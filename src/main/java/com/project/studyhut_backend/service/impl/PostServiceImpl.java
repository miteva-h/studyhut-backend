package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.exception.CourseNotFoundException;
import com.project.studyhut_backend.exception.PostNotFoundException;
import com.project.studyhut_backend.exception.UserNotFoundException;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.repository.CourseRepository;
import com.project.studyhut_backend.repository.PostRepository;
import com.project.studyhut_backend.repository.UserRepository;
import com.project.studyhut_backend.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
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
    public Post createPost(String keywords, String title, String notes, String dateTime, Integer courseId, Integer userId) {
        Course course = this.courseRepository.findById(courseId).orElseThrow(CourseNotFoundException::new);
        User user = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss.SSS");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime, formatter);
        Post post = new Post(keywords, title, notes, parsedDateTime, course, user);
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
