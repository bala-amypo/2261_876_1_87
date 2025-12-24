package com.example.demo.service.impl;

import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;

public class ActivityTypeServiceImpl implements ActivityTypeService {
    private final ActivityCategoryRepository categoryRepository;
    private final ActivityTypeRepository typeRepository;

    public ActivityTypeServiceImpl(ActivityCategoryRepository categoryRepository, ActivityTypeRepository typeRepository) {
        this.categoryRepository = categoryRepository;
        this.typeRepository = typeRepository;
    }
}