package com.example.demo.service;

import com.example.demo.entity.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    ActivityType createActivityType(ActivityType activityType);

    List<ActivityType> getActivityTypesByCategory(Long categoryId);
}
