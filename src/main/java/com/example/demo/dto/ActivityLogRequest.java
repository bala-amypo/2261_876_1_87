package com.example.demo.dto;

import java.time.LocalDate;

public class ActivityLogRequest {

    private Long activityTypeId;
    private Double quantity;
    private LocalDate activityDate;

    public ActivityLogRequest() {}

    public ActivityLogRequest(Long activityTypeId, Double quantity, LocalDate activityDate) {
        this.activityTypeId = activityTypeId;
        this.quantity = quantity;
        this.activityDate = activityDate;
    }

    public Long getActivityTypeId() { return activityTypeId; }
    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }

    public LocalDate getActivityDate() { return activityDate; }
    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }
}
