package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService categoryService;

    public ActivityCategoryController(ActivityCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // CREATE CATEGORY
    @PostMapping
    public ResponseEntity<ActivityCategory> createCategory(
            @RequestBody ActivityCategory category) {
        ActivityCategory saved = categoryService.createCategory(category);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET ALL CATEGORIES
    @GetMapping
    public ResponseEntity<List<ActivityCategory>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
