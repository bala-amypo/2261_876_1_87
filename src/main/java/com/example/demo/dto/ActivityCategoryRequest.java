package com.example.demo.dto;

public class ActivityCategoryRequest {

    private String categoryName;
    private String description;

    public ActivityCategoryRequest() {}

    public ActivityCategoryRequest(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }
}
