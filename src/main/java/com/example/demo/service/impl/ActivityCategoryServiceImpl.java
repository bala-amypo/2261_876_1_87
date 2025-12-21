package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service   // <-- THIS IS THE CRUCIAL ANNOTATION
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository repository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {
        return repository.save(category);
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return repository.findAll();
    }
}
