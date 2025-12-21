package com.example.demo.service.impl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository emissionFactorRepository;

    public EmissionFactorServiceImpl(EmissionFactorRepository emissionFactorRepository) {
        this.emissionFactorRepository = emissionFactorRepository;
    }

    @Override
    public EmissionFactor createEmissionFactor(EmissionFactor factor) {
        return emissionFactorRepository.save(factor);
    }

    @Override
    public List<EmissionFactor> getAllEmissionFactors() {
        return emissionFactorRepository.findAll();
    }
}
