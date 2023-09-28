package com.js.productservice.models;


import jakarta.persistence.*;
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

    // this means that the category field in the Product class is the owner of the relationship
    // using the joincolumn annotation to specify the column that will be used to join the two entities (Product and Category)
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category")
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Price price;

    public Product() {
    }

    public Product(String title, String description, String image, Category category, Price price) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category;
        this.price = price;
    }
}
