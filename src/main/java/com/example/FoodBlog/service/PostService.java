package com.example.FoodBlog.service;

import com.example.FoodBlog.models.Post;
import com.example.FoodBlog.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    public void addPost(Post post) {
        Post newPost = new Post();
        newPost.setTitle(post.getTitle());
        newPost.setText(post.getText());
        newPost.setImage(post.getImage());
        newPost.setCategory(post.getCategory());
        postRepository.save(newPost);
    }

    public List<Post> getAllPosts() {
        Iterable<Post> posts = postRepository.findAll();
        List<Post> postList = new ArrayList<>();
        for (Post post : posts) {
            postList.add(post);
        }
        return postList;
    }

    public Post getPost(int id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
        return post;
    }

    public boolean editPost(int id, Post post) {
        Post newPost = postRepository.findById(id).orElse(null);
        if (newPost != null) {
            newPost.setTitle(post.getTitle());
            newPost.setText(post.getText());
            newPost.setImage(post.getImage());
            newPost.setCategory(post.getCategory());
            postRepository.save(newPost);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePost(int id) {
        postRepository.deleteById(id);
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            return false;
        } else {
            return true;
        }
    }

    public List<Post> getPostsByCategory(int categoryId) {
        Iterable<Post> posts = postRepository.findAll();
        List<Post> postList = new ArrayList<>();
        for (Post post : posts) {
            if (post.getCategory().getId() == categoryId) {
                postList.add(post);
            }
        }
        return postList;
    }

}
