package com.example.demo.dto;

public class EmissionFactorRequest {

    private Long activityTypeId;
    private Double factorValue;
    private String unit;

    public EmissionFactorRequest() {}

    public EmissionFactorRequest(Long activityTypeId, Double factorValue, String unit) {
        this.activityTypeId = activityTypeId;
        this.factorValue = factorValue;
        this.unit = unit;
    }

    public Long getActivityTypeId() { return activityTypeId; }
    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Double getFactorValue() { return factorValue; }
    public void setFactorValue(Double factorValue) {
        this.factorValue = factorValue;
    }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
}
