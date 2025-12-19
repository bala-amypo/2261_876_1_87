package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository logRepository;
    private final UserRepository userRepository;
    private final ActivityTypeRepository typeRepository;
    private final EmissionFactorRepository factorRepository;

    public ActivityLogServiceImpl(ActivityLogRepository logRepository,
                                  UserRepository userRepository,
                                  ActivityTypeRepository typeRepository,
                                  EmissionFactorRepository factorRepository) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
        this.factorRepository = factorRepository;
    }

    @Override
    public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {

        if (log.getActivityDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("Activity date cannot be in the future");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ActivityType type = typeRepository.findById(typeId)
                .orElseThrow(() -> new RuntimeException("Activity type not found"));

        EmissionFactor factor = factorRepository.findByActivityTypeId(typeId)
                .orElseThrow(() -> new RuntimeException("Emission factor not found"));

        double estimatedEmission = log.getQuantity() * factor.getFactorValue();

        log.setUser(user);
        log.setActivityType(type);
        log.setEstimatedEmission(estimatedEmission);

        return logRepository.save(log);
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return logRepository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end) {
        return logRepository.findByUserId(userId).stream()
                .filter(log -> !log.getActivityDate().isBefore(start)
                        && !log.getActivityDate().isAfter(end))
                .toList();
    }

    @Override
    public ActivityLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity log not found"));
    }
}
