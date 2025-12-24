package com.example.demo.service.serviceimpl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    @Autowired
    private ActivityCategoryRepository repository;

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {
        return repository.save(category);
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public ActivityCategory getCategory(Long id) {
        return repository.findById(id).orElse(null);
    }
}
