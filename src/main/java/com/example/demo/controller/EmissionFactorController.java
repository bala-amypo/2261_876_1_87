package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {
    private final EmissionFactorService factorService;

    public EmissionFactorController(EmissionFactorService factorService) {
        this.factorService = factorService;
    }

    @PostMapping("/type/{typeId}")
    public EmissionFactor createFactor(@PathVariable Long typeId, @RequestBody EmissionFactor factor) {
        return factorService.createFactor(typeId, factor);
    }

    @GetMapping
    public List<EmissionFactor> getAllFactors() {
        return factorService.getAllFactors();
    }

    @GetMapping("/{id}")
    public EmissionFactor getFactor(@PathVariable Long id) {
        return factorService.getFactor(id);
    }

    @GetMapping("/type/{typeId}")
    public EmissionFactor getFactorByType(@PathVariable Long typeId) {
        return factorService.getFactorByType(typeId);
    }
}
