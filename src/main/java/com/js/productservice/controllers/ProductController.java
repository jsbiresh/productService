package com.js.productservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    @GetMapping
    public String getAllProducts() {
        return "Products List";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return "Here is product id: " + id;
    }


    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }

    @PostMapping
    public void createProduct() {

    }

    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id") Long id) {

    }


}
