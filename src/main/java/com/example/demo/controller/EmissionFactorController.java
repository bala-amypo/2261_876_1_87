package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emission-factor")
public class EmissionFactorController {

    @Autowired
    private EmissionFactorService emissionFactorService;

    @PostMapping("/create")
    public EmissionFactor createFactor(@RequestBody EmissionFactor factor) {
        return emissionFactorService.createFactor(factor);
    }

    @GetMapping("/all")
    public List<EmissionFactor> getAllFactors() {
        return emissionFactorService.getAllFactors();
    }

    @GetMapping("/type/{typeId}")
    public EmissionFactor getFactorByType(@PathVariable Long typeId) {
        return emissionFactorService.getFactorByType(typeId);
    }
}
