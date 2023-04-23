package com.project.studyhut_backend.web;


import com.project.studyhut_backend.model.Category;
import com.project.studyhut_backend.model.Course;
import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.Review;
import com.project.studyhut_backend.model.dtos.PostDto;
import com.project.studyhut_backend.service.PostService;
import com.project.studyhut_backend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final ReviewService reviewService;

    @GetMapping
    public List<Post> getAllPosts() {
        return this.postService.listAllPosts();
    }

    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        Post createdPost = postService.createPost(postDto.getKeywords(), postDto.getTitle(), postDto.getNotes(), postDto.getDateTime(), postDto.getCourseId(), postDto.getUserId());
        if (createdPost == null) {
            return ResponseEntity.badRequest().build();
        }
        PostDto createdPostDto = convertToDto(createdPost);
        return ResponseEntity.ok().body(createdPostDto);
    }

    private PostDto convertToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setKeywords(post.getKeywords());
        postDto.setTitle(post.getTitle());
        postDto.setNotes(post.getNotes());
        postDto.setDateTime(post.getDateTime());
        postDto.setCourseId(post.getCourse().getCourseID());
        postDto.setUserId(post.getUser().getUserID());
        return postDto;
    }

    @GetMapping("/{id}/reviews")
    public List<Review> listAllReviews(@PathVariable Integer id) {
        Post post = this.postService.findById(id);
        return this.reviewService.listAllReviewsInPost(post);
    }

    @GetMapping("/searchByCourse")
    public List<Post> searchByCourse(@RequestParam Integer courseId) {
        return this.postService.searchByCourse(courseId);
    }

    @GetMapping("/searchByKeywords")
    public List<Post> searchByKeywords(@RequestParam String keywords) {
        return this.postService.searchByKeywords(keywords);
    }
}
