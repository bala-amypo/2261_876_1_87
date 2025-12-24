package com.example.demo.service.serviceimpl;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository emissionFactorRepository;
    private final ActivityTypeRepository activityTypeRepository;

    public EmissionFactorServiceImpl(EmissionFactorRepository emissionFactorRepository,
                                     ActivityTypeRepository activityTypeRepository) {
        this.emissionFactorRepository = emissionFactorRepository;
        this.activityTypeRepository = activityTypeRepository;
    }

    @Override
    public EmissionFactor addEmissionFactor(EmissionFactor emissionFactor) {
        ActivityType activityType = activityTypeRepository
                .findById(emissionFactor.getActivityType().getId())
                .orElseThrow(() -> new RuntimeException("Activity type not found"));

        emissionFactor.setActivityType(activityType);
        return emissionFactorRepository.save(emissionFactor);
    }

    @Override
    public EmissionFactor getEmissionFactorByActivityType(Long activityTypeId) {
        return emissionFactorRepository.findByActivityTypeId(activityTypeId)
                .orElseThrow(() -> new RuntimeException("Emission factor not found"));
    }
}
