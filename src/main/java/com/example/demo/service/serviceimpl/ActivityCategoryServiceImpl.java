package com.example.demo.service.serviceimpl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository repository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {
        if (repository.findByCategoryName(category.getCategoryName()).isPresent()) {
            throw new RuntimeException("Category already exists");
        }
        return repository.save(category);
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return repository.findAll();
    }
}
