package com.js.productservice.controllers;

import com.js.productservice.dtos.DisplayProductDto;
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


    // Field Injection
    //    @Autowired
    private final ProductService productService;

    // Setter Injection
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }


    // use code for LOCAL DATABASE
    // *****************************************************************************************************************
    //     Constructor Injection
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public ProductDto createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @GetMapping("/")
    public List<DisplayProductDto> getAllProducts() throws NotFoundException {

        System.out.println("getProductTitles() called :- ");
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public DisplayProductDto getProductById(@PathVariable("id") String id) throws NotFoundException {

        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDto updateProductById(@PathVariable("id") String id, @RequestBody ProductDto product) throws NotFoundException {

        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> deleteProductById(@PathVariable("id") String id) throws NotFoundException {

        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    // *****************************************************************************************************************


//    // use code for FAKESTORE API
//    // *****************************************************************************************************************
//
//    // Constructor Injection
//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @PostMapping("/")
//    public FakeStoreProductDto createProduct(@RequestBody FakeStoreProductDto fakeStoreProductDto) {
//
//        return productService.createProduct(fakeStoreProductDto);
//    }
//
//    @GetMapping("/")
//    public List<FakeStoreProductDto> getAllProducts() throws NotFoundException {
//
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/{id}")
//    public FakeStoreProductDto getProductById(@PathVariable("id") String id) throws NotFoundException {
//
//        return productService.getProductById(id);
//    }
//
//    @PutMapping("/{id}")
//    public FakeStoreProductDto updateProduct(@PathVariable("id") String id, @RequestBody FakeStoreProductDto fakeStoreProductDto) throws NotFoundException {
//
//        return productService.updateProduct(id, fakeStoreProductDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteProduct(@PathVariable("id") String id) throws NotFoundException {
//
//        return productService.deleteProduct(id);
//    }
//    // *****************************************************************************************************************



}
