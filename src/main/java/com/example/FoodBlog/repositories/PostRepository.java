package com.example.FoodBlog.repositories;

import com.example.FoodBlog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository <Post, Integer> {
}
