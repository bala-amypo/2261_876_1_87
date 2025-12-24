package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
import java.util.List;

public interface EmissionFactorService {
    EmissionFactor createFactor(EmissionFactor factor);
    List<EmissionFactor> getAllFactors();
    EmissionFactor getFactorByType(Long typeId);
}
