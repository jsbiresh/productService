package com.js.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "category")
@Getter
@Setter
public class Category extends BaseModel {
    private String name;

    public Category() {
    }
}
