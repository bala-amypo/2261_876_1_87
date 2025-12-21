package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository activityTypeRepository;

    public ActivityTypeServiceImpl(ActivityTypeRepository activityTypeRepository) {
        this.activityTypeRepository = activityTypeRepository;
    }

    @Override
    public ActivityType createActivityType(ActivityType type) {
        return activityTypeRepository.save(type);
    }

    @Override
    public List<ActivityType> getAllActivityTypes() {
        return activityTypeRepository.findAll();
    }
}
