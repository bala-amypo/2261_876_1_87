package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.ActivityLogService;

import java.time.LocalDate;
import java.util.List;

public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository logRepo;
    private final UserRepository userRepo;
    private final ActivityTypeRepository typeRepo;
    private final EmissionFactorRepository factorRepo;

    // ORDER MATTERS
    public ActivityLogServiceImpl(ActivityLogRepository logRepo,
                                  UserRepository userRepo,
                                  ActivityTypeRepository typeRepo,
                                  EmissionFactorRepository factorRepo) {
        this.logRepo = logRepo;
        this.userRepo = userRepo;
        this.typeRepo = typeRepo;
        this.factorRepo = factorRepo;
    }

    public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {

        if (log.getActivityDate().isAfter(LocalDate.now())) {
            throw new ValidationException("cannot be in the future");
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ActivityType type = typeRepo.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        EmissionFactor factor = factorRepo.findByActivityType_Id(typeId)
                .orElseThrow(() -> new ValidationException("No emission factor configured"));

        log.setUser(user);
        log.setActivityType(type);
        log.setEstimatedEmission(log.getQuantity() * factor.getFactorValue());

        return logRepo.save(log);
    }

    public List<ActivityLog> getLogsByUserAndDate(Long userId,
                                                  LocalDate start,
                                                  LocalDate end) {
        return logRepo.findByUser_IdAndActivityDateBetween(userId, start, end);
    }

    public ActivityLog getLog(Long id) {
        return logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
