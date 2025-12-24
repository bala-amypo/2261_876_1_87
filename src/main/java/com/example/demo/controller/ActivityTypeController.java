package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity-types")
public class ActivityTypeController {

    private final ActivityTypeService activityTypeService;

    public ActivityTypeController(ActivityTypeService activityTypeService) {
        this.activityTypeService = activityTypeService;
    }

    // CREATE ACTIVITY TYPE
    @PostMapping
    public ResponseEntity<ActivityType> createActivityType(
            @RequestBody ActivityType activityType) {
        ActivityType saved = activityTypeService.createActivityType(activityType);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET ALL ACTIVITY TYPES
    @GetMapping
    public ResponseEntity<List<ActivityType>> getAllActivityTypes() {
        return ResponseEntity.ok(activityTypeService.getAllActivityTypes());
    }

    // GET ACTIVITY TYPES BY CATEGORY ID
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getByCategory(
            @PathVariable Long categoryId) {
        return ResponseEntity.ok(
                activityTypeService.getActivityTypesByCategory(categoryId)
        );
    }
}
