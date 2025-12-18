package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ActivityCategory;

import java.util.Optional;

public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Long> {

    Optional<ActivityCategory> findByCategoryName(String categoryName);

    boolean existsByCategoryName(String categoryName);
}
