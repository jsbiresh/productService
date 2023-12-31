package com.js.productservice.dtos;

import java.util.List;

//@Getter
//@Setter
public class CategoryDto {

    private String name;

    private List<ProductDto> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}