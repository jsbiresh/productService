package com.js.productservice.controllers;

import com.js.productservice.dtos.ProductDto;
import com.js.productservice.exceptions.NotFoundException;
import com.js.productservice.models.Product;
import com.js.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<ProductDto> getAllProducts() throws NotFoundException {

        System.out.println("getProductTitles() called :- ");
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") String id) throws NotFoundException {

        return productService.getProductById(id);
    }

    @PostMapping("/")
    public ProductDto createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ProductDto updateProductById(@PathVariable("id") String id, @RequestBody ProductDto product) {

        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> deleteProductById(@PathVariable("id") String id) {

        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }



}
