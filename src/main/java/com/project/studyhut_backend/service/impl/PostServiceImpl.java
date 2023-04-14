package com.project.studyhut_backend.service.impl;

import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.User;
import com.project.studyhut_backend.repository.PostRepository;
import com.project.studyhut_backend.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> listAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(String keywords, String title, String notes, LocalDateTime dateTime, Course course, User user) {
        Post post = new Post(keywords, title, notes, dateTime, course, user);
        return postRepository.save(post);
    }
}
