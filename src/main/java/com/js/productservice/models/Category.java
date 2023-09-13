package com.js.productservice.models;

import jakarta.persistence.Entity;
import lombok.Builder;

@Entity(name = "category")
@Builder
public class Category extends BaseModel {
    private String name;

    public Category() {
    }
}
