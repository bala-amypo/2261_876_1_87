package com.example.demo.repository;

import com.example.demo.entity.ActivityType;
import java.util.List;
import java.util.Optional;

public interface ActivityTypeRepository {
    ActivityType save(ActivityType activityType);
    Optional<ActivityType> findById(Long id);
    List<ActivityType> findByCategory_Id(Long categoryId);
}