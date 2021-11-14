package com.example.FoodBlog.controllers;

import com.example.FoodBlog.models.Post;
import com.example.FoodBlog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity addPost(@RequestBody Post post) {
        postService.addPost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/post")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> postList = postService.getAllPosts();
        if (postList != null && !postList.isEmpty()) {
            return new ResponseEntity<>(postList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> showPost(@PathVariable int id) {
        Post post = postService.getPost(id);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/post/{id}")
    public ResponseEntity editPost(@PathVariable int id, @RequestBody Post post) {
        final boolean updated = postService.editPost(id, post);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity deletePost(@PathVariable int id) {
        final boolean deleted = postService.deletePost(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
