package com.js.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity(name = "orders")
public class Order  extends BaseModel {

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )   // this means that the category field in the Product class is the owner of the relationship
    private List<Product> product;
    // we use the @JoinTable annotation to specify the join table that will be used to join the two entities.(Mapping table because of many to many relationship)
}
