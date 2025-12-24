package com.example.demo.service.serviceimpl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.ActivityLogService;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;
    private final EmissionFactorService emissionFactorService;

    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository,
                                  EmissionFactorService emissionFactorService) {
        this.activityLogRepository = activityLogRepository;
        this.emissionFactorService = emissionFactorService;
    }

    @Override
    public ActivityLog logActivity(ActivityLog activityLog) {

        if (activityLog.getActivityDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("Activity date cannot be in the future");
        }

        EmissionFactor factor = emissionFactorService
                .getEmissionFactorByActivityType(
                        activityLog.getActivityType().getId());

        double emission = activityLog.getQuantity() * factor.getFactorValue();
        activityLog.setEstimatedEmission(emission);

        return activityLogRepository.save(activityLog);
    }

    @Override
    public List<ActivityLog> getUserActivities(Long userId) {
        return activityLogRepository.findByUserId(userId);
    }
}
