package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.repository.ActivityTypeRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factors")
@Tag(name = "Emission Factors")
public class EmissionFactorController {

    private final EmissionFactorRepository factorRepository;
    private final ActivityTypeRepository typeRepository;

    public EmissionFactorController(EmissionFactorRepository factorRepository,
                                    ActivityTypeRepository typeRepository) {
        this.factorRepository = factorRepository;
        this.typeRepository = typeRepository;
    }

    @PostMapping("/{activityTypeId}")
    public EmissionFactor createFactor(@PathVariable Long activityTypeId,
                                       @RequestBody EmissionFactor factor) {
        factor.setActivityType(
                typeRepository.findById(activityTypeId)
                        .orElseThrow(() -> new RuntimeException("Activity type not found"))
        );
        return factorRepository.save(factor);
    }

    @GetMapping("/{id}")
    public EmissionFactor getFactor(@PathVariable Long id) {
        return factorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factor not found"));
    }

    @GetMapping("/type/{activityTypeId}")
    public EmissionFactor getFactorByType(@PathVariable Long activityTypeId) {
        return factorRepository.findByActivityTypeId(activityTypeId)
                .orElseThrow(() -> new RuntimeException("Factor not found"));
    }

    @GetMapping
    public List<EmissionFactor> getAllFactors() {
        return factorRepository.findAll();
    }
}
