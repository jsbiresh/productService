package com.js.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel {
    private String name;

//    @OneToMany
//    private List<Product> products;


    @OneToMany(mappedBy = "category")
    // this means that the category field in the Product class is the owner of the relationship
    private List<Product> products;


}
