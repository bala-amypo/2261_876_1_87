package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity-category")
public class ActivityCategoryController {

    @Autowired
    private ActivityCategoryService categoryService;

    @PostMapping("/create")
    public ActivityCategory createCategory(@RequestBody ActivityCategory category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/all")
    public List<ActivityCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ActivityCategory getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }
}
