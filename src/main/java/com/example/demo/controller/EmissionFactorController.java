package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;

@RestController
@RequestMapping("/emission-factors")
public class EmissionFactorController {

    private final EmissionFactorService emissionFactorService;

    public EmissionFactorController(EmissionFactorService emissionFactorService) {
        this.emissionFactorService = emissionFactorService;
    }

    // CREATE emission factor
    @PostMapping
    public ResponseEntity<EmissionFactor> createEmissionFactor(
            @RequestBody EmissionFactor emissionFactor) {

        EmissionFactor saved = emissionFactorService.createEmissionFactor(emissionFactor);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET all emission factors
    @GetMapping
    public ResponseEntity<List<EmissionFactor>> getAllEmissionFactors() {
        return ResponseEntity.ok(emissionFactorService.getAllEmissionFactors());
    }

    // GET emission factor by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmissionFactor> getEmissionFactorById(
            @PathVariable Long id) {

        EmissionFactor factor = emissionFactorService.getEmissionFactorById(id);
        return ResponseEntity.ok(factor);
    }

    // UPDATE emission factor
    @PutMapping("/{id}")
    public ResponseEntity<EmissionFactor> updateEmissionFactor(
            @PathVariable Long id,
            @RequestBody EmissionFactor emissionFactor) {

        EmissionFactor updated =
                emissionFactorService.updateEmissionFactor(id, emissionFactor);
        return ResponseEntity.ok(updated);
    }

    // DELETE emission factor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmissionFactor(
            @PathVariable Long id) {

        emissionFactorService.deleteEmissionFactor(id);
        return ResponseEntity.ok("Emission factor deleted successfully");
    }
}
