package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/activity-log")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    @PostMapping("/log")
    public ActivityLog logActivity(@RequestParam Long userId,
                                   @RequestParam Long typeId,
                                   @RequestBody ActivityLog log) {
        return activityLogService.logActivity(userId, typeId, log);
    }

    @GetMapping("/user/{userId}")
    public List<ActivityLog> getLogsByUser(@PathVariable Long userId) {
        return activityLogService.getLogsByUser(userId);
    }

    @GetMapping("/user/{userId}/date-range")
    public List<ActivityLog> getLogsByUserAndDate(@PathVariable Long userId,
                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return activityLogService.getLogsByUserAndDate(userId, start, end);
    }
}
