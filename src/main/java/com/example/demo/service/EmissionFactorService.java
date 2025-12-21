package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
import java.util.List;

public interface EmissionFactorService {
    EmissionFactor createEmissionFactor(EmissionFactor factor);
    List<EmissionFactor> getAllEmissionFactors();
}
