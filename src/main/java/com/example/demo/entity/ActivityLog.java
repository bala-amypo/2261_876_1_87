package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private Double quantity;

    private LocalDate activityDate;

    private Double estimatedEmission;

    private LocalDateTime loggedAt;

    @PrePersist
    void onCreate() {
        loggedAt = LocalDateTime.now();
    }

    // getters & setters
}
