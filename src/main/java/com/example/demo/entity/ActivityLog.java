package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType activityType;

    private double quantity;

    private LocalDate activityDate;

    private double estimatedEmission;

    private LocalDateTime createdAt;

    public ActivityLog() {
    }

    public ActivityLog(Long id, User user,
                       ActivityType activityType,
                       double quantity,
                       LocalDate activityDate,
                       double estimatedEmission,
                       LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.activityType = activityType;
        this.quantity = quantity;
        this.activityDate = activityDate;
        this.estimatedEmission = estimatedEmission;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    /* ===== Getters & Setters ===== */

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public double getEstimatedEmission() {
        return estimatedEmission;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public void setEstimatedEmission(double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }
}
