package com.example.demo.controller;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Activity Logs")
public class ActivityLogController {

    private final ActivityLogService service;

    public ActivityLogController(ActivityLogService service) {
        this.service = service;
    }

    @PostMapping("/{userId}/{typeId}")
    public ActivityLog logActivity(@PathVariable Long userId,
                                   @PathVariable Long typeId,
                                   @RequestBody ActivityLogRequest request) {

        ActivityLog log = new ActivityLog();
        log.setQuantity(request.getQuantity());
        log.setActivityDate(request.getActivityDate());

        return service.logActivity(userId, typeId, log);
    }

    @GetMapping("/user/{userId}/range")
    public List<ActivityLog> getByUserAndDate(@PathVariable Long userId,
                                              @RequestParam LocalDate start,
                                              @RequestParam LocalDate end) {
        return service.getLogsByUserAndDate(userId, start, end);
    }

    @GetMapping("/{id}")
    public ActivityLog get(@PathVariable Long id) {
        return service.getLog(id);
    }
}
