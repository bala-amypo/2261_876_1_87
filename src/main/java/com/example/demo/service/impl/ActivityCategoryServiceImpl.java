package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import java.util.List;

public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository repository;

    // ORDER MATTERS
    public ActivityCategoryServiceImpl(ActivityCategoryRepository repository) {
        this.repository = repository;
    }

    public ActivityCategory createCategory(ActivityCategory category) {
        if (repository.existsByCategoryName(category.getCategoryName())) {
            throw new ValidationException("Category name must be unique");
        }
        return repository.save(category);
    }

    public ActivityCategory getCategory(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public List<ActivityCategory> getAllCategories() {
        return repository.findAll();
    }
}
