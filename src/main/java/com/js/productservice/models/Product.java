package com.js.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "product")
@Getter
@Setter
public class Product extends BaseModel {

    private String title;
    private String description;
    private String image;
    //    Product : Category
//    => L to R : 1 : 1
//    => R to L : m : 1
//    => Ans:- m :1
    @ManyToOne
    private Category category;
    private double price;

    public Product() {
    }
}
