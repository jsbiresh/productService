package com.js.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity(name = "category")
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel {

    private String name;

//    @OneToMany
//    private List<Product> products;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // this means that the category field in the Product class is the owner of the relationship
    @OneToMany(mappedBy = "category")
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products;


//    public UUID getUuid() {
//        return super.getUuid();
//    }
}
