package com.project.studyhut_backend.web;


import com.project.studyhut_backend.model.Post;
import com.project.studyhut_backend.model.dtos.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService=postService;
    }

    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        Post post = new Post();
        post.setKeywords(postDto.getKeywords());
        post.setTitle(postDto.getTitle());
        post.setNotes(postDto.getNotes());
        post.setDateTime(postDto.getDateTime());
        post.setCourse(postDto.getCourse());
        post.setUser(postDto.getUsername());

        Post createdPost = postService.createPost(post);

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
        postDto.setCourse(post.getCourse());
        postDto.setUsername(post.getUser());
        return postDto;
    }
}
