package com.example.demo.service.serviceimpl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository typeRepository;
    private final ActivityCategoryRepository categoryRepository;

    public ActivityTypeServiceImpl(ActivityTypeRepository typeRepository,
                                   ActivityCategoryRepository categoryRepository) {
        this.typeRepository = typeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ActivityType createActivityType(ActivityType activityType) {
        ActivityCategory category = categoryRepository
                .findById(activityType.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        activityType.setCategory(category);
        return typeRepository.save(activityType);
    }

    @Override
    public List<ActivityType> getActivityTypesByCategory(Long categoryId) {
        return typeRepository.findByCategoryId(categoryId);
    }
}
