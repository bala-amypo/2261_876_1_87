package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @Override
    public ActivityLog createActivityLog(ActivityLog log) {
        return activityLogRepository.save(log);
    }

    @Override
    public List<ActivityLog> getAllLogs() {
        return activityLogRepository.findAll();
    }
}
