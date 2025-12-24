package com.example.demo.service.serviceimpl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    @Autowired
    private EmissionFactorRepository emissionFactorRepository;

    @Override
    public EmissionFactor createFactor(EmissionFactor factor) {
        return emissionFactorRepository.save(factor);
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return emissionFactorRepository.findAll();
    }

    @Override
    public EmissionFactor getFactorByType(Long typeId) {
        return emissionFactorRepository.findByActivityTypeId(typeId);
    }
}
