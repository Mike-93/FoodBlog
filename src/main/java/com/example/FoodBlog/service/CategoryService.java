package com.example.FoodBlog.service;


import com.example.FoodBlog.models.Category;
import com.example.FoodBlog.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void addCategory(Category category) {
        Category newCategory = new Category();
        newCategory.setTitle(category.getTitle());
        newCategory.setText(category.getText());
        newCategory.setImage(category.getImage());
        categoryRepository.save(newCategory);
    }

    public Category getCategory(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException(""));
        return category;
    }

    public boolean editCategory(int id, Category category) {
        Category newCategory = categoryRepository.findById(id).orElse(null);
        if (newCategory != null) {
            newCategory.setTitle(category.getTitle());
            newCategory.setText(category.getText());
            newCategory.setImage(category.getImage());
            categoryRepository.save(newCategory);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteCategory(int id) {
        categoryRepository.deleteById(id);
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            return false;
        } else {
            return true;
        }
    }

    public List<Category> getAllCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        List<Category> categoriesList = new ArrayList<>();
        for (Category category : categories) {
            categoriesList.add(category);
        }
        return categoriesList;
    }


}
