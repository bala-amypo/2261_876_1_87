package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    // LOG ACTIVITY (CALCULATES EMISSION)
    @PostMapping("/user/{userId}/type/{typeId}")
    public ResponseEntity<ActivityLog> logActivity(
            @PathVariable Long userId,
            @PathVariable Long typeId,
            @RequestBody ActivityLog log) {

        ActivityLog created =
                activityLogService.logActivity(userId, typeId, log);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // GET LOGS BY USER
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityLog>> getLogsByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                activityLogService.getLogsByUser(userId));
    }

    // GET LOGS BY USER + DATE RANGE
    @GetMapping("/user/{userId}/range")
    public ResponseEntity<List<ActivityLog>> getLogsByUserAndDate(
            @PathVariable Long userId,
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return ResponseEntity.ok(
                activityLogService.getLogsByUserAndDate(userId, start, end));
    }
}
