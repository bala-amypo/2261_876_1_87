package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorService {

    EmissionFactor addEmissionFactor(EmissionFactor emissionFactor);

    EmissionFactor getEmissionFactorByActivityType(Long activityTypeId);
}
