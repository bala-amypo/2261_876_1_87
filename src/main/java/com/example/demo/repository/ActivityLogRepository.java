package com.example.demo.repository;

import com.example.demo.entity.ActivityLog;
import java.time.LocalDate;
import java.util.List;

public interface ActivityLogRepository {
    ActivityLog save(ActivityLog activityLog);
    List<ActivityLog> findByUser_IdAndActivityDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
    List<ActivityLog> findByUser_Id(Long userId);
}