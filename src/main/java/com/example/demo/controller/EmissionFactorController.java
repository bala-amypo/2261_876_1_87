package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factors")
public class EmissionFactorController {

    private final EmissionFactorService emissionFactorService;

    public EmissionFactorController(EmissionFactorService emissionFactorService) {
        this.emissionFactorService = emissionFactorService;
    }

    // CREATE EMISSION FACTOR
    @PostMapping
    public ResponseEntity<EmissionFactor> createFactor(
            @RequestBody EmissionFactor factor) {
        EmissionFactor saved = emissionFactorService.createFactor(factor);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET ALL FACTORS
    @GetMapping
    public ResponseEntity<List<EmissionFactor>> getAllFactors() {
        return ResponseEntity.ok(emissionFactorService.getAllFactors());
    }

    // GET FACTOR BY ACTIVITY TYPE ID
    @GetMapping("/type/{typeId}")
    public ResponseEntity<EmissionFactor> getFactorByType(
            @PathVariable Long typeId) {
        return ResponseEntity.ok(emissionFactorService.getFactorByType(typeId));
    }
}
