package com.example.FoodBlog.controllers;

import com.example.FoodBlog.models.Category;
import com.example.FoodBlog.models.Post;
import com.example.FoodBlog.service.CategoryService;
import com.example.FoodBlog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final PostService postService;

    @PostMapping("/category")
    public ResponseEntity addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity editCategory(@PathVariable int id, @RequestBody Category category) {
        final boolean updated = categoryService.editCategory(id, category);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity categoryRemove(@PathVariable int id) {
        final boolean deleted = categoryService.deleteCategory(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> showCategory(@PathVariable int id) {
        Category category = categoryService.getCategory(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoryList = categoryService.getAllCategories();
        if (categoryList != null && !categoryList.isEmpty()) {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/{id}/list")
    public ResponseEntity<List<Category>> getPostsByCategory(@PathVariable int id) {
        List<Post> postList = postService.getPostsByCategory(id);
        if (postList != null && !postList.isEmpty()) {
            return new ResponseEntity(postList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
