package com.example.demo.dto;

public class ActivityTypeRequest {

    private String typeName;
    private Long categoryId;
    private String unit;

    public ActivityTypeRequest() {}

    public ActivityTypeRequest(String typeName, Long categoryId, String unit) {
        this.typeName = typeName;
        this.categoryId = categoryId;
        this.unit = unit;
    }

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
}
