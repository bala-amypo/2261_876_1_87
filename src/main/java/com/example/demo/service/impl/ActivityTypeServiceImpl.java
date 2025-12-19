package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import java.util.List;

public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository typeRepo;
    private final ActivityCategoryRepository categoryRepo;

    // ORDER MATTERS
    public ActivityTypeServiceImpl(ActivityTypeRepository typeRepo,
                                   ActivityCategoryRepository categoryRepo) {
        this.typeRepo = typeRepo;
        this.categoryRepo = categoryRepo;
    }

    public ActivityType createType(Long categoryId, ActivityType type) {
        ActivityCategory category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        type.setCategory(category);
        return typeRepo.save(type);
    }

    public ActivityType getType(Long id) {
        return typeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepo.findByCategory_Id(categoryId);
    }
}
