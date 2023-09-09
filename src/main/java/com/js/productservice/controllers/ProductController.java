package com.js.productservice.controllers;

import com.js.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products/")
public class ProductController {


    private ProductService productService;

//    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts() {
        return "Products List";
    }

    @GetMapping("{id}")
    public String getProductById(@PathVariable("id") Long id) {
//        return "Here is product id: " + id;
        return productService.getProductById(id);
    }


    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

    }

    @PostMapping
    public String createProduct() {
        return "Created new product with id: " + UUID.randomUUID().toString();
    }

    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id") Long id) {

    }


}
