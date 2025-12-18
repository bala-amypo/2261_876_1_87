package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ActivityType;

import java.util.Optional;
import java.util.List;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {

    Optional<ActivityType> findByTypeName(String typeName);

    List<ActivityType> findByCategoryId(Long categoryId);

    boolean existsByTypeName(String typeName);
}
